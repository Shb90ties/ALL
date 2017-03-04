/* Auto increment replacement */
Create trigger trig
before insert on tableT
	execute procedure funcA()

create or replace function funcA()
return trigger as $$
BEGIN
	declare @r int;
	@r = 0;
	select @r=id_ from tableT order by id_ desc limit 1;
	NEW.id_ = (@r+1);
	return NEW;
END $$ Language 'plpgsql'

/*__________________________*/

select OO.c,CustomerName,LastName,FirstName from Employees join (SELECT CustomerName,count(OrderID) AS c FROM Customers join Orders on Customers.CustomerID = Orders.CustomerID group by Customers.CustomerID order by c desc limit 5) as OO on Employees.EmployeeID = OO.c


/* all people that doesn't have n in their name */
select * from Employees where FirstName not in (select FirstName from Employees where FirstName like '%n%')

select * from Employees where FirstName like 'A%'
union
select * from Employees where FirstName like 'N%'
order by EmployeeID desc
