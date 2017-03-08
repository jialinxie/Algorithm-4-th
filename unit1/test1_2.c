//1.2编写一个程序求解字谜游戏问题
#include <stdio.h>

/**
    directions:
        1------从左到右
        2------从右到左
        3------从上到下
        4------从下到上
        5------从左下到右上
        6------从左上到右下
        7------从右下到左上
        8------从右上到左下
*/


int compare(char *word1, char *word2){
	int index1 = 0, index2 = 0;
    
    ////printf("compare \n");
    
	while(word1[index1] && word2[index2]){
		if(word1[index1] < word2[index2])
			return 0;
		else if(word1[index1] > word2[index2])
			return 1;

		index1 ++;
		index2 ++;
	}
	if(word1[index1])
		return 1;
	else 
		return 0;
}

//对字典中的词按首字母进行升序排序
void sort(char **direc, int m){
	int i, j;
	char *word1;
	char *word2;

    
	for(i = m; i > 0; i--){
		for(j = 0; j < i-1; j++){
			word1 = direc[j];
			word2 = direc[j+1];
			if(compare(word1, word2)){
				direc[j] = word2;
				direc[j+1] = word1;
			}
		}
	}
}

char **findOne(char **puzzle, int row, int col, int n, char **direct, int m, int index, int *returnSize){
	char **res = (char **)malloc(sizeof(char*) * m);
	int count = 0;
	int dir;
	int i;
	char head = puzzle[row][col];

	int tmpRow, tmpCol;
	int directIndex;
    
    //printf("findOne\n");
    
	for(dir = 1; dir <= 8; dir ++){ //从8个方向遍历
		directIndex = 0;
		tmpRow = row;
		tmpCol = col;

		switch(dir){
			case 1://左到右
				for(i = index; i < m && direct[i][0] == head; i++){
					while(direct[i][directIndex] && tmpCol < n){    //从符合的字典中的首字母开始遍历
						if(direct[i][directIndex] != puzzle[tmpRow][tmpCol]){ //遍历时，遇到字典和字谜中的字母不同，说明字谜中没有该字
							break;
						}
						tmpCol++;           //字谜遍历中，控制字谜的边界
						directIndex++;      //字典遍历中
					}
					if(!direct[i][directIndex]){    //字典遍历到结束符
						res[count++] = direct[i];   //保留在字谜中找到的字典,并在最后返回给main
						break;
					}
				}
				break;
		case 2://从右向左
				for(i = index; i < m && direct[i][0] == head; i++){
					while(direct[i][directIndex] && tmpCol >= 0){
						if(direct[i][directIndex] != puzzle[tmpRow][tmpCol]){
							break;
						}
						tmpCol--;
						directIndex++;
					}
					if(!direct[i][directIndex]){
						res[count++] = direct[i];
						break;
					}
				}
				break;
		case 3://从上到下
				for(i = index; i < m && direct[i][0] == head; i++){
					while(direct[i][directIndex] && tmpRow < n){
						if(direct[i][directIndex] != puzzle[tmpRow][tmpCol]){
							break;
						}
						tmpRow++;
						directIndex++;
					}
					if(!direct[i][directIndex]){
						res[count++] = direct[i];
						break;
					}
				}
				break;
		case 4://从下到上
				for(i = index; i < m && direct[i][0] == head; i++){
					while(direct[i][directIndex] && tmpRow >= 0){
						if(direct[i][directIndex] != puzzle[tmpRow][tmpCol]){
							break;
						}
						tmpRow--;
						directIndex++;
					}
					if(!direct[i][directIndex]){
						res[count++] = direct[i];
						break;
					}
				}
				break;
		case 5://从左下到左上
				for(i = index; i < m && direct[i][0] == head; i++){
					while(direct[i][directIndex] && tmpCol < n && tmpRow >= 0){
						if(direct[i][directIndex] != puzzle[tmpRow][tmpCol]){
							break;
						}
						tmpRow--;
						tmpCol++;
						directIndex++;
					}
					if(!direct[i][directIndex]){
						res[count++] = direct[i];
						break;
					}
				}
				break;
		case 6://从左上到右下
				for(i = index; i < m && direct[i][0] == head; i++){
					while(direct[i][directIndex] && tmpCol < n && tmpRow < n){
						if(direct[i][directIndex] != puzzle[tmpRow][tmpCol]){
							break;
						}
						tmpRow++;
						tmpCol++;
						directIndex++;
					}
					if(!direct[i][directIndex]){
						res[count++] = direct[i];
						break;
					}
				}
				break;
		case 7://从右下到左上
				for(i = index; i < m && direct[i][0] == head; i++){
					while(direct[i][directIndex] && tmpCol >= 0 && tmpRow  >= 0){
						if(direct[i][directIndex] != puzzle[tmpRow][tmpCol]){
							break;
						}
						tmpRow--;
						tmpCol--;
						directIndex++;
					}
					if(!direct[i][directIndex]){
						res[count++] = direct[i];
						break;
					}
				}
				break;
		case 8://从右上到左下
			for(i = index; i < m && direct[i][0] == head; i++){
				while(direct[i][directIndex] && tmpCol >= 0 && tmpRow < n){
					if(direct[i][directIndex] != puzzle[tmpRow][tmpCol]){
						break;
					}
					tmpRow++;
					tmpCol--;
					directIndex++;
				}
				if(!direct[i][directIndex]){
					res[count++] = direct[i];
					break;
				}
			}
			break;
		default:
			break;
		}
	}
	*returnSize = count;
	return res;
}

