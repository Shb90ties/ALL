#include <iostream>
#include <vector>
#include <string>
#include <fstream>

using namespace std;

struct save{
	public:
		string name;
		int points;
};

void write(const std::string& file_name, OBJECT& data){
	std::ofstream out;
	out.open(file_name,std::ios::binary);
	out.write(reinterpret_cast<char*>(&data), sizeof(OBJECT));
	out.close();
}

void read(const std::string& file_name, OBJECT& data){
	
}

int main(){
	save S;
	S.name = "new";
	S.points = 50;
	
	cout << S.name << " " << S.points;
	
	return 0;
}