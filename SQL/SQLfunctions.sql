DO
$body$
BEGIN
	if exists(select...) then raise notice 'dddfd';
	end if;
END
$body$

create function TT(arg varchar(15))
returns table (.....) /* must match what is found */
AS $$
begin
	select * ... where a = $1;
	return QUERY select .... = $1;
end
$$ language plpgsql;

Select * from TT('ddd')


create or replace function TT()
returns setof tableA
AS $body$
declare r tableA%rowtype;
begin
	for r in select * from tableA contidions....
	LOOP
		if.....
		return next r;
	end loop;
	return;
end
$BODY$
LANGUAGE 'plpgsql';


do
$body$
declare i bonus%rowtype
BEGIN
	for i in select * from bonus
	LOOP
		update workers set workers.wages = (workers.wages+i.bonus)
			where workers.wages < 1000 and workers.id = i.id
	end LOOP
end
$body$