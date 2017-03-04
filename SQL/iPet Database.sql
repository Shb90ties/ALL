/* PostgreSQL Login Role :
		Username : petBIT
		pass : 01235
		Database name : petBITdb
			( DB owner : petBIT )	*/
			
/* select connect_all_userpets('all') */			


create table OwnerUsers 
(
   userName varchar(15) primary key,
   status varchar(3) NOT NULL,
   password varchar(15) NOT NULL,
   phoneNumber varchar(10) NOT NULL
);

INSERT INTO public.ownerusers(username, status, password, phonenumber) VALUES ('Shay', 'off', '012345', '0548888888');
INSERT INTO public.ownerusers(username, status, password, phonenumber) VALUES ('admin', 'off', '01234', '000');
INSERT INTO public.ownerusers(username, status, password, phonenumber) VALUES ('test1234', 'off', '012345', '0548888888');
INSERT INTO public.ownerusers(username, status, password, phonenumber) VALUES ('locationUser', 'off', '01234', '000');



create table petsNumbers 
(
   petNumber varchar(15) primary key,
   status varchar(5)
);

INSERT INTO public.petsnumbers(petnumber,status) VALUES ('0541111111','on');
INSERT INTO public.petsnumbers(petnumber,status) VALUES ('0547777777','on');
INSERT INTO public.petsnumbers(petnumber,status) VALUES ('0542222222','on');
INSERT INTO public.petsnumbers(petnumber,status) VALUES ('0543333333','on');
INSERT INTO public.petsnumbers(petnumber,status) VALUES ('0544444444','on');
INSERT INTO public.petsnumbers(petnumber,status) VALUES ('0545555555','on');
INSERT INTO public.petsnumbers(petnumber,status) VALUES ('0546666666','on');
INSERT INTO public.petsnumbers(petnumber,status) VALUES ('0540000000','on');
INSERT INTO public.petsnumbers(petnumber,status) VALUES ('0548888888','on');


create table OwnersPetsLink 
(
   ownerName varchar(15),
   petName varchar(15),
   petNumber varchar(15) NOT NULL,
   icon varchar(5),
   age varchar(4),
   size varchar(10),
   primary key(ownerName,petName),
   foreign key(ownerName) references OwnerUsers(userName) on delete cascade,
   foreign key(petNumber) references petsNumbers(petNumber) on delete cascade
);

INSERT INTO public.ownerspetslink(ownername, petname, petnumber, icon, age, size) VALUES ('admin', 'joshua', '0541111111', '3','12.5','small');
INSERT INTO public.ownerspetslink(ownername, petname, petnumber, icon, age, size)  VALUES ('test1234', 'horse', '0547777777', '5','0.5','small');
INSERT INTO public.ownerspetslink(ownername, petname, petnumber, icon, age, size)  VALUES ('test1234', 'door', '0540000000', '2','0.11','medium');
INSERT INTO public.ownerspetslink(ownername, petname, petnumber, icon, age, size)  VALUES ('test1234', 'glass of water', '0542222222', '8','1.4','big');
INSERT INTO public.ownerspetslink(ownername, petname, petnumber, icon, age, size)  VALUES ('test1234', 'unMarkerd pet', '0548888888', '0','5.8','medium');
INSERT INTO public.ownerspetslink(ownername, petname, petnumber, icon, age, size)  VALUES ('locationUser', 'zebra', '0543333333', '13','9.3','big');
INSERT INTO public.ownerspetslink(ownername, petname, petnumber, icon, age, size)  VALUES ('locationUser', 'human being', '0544444444', '16','4.7','medium');
INSERT INTO public.ownerspetslink(ownername, petname, petnumber, icon, age, size)  VALUES ('locationUser', 'red car', '0546666666', '19','0.2','small');

create table FriendsList 
(
   userName varchar(15),
   FriendName varchar(15),
   primary key(userName,FriendName),
   foreign key(userName) references OwnerUsers(userName) on delete cascade,
   foreign key(FriendName) references OwnerUsers(userName) on delete cascade
);

INSERT INTO public.friendslist(username, friendname) VALUES ('admin', 'Shay');
INSERT INTO public.friendslist(username, friendname) VALUES ('test1234', 'locationUser');
INSERT INTO public.friendslist(username, friendname) VALUES ('test1234', 'admin');

create table PetsLocation 
(
   petNumber varchar(15),
   Lat  NUMERIC,
   Lon NUMERIC,
   primary key(petNumber),
   foreign key(petNumber) references petsNumbers(petnumber) on delete cascade
);

INSERT INTO public.petslocation(petnumber, lat, lon) VALUES ('0540000000', '32.445714', '34.898833');
INSERT INTO public.petslocation(petnumber, lat, lon) VALUES ('0541111111', '32.44583336093848', '34.898888171010185');
INSERT INTO public.petslocation(petnumber, lat, lon) VALUES ('0542222222', '32.445729', '34.899163');
INSERT INTO public.petslocation(petnumber, lat, lon) VALUES ('0543333333', '32.446219', '34.89934');
INSERT INTO public.petslocation(petnumber, lat, lon) VALUES ('0544444444', '32.445869', '34.899364');
INSERT INTO public.petslocation(petnumber, lat, lon) VALUES ('0545555555', '32.446227', '34.897479');
INSERT INTO public.petslocation(petnumber, lat, lon) VALUES ('0546666666', '32.446411', '34.898613');
INSERT INTO public.petslocation(petnumber, lat, lon) VALUES ('0547777777', '32.44563643489031', '34.89816665645776');

create table Messages 
(
   CommentNum SERIAL,
   userName varchar(15),
   Messg varchar(300),
   primary key(CommentNum),
   foreign key(userName) references OwnerUsers(userName) on delete cascade
);

INSERT INTO public.messages(commentnum, username, messg) VALUES (DEFAULT, 'admin', 'test1234 : TEST000');
INSERT INTO public.messages(commentnum, username, messg) VALUES (DEFAULT, 'test1234', 'locationUser : TEST000');
INSERT INTO public.messages(commentnum, username, messg) VALUES (DEFAULT, 'locationUser', 'test1234 : TEST111');


create table NewMessages 
(
   userName varchar(15),
   primary key(userName),
   foreign key(userName) references OwnerUsers(userName) on delete cascade
);

INSERT INTO public.newmessages(username) VALUES ('admin');
INSERT INTO public.newmessages(username) VALUES ('locationUser');
INSERT INTO public.newmessages(username) VALUES ('test1234');


ALTER TABLE public.friendslist 
  OWNER TO "petBIT";
ALTER TABLE public.messages  
  OWNER TO "petBIT";
ALTER TABLE public.ownerspetslink
  OWNER TO "petBIT";
ALTER TABLE public.newmessages 
  OWNER TO "petBIT";
ALTER TABLE public.ownerusers  
  OWNER TO "petBIT";
ALTER TABLE public.petslocation   
  OWNER TO "petBIT";
ALTER TABLE public.petsnumbers    
  OWNER TO "petBIT";
  
  
CREATE FUNCTION locationInserter(petNumber varchar(15),lat numeric,lon numeric)
RETURNS text AS $$
BEGIN
	IF NOT EXISTS(
		SELECT * FROM public.petslocation WHERE 
						public.petslocation.petnumber = $1 )
		THEN
			INSERT INTO public.petslocation(petnumber, lat, lon) 
				VALUES ($1, $2, $3);
			RETURN 'Updated';

	ELSE
		UPDATE public.petslocation
			SET lat=$2, lon=$3
				WHERE public.petslocation.petnumber = $1;
		RETURN 'Updated';
	END IF;
END 
$$ LANGUAGE plpgsql;

ALTER FUNCTION public.locationinserter(character varying, numeric, numeric)
  OWNER TO "petBIT";

/* SELECT locationInserter('0548888888',32.445110,34.899775); */


CREATE FUNCTION messageInserter(userName varchar(15),message varchar(300))
RETURNS text AS $$
BEGIN
	IF NOT EXISTS(
		SELECT * FROM public.newmessages WHERE 
						public.newmessages.username = $1 )
		THEN
			INSERT INTO public.newmessages(username) VALUES ($1);
	END IF;
	INSERT INTO public.messages(commentnum, username, messg) 
		VALUES (DEFAULT, $1, $2);
	RETURN ('message inserted to DB for ',$1);
END 
$$ LANGUAGE plpgsql;

ALTER FUNCTION public.messageinserter(character varying, character varying)
  OWNER TO "petBIT";

/*SELECT messageInserter('test1234','you!'); */

CREATE FUNCTION messageSender(UN varchar(15))
RETURNS TABLE(
	commentnum integer,
	username varchar(15),
	messg varchar(300)
) AS $$
BEGIN
	IF EXISTS(
		SELECT * FROM public.newmessages WHERE 
						public.newmessages.username = $1 )
		THEN
			DELETE FROM public.newmessages 
				WHERE public.newmessages.username = $1;
	END IF;
	RETURN QUERY 
		SELECT * FROM public.messages 
			WHERE public.messages.username = $1;
END 
$$ LANGUAGE plpgsql;

ALTER FUNCTION public.messagesender(IN character varying)
  OWNER TO "petBIT";

/* SELECT * FROM messageSender('test1234') */


ALTER TABLE public.petsnumbers 
ADD checkedIN TIMESTAMP

DO
$body$
DECLARE
	r public.petsnumbers%rowtype;
BEGIN
	FOR r IN SELECT * FROM public.petsnumbers
	LOOP
		UPDATE public.petsnumbers
		   SET checkedin= current_timestamp
			WHERE petnumber = r.petnumber;
	END LOOP;
END
$body$;


CREATE FUNCTION updateStatus()
RETURNS text AS $$
DECLARE
	r public.petsnumbers%rowtype;
	t BOOLEAN;
	outPt TEXT;
BEGIN
	FOR r IN SELECT * FROM public.petsnumbers WHERE status = 'on'
	LOOP
		t = ((current_timestamp-r.checkedin)>time'00:10:00');
		IF (t = true) THEN
			UPDATE public.petsnumbers
				SET status= 'off'
					WHERE petnumber = r.petnumber;
		END IF;
	END LOOP;
	
	outPt = 'offline';
	IF EXISTS (SELECT * FROM public.petsnumbers WHERE status = 'on')
	THEN
		outPt = 'online';
	END IF;
	
	RETURN outPt;
END 
$$ LANGUAGE plpgsql;

ALTER FUNCTION public.updatestatus()
  OWNER TO "petBIT";

/* SELECT updateStatus() */

CREATE FUNCTION loginInserter(petNumber varchar(15))
RETURNS text AS $$
BEGIN
	IF NOT EXISTS(
		SELECT * FROM public.petsnumbers WHERE 
						public.petsnumbers.petnumber = $1 )
		THEN
			INSERT INTO public.petsnumbers(petnumber,status,checkedin) VALUES ($1,'on',current_timestamp);
			RETURN 'Connected';

	ELSE
		UPDATE public.petsnumbers
			SET status='on',checkedin=current_timestamp
				WHERE public.petsnumbers.petnumber = $1;
		RETURN 'Connected';
	END IF;
END 
$$ LANGUAGE plpgsql;

ALTER FUNCTION public.logininserter(character varying)
  OWNER TO "petBIT";

/*SELECT loginInserter('0541111111')*/

CREATE FUNCTION connect_ALL_userPets(username varchar(15))
RETURNS text AS $$
DECLARE
	outPt TEXT;
BEGIN
	IF ($1 = 'all') 
	THEN
		UPDATE public.petsnumbers
			SET status='on', checkedin=current_timestamp;
		outPt = 'all pets are online';
	ELSE
		UPDATE public.petsnumbers
			SET status='on', checkedin=current_timestamp WHERE
				petnumber IN (SELECT petnumber FROM public.ownerspetslink 
							WHERE ownername = $1);
		outPt = ('set online of all the pets of ',$1);
	END IF;
	RETURN outPt;
END 
$$ LANGUAGE plpgsql;

ALTER FUNCTION public.connect_all_userpets(character varying)
  OWNER TO "petBIT";

/* SELECT connect_ALL_userPets('all') // active all the pets */
/* SELECT connect_ALL_userPets('username') // active user pets only */

create table illness 
(
   illName varchar(100),
   ENG_name VARCHAR(200),
   Physical_causes text,
   Mental_causes text,
   illDescription text,
   ill_diagnose text,
   ill_managment text,
   primary key(illName)
);

ALTER TABLE public.illness OWNER TO "petBIT";

INSERT INTO public.illness(
            illname, eng_name, physical_causes, mental_causes, illdescription, 
            ill_diagnose, ill_managment)
    VALUES ('linguistic extinction', 'death',
		'heart failure,injury,brain illness',
		'shock,depression,stupitidy',
		'being dead not living anymore passed on to the next world', 
		'your pet is dead',
		'burry your pet nothing else you can do');

create table symptoms
(
	symName varchar(100),
	symDescription text,
	primary key(symName)
);

ALTER TABLE public.symptoms OWNER TO "petBIT";

INSERT INTO public.symptoms(symname, symdescription) VALUES ('not moving', 'pet is on the ground not moving');
INSERT INTO public.symptoms(symname, symdescription) VALUES ('not breathing', 'pet doesnt breath');

create table illnesSymptons
(
	illName varchar(40),
	symName varchar(100),
	primary key(illName,symName),
	foreign key(illName) references illness(illName) on delete cascade,
	foreign key(symName) references symptoms(symName) on delete cascade
);

ALTER TABLE public.illnessymptons OWNER TO "petBIT";

INSERT INTO public.illnessymptons(
            illname, symname)
    VALUES ('linguistic extinction', 'not moving');
INSERT INTO public.illnessymptons(
            illname, symname)
    VALUES ('linguistic extinction', 'not breathing');
	
CREATE TABLE BPMList
(
	petNum VARCHAR(15),
	BPM VARCHAR(50),
	timeStmp TIMESTAMP,
	PRIMARY KEY(petNum,timeStmp),
	foreign key(petNum) references petsNumbers(petNumber) on delete cascade
)

ALTER TABLE public.bpmlist
  OWNER TO "petBIT";

INSERT INTO public.bpmlist(
        petnum, bpm, timestmp)
			VALUES ('0546666666' , '65', current_timestamp);

SELECT * FROM public.bpmlist
	WHERE ((current_timestamp-timestmp)<time'00:10:00')
		AND petnum = '0546666666'
			ORDER BY timestmp DESC