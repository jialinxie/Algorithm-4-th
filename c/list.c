//#链表，实现增删改查
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LEN 10

typedef struct _node{
	node *next;
	int num;
}node

void initList(){
	node *p = (node)malloc(n * sizeof(node));
	if(p == NULL){
		exit(-1);
	}
	p->next = null;
	p->name = "jacky";
}

void addNode(node *s, node *node){
	if(node == nullptr)
		return;

	for(int i = 0; *s != nullptr; i++){
		if(*s.next != nullptr)
			continue;

		s[i] = node;
		s[i].next = s[i];
	}
}

void deleteNode(node *s, node *node){
	if(node == nullptr)
		return;

	for(int i = 0; *s != nullptr; i++){
		if(strcmp(*s.num, node->num) == 0)
		*s = *(s+1);
		s->next = nullptr;
	}

}

node* findNode(node *s, node *node){
	for(int i = 0; *s != nullptr; i++){
		if(strcmp(*s->num, node->num) == 0)
			return node;
	}
}


int main(int argc, char* argv[]){
	
	initList();

	node stu;
	
	stu.num = "jacky";
	stu.next = nullptr;
	addNode(stu);

	int deleteIdx = 6;
	deleteFromList(deleteIdx);

	node stu1;
	stu1.num = "linda";
	bool ret = findList(stu1);
}