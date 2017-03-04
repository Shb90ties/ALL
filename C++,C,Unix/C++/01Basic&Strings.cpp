#include <iostream>
#include <vector>
#include <string>
#include <fstream>

using namespace std;

int main(){
	int numD = 10;
	float n = 20;
	cout << sizeof(float);
	
	string numbb = "447";
	cout << numbb.length() << endl;
	int numbbB = atoi(numbb.c_str());
	cout << (numbbB+5) << endl;
	
	for(int i=0; i<numbb.length(); i++){
		cout << numbb[i] << ",";
	}
	cout << endl;
	
	cout << "Hello world\n";
	const double PI = 3.1415;
	cout << "Size od double = " << sizeof(PI) << "\n";
	if((PI >= 3) && (sizeof(PI) > sizeof(int))){
		cout << "PI!!! \n";
	}
	
	
	int BBB[2][2] = {{2,3},{4,5}};
	cout << "BBB[1][1] = " << BBB[0][0] << "\n";
	
	cout << "size of array " << (sizeof(BBB)/sizeof(int)) << endl;

	char BCB[2][2] = {{'a',49},{'G',70}};
	for(int i=0; i< 2; i++){
		for(int j=0; j< 2; j++){
			cout << ","<< BCB[i][j];
		}
	}
	
	
	char Stringer[4] = {'A','B','C','D'};
	cout << "\nPrint whole Array: " << Stringer << "\n";
	
	
	string inputS;
	cout << "Type something : ";
	getline(cin,inputS);
	cout << "you typed : " << inputS << "\n";
	
	string doubleINstring;
	cout << "type a double number :";
	getline(cin,doubleINstring);
	double DDdd= stod(doubleINstring);
	cout << (DDdd+5) << "\n";
	
	
	string ffdse = "GGFSA";
	cout << "Size of the string : GGFSA is:" << ffdse.size() << "\n";
	
	
	string a = "HELLOOO";
	cout << "cut string HELLOOO [1]~3 steps : " << a.assign(a,1,3) << endl;
	cout << "find the index of char L search from 0 : "<< a.find("L",0); 
	cout << "\nInsert 'BOB' to a at index 2 : "<< a.insert(2,"BOB");
	cout << "\nErase from index 2 to 4" << a.erase(2,4);
	cout << "\nReplace from index 1~3: " << a.replace(1,3,"GOOO");
	return 0;
}