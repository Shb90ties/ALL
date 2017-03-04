Create______________________________________________________
Create DATABASE myDB
Drop DATABASE myDB
Create Table myTable(
	ID integer not null AUTO_INCREMENT=10000000,
	Salary int Check(Salary > 4500),
	Name varchar(50),
	About Text Check,
	Joined Date Default getDate(),
	Role varchar(50) not null Unique,
	DaysOnJob int identity(1,1), /* start with 1, grows by 1 */
	Primary Key(ID),
	Foreign Key(Name) References (namesZ(name)) On Delete cascade,
	Foreign Key(Role) References (rolesZ(role)) On Update Set Null,
	Constraint constName Unique (Name,About), /* Name+About combo = unique */
);
Rename Table T to newT
Rename Column T.col to T.newCol
Truncate Table myTable; /* Reset Table */
Insert into TableA(a,b,c) Values(Default,"bb",55); /* a is Auto_Increment */
Update TableA set TableA.Col = "changed" Where .....
Delete From TableA Where....
Alter Table TableA {Add/Drop} Column ColName
Alter Table TableA {Add/Drop} Constraint ConName Unique (rowA,rowB)
Alter Table TableA {Add/Drop} {Primary Key/Foreign Key} keyName
Alter Table TableA Set Column C Default 'nothing was put in';
Alter Table TableA Drop Column C Default;
Alter Table TableA {Set/Modify} Column C Auto_Increment; /* start from 1 */
Alter Table TableA Add Check(ID>100000);
________________________________________________________________________
Types__________________________________________________________________
character(lengthN)	varchar(n)	varying(lengthN) text
binary(lenghN) 	boolean 	varbinary(lengthN)
integer(precision) smallint 	integer 	bigint
decimal(5,2) /* fit numbers , 555.21 331.17 332.20 */
numeric(p,s) 	float 	 real
Date(YYYY-MM-DD) Time (HH-MM-SS) TIMESTAMP (<-All)
ARRAY {...} 	byte (0-255) 	integer 	LONG
single double currency  	char(sizeN) /* characters n length */
enum(x,y,z...) 	float(numOFdigists,parameter)
_________________________________________________________________________
Select * from table where conditions and moreConditions order by col DESC
Select * from table where (conditions or moreConditions) order by col DESC
select * from table where colmn like 'R%' Limit 5
'T%' , '%T' , '%T%' , '[^abc]' , '[!abc]' , '%T_T%' , '[a-b]%'
select DISTINCT * from table...
select top 50 PERCENT * from tableName
select top 50 * from tableName
select * from tableA where columnA in (select columnA .... )
select * from tableA where columnA in ('value1','value2'...)
select * from t where price between 5 and 6
WHERE name NOT BETWEEN 'A%' AND 'C%' and price BETWEEN ...
select CONCAT(colaA+','+colB) AS ONEcol from table
select a.B,b.B from TT as a, TT as b where a.B = b.B ....
/*left outer join (all Left), right outer join (all right), full outer join (all)*/
	/* without OUTER only those that were matched */
select ... from a join b on a.C = b.C
select a.O,.. from c join (select O,....) as a on c.id = a.O
	/* ^ O must be presented in the select to be used here ^ */
select ... from a UNION select ... from b
/* returns 1 row */
avg(colName) , avg(colName) as A , count(distinct col) , first(colA
last(colA) , max(colA) , min(colA) , sum(colA) , count(col)
Select max(a),b from .... group by b;
	/* returns all the a's with the same b in one row, # of rows = # of b's */
/* returns same rows */
ucase(col) , upper(col) , lcase(col) , lower(col) , mid(city,1,4)
len(name) /* length of names */ , round(col,0)
select *,now() from ... /* current Date */
select *,format(now(),'YYYY-MM') as .. from ... /* current date on picked format */
WHERE ((current_timestamp-timestmp)<time'00:10:00')
CREATE VIEW viewName AS SELECT.....
________________________________________________________________________________
Functions_______________________________________________________________________
DO
$body$
BEGIN
	if exists(select...) then raise notice 'dddfd';
	end if;
END
$body$

create function TT(arg varchar(15),.....)	/* $1 first argument.... */
{returns table (.....)/Trigger/text/integer/tableA%ROWTYPE}
AS $$
Declare i bonuses%rowtype;
Declare r record; /* can be any shape of table */
begin
	/* Declare int $x = NEW.x; Declare varchar(50) $y = OLD.y; in Trigger */
	For i Select * from bonuses
	LOOP
		Update .... set A.x = (A.x + i.x) Where .... A.n = i.n
		IF .... Return next i;
	end LOOP
	{Return i;/Return NEW/Return "x"/Return 10/Return Query Select ... from tableA}
end		/* Trigger returns NEW */
$$ language plpgsql;
_________________________________________________________________________________
Trigger__________________________________________________________________________
/* PostgreSQL */
Create Trigger triggA
{BEFORE/AFTER/Instead OF} {UPDATE/Delete/Insert} ON tableA /* AFTER | Instead of */
	{FOR EACH ROW/* or just run the function 1 time */}
	EXECUTE PROCEDURE fA(); /* fA returns Trigger, in body RETURN NEW */
/* MySQL */
if Object_id('TriggerA') is not NULL
	drop trigger TriggerA
GO 

Create Trigger TriggerA
ON TableA
{INSTEAD/After/Before} {Delete/Update/Insert}
AS
	Begin
		declare @i int;
		select @i=ID from INSERTED conditions....
			IF(@i == 55) Then raiseError('...') RollBack; End IF
		select * from DELETED	/* Rollback if it was After Insert */
	End
GO
_____________________________________________________________________________
Combinitions_________________________________________________________________
Update TablA Set a = TablB.a + a FROM  TablA join TablB on TablA.a = TablB.a WHERE .....