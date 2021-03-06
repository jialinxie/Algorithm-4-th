// findPath.cpp: 定义控制台应用程序的入口点。
//穷尽递归算法,遍历所有的可能路径

#include "stdafx.h"

#define MAX_NUMBER_LENGTH 6
//用矩阵表示地图：其中1表示路，0表示没有路，2表示终点，起始地点为（1,0）
static int gPath[MAX_NUMBER_LENGTH][MAX_NUMBER_LENGTH] = {
{ 0 , 1, 1, 1, 1, 1 },
{ 1,  1, 0, 0, 1, 1 },
{ 0 , 1, 1, 1, 1, 1 },
{ 0 , 0, 1, 0, 1, 2 },
{ 0 , 0, 1, 0, 1, 0 },
{ 0 , 0, 1, 1, 1, 0 }
};

static int gValue[MAX_NUMBER_LENGTH][MAX_NUMBER_LENGTH] = { 0 }; /* 记录已走过的路 */

int check_pos_valid(int x, int y)
{
	/* 节点是否出边界 */
	if (x < 0 || x >= MAX_NUMBER_LENGTH || y < 0 || y >= MAX_NUMBER_LENGTH)
		return 0;

	/* 当前节点是否存在路 */
	if (0 == gPath[x][y])
		return 0;

	/* 当前节点是否已经走过 */
	if ('#' == gValue[x][y])
		return 0;

	return 1;
}
#if 0
//寻找出一条路径
int find_path(int x, int y)
{
	if (check_pos_valid(x, y))
	{
		if (2 == gPath[x][y]) {
			gValue[x][y] = '#';
			return 1;
		}

		gValue[x][y] = '#';
		if (find_path(x, y - 1))
			return 1;

		if (find_path(x - 1, y))
			return 1;

		if (find_path(x, y + 1))
			return 1;

		if (find_path(x + 1, y))
			return 1;
		gValue[x][y] = 0;
		return 0;
	}

	return 0;
}
#endif
void print_path()
{
	int outer;
	int inner;

	for (outer = 0; outer < MAX_NUMBER_LENGTH; outer++) {
		for (inner = 0; inner < MAX_NUMBER_LENGTH; inner++) {
			printf("%c ", gValue[outer][inner]);
		}
		printf("\n");
	}
}  

#if 1
//寻找出所有路径
void find_path(int x, int y)
{
	if (check_pos_valid(x, y))
	{
		if (2 == gPath[x][y]) {
			gValue[x][y] = '#';
			print_path();
			gValue[x][y] = 0;
			return;
		}

		gValue[x][y] = '#';
		find_path(x, y - 1);
		find_path(x - 1, y);
		find_path(x, y + 1);
		find_path(x + 1, y);
		gValue[x][y] = 0;
	}
}
#endif

int main()
{
	find_path(1,0);
	print_path();
    return 0;
}