SELECT * FROM film LIMIT 40
/* '*' = all the columns
	FROM = source the table name
	LIMIT = only the first 40 according to the
					first column mentioned or key column */
SELECT release_year FROM film LIMIT 30
/*	will give only the release year column */
SELECT film.release_year FROM film LIMIT 30
/* can always write 'table name'.'column name'
	its the second way to get the same result */
SELECT release_year FROM film LIMIT 30;
SELECT description FROM film LIMIT 15;
/* if there is more than 1 command put ';' at the end */
SELECT release_year,description FROM film LIMIT 30;
/* select 2 or more columns at the same time
	possible with ',' between them */
SELECT DISTINCT replacement_cost FROM film LIMIT 30;
/* remove duplicates,first comes first showed */
INSERT INTO cities VALUES ('dimona',43,.....); ('hadera',85....);....
/* way to insert from Query to a table, here its 'cities */
SELECT description FROM film LIMIT 5, 10
/* will give you 6,7,8,9,10,....15 */ 
SELECT * SELECT * FROM Customers ORDER BY PostalCode
/* will arrange the rows according to the value in 'postalCode'
	if 'postalCode' is char, will be a,b,c,d....
		if its integer will be 000 001 0002..... */
SELECT Address FROM Customers ORDER BY CustomerID
/* can always be sorted by the key column  */
SELECT * FROM Customers ORDER BY CustomerID,City
/* after sorting by ID if some are the same second priority
		is order by City */
SELECT * FROM Customers ORDER BY CustomerID DESC
/* Order by REVERSE high to low */
SELECT LastName FROM Employees ORDER BY BirthDate LIMIT 1
/* Gives you the oldest employee
	sorted by date then limit it to 1 */
SELECT * FROM Employees WHERE EmployeeID=7
SELECT * FROM Employees WHERE EmployeeID!=7
SELECT * FROM Employees WHERE EmployeeID>7
SELECT * FROM Employees WHERE EmployeeID<7
/* filtering according to the ID we want can also be >= <= */
SELECT * FROM Employees WHERE EmployeeID BETWEEN 5 AND 14
/* filtering just the ones who are between 5~14 */
SELECT * FROM Employees WHERE LastName='Buchanan'
/* WHERE doesn't have to be numbers */
SELECT * FROM Employees WHERE LastName='Leverling' AND FirstName='Janet'
/* search with the && option, AND */
SELECT * FROM Employees WHERE LastName='Davolio' OR FirstName='Margaret'
/* search with the || option, OR */
SELECT * FROM Employees WHERE EmployeeID=4 OR EmployeeID=1 AND LastName='Peacock'
/* OR + AND, SQL execute the commands from left to right
	so it was [(** OR **) AND (**) ] execute the OR first
		then on the table that it got use the AND command */
SELECT * FROM Products WHERE SupplierID IN (1,7,4,3)
/* equal to SupplierID=1 OR =7 OR =4 OR.... its a short cut */
SELECT * FROM Products WHERE SupplierID IN (1,7,4,3) ORDER BY SupplierID
/* recommand to order it by something (same column)  */
SELECT * FROM Products WHERE SupplierID NOT IN (1,7,4,3) ORDER BY SupplierID
/* NOT IN it reverses the test from before */
SELECT * FROM Products WHERE ProductName LIKE "CH%"
/* gives you all the ones that STARTS with 'CH' */
SELECT * FROM Products WHERE ProductName LIKE "%e"
/* everything that ENDED with 'e'
	its all according to the location of the % */
