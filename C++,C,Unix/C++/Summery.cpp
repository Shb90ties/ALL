#include <iostream,vector,string,fstream>
using namespace std;
cout << "console " << "print" << endl;
string str;
getline(cin,str); // scanf to str
const double PI;
sizeof(PI);
int 2D[5][5] = {{6,6},{6,6}}
(sizeof(2D)/sizeof(int)) // num of elements
(sizeof(2D)/sizeof(2D[0])) // num of rows
(sizeof(2D[0])/sizeof(int)) // num of columns
cout << array << "\n";
double num = stod(numString) // convert string to num
string.size();
stringA.assign(stringA,2,5) // cut string to just 2~5
string.find("L",0); // search for "L" from 0
string.insert(2,"NEW");
string.erase(2,4);
string.replace(1,3,"GOO");
vector <int> A(size);
A.insert(A.begin(),arrayX,arrayX+5);
ofstream w("file.txt");
if(w){ w << "text to file\n"; w.close(); }
w("file.txt",ios::app);
if(w){ w << "addittion to file\n"; w.close(); }
ifstream r("file.txt");
if(r.is_open()){
	string line;
	while(getline(r,line)){ cout<<line; }
}
else throw(n); catch(int n){...}
int * p = &n;
int & ref = n; // change the value in the memory
cout << ref;

class A{
	private:
		...
		static // will be shared around all A objects
	A(...)
	void func(..)
	void funcPrototype(..);
}
void A::funcPrototype(..){ ... }

class subA : public A{
	....
	subA(...) : A(..){ .. }
}