create database DBnnn;
DROP DATABASE database_name
TRUNCATE TABLE table_name /* resets the table */
rename table T to TT;
rename column T.c to T.ccc 
create table T(
	id_ integer not null auto_increment, /* or AUTOINCREMENT */
	num int UNIQUE check (num > 1000),
	name varchar(50) CHECK, /* checks if user is putting a varchar(50) */
	about text,
	datee date DEFAULT getDate(),
	PRIMARY KEY(id_),
	UNIQUE(text), /* apply unique after row was announced */
	constraint numID unique (colA,colB),
		/* numID has to have different colA&colB from eachother */
	outID int not null foreign key outss(id_),
	foreign key (about) references (aboutss(about)),
	constraint conName check (num > 1000 and date...),
	numMM int identity(1,1) /* auto increment, start from 1, grows +1 */
);
insert into tableName(a,b,v) values (DEFAULT,cc,ccc....)
update tableA set name="sdfsd" where conditions...
	delete from tableA where conditions...
		or delete ....
alter table tabl ADD constraint tableA unique (colA,colB)
alter table T drop constraint numID
alter table T drop index numID
alter table T column C set DEFAULT 'china!'
~same^~ alter table T modify C default 'china!'
alter table T column C DROP default
alter table T add constraint conName PRIMARY key(colA,colB)
alter table T drop primary key 
alter table T add foreign key (colID) references cc(id_)
alter table T add CHECK(id_ > 100000)
create unique index indexName on T(colName)
DROP INDEX index_name ON table_name
ALTER TABLE Persons AUTO_INCREMENT=100 /* starts from 100 */
CREATE SEQUENCE seqA minvalue 1 start with 1 increment by 1 cache 10
	/* creates sequence of objects called seqA increase by 1 up to 10 */
insert into T(..) values (seqA.nextval,..) /*assigns the next number from ^ */
/* View */
create view viewName AS select ...;
create view [current viewName] AS select.....; /*current live table */
drop view viewName
/* Types ______________________________________ */
character(lengthN)	varchar(n)	varying(lengthN) text
binary(lenghN) 	boolean 	varbinary(lengthN)
integer(precision) smallint 	integer 	bigint
decimal(5,2) /* fit numbers , 555.21 331.17 332.20 */
numeric(p,s) 	float 	 real
Date(YYYY-MM-DD) Time (HH-MM-SS) TIMESTAMP (<-All)
ARRAY {...} 	byte (0-255) 	integer 	LONG
single double currency  	char(sizeN) /* characters n length */
enum(x,y,z...) 	float(numOFdigists,parameter)
/*____________________________________________*/

