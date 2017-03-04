#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void erase(int* a){
	*a = 0;
}

void print(int** Matrix,int rows,int cols){
	for(int i=0; i<rows; i++){
		for(int j=0; j<cols; j++){
			printf("%d,",Matrix[i][j]);
		}
		printf("\n");
	}
}

void eraseMatrix(int** Matrix,int rows,int cols){
	for(int i=0; i<rows; i++){
		for(int j=0; j<cols; j++){
			erase(&Matrix[i][j]);
		}
	}
	printf("erased values : \n");
}

int** make(int rows,int cols){
	int** x = (int **)malloc(rows*sizeof(int **));
	for(int i=0; i<rows; i++){
		x[i] = (int *)malloc(cols*sizeof(int *));
	}
	for(int i=0; i<rows; i++){
		for(int j=0; j<cols; j++){
			x[i][j] = rand()%10 + 1;
		}
	}
	return x;
}

int*** makeThreeD(int nums,int rows,int cols){
	int*** MMA = (int***)malloc(nums*sizeof(int***));
	for(int i=0; i<nums; i++){
		MMA[i] = make(rows,cols);
	}
	return MMA;
}

void printThreeD(int*** MMatrix,int nums,int rows,int cols){
	for(int i=0; i<nums; i++){
		print(MMatrix[i],rows,cols);
		printf("\n");
	}
}

void eraseThreeD(int*** MMatrix,int nums,int rows,int cols){
	for(int i=0; i<nums; i++){
		eraseMatrix(MMatrix[i],rows,cols);
		printf("\n");
	}
}

int main(){
	int** matrix = make(5,5);
	print(matrix,5,5);
	eraseMatrix(matrix,5,5);
	print(matrix,5,5);
	
	int*** MMtrix = makeThreeD(3,5,3);
	printThreeD(MMtrix,3,5,3);
	eraseThreeD(MMtrix,3,5,3);
	printThreeD(MMtrix,3,5,3);
	
	return 0;
}