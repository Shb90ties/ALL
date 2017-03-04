Select * from table where conditions and moreConditions order by col DESC
Select * from table where (conditions or moreConditions) order by col DESC
select * from table where colmn like 'R%'
select * from table condition .... limit 5 /* SQL */
select top 5 * from table condition... /* mySQL */
select * from table ..... where ROWNUM <= 5 /* Oracle */
/* comment */
like engine :
	'T%' start with T...
	'%T' ends with T...
	'%T%' got T in it..
	'[^abc]' doesnt have a b or c
	'[!abc]' same ^
	'%T_T%' got T[some char]T in it
	'[a-b]%' start with a or b
	
select DISTINCT * from table... /*only different values */
/* <> ~ != , <= >=  */
select * from table order by name desc /* last to first */
select * from table order by name asc /* first to last */
select top 50 PERCENT * from tableName
select top 50 * from tableName
select * from tableA where columnA in (select columnA .... )
select * from tableA where columnA in ('value1','value2'...)
select * from t where price between 5 and 6
WHERE name BETWEEN 'A%' AND 'C%' order by name;
WHERE name NOT BETWEEN 'A%' AND 'C%' and price BETWEEN ...
WHERE OrderDate BETWEEN #07/04/1996# AND #07/09/1996#;
#date#
select * AS cc from tableA
select newCola(colA) from table as colaName
select colA+","+colB+","+colA AS ONEcol from table
select CONCAT(colaA+','+colB) AS ONEcol from table 
select a.B,b.B from TT as a, TT as b where a.B = b.B ....
select ... from inner join on a.C = b.C;
/*	inner = only if it matched in BOTH tables
	left = all the ones from left that matched
	right = all the ones from right that matched
	full = all the rows that were matched in ETIEHR on of the table
	left outer join = all the lefts, and the matched ones from left
	right outer join = all the rights, and the matched ones from right
	full outer join = all the rows matched or no matched
*/
select ... from a join b on a.C = b.C /* default = full */
select ... from a UNION select ... from b
select ... from a UNION ALL select ... from b
select ... INTO backUPtable IN 'database.mdb' from T
select ... INTO backUPtable from T /* in same DB */
insert into Tabl select ... from where....
insert int Tabl(colA,colB) select .. from where .. /* insert only colA,colB */
select * from .. where datee = '2008-11-11'; date
select * from .. where datee = '2008-11-11 13:23:44'; datetime / timestamp
select * from ... where year = '2008'; year
select * from ... where addd is null;
			/* all rows that doesn't have value in that colmn */
select avg(colName) from T
select avg(colName) as A from T	/* return 1 row */
select * from T where p > (select avg(p) from T)
select count(distinct col) from T	/* return 1 row */
select first(colA) from T 	/* return 1 row */
select last(colA) from T 
select max(colA) from T 
select min(colA) from T
select sum(colA) from T /*ALL can be multiple with group by*/
select sum(col) from T group by cols
select count(col) from T group by cols
select .. from ((a join b on..) join c on ...) group by
select .. from ... group by having count(..) > 10
select ucase(col) from ... /* upper case */
select upper(col) from ...
select lcase(col) from ... /* lower case */
select lower(col) from ...
select mid(city,1,4) from .... /* only cities with 4 characters */
select len(name) from ... /* shows length of names */
select round(col,0) from .. /* round numbers 0 digits after the . */
select *,now() from ... /* puts the current timestamp */
select *,format(now(),'YYYY-MM') as .. from ...
WHERE ((current_timestamp-timestmp)<time'00:10:00')
Select OO.c.... from tab join (select count as c....) as OO on tab.ID = OO.c
	/* ^ must show new column if it used in the join condition
			table join (select...) {NOT}->(table join (select..)) */

