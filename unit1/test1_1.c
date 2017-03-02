#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#if 1
//bubble sort
int sort(unsigned char *a)
{
	int i = 0, j = 0, temp = 0, len = 0;

    //if(a != NULL)
        //printf("*a[0] = %c\n", a[0] + '0');
    
    len = strlen(a);
    //printf("length of *a = %d\n", len);
#if 1
	for(i = 0;i < len-1; i++)
	   for(j = i+1; j < len; j++)
	   {
		if(a[i] > a[j]){
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;
		}	
	   }
	return a[len/2];
#endif
    return 0;
}
#endif
int main(void)
{
   clock_t start, finish;
   double  duration;
   unsigned char a[20] = {2,3,4,5,6,7,8,9,1,10,23,23,42,31,35,46,57,64,42,2}; 
   unsigned char getData = 0;
   int i = 0;
   int len = 0;
   char *p = NULL;

   scanf("%d", &len);

   printf("len = %d\n", len);

   p = (char *)malloc(len * sizeof(char));  

    if(p == NULL)
       printf("malloc FAIL!\n");
    else{
        printf("malloc OK!\n");
        
        for(i = 0; i < len; i++){
            scanf("%d", &p[i]);
            //printf("%c", p[i] + '0');
        }
    }

  /* 测量一个事件持续的时间*/
   printf( "Time to do N/2 is ");
   start = clock();
   getData = sort(p);
   finish = clock();
   duration = (double)(finish - start) / CLOCKS_PER_SEC;
   printf( "%f seconds\n", duration );
   printf("getData = %d\n", getData);
  
   free(p);
   p = NULL;
    
   system("pause");
   return 0;
}
