#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int globalVar = 50;

int add(int a, int b){
	return (a+b);
}

void generate(int * x,int * y){
	*x = (rand()%50 +1);
	*y = (rand()%50 +1);
}

void swap(int * x,int * y){
	int temp = *x;
	*x = *y;
	*y = temp;
}

void printArr(int * arr, int size){
	printf("\n");
	for(int i=0; i<size; i++){
		printf("%d,",*(arr+i));
	}
	printf("\n");
}

void sortArr(int * arr,int size){
	for(int i=0; i<(size-1); i++){
		for(int j=0; j<(size-i-1); j++){
			if(*(arr+j) > *(arr+j+1)){
				swap(arr+j,arr+j+1);
			}
		}
	}
}

void print2DArray(int (*arr)[],int n,int m){
	printf("\n");
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			printf("%d,",*((*arr+i)+j));
		}
		printf("\n");
	}
}

void printPointersArr(int * p[],int size){
	for(int i=0; i<size; i++){
		printf("%d,",*(p[i]));
	}
	printf("\n");
}

void printPointersToPointersArr(int ** p[],int size){
	printf("\nprint Pointer to Pointers: ");
	for(int i=0; i<size; i++){
		printf("%d,",**(p[i]));
	}
	printf("\n");
}

int main(){
	printf("5+6=%d\n",add(5,6));
	
		// pointers
	int a = 50;
	printf("location of a and globalVar %p , %p \n",&a,&globalVar);
	printf("decimal version of those address %d , %d \n",&a,&globalVar);
	int * p = &a;
	printf("pointer location %p, pointer value %p, pointed value %d \n",&p,p,*p);
	*p = 20;
	printf("*p=20 ||> *p=%d , a=%d\n",*p,a);
	
	int doo[] = {5,7,9,10};
	printf("doo[0]: %d , *doo: %d \n",doo[0],*doo);
	printf("doo[1]: %d , *(doo+1): %d \n",doo[1],*(doo+1));
		// if the point is int * then it jumps 4 places in a +1
	
	// Array of pointers
	char * pplz[4] = {"guy","girl","kid","old"};
	for(int i=0; i<4; i++){
		printf("char*pplz[%d]= %s , at(%d||%p) \n",i,pplz[i],&pplz[i],&pplz[i]);
		printf("*pplz[%d]= %d , pplz[%d]= %d \n",i,*pplz[i],pplz[i]);
	}
	
	// print Random number, in stdlib.h
	printf("Generated int from 1 to 50 = %d\n",(rand()%50 + 1));
	
	int x = 70; int y = 20;
	printf("x = %d , y = %d \n",x,y);
	generate(&x,&y);
	printf("after generate(&x,&y) , x= %d, y=%d",x,y);
	
	int gg[5] = {5,7,3,4,6};
	printArr(gg,(sizeof(gg)/sizeof(int)));
	printf("after sort :"); 
	sortArr(gg,5);
	printArr(gg,(sizeof(gg)/sizeof(int)));
	
	int dd[2][2] = {{4,3},{1,7}};
	printf("d[0][1] = %d\n",*(*(dd)+1));
	int ddALL = (sizeof(dd)/sizeof(int));
	int ddRows = (sizeof(dd[0])/sizeof(int));
	int ddColumns = (sizeof(dd)/sizeof(dd[0]));
	printf("size of dd = %d, rows %d , columns %d \n",ddALL,ddRows,ddColumns);
	
	print2DArray(dd,ddRows,ddColumns);
	printf("Sort 2D array with same function as regular array :");
	sortArr(dd[0],4);
	print2DArray(dd,ddRows,ddColumns);
	
	// Array of pointers
	int g =50;
	int f = 77;
	int * pntrs[2] = {&g,&f};
	int pntrsN = (sizeof(pntrs)/sizeof(int*));
	printf("*pointer[0] value = %d \n",*(pntrs[0]));
	printPointersArr(pntrs,pntrsN);
	
	// Pointer to Pointer **
	int ** PPntrs[2] = {&pntrs[0],&pntrs[1]};
	int PPntrsN = (sizeof(PPntrs)/sizeof(int**));
	printf("print value of pointer to pointer[0] = %d",**(PPntrs[0]));
	printPointersToPointersArr(PPntrs,PPntrsN);
	
	return 0;
}