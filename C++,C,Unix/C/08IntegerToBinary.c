#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char * convertBinary(unsigned int num){
	char * arr = (char *)malloc(sizeof(char)*33);
	arr = (arr+33)-1;
	*arr = '\0';
	
	do{
		int v = num % 2; // base 2 binary
		arr = arr-1;
		*arr = '0' + v; // 0 value in Ascii + 1 or 0
		num /= 2;
	}while(num != 0);
	return arr;
}

int main(){
	unsigned int a = 55;
	char * b = convertBinary(a);
	printf("convert a:%d , to binary:%s\n",a,b);
	
	unsigned int x = 5;
	unsigned int y = 6;
	unsigned int sum = x^y;
	printf("5^6=%d , (1^0)=1 binary:\n",sum);
	printf("%s^%s=%s\n",convertBinary(x),convertBinary(y),convertBinary(sum));
	
	printf("10<<2||%s << 2 = %s %d\n",convertBinary(10),convertBinary(10 << 2),10 << 2);
	printf("10>>2||%s >> 2 = %s %d\n",convertBinary(10),convertBinary(10 << 2),10 >> 2);
	return 0;
}