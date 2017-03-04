#include <iostream>
#include <vector>
#include <string>
#include <fstream>

using namespace std;

void basicException(int n){
	try{
		if(n != 0){
			cout << "divide by num" << 5/n << endl;
		}else throw(n);
	}catch(int n){
		cout << "can't divid by that num";
	}
	cout << "\n";
}

void pinterFunc(int* b){
	cout << "value = " << *b << " place = " << b << endl;
}

int main(){
	basicException(0);
	
	
	int Boo = 50;
	int* BooPlace = &Boo;
	cout << "int Boo is located at " << BooPlace << endl;
	cout << "int Boo value is... " << *BooPlace << endl;
	
	int arr[3] = {13,12,11};
	int* arrPoint = arr;
	for(int i=0; i<(sizeof(arr)/sizeof(int)); i++){
		cout << "*arrPointer=" << *(arrPoint+i) << " , ";
	}
	cout << "\n";
	
	pinterFunc(&Boo);
	
	int& BooRefrence = Boo;
	BooRefrence++;
	cout << BooRefrence << " , " << Boo << " Changed by ref \n"; 
	// references change the value in the memory
		// reference cannot be changed what's its pointing at
	
	int* BooPointer = &Boo;
	*BooPointer++;
	cout << *BooPointer << " , " << Boo << " Was not changed by pointer";
	// pointer now points to one memory location after &Boo
	
	return 0;
}