SELECT * FROM Products WHERE ProductName LIKE "%ee%"
/* everything that has 'ee' in it somewhere */
SELECT * FROM Products WHERE ProductName LIKE "A%p"
/* anythign that STARTS with A and ENDS with p */
SELECT * FROM Products WHERE Unit LIKE "_ kg"
/* any 1 CHARACTER that has ' kg' after it */
SELECT * FROM Products WHERE ProductName REGEXP "Chais"
/* regEXP regular expression, anything that has the WORD Charis */
SELECT * FROM Customers WHERE ContactName REGEXP ".Anders"
/* searching for the word (.)Andres , . = any char */
	Ways of writing with "" or REGEXP
		(.)=anything, any digit,char,space ect...
			/* (.x) = if there is x and something behind it */
		(_)=any character
			/* (_x) = if there is x and some char behind it */
		(%x)=x at the end of the line/word
		(x%)=x at the start of the line/word
		(%x%)=there is 'x' somewhere in the line/word
		(|)=(x|y)= if there is 'x' or 'y' in it
		([xy....])=a character that is either x or y or ...ect
			/* ([123]x) = if there is 1x or 2x or 3x */
		(^)= not! anything other than the next char
			/* [^xy]ola = anything other than xola or yola */
		(-)=a series, [1-5] = 1,2,3,4,5 , [a-d]= a,b,c,d
		/*search more on SQL regular expressions */
	Functions, after every function there is a '(..)'
		CONCAT() = create a new column from a joint previous ones
		UPPER() = creates a new column with upper case characters
		SQRT() = creates a square root column
		AVG() = creates an average column and return just 1 row
		SUM() = creates a sum column returns 1 row
		COUNT() = returns 1 row with new col with the numbers of founds
		MAX() = gives you the max number, in col insterted in new col
		MIN() = gives the minimum same as ^ but minimum
		ALTER TABLE x ADD FUNCTION()
			FULLTEXT(column) = makes the col a search engine
				MATCH(column) AGAINST("WORD") , way to search^
				AGAINST('+x -y' IN BOOLEAN MODE)
					make sure x is included and y isnt
		
		
SELECT * FROM ForgeRock WHERE description REGEXP 'Platform|access'
/* any description that has Platform or access WORDS in it */
SELECT * FROM ForgeRock WHERE description REGEXP '[nf]or'
/* any word that is 'nor' or 'for' */
SELECT CONCAT(id,' + ',productName) AS new_col FROM ForgeRock
/* will create a new column with the name 'new_col'
	that has "ID + productName" in it */
SELECT CONCAT(id,' + ',productName) AS new_col,description FROM ForgeRock
/* add to the new column an existing one the 'description' */
SELECT *,id-1 AS previous_ID FROM ForgeRock
/* creates a new column from ID but Subtracting -1
		from each of its values, needs to be integer
			or atleast a numbers column */
SELECT *,id*5 AS previous_ID FROM ForgeRock
SELECT *,id+7 AS previous_ID FROM ForgeRock
SELECT *,id/3 AS previous_ID FROM ForgeRock
/* and any other mathematical sign */
SELECT *,UPPER(productName) AS previous_ID FROM ForgeRock
/* creates a new column with UPPER CASE characters 
	from the previous one, the previous one has to be
		a character column */
SELECT *,SQRT(id) AS New_Col FROM ForgeRock
/* creates a square root column from a previous column */
SELECT *,AVG(id) AS New_Col FROM ForgeRock
/* gives you ONE ROW with a new column that has the
	average of the column you chose to put in,
		by default it will give you the first row */
SELECT *,SUM(id) AS New_Col FROM ForgeRock
/* returns one column with the SUM of the columns chosen */
SELECT *,COUNT(id) AS New_Col FROM ForgeRock
/* returns one row with the number of the rows found */
SELECT *,MAX(id) AS New_Col FROM ForgeRock
/* creates a new column with the max number of the
	column been sent to it */
SELECT *,COUNT(productName) AS New_Col FROM ForgeRock GROUP BY productName
/* grouping rows by the column 'productName' into 1
	and the last call of the function will be display in that
		row, so the last count of the 'productName' will be there */
SELECT *,MAX(damages) AS New_Col FROM ForgeRock GROUP BY productName
/* grouping by productName to 1 row, and the new_col
	will be the max damages that productName in that 1 row got */
