#include <stdio.h>
#include <iostream>

#define HASH_SIZE 10
using namespace std;

typedef struct _node{
	char *name;
	char *desc;
	_node *next;
}node;

node *hashtab[HASH_SIZE];

void hashInit(int len){
	for(int i = 0; i < len; i++){
		hashtab[i]->next = NULL;
	}
}

char *getMalloc(char *t){
	char *s;
	s = (char *)malloc(sizeof(char) * strlen(t));
	if(NULL == s){
		cout << "malloc failed";
		exit (0);
	}
	strcpy(s, t);
	return s;
}

unsigned int hashCal(char *s){
	unsigned int sum;
	for(; *s; s++){
		sum += *s * 31;
	}

	return sum % HASH_SIZE;
}

void hashPut(char *name, char *desc){
	char *s = getMalloc(name);
	char *t = getMalloc(desc);

	unsigned int hv = hashCal(name);
	node *np = hashtab[hv];
	while(np->next != NULL){
		np++;
	}
	np->name = s;
	np->desc = t;
	np->next = np;
}

void hashGet(char *name){
	char *s = getMalloc(name);
	unsigned int hv = hashCal(name);
	node *np = hashtab[hv];
	while((np->next != NULL) && (strcmp(np->name, name) != 0))
		np++;

	if(NULL == np->next)
		return;
	return;
}

void hashInstall(char *name, char *desc){
	hashPut(name, desc);
	return;
}

void hashClean(){
	node *np;
	for(int i = 0; i < HASH_SIZE; i++){
		np = hashtab[i];
		if(np->next != NULL){
			free(np->name);
			free(np->desc);
			np->next = NULL;
		}
	}
}

//init
//put
//get
//free
int main(int argc, char** argv){

	char *name = "jacky,colin,john,Lisa,Linda";
	char *desc = "a,b,c,d,e";

	hashInit(strlen(name));
	hashInstall(name, desc);

	for(int i = 0; i < strlen(name); i++){
		// char *a = hashGet(name[i]);
		// cout << "a = " << *a << endl;
	}

	hashClean();

	return 0;
}