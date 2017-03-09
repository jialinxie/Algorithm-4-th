#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void PrintDigit(int num){
    printf("%d", num);
}

void PrintOut(int num){
    char a[100];
    int i;
    
    sprintf(a, "%d", num);
    
    for(i = 1; i < strlen(a); i++)
      printf("%c", a[i]);
}

void PrintDouble(double num, int precision){
    int numInt = 0;
    double tail;
    int tailInt = 0;
    
    
    if(num < 0){
        printf("-");
        num = num - 2 * num;
    }
    
    numInt = (int)num;
    PrintDigit(numInt);
    
    tail = num - numInt;
    if(tail > 0){    //double num
        printf(".");
        tailInt = tail * pow(10, precision);
        PrintDigit(tailInt);
        return;
    }
    if(tail == 0){  //int num
        printf(".");
        tailInt = 1 * pow(10, precision);
        PrintOut(tailInt);
        return;
    }
}

void main(void)
{
    PrintDouble(-1.234233, 5);
    printf("\n");
    return;
}