SELECT *,MAX(damages) AS New_Col FROM ForgeRock GROUP BY productName
	HAVING MAX(damages)>=90
/* after the group by HAVING will remove rows that their
	new MAX column is lower than 90, to sort them with max
		you must have a MAX function column already */
SELECT *,MAX(damages) AS New_Col FROM ForgeRock GROUP BY productName
	HAVING MAX(damages)>=90 ORDER BY New_Col
/* can also ORDER BY a new column that was created in the same
	command/query */
SELECT *,MAX(damages) AS New_Col FROM ForgeRock GROUP BY productName
	HAVING MAX(damages)>=90 ORDER BY New_Col DESC
/* same thing but highest to lowest */

/* EXCEPT => A-B */
	SELECT * FROM employees
		EXCEPT
			SELECT * FROM employees AS e1 WHERE e1.ename = 'dafna'
		/* only has to rename the table ^ if its been used twice */
			/* returns all the raws that dafna are not in them */

			
 SELECT * FROM ForgeRock WHERE damages>(
   SELECT AVG(damages) FROM ForgeRock
     ) ORDER BY damages
/* Subqueries OR Sub Query, instead of typing..
	WHERE damages>(some number) we put another Query there
		it runs the inside query first then the outside one */
 SELECT *,MIN(damages) FROM ForgeRock 
   WHERE productName Like 'open%' AND status IN(
     SELECT status FROM ForgeRock WHERE status = 'open')
/* IN is a command to take a column from INside a list
	the list given has to be of the same column ONLY */
 SELECT *,MIN(damages) FROM ForgeRock 
   WHERE status IN(
     SELECT status FROM ForgeRock WHERE status = 'open')
/* same result shorter */
SELECT ForgeRock.*,Rocks.* FROM ForgeRock,Rocks
  WHERE ForgeRock.id=Rocks.id ORDER BY ForgeRock.id
 /* JOIN tables, to include columns its [table name].[col name]
	FROM table1,table2.... WHERE is how you compare between them */
SELECT ForgeRock.*,Rocks.Location,RandomPeople.name 
    FROM ForgeRock,Rocks,RandomPeople
      WHERE ForgeRock.id=Rocks.id 
          AND Rocks.Location=RandomPeople.Location
/* join between 3 tables if there is duplicates
			will show same row with a different end option */
SELECT RandomPeople.name,Rocks.* FROM RandomPeople 
      LEFT OUTER JOIN Rocks ON Rocks.Location=RandomPeople.Location
/* if there is in RandomPeople column names that don't match
	Rocks will put them there anyways with NULL on the column */
SELECT RandomPeople.name,Rocks.`Rock Colour` FROM RandomPeople 
      RIGHT OUTER JOIN Rocks ON Rocks.Location=RandomPeople.Location
/* same as left outer join but from the table given later
		on the right point of view */
SELECT * FROM ForgeRock WHERE id>5
  UNION
    SELECT * FROM ForgeRock WHERE damages>30
/* UNION between to commands, like saying WHERE id>5 OR dameges>30
	remove duplicates! */
SELECT * FROM ForgeRock WHERE id>5
  UNION ALL
    SELECT * FROM ForgeRock WHERE damages>30
/* same but leave duplicates if one was in the first will pop again
	in the second */
SELECT * FROM ForgeRock WHERE MATCH(description) AGAINST("cnot")
/* for tables that has FULLTEXT function in them
	it also tanks it by how well it was matched */
SELECT * FROM ForgeRock 
  WHERE MATCH(description) AGAINST("+1is -1st" IN BOOLEAN MODE)
/* make sure 1is is included and 1st isn't included */
UPDATE Foods SET Description='impossible' 
  WHERE Description REGEXP 'possible';
/* change in Food at Description to ='..' Where it match
		what we want */
UPDATE Foods SET Description='impossible',category='ruined!'
  WHERE Description REGEXP 'possible';
