#include <stdio.h>
#include <stdlib.h>
#include <string.h>

	// union only holds 1 value at a time
		// the last value that was installed
typedef union{
	int total;
	int avg;
}amount;

enum colors{ RED, BLUE, GREEN };

typedef struct node{
	int val;
	struct node * next;
}node;

int main(){
	amount DD = {.total = 30};
	printf("DD.total = %d\n",DD.total);
		// total will be erased by this
	DD.avg = 12;
	printf("after change DD.avg = %d | DD.total = %d\n",DD.avg,DD.total);
	
	enum colors Color = BLUE;
	if(Color == BLUE){
		printf("enum color is blue\n");
	}
	
	node tail = {55,NULL};
	node bod = {22,&tail};
	node head = {11,&bod};
	node * nextP = &head;
	while(nextP != NULL){
		printf("%d,",nextP->val);
		nextP = nextP->next;
	}
	printf("\nInsert 15 to the list\n");
	node bodT = {15,&bod};
	head.next = &bodT;
	nextP = &head;
	while(nextP != NULL){
		printf("%d,",nextP->val);
		nextP = nextP->next;
	}
	
	return 0;
}