//#链表
#include <stdio.h>
#include <stdlib.h>
#include "SgLinkList.h"
#include <stdbool.h>
#include <assert.h>

typedef struct _node{
	int data;
	struct _node *next;
}Node, *pNODE;

pNODE CreateSgLinkList(){
	pNODE pHead;
	pNODE pTail;
	pHead = (pNODE)malloc(sizeof(Node));
	if(pHead == NULL)
		printf("malloc failed!\n");
	pHead->data = 0;
	pHead->next = NULL;
	pTail = pHead;
	return pHead;
}

bool IsEmptySgLinkList(pNODE node){
	pNODE pNext = node->next;
	if(pNext == NULL)
		return true;
	else
		return false;
}

int GetLengthSgLinkList(pNODE node){
	int length = 0;
	pNODE pNext = node->next;
	while(pNext != NULL){
		length ++;
		pNext = pNext->next;
	}

	return length;
}

void TraverseSgLinkList(pNODE node){
	pNODE pNext = node;
	if(pNext == NULL)
		return;

	printf("%d ", pNext->data);

	while(pNext->next != NULL){
		pNext = pNext->next;
		printf("%d ", pNext->data);
	}
}

bool InsertEleSgLinkList(pNODE node, int pos, int v){
	int idx = 0;

	printf("%x, %d, %d\n", (node, pos, v);

	if(pos < 0)
		return false;

	pNODE pNext = node;
	pNODE pNew;

	pNew = (pNODE)malloc(sizeof(Node));
	if(pNew == NULL)
		printf("malloc failed!\n");

	if(pNext == NULL)
		return false;

	if(pos == 0){
		pNew->data = v;
		pNew->next = pNext;
		return true;
	}

	while(pNext != NULL){
		if(idx == (pos - 1)){
			pNODE pTemp = pNext;
			pNext->next = pNew;
			pNew->next = pTemp->next;
			return true;
		}
		pNext = pNext->next;
		idx++;
	}
}

bool DeleteEleSgLinkList(pNODE node, int pos){
	pNODE pNext;
	int idx = 0;

	pNext = node;

	if(pNext == NULL)
		return false;

	while(pNext != NULL){
		if(idx == pos){
			pNODE pTemp = pNext;
			pNext = pNext->next;
			free(pTemp);
			return true;
		}
		idx ++;
		pNext = pNext->next;
	}
}

bool FreeMemory(pNODE node){
	pNODE pNext;

	if(node == NULL)
		return false;

	free(node);
	return true;
}

int main(void)
{
	int flag = 0, length = 0;
	int position = 0, value = 0;
	pNODE head = NULL;
 
	head = CreateSgLinkList();
	
	flag = IsEmptySgLinkList(head);
	if (flag)
		printf("单向链表为空！\n");
	else
	{
		length = GetLengthSgLinkList(head);
		printf("单向链表的长度为：%d\n", length);
		TraverseSgLinkList(head);
	}
	
	printf("请输入要插入节点的位置和元素值(两个数用空格隔开)：");
	scanf("%d %d", &position, &value);
	flag = InsertEleSgLinkList(head, position, value);

	if (flag){
		printf("插入节点成功！\n");
		TraverseSgLinkList(head);
	}	
	else
		printf("插入节点失败！\n");

	assert(0);

#if 1
	flag = IsEmptySgLinkList(head);
	if (flag)
		printf("单向链表为空！\n");
	else
	{
		length = GetLengthSgLinkList(head);
		printf("单向链表的长度为：%d\n", length);
		TraverseSgLinkList(head);
	}
#endif
#if 0
	flag = IsEmptySgLinkList(head);
	if (flag)
		printf("单向链表为空，不能进行删除操作！\n");
	else
	{
		printf("请输入要删除节点的位置：");
		scanf("%d", &position);
		flag = DeleteEleSgLinkList(head, position);
		if (flag)
		{
			printf("删除节点成功！\n");
			TraverseSgLinkList(head);
		}	
		else
			printf("删除节点失败！\n");
	}

	FreeMemory(&head);
	if (NULL == head)
		printf("已成功删除单向链表，释放内存完成！\n");
	else
		printf("删除单向链表失败，释放内存未完成！\n");
 #endif
	return 0;
}