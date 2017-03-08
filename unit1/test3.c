//只使用处理IO的printDigit函数，编写一个过程以输出任意实数（可以为负）
#include <stdio.h>
#include <stdlib.h>

void printDigit(int num){
    printf("%d",num);
}
void printOut(int num){
    if(num>10)
        printOut(num/10);
    printDigit(num%10);
}
//d:输入实数;decplace:舍入位置
void printDouble(double d,int decPlace){
    int num = d;
    double dec = d-num;
    if(num<0){
        putchar('-');
        num = -num;
        dec = -dec;
    }
    printOut(num);
    putchar('.');
    
    int i;
    for(i = 0;i<decPlace;i++){
        dec = dec*10;
        num = dec;
        dec = dec-num;
        if(i==decPlace-1){//打印最后一位时注意舍入
            dec = dec*10;
            int tmp = dec;
            if(tmp>4)
                num++;
        }
        printOut(num);
        
    }
}

int main(){
    printDouble(-9.1345,3);
    printf("\nhello\n");
    system("pause");
}
