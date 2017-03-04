#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(){
	FILE * writeF;
	writeF = fopen("06test.txt","w");
		// a = appeand, a+ appeand+write, r = read, r+ read+write, w = all
	if(!writeF){
		printf("ERROR! can't write to file, program exit");
		return 1;
	}
	fprintf(writeF,"%s\n","testingfile STREAM!!");
	
	if(fclose(writeF) != 0){
		printf("ERROR file is not closed");
	}else{
		printf("File is close\n");
	}
	
	
	// READ_____________ //
	char buffer[1000];
	FILE * readF;
	readF = fopen("06test.txt","r");
	if(!readF){
		printf("ERROR! can't write to file, program exit");
		return 1;
	}
	while(fgets(buffer,1000,readF) != NULL){
		printf("%s",buffer);
	}
	
	
	// READ+Write____________//
	readF = fopen("06test.txt","r+");
	fputs("CHOOOO",readF); // put at start of file
	
	// Write from Selected places //
		// SEEK_SET = start from the start
			// SEEK_CUR = start from current position
				// SEEK_END = start from the end
	fseek(readF,15,SEEK_SET);
			// index will be 15 steps from the start
	fputs("SEEK!!",readF);
	
	fseek(readF,0,SEEK_END);
	fputs("AFTERALL!!",readF);
	printf("printed at the end of the file \n");
	
	long numberOfBytes = ftell(readF);
	printf("number of bytes in the file = %d\n",numberOfBytes);
	
	return 0;
}