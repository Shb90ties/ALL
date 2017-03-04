Linux
	man command {get info on command}
	pwd {print working directory}
		shows current address
	rm filename {in current folder}
	cp filename {folder to copy to}
	mkdir FolderName
	rmdir FolderName {folder must be empty}
	rm -r FolderName {removes folder with files in it}
	cp -r folderA toFolderB
	rm -i something {gives you an info notice}
	head -20 phone {print 20 first files in folder}
	wc -l/-w/-c fileName {print word count or lines or c=(data)}
	chmod u+x fileName {gives user ability to write}
		r read, w write, x ecevute
		u user, g group, o other,a all
		+ ADD , - REMOVE, = ASSIGN
	echo $HOME {print home address}
		or echo ~ ^
	echo ~/yyy {print yyy that is in home address}
	cat file1 >| file2 {copy over file2}
	cat file1 >> file2 {copy at the end of file 2}
	command 1> GoodOutputFile 2> ErrorOutputFile
	command 1> fileName 2>&1
	x=50 {assign value to x}
	v="gggff"
	declare -4 x {x is now 46}
	export x=y
	z=$[$x+$y] {shows the value of x+y z is x+y}
	echo "$[5 && 0] $[5 | 2]" {prints 0 7}
	-e fileName {exists fileName then true}
	-w fileName {true if write premission exists}
		-x -r -f -d
	#!/bin/sh
	if ["$1" = "$2"]
	then
		echo "string 1 = string 2"
		{$1 $2 arguments in a bash #! program}
	for i in dd bb cc ii
		do
			echo "$i"
		done
	for fileEndWithC in *.c
		do
			echo $fileEndWithC
		done
	ls *
	ls a[A-Za-z13] {all the files that starts with a and after that
						either have A to Z or a to z or 1 to 3 char }
	$ tr fileName a-z A-Z {replace all lower case to upper case}
	echo "This   is   for testing" | tr [:space:] '\t'
	sort -operand fileName
		 -b {ignore spaces} , -f{ignore upper case/lower case}
		 -m {merge sort} , -n {numerated}
		 -r {reverse} , -u {group equal lines}
	uniq -operand file1 file2 {remove from file1 all lines that exists in file2}
		 -c {every line 1 time + count copies} -d {print duplicates}
		 -u {only lines that doens;t have dups}
	egrep 21 file {print only lines that has 21 in them}
		"^ab.[^a]" // reverse so must start with a
	egrep [^as]$ F {doesn't have a or be at start, $ = anything don't care}
	
	
C
	#include <stdio.h>
	#include <stdlib.h>
	int main()
	{
		.....
	}
	
	void printthis(int *p,int k,int n,int m)
	{
		printf("The number is : %d\n",(*p+(k-1)+(n-1)+(m-1)));
	}
	Life[1][1][1]=11;
	printthis(&Life[1][1][1],1,1,1);
	
	int compare_int( void * a, void * b )
	{
		if( *((int*)a) == *((int*)b) )
		{	return 0;	}
		if( *((int*)a) > *((int*)b) )
		{	return 1;	}
		return (-1);
	}
								// function(function,function)
	void * gMax ( int n,int m,int (*cmp)(void *,void *), void * a, ... )
	
	int compare_double( void * a, void * b )
	{
		if( *((double*)a) == *((double*)b) )
		{	return 0;	}
		if( *((double*)a) > *((double*)b) )
		{	return 1;	}
		return (-1);
	}
			%d,%f,%c = types
	scanf(%f,&file)
	if[(retV = scanf(%d,&n)) != 1]
	gcc -c program.c
	sizeOf(m)/sizeOf(m[0]) {size of bytes}
			// gives u number of lines 
	swap(x,y) | swap(&x,&y) // replace values
	
	void * gMax ( int n,int m,int (*cmp)(void *,void *), void * a, ... )
	{
		va_list args; void * temp; int s_n=1;
		va_start(args ,a);
		while( ( temp = va_arg(args,void *) ) )
		{	s_n++;	}
		va_start(args ,a);
		void * starts [s_n]; void * maxes [s_n];
		starts[0] = a; int i,j,cmpr,counter;
		maxes[0]=get_max_value(starts[0],n,m,(*cmp));
		for(i=1; i<s_n; i++)
		{
			starts[i]=va_arg(args,void *);
			maxes[i]=get_max_value(starts[i],n,m,(*cmp));
		}
		void * max_arrays[s_n][n]; void * pointers_to_max_arrays[s_n+1];
		for(i=0; i<s_n; i++)
		{
			for(j=0; j<n; j++)
			{
				max_arrays[i][j]=NULL;
			}
		}
		pointers_to_max_arrays[s_n]=NULL;
		for( i=0; i<s_n; i++)
		{
			counter=0;
			for( j=0; j<n; j++ )
			{
				cmpr=(*cmp)( maxes[i], (starts[i]+j*m) );
				if( cmpr = 0 )
				{
					max_arrays[i][counter]=(starts[i]+j*m);
					counter++;
				}
			}
			pointers_to_max_arrays[i]=max_arrays[i][0];
		}
		return pointers_to_max_arrays[0];
	}
	
	POINTERS_________
	void *p
	*(int*)p {take 4 bytes} , *(float*)p {take 8 bytes}
		to take p value
	____________
	int a sits in 204444
	a = 5, and int* p = &a
	print p => output = 204444
	print *p => output = 5
	*p = 8
	print a => output = 8
	char c
	int** q = &p
	printf("%d\n",*(*q)); => output 8
	
	Struct_____________
	struct student{string name,int age}s1;
	s1.name;

C++
	#include<iostream.h>
	class student
	{
		int age;
		void display()
		{
			count<<"HYY";
		}
	};
	void main()
	{		character out = cout
		count<<"Welcome";
		student s;
		string name = "";
		s.show();
			character input = cin
		cout<<"Enter your name:";
		cin >> name;
		cout<< "your name is: "<< name << "thank you";
		return 0;
	}
	
	string movie;
	cout << "what is the movie?";
	getline(cin,movie);
	
	if(movie == "red")
	word.size()
	do{
	}while(...)
	
	int radius = getPostInt("enter the radius :");
	
	