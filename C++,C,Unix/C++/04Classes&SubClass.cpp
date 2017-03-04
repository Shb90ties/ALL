#include <iostream>
#include <vector>
#include <string>
#include <fstream>

using namespace std;

class Animal{
	private:
		int height;
		int weight;
		static int numOfAnimals;
			// static = value to be shared accross all Animal objects
	public:
		string name;
		int getHeight(){ return height; }
		int getWeight(){ return weight; }
		static int getNumOfAnimals(){ return numOfAnimals; };
	
	Animal(int h,int w,string name){
		this -> height = h;
		this -> weight = w;
		this -> name = name;
		Animal::numOfAnimals++;
	}
	
	// function prototypes
	void resetNumOfAnimals(int);
	
	// a function that might get OVERWRITE
	virtual void printType(){
		cout << "Generic type\n";
	}
};

	// deal with static between classes
int Animal::numOfAnimals = 0;

void Animal::resetNumOfAnimals(int num){
	Animal::numOfAnimals = 0;
}

	// sub class
class Dog : public Animal{
	public:
		string nickName;
		void printType(){
			cout << "This is a dog\n";
		}
	Dog(int h,int w,string name,string nickName) : Animal(h,w,name){
		this -> nickName = nickName;
	}
};

int main(){
	Animal bee = Animal(5,7,"BEE");
	Animal lion = Animal(18,7,"Doo");
	
	cout << "Num of animals : " << lion.getNumOfAnimals() << endl;
	cout << "Lion attr : " << lion.getHeight() << " " <<lion.name << endl;
	
	Dog d = Dog(8,22,"ROOF","Nikki");
	bee.printType();
	lion.printType();
	d.printType();
	
	Animal* dogPointer = &d;
	cout << "Animal pointer to dog, printType: ";
	dogPointer -> printType();
	
	return 0;
}