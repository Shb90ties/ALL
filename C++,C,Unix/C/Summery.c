#include <stdio,stdlib,string,ctype,errno,stdarg>
#define Five = 5; // Five will be 5 in the code
float PI = 3.14159;
printf("%d %f %p %ld %c %s",....);
int a = rand()%50 + 1; // generates between 1~50, includes 1&50
char s[] = "BOO\0";
printf("%s",s);
strcpy(s,"new values"); // Replace s value with new one
char c; scanf("%c",&c);
int r; (float)r;
switch(r%2){
	case(0): continue; break;
	default : printf("%d ",i); break;
}
strcmp(stringA,stringB); // negative,0,positive (<,=,>)
strcat(stringA,stringB); // merge A with B
strlen(string); // string length
fgets(string,10,stdin); // scan 10 chars to string
char numbr[] = "777";	// convert char[] to int
	int numbrR = atoi(numbr); // ^
int * p = &x;
*p = 50 => x = 50;
// in functions
int arr[][] => number
*(arr+5) ~ arr[5] => numbers
	to pass them to a int* function
		&arr[5] or &(arr+5) => pass pointer location
	pass [][][] => func int*** c
		c[i] = int**
		c[i][j] = int*
		c[i][j][k] = int
		&c[i][j][k] = int*
	int *** c = (int ***)malloc(size*sizeof(int***))
	int ** d = (int **)malloc(size*sizeof(int**))
	int * i = (int *)malloc(size*sizeof(int*))
int** arr ~ arr[][]
	arr[5][1] ~ *(*(arr+5)+1)
int (*arr)[])
printf("%d,",*((*arr+i)+j));
int * p[])
printf("%d,",*(p[i]));
int ** p[])
printf("%d,",**(p[i]));
(rand()%50 + 1) // random 1~50
int dd[2][2] = {{4,3},{1,7}};
printf("d[0][1] = %d\n",*(*(dd)+1));
(sizeof(dd)/sizeof(int));
(sizeof(dd[0])/sizeof(int));
(sizeof(dd)/sizeof(dd[0]));
struct animal{....}
const char * name;
struct animal dodo = {"roll",55,13};
dodo.A || dodo->A || (*dodo).A
typedef struct pimp{ ...}pimp;
pimp eldo = {17,"lips"};
typedef union{ ... }amount; // can only hold 1 value
enum colors{ RED, BLUE, GREEN };
enum colors Color = BLUE;
if(Color == BLUE)
//Malloc make arrays in function
int * arr = (int *)malloc(size*sizeof(int));
free(arr); // at the end free the space
arr[i] = (rand()%50+1);
_Bool bool;  // returns 1 if true, 0 if false;
bool = (scanf("%d",&number) == 1);
int verdict = bool;
FILE * writeF;
writeF = fopen("06test.txt","w");
fprintf(writeF,"%s\n","testingfile STREAM!!");
fclose(writeF)
char buffer[1000];
readF = fopen("06test.txt","r");
while(fgets(buffer,1000,readF) != NULL){
	printf("%s",buffer); }
readF = fopen("06test.txt","r+");
fputs("CHOOOO",readF);

fseek(readF,15,SEEK_SET);
fputs("SEEK!!",readF);
fseek(readF,0,SEEK_END);
long numberOfBytesINfile = ftell(readF);
//_______saveOBJ__________//
FILE * file = fopen("obj.bin","rb+");
	// array
fwrite(chars,sizeof(chars[0]),Length,file);
	// before loading
int fileSize = 0;
fseek(file,0,SEEK_END);
fileSize = ftell(file);	
fseek(file,0,SEEK_SET);
char * buffer = (char *)malloc(fileSize*sizeof(char));
fread(buffer,1,fileSize,file);
	// struct
struct obj doggy = {57,"rex"};
fwrite(&doggy,sizeof(struct obj),1,file);
	// load
struct obj * dogger = (struct obj *)malloc(sizeof(struct obj));
fread(dogger,1,fileSize,file);
//________Generic___________//
int a
void * p = &a;
printf("%d.",*((int*)p));
F(void (*function)(...)){
	(*function)(...);
}
F(&func);