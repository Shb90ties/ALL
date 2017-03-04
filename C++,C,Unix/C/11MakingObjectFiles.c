#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

struct save{	
	int points;
	char * name;
	char * status;
};

void stringCopy(char * to,char from[]){
	for(int i=0; i<5; i++){
		*(to+i) = from[i];
	}
}

int main(){
	FILE * f = fopen("11obj.bin","rb");
	if(!f){
		printf("no save found, enter name :");
		char * n = (char *)malloc(sizeof(char)*10);
		//scanf("%s",name);
		fgets(n,10,stdin);	// with spaces
		struct save S;
		S.points = 50; S.status = "new";
		strcpy(S.name,n);
		printf("Name : %sPoints : %d",S.name,S.points);
		FILE * fw = fopen("11obj.bin","wb+");
		if(fw){	fwrite(&S,sizeof(struct save),1,fw);
				fclose(fw); }
	}else{
		struct save *S = (struct save *)malloc(sizeof(struct save));
		fread(S,sizeof(struct save),1,f);
		printf("Name : %s\nPoints: %d\nStatus: %s",S->name,S->points,S->status);
	}
	
	
	
	return 0;
}