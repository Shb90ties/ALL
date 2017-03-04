#include <string>
#include <fstream>
#include <iostream>
#include <vector>

using namespace std;

void function(int x,int y = 0){
	cout << "y default is 0, here its y=" << y << endl;
	cout << "x is " << x << endl;
}

void WriteFile(string fileName){
	ofstream writer(fileName);
	if(!writer){
		cout << "Error can't read file\n";
	}else{
		writer << "Writing this into the file!!!" << endl;
		writer.close();
		cout << "Wrote to file : " << fileName << endl;
	}
}

void WriteFileInAddition(string fileName){
	ofstream writer(fileName, ios::app);
	if(!writer){
		cout << "Error can't read file\n";
	}else{
		cout << "Write an addittion to the file : " << endl;
		string c;
		getline(cin,c);
		writer << "\n" << c << endl;
		writer.close();
		cout << "Wrote an addition to file : " << fileName << endl;
	}
}

void ReadFile(string fileName){
	string line;
	ifstream myfile (fileName);
	if (myfile.is_open())
	{
		while ( getline (myfile,line) )
		{
			cout << line << '\n';
		}
		myfile.close();
	}
	else cout << "Unable to open file"; 
}

int main(){
	
	vector <int> A(10);
	cout << "vector(list) size : " << A.size() << endl;
	
	int arr[5] = {1,5,7,2,5};
	A.insert(A.begin(),arr,arr+2);
	cout << "insert(A.fromIndex,arrFromIndex,arrToIndex) : "<< A.at(1) << endl;
	A.insert(A.begin()+2,arr+2,arr+4);
	cout << A.at(3) << endl;
	
	function(5);
	function(5,3);
	
	WriteFile("tempFile.txt");
	WriteFileInAddition("tempFile.txt");
	ReadFile("tempFile.txt");
	
	return 0;
}