#include <string>
#include <fstream>
#include <iostream>
#include <vector>

using namespace std;

int** makeMatrix(int rows,int cols){
	int** matrix = (int**)malloc(rows*sizeof(int**));
	for(int i=0; i<rows; i++){
		matrix[i] = (int*)malloc(cols*sizeof(int*));
		for(int j=0; j<rows; j++){
			matrix[i][j] = rand()%10+1;
				// includes 10 and 1
		}
	}
	return matrix;
}

void print(int** matrix,int rows,int cols){
	for(int i=0; i<rows; i++){
		for(int j=0; j<cols; j++){
			cout << matrix[i][j] << ",";
		}
		cout << "\n";
	}
}

int main(){
	int** matrix = makeMatrix(5,5);
	print(matrix,5,5);
	return 0;
}