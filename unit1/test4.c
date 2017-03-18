#include <stdio.h>
#include <string.h>

#define MAXLINE 1024

void process_line(const char *filename);

int main(int argc,char **argv)
{
    process_line("stdio.h");
}

void process_line(const char *filename)
{
    char *buf,*fName, *match, *subfile;
    fName = (char *)malloc(sizeof(char)*MAXLINE);
    buf = (char *)malloc(sizeof(char)*MAXLINE);
    match = (char *)malloc(sizeof(char)*MAXLINE);
    subfile = (char *)malloc(sizeof(char)*MAXLINE);

    memset(fName,'\0',MAXLINE);
    memset(buf,'\0',MAXLINE);
    memset(match,'\0',MAXLINE);
    memset(subfile,'\0',MAXLINE);

    strcpy(match, "#include");
    //strcpy(fName, "/usr/include/");
    strcpy(fName, "/Users/Jonse/DataStructures-and-Algorithm-Analysis-in-C/unit1/");
    strcat(fName, filename);

    FILE *fp;
    while((fp = fopen(fName, "r+"))==NULL)
    {
        printf("open %s error\n",fName);
        //memset(fName,'\0',MAXLINE);
        //strcpy(fName, "/usr/include/linux/");
        //strcat(fName, filename);
        sleep(2);
    }

    while(fgets(buf, MAXLINE, fp) != NULL)
    {
       if(strstr(buf,match) !=NULL)
       {
           strncpy(subfile, strstr(buf,"<")+1, strstr(buf,">")-strstr(buf,"<")-1);
           printf("subfile = %s\n", subfile);
           sleep(3);
           process_line(subfile);
           memset(subfile,'\0',MAXLINE);
       }
       printf("%s\n", buf);
       memset(buf, '\0', MAXLINE);
    }
}
