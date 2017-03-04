if Object_id('TriggerA') is not NULL
	drop trigger TriggerA
GO 
	/* delete incase it already existed */
Create Trigger TriggerA
ON TableA
[INSTEAD | After] [Delete, Update | Insert]
AS	/* New Old ~ Deleted Inserted, that were affected */
	Begin
		select * from INSERTED
		select * from DELETED
	End
GO



create trigger TriggerB
ON tableB
INSTEAD of insert,update
as
	BEGIN
		declare @i int;
		select @i=city from INSERTED
			if (@i == 'haifa')
			BEGIN
				raiserror("haifa can't be affected");
				ROLLBACK;
			end
	END
go

/*___________________________ postgreSQL*/


Create Trigger triggA
BEFORE UPDATE ON tableA /* AFTER | Instead of */
	FOR EACH ROW
	EXECUTE PROCEDURE functionA();
		/* function on each row */
CREATE OR REPLACE FUNCTION functionA()
RETURNS trigger AS
$$ BEGIN
	IF (NEW.colA <> OLD.colA)
	THEN
		INSERT into tabl(..) VALUE(OLD.id,...)
	ENDIF
	RETURN NEW;
END $$
LANGUAGE 'plpgsql';