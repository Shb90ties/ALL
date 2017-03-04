#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

struct obj{
	int value;
	const char * name;
};

void Err(char * err){
	printf("%s\n",err);
	perror("Error!!");
	printf("Error code : %d\n",errno);
}

int main(){
	FILE *file;
		// rb+ read binary, wb+ write binary
	file = fopen("obj.bin","rb+");
	if(!file){
		Err("Can't load file");
		// create file if doesn't exists
		file = fopen("obj.bin","wb+");
		if(!file){
			Err("Can't create file");
			return 1;
		}
	}
	char chars[] = "Char array for the file";
	int size = sizeof(chars)/sizeof(chars[0]);
	fwrite(chars,sizeof(chars[0]),size,file);
	
	//__________LOAD______________//
	
	int fileSize = 0;
	fseek(file,0,SEEK_END);
	fileSize = ftell(file);
	
	fseek(file,0,SEEK_SET);
	
	char * buffer = (char *)malloc(fileSize*sizeof(char));
	if(!buffer){ Err("file is empty"); return 1; }
	
	fread(buffer,1,fileSize,file);
	
	printf("reading char[] object : %s\n",buffer);
	
	//________________ Saving/Load Struct ____________________//
	fseek(file,0,SEEK_SET);
	
	struct obj doggy = {57,"rex"};
	fwrite(&doggy,sizeof(struct obj),1,file);
	
	printf("saving dog object : %d , %s\n",doggy.value,doggy.name);
	
	//_______________READ obj__________________//
	struct obj * dogger = (struct obj *)malloc(sizeof(struct obj));
	
	fileSize = 0;
	fseek(file,0,SEEK_END);
	fileSize = ftell(file);
	
	fseek(file,0,SEEK_SET);
	
	fread(dogger,1,fileSize,file);

	printf("loaded dog object : value = %d , name = %s\n",dogger->value,dogger->name);
	
	
	fclose(file);
	return 0;
}