/* changes 2 things the Description to impossible and
	category to ruined, on rows that match the WHERE */
DELETE FROM table WHERE id='x'
/* deleting rows from table, always delete by primary key */
`id` int NOT NULL AUTO_INCREMENT,
/* means the id will increase itself or decrease itself
	after you put or remove a row
		when inserting a row, put 0 when the id value is */
ALTER TABLE Foods ADD AnotherColumn varchar(15);
/* add a column */
ALTER TABLE Foods DROP COLUMN AnotherColumn;
/* remove a column */
RENAME TABLE Foods TO Feeds;
/* change a table name */
primary key(column)
/* the ID of each row cannot be the same in 2 rows */
foreign key('column from other table') references  'the other table'
/* you create a column in your table and link it
	to another column making it the same in the other table
		by saying its a foregin key, has to have the same values */
(select rId from realtors) intersect (select bid from buyers)
	/* intersect is like (A n B) the common group of the two */
		/* rID and bID are of the same nature so it can be used as a tool */
			/* to compare between the two */
reminder : <> ~ !=
WHERE NOT EXIST
  CREATE VIEW temp AS
      SELECT DISTINCT
        bId,address,rId
          FROM
            visits ORDER BY address,bId
/* creates a new temporary table */
IS NULL and IS NOT NULL
 =, <, or <>.
 
SELECT * FROM finalViewQu9 WHERE time BETWEEN '12:00:00' AND '23:59:59';

/* EXCEPT => A-B */
	1) SELECT * FROM employees
			EXCEPT
				SELECT * FROM employees AS e1 WHERE e1.ename = 'dafna'
		/* only has to rename the table ^ if its been used twice */
			/* returns all the raws that dafna are not in them */

/* MAKE => AxB */
	SELECT * FROM works INNER JOIN works AS w1 ON works.cname = w1.cname
		/* ^ AxA on some row .......................^
		/* makes all the possible couples */
	SELECT  * FROM works INNER JOIN works AS w1 ON works.cname = w1.cname
		WHERE works.ename = 'shimon' AND  w1.ename = 'amir'
			/* employeer that has shimon AND amir under him */

/*NEW METERIAL */

/*1.Select in Select */
SELECT CustomerID,City FROM (select * FROM Customers WHERE City like "C%") WHERE CustomerID > 32 AND CustomerID  < 40

/*2.select by date, (year,month,day) , YYYY-MM-DD */
SELECT * FROM [Orders]  WHERE OrderDate > '1997-01-01'
/* all orders from 1997 on wards */

/*3.select orders only from 1996 */
SELECT * FROM [Orders]  WHERE OrderDate > '1996-01-01' and OrderDate < '1996-12-31'
/*oprion 2*/
SELECT * FROM [Orders]  WHERE OrderDate > '1996-01-01' and OrderDate < '1997-01-01'

DATETIME - format: YYYY-MM-DD HH:MI:SS
/*same principle as date*/	example '1996-01-01 00:00:00'

/*4.selecting fields from other tables in multiple select require "AS" */
SELECT AA.OrderID FROM 
(( select * from OrderDetails where OrderDetails.Quantity > 10 )AS AA)
/* the temp table from the other select will be named AA */

/*5.making a table only of ID can perform A-B */
SELECT * FROM Orders WHERE OrderID NOT IN
	(SELECT OrderID FROM OrderDetails where OrderDetails.Quantity > 10)
		AND OrderDate > '1996-08-01'
/* can work only if its the same name not table.ID */

/*6.Having count without starting a new col for it */
SELECT * FROM OrderDetails WHERE OrderID IN
( SELECT OrderID FROM Orders GROUP BY Orders.EmployeeID HAVING count(Orders.OrderID)>25 )
GROUP BY OrderID
/*for WHERE NOT */

/*7.comparing fields on simple multi table select */
SELECT A.colum FROM A,B
	WHERE A.id = B.id AND
		A.xix = B.Other_xix AND
			B.end_date = NULL