char ** findWord(char **puzzle, int n, char **direc, int m, int *returnSize){
	char **res = (char **)malloc(sizeof(char *)*m);//返回值
	int count = 0; //res index

	int row, col;
	int i;
	char tmp;
	char hash[26];	//store first word
	char index;
    
    //printf("findWord\n");

	sort(direc, m);	//将direct排序
	for(i = 0; i < 26; i++) //init hash table
		hash[i] = -1;
	for(i = 0; i < m; i++){
		tmp = direc[i][0];  //取字典中每个词的首字母
		if(hash[tmp - 'a'] == -1)
			hash[tmp - 'a'] = i;	//对direc首字母按升序排序后，存储7个direc的开始索引
	}

	for(row = 0; row < n; row++){
		for(col = 0; col < n; col++){
			tmp = puzzle[row][col];
			//check hash table
			index = hash[tmp - 'a'];    //hash_table中保存的数据是0-6的字典编号  index可能代表字谜中的某个字母与字典中某个单词的首字母相同
			if(index == -1)         //hash table中没有出现字谜中的字符
				continue;           //后面的语句不执行，继续下次循环
			int size;               //字谜中的某个字母与字典中某个单词的首字母相同
			char **word = findOne(puzzle, row, col, n, direc, m, index, &size);
			if(size){
				for(i = 0; i < size; i++)
					res[count++] = word[i];
			}
		}
	}
	*returnSize = count;
	return res;
}

int main(void){
	int n = 4;
	char *puzzle[4];
	char p1[4] = {'t', 'h', 'i', 's'};
	char p2[4] = {'w', 'a', 't', 's'};
	char p3[4] = {'o', 'a', 'h', 'g'};
	char p4[4] = {'f', 'g', 'd', 't'};
	puzzle[0] = p1;
	puzzle[1] = p2;
	puzzle[2] = p3;
	puzzle[3] = p4;

	char *s1 = "this";
	char *s2 = "two";
	char *s3 = "otw";
	char *s4 = "fat";
	char *s5 = "that";
	char *s6 = "hello";
	char *s7 = "fuck";

	char *direc[7];
	direc[0] = s1;
	direc[1] = s2;
	direc[2] = s3;
	direc[3] = s4;
	direc[4] = s5;
	direc[5] = s6;
	direc[6] = s7;

	int size;
    int i;
	
    char **res = findWord(puzzle, 4, direc, 7, &size);
    
    ////printf("size = [%d]\n", size);
    
	for(i = 0; i < size; i++)
		printf("%s\n", res[i]);

    ////printf("hello!\n");
    system("pause");
}
