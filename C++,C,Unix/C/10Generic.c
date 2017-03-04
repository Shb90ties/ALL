#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void readValue(void * v,int size){
	switch(size){
		case(sizeof(char)):
			printf("'%c',",*((char*)v)); break;
		case(sizeof(int)):
			printf("%d,",*((int*)v)); break;
		case(sizeof(double)):
			printf("%f,",*((double*)v)); break;
	}
}

// ____________Generic functions______________ // 

void caseONE(int* a){
	printf("%d case one\n",*a);
}
void caseTWO(int* a){
	printf("case two %d\n",*a);
}

void mainCASE(int * a, void (*func)(int *)){
	(*func)(a);
}

int main(){
	int g = 50;
	void * p = &g;
	readValue(p,sizeof(int));
	
	char c = 'G';
	p = &c;
	readValue(p,sizeof(char));
	
	double d = 55.47841;
	p = &d;
	readValue(p,sizeof(double));
	
	printf("\n");
	
	mainCASE(&g,&caseONE);
	mainCASE(&g,&caseTWO);
	
	return 0;
}