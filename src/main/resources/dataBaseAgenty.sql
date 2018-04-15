CREATE DATABASE IF NOT EXISTS dataBaseAgenty;
USE dataBaseAgenty;

CREATE TABLE IF NOT EXISTS clients
( 
CNP char(20) NOT NULL UNIQUE PRIMARY KEY,
nameC char(20),
noCard int,
address char(50)
);

CREATE TABLE IF NOT EXISTS agents
(
idAgent int UNIQUE auto_increment primary key,
nameA char(50),
address char(50),
telephon char(50),
username char(50),
passwordA char(50),
isAdmin bool);



CREATE TABLE IF NOT EXISTS rezervation
(
idRez int  UNIQUE auto_increment primary key,
destination char(50),
hotelName char(50),
noOfperson int,
totalPrice float,
partialPay float,
finalPayDate date,
idClient char(20) 
);

CREATE TABLE IF NOT EXISTS history
(
idHistory int unique auto_increment primary key,
idAgent int,
dataH date,
activity char(50)

);



alter table rezervation
add constraint fk_rezervation_clients
foreign key (idClient)
references clients(CNP)
on update cascade
on delete cascade;


alter table history
add constraint fk_history_agent
foreign key (idAgent)
references agents(idAgent)
on update cascade
on delete cascade;


INSERT INTO clients 
(CNP, nameC,noCard ,address) 
VALUES
('1950123156935','Popa Ion', 4,'Str. Mare, Dabuleni, Ilfov'),
('2601219157632','Popescu Maria', 5, 'Blvd. Primaverii, Bucuresti'),
('1990310786543','Andreescu Victor', 6,'Blvd. Iuliu Maniu, Bucuresti'),
('2950617864545','Predescu Andreea', 7,'Str. Virtutii, Baia Mare'),
('2980716543432','Ionescu Mihaela', 8,'Str. Visinilor, Bucuresti'),
('1890726554432','Dinu Cornel', 9,'Calea Victoriei, Bucuresti'),
('23446788','Orange S.A',20,'Bucuresti'),
('28946368','Electrica S.A',56,'Bucuresti'),
('16945971','E.ON S.A',78,'Cluj-Napoca'),
('92369498,','CAA S.A',90,'Cluj-Napoca');


INSERT INTO agents
(idAgent,nameA, address, telephon, username, passwordA, isAdmin) 
VALUES
(0,'Jesse Cole', '12557 Daystar Parkway', '62-(615)720-3591','ana123', 'Parola1#',true),
(10,'Kenneth Sullivan', '289 Maple Wood Hill', '420-(246)883-1509','ana','parola2',false),
(2,'Denise Butler', '7610 Continental Drive', '358-(654)301-8610','dbutler2@google.co.jp','parola3',false),
(3,'Margaret Henderson', '78483 Reindahl Court', '55-(101)544-8762','mhenderson3@macromedia.com','parola4',false),
(4,'Anthony Sanchez', '2 Old Gate Way', '62-(776)174-7428','asanchez4@baidu.com','parola5',false),
(5,'Ann Robinson', '89 Bay Plaza', '7-(738)930-1737','arobinson5@go.com','parola6',false),
(6,'Doris Meyer', '93268 Moose Plaza', '86-(121)279-3985','dmeyer6@e-recht24.de','parola7',false),
(7,'Joan Bradley', '9728 Grayhawk Terrace', '46-(345)602-7270','jbradley7@google.co.jp','parola8',false),
(8,'Sean Wheeler', '39953 Toban Hill', '1-(661)824-4437','swheeler8@huffingtonpost.com','parola9',false),
(9,'Gregory Adams', '4441 Moulton Street', '55-(816)352-7024','gadams9@weather.com','parola10',false);
INSERT INTO rezervation
(idRez,destination ,hotelName ,noOfperson ,totalPrice,partialPay,finalPayDate,idClient)
VALUES
(0,'anglia','nume h',6,100,7.0,'2018-04-19','1950123156935'),
(9,'spania','nume h',6,1330,700,'2018-02-19','1890726554432');

INSERT INTO history
(idHistory,idAgent,dataH ,activity )
Values
(0,9,'2018-03-10','rezervare vacante clienti'),
(8,10,'2018-02-11','acceptare partial pay');

