#include <iostream>
#include <vector>
#include <string>
#include <fstream>

using namespace std;

int max(int a,int v){
	if(a > v){ return a; }
	return v;
}

int main(){
	bool f = max(10,5);
	bool x = true;
	cout << (x+f);
	
	return 0;
}