/*8.controlling group by, by having it show only the max quantity cols */
SELECT *,count(OrderID) as Times FROM [OrderDetails] GROUP BY ProductID HAVING MAX(Quantity)

/*9.using it with other functions*/
SELECT *,count(OrderID) as Times FROM [OrderDetails] GROUP BY ProductID HAVING AVG(Quantity);
SELECT *,count(OrderID) as Times FROM [OrderDetails] GROUP BY ProductID HAVING MIN(Quantity);

/*10.having sum with group by */
SELECT *,count(OrderID) as Times,SUM(Quantity) as Sum
 FROM [OrderDetails] GROUP BY ProductID
 
/*11.picking rows according to their sum with group by */
SELECT *,count(OrderID) as Times
 FROM [OrderDetails] GROUP BY ProductID
  Having SUM(Quantity)>100
  
/*12.multiple HAVING, in group can't use WHERE, so use HAVING */
SELECT *,count(OrderID) as Times,sum(Quantity) as SumQuantity
 FROM [OrderDetails] GROUP BY ProductID
  Having SUM(Quantity)>100 AND MIN(Quantity) AND OrderID > 10400
  
/*13.Simple OR statements */
SELECT * FROM [Orders] WHERE CustomerID = 65 OR CustomerID = 20

/*14.passing arguments inside the second select '()' */
SELECT * FROM [Customers] WHERE
(SELECT CustomerID FROM [Orders]
	where OrderID > 10276 AND OrderID < 10280 
		AND Customers.CustomerID = Orders.CustomerID )
		/* ID from the outside table, and the inside table */
			/* usually do it with natural join in the outside select */

/*15. WHERE value in ANOTHER TABLE? with different names */
SELECT * FROM [Products] WHERE ProductID in
	( SELECT ShipperID FROM Shippers)
	/* picks all the ProductID that are equal to ShipperID */
		/* the colmns doesn't have to have the same name */

/*16. NATURAL JOIN */
SELECT * FROM Orders NATURAL JOIN OrderDetails
	WHERE Orders.CustomerID = 80 AND OrderDetails.Quantity > 14 
	/* both have OrderID one as a foreign key and the other
		as a primary key, will detect the common key and connect the two
			with it*/

/*17. number of rows found in a natural join according to Where */
SELECT COUNT() AS how_many_rows FROM Orders NATURAL JOIN OrderDetails
	WHERE Orders.CustomerID = 80 AND OrderDetails.Quantity > 14
	/* count() will show 1 row with the number of rows the table
		had before the count command */

/*18.HAVING with more than one function */ 
SELECT *,COUNT(ProductID) AS c FROM [OrderDetails] GROUP BY OrderID
	HAVING count(ProductID) >=4 AND max(ProductID)
	
/*19.MAX only shows one row, used in the start of the command */
SELECT MAX(OrderID) FROM [OrderDetails]

/*20. show MAX row without starting a max Column for it */
SELECT * FROM [OrderDetails] GROUP BY OrderID ORDER BY
	count(OrderDetailID) DESC LIMIT 1
	/*count will show the number of row that poped most times*/
	
/*21.comparing rows from the same table */
SELECT * FROM table_a A1,table_a A2
	WHERE A1.x = A2.x AND A1.y <> A2.y
	
	
/* TRIGGER */

/* check if trigger is already exists, if so then drop it */
IF OBJECT_ID('some_new_trigger') IS NOT NULL
	DROP TRIGGER some_new_trigger
GO


CREATE TRIGGER some_new_trigger
ON some_tables_name
AFTER UPDATE, INSERT  /* options AFTER INSERT or UPDATE or DELETE */
/* trigger will take place after an update or an insert */
AS
	BEGIN
	/* here is all the code */
		print 'You inserted or updated something';
	END
GO /* final confirm */
/*when we update something*/

UPDATE some_tables_name
SET some_column_X_in_the_table = 'new_value'
WHERE some_column_in_the_table = 'old_value'
/* will change whenever there is old_value to new_value in column X */
	/* will print 'You inserted or updated something' , because of the trigger */

INSERT INTO some_table_name(colmn_a_name,colmn_b_name,.....)
	VALUES ('value for a','vlaue for b'....)
/* trigger will print again because we updated */



CREATE TRIGGER some_new_trigger
ON some_tables_name
AFTER INSERT, UPDATE
AS
	BEGIN
		SELECT * FROM some_table
		WHERE colum_x = ( SELECT column_x FROM INSERTED )
	END
GO
/* will show the row that was change after the insert */
	/* INSERTED is a temp table of what we inserting to our table */

	

CREATE TRIGGER some_new_trigger
ON some_tables_name
INSTEAD OF INSERT, UPDATE /* instead of updating or inserting, do this */
AS							/* not that useful trigger */
	BEGIN
		SELECT * FROM some_table
		WHERE colum_x = ( SELECT column_x FROM INSERTED )
	END
GO
/* instead of inserting will show the row that in the table that match */
	/* what we wanted to insert (if it exists already in our table ) */


CREATE TRIGGER some_new_trigger
ON some_tables_name
AFTER DELETE
AS
	BEGIN		
		SELECT * FROM DELETED
	END
GO
/* will show the row/rows that were deleted */
	/* like INSERTED, DELETED is a temp table of what was deleted */
/* then command */
DELETE FROM some_tables_name
WHERE some_column_value = 'some_value'
/* will show the table that was deleted */



CREATE TRIGGER some_new_trigger
ON some_tables_name
AFTER DELETE, UPDATE 
AS
	BEGIN
		SELECT * FROM INSERTED
		SELECT * FROM DELETED
	END
GO
/* then command */
UPDATE some_tables_name
SET some_column_X_in_the_table = 'new_value'
WHERE some_column_in_the_table = 'old_value'
/* it will show the old table that was removed for the updated one */
	/* will also show the new table that was inserted for the old one */
		/* UPDATE creates both INSERTED temp and DELETED temp */

		
CREATE TRIGGER limit_checking_trigger
ON table_name
AFTER INSERT, UPDATE
AS
	BEGIN
		DECLARE @columnID INT /* must match with String to String or int to int */
		/* like installing a value with a name, like (int @columnID;) */
		SELECT @columnID = column_x FROM INSERTED
		/* installing a value in it */
		DECLARE @count_ INT
		SELECT @count_ = 
			COUNT(*) FROM table_name WHERE column_x = @columnID
		/* @count_ will have the value of how much time @columnID shows */
		
		IF( @count_ >= 10 )
			BEGIN					// ("string",level of threat, always 0 )
				RAISERROR("can't add anymore rows to that ID", 10,0)
				ROLLBACK
				/* undo what ever they tried to do */
			END
	END
GO
/* if you inserted something which is ID is over 10 it will not insert it */
	/* will also show you error */
	
	
	
	
/* function with a trigger launching it for each row */
CREATE FUNCTION new_function() RETURN TRIGGER AS $$
DECLARE @bad_record RECORD;
	BEGIN
		SELECT table_x.Column_y,table_x.Column_z INTO @bad_record
			/* will move what ever piece of table that was found to bad_record */
		FROM table_x WHERE table_x.Column_y > table_x.Column_z
		
		IF		EXISTS @bad_record
			BEGIN RAISE NOTICE 'bad record!';
				RAISE NOTICE 'a bad record was found in % at %',
											table_x.Column_y,table_x.Column_z;
				/* % will be the value given after the '..',(value) */
				RETURN OLD;
			END
		ELSE
			RETURN NEW;
		END IF;
	END
$$LANGUAGE PLPGSQL;

CREATE TRIGGER check_for_bad_record
BEFORE INSERT, UPDATE
ON table_x
	FOR EACH ROW
		EXECUTE PROCEDURE new_function();
		
/* simple function */


		

Building the Database for the example /*




CREATE TABLE ForgeRock
	(`id` int NOT NULL AUTO_INCREMENT,
     `productName` varchar(7) NOT NULL,
     `description` varchar(55) NOT NULL,
     `damages` int,
     `status` varchar(30) NOT NULL,
     PRIMARY KEY(id)
    )
;
	
INSERT INTO ForgeRock
	(`id`, `productName`, `description`, `damages`,`status`)
VALUES
	(0,'OpenIDM', 'Platform for building enterprise provisioning solutions', 53, 'open'),
	(0,'OpenAM', 'Full-featured access management', 71, 'open'),
	(0,'OpenDJ', 'Robust LDAP server for Java', 83, 'close'),
    (0,'OpenFG', 'nor is the server of lor', 102, 'open'),
    (0,'OpenZG', '1is 2is 3is anot bnot cnot dnot', 12, 'close'),
    (0,'OpenZK', '5is 7is 8is enot fnot gnot hnot', 27, 'bankrupt'),
    (0,'OpenJK', 'for on array will give you headask', 98, 'close'),
    (0,'OpenIDM', 'for on array will give you headask', 96, 'bankrupt'),
    (0,'OpenIFM', '1st 2nd 3rd 4th 5th cnot dnot', 133, 'bankrupt')
;

CREATE TABLE Rocks
	(`id` int,
     `Rock Colour` varchar(15) NOT NULL,
     `Location` varchar(55) NOT NULL,
      PRIMARY KEY(id)
    )
;

INSERT INTO Rocks
	(`id`, `Rock Colour`, `Location`)
VALUES
	(1, 'Dark rock', 'New York'),
	(2, 'Light rock', 'Some dark hole'),
	(3, 'Blue rock', 'No idea'),
    (4, 'Dark rock', 'Alabama'),
    (5, 'Silver rock', 'No idea'),
    (6, 'Light rock', 'Mexico'),
    (7, 'Dark rock', 'Some dark hole'),
    (8, 'Blue rock', 'Alabama'),
    (9, 'Light rock', 'No idea')
;

CREATE TABLE RandomPeople
	(`id` int NOT NULL,
     `name` varchar(15) NOT NULL,
     `Location` varchar(55) NOT NULL,
     `food` varchar(30) NOT NULL,
      PRIMARY KEY(id)
    )
;

INSERT INTO RandomPeople
	(`id`, `name`, `Location`, `food`)
VALUES
	(6, 'Josh', 'New York','Italian'),
	(3, 'Suzena', 'Some dark hole','Chinese'),
	(2, 'Charls', 'No idea','Sushi'),
    (1, 'Rihanna', 'Alabama','Grilled'),
    (5, 'Ashley', 'London','Vegeterian'),
    (9, 'Havier', 'Mexico','Fast food'),
    (4, 'Lorla', 'Corn','Grilled'),
    (8, 'Kreps', 'Zardinya','Sushi'),
    (7, 'Katy', 'Fluffy dogs','Sushi')
;

CREATE TABLE Foods
	(`category` varchar(30) NOT NULL,
     `Description` varchar(50),
      PRIMARY KEY(category)
    )
;

INSERT INTO Foods
	(`category`, `Description`)
VALUES
	('Italian','pie or others that will make you fat'),
	('Chinese','nodels and fish smells bad'),
	('Sushi','fish and rice vegies'),
    ('Grilled','tons of meat possible heart attack'),
    ('Vegeterian','only vegtables no iron in yar body'),
    ('Fast food','shitty meat probably a heart attack')
;


ALTER TABLE ForgeRock ADD FULLTEXT(description);
ALTER TABLE Foods ADD FULLTEXT(Description);


/*	RandomPeople{id,name,Location,food}
	Rocks{id,`Rock Colour`,Location}
	ForgeRock{id,productName,description,damages,status}
    Foods{category,Description} */
	*/
Fold it

