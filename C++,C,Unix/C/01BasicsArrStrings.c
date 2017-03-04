// Basics
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define myName "C program Baiscs"
		// replaces myName with this in the code
int globalVar = 500;

int length(char * c){
	int i = 0;
	do{
		i++;
	}while(*(c+i) != '\0');
	return i;
}

int main(){
	
	bool f = 15;
	char * st = "a";
	int stN = length(st);
	for(int i=0; i<stN; i++){
		printf("%c,",*(st+i));
	}printf("\n");
	
	
	char box = 'G';
	float PI = 3.14159;
	int age = 50;
	printf("%f , %d , %ld",PI,age);
	printf("\nOnly the first 2 digits of PI = %.2f\n",PI);
	
	char numbr[] = "777";
	int numbrR = atoi(numbr);
	printf("\n convert 777 to int, 777+5= %d\n",(numbrR+5));
	
	char s[] = "Boo\0";	// \0 is null, marks end of string
	printf("print String %s and another string %s\n",s,"Hoo");
	printf("string before copy : %s\n",s);
	strcpy(s,"hola");
	printf("string after copy : %s\n",s);
	
	
	char inputt;
	printf("type something:");
	scanf("%c",&inputt);
	printf("inputt = %c",inputt);
	
	char firstName[50]; char lastName[50];
	printf("\nType your first & last name :");
	scanf(" %s %s",firstName,lastName);
	printf("\nYour name is %s %s\n",firstName,lastName);
	
	int r = 1;
	printf("r=1 before this line, after this line r=%d",r+=2);
	printf("\nPrint int r as a float : %f\n",(float)r);
	
	char VV = 'D';
	do{
		printf("type in only (T or F) : \n");
		scanf("%c",&VV);
	}while(VV != 'T' && VV != 'F');
	
	for(int i=0; i<15; i++){
		switch(i%2){
			case(0): continue; break;
			default : printf("%d ",i); break;
		}
	}
	
	int arr[] = {5,2,8};
	printf("\nLENGTH of {5,2,8} array = %d",((sizeof(arr))/(sizeof(int))));
	
	// String methods
	char myString[] = "LOLOLAaa";
		// negative = first less than second, 0 equals
			// positive = first is more than second
	printf("\nCOMPARE 'ff'=='dd' result?(negative,0,positive) = %d\n",strcmp("ff","dd"));
	// Merge/Appeand strings
	char vv[] = "ff";
	char cc[] = "dd";
	strcat(vv,cc);
	printf("Merge 'ff' with 'dd' : %s\n",vv);
	// LENGTH of String
	printf("THE length of the new String : %d\n",strlen(vv));
	
	// Input from the user on a specific string size FGETS
	char fgetsString[10];
	printf("\nType something with only 10 characters:");
	fgets(fgetsString,10,stdin);
	printf("\nYou typed : %s\n",fgetsString);
	
	return 0;
}