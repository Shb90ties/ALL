#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int* makeAnArray(int size){
	int * arr = (int *)malloc(size*sizeof(int));
	for(int i=0; i<size; i++){
		arr[i] = (rand()%50+1);
	}
	return arr;
	// return &arr <= returns pointer to a pointer **
}

int main(){
	_Bool isNumber;
	int number = 0;
	
	printf("Enter a num : ");
	isNumber = (scanf("%d",&number) == 1);
	printf("did you put a number?  ");
	int verdict = isNumber;
	switch(verdict){
		case(0): printf("false\n"); break;
		case(1): printf("true\n"); break;
	}
	
	// memory allocation, saves memory for something
	int * MallocArray = (int *)malloc(5*sizeof(int));
		// new place with empty space infront of it, to fit 5 ints
			// similar to int MallocArray[5] but doesn't have to be filled
	MallocArray[0] = 50;
	MallocArray[1] = 20;
	MallocArray[2] = 25;
	MallocArray[3] = 45;	// leaving [4] empty
	int i = 0;
	while(MallocArray[i] != NULL){
		printf("%d,",MallocArray[i]);
		i++;
	}
	free(MallocArray);
	printf(" <= Memory Space been freed\n");
	
	int * newARR = makeAnArray(5);
	printf("make an array function : ");
	for(int i=0; i<5; i++){
		printf("%d,",*(newARR+i));
	}
	free(newARR);
	printf("\n");
	
	
	return 0;
}