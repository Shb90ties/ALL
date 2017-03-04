#include <stdio.h>
#include <string.h>
#include <stdlib.h>
	// struct ~ class
struct animal{
		// equals to const string name; \0 tells it to stop
	const char * name;
	int hght;
	int age;
};

struct creator{
	const char * planet;
	struct animal Typ;
};

void printAnimal(struct animal A){
	printf("Name : %s, size : %d, age : %d \n",A.name,A.hght,A.age);
}

void changeAnimalAge(struct animal * anm){
	// 2 ways
	(*anm).age = 77;
	anm -> age = 66;
}

//_________define a struct as type________________//
	// saves time instead of writing struct animal, just animal
typedef struct pimp{
	int numOfBitches;
	const char * name;
}pimp;

void printPimp(pimp p){
	printf("name : %s, bitches : %d \n",p.name,p.numOfBitches);
}

int main(){
	struct animal dodo = {"roll",55,13};
	printAnimal(dodo);
	
	struct animal dodoCopy = dodo;
	printf("struct animal dodoCopy = dodo\n");
	printf("location to dodo %p , location of copy %p",&dodo.name,&dodoCopy.name);
	
		// struct in struct
	struct creator Gooe = {"earth",{"G",5,1}};
	printf("\nCreature.Animal struct value name : %s\n",Gooe.Typ.name);
	
	printf("age before change : %d\n",dodo.age);
	changeAnimalAge(&dodo);
	printf("age after change : %d\n",dodo.age);
	
	pimp eldo = {17,"lips"};
	printPimp(eldo);
	
	return 0;
}