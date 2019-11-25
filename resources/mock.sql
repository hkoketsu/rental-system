DROP TABLE vehicles;
DROP TABLE vehicleTypes;
DROP TABLE customers;
DROP TABLE reservations;
DROP TABLE rentals;
DROP TABLE branch;
DROP TABLE returns;

CREATE TABLE branch
    (location VARCHAR(50) NOT NULL,
    city VARCHAR(20) NOT NULL,
    PRIMARY KEY (location, city));

grant select on branch to public;

CREATE TABLE vehicles
    (vlicense VARCHAR(10) NOT NULL,
    make VARCHAR(40) NOT NULL,
    model VARCHAR(40) NOT NULL,
    year INT NOT NULL,
    color VARCHAR(20) NOT NULL,
    odometer INT NOT NULL,
    vtname VARCHAR(40) NOT NULL,
    location VARCHAR(50) NOT NULL,
    city VARCHAR(20) NOT NULL,
    status VARCHAR(15) NOT NULL,
    PRIMARY KEY (vlicense));

grant select on vehicles to public;

CREATE TABLE vehicleTypes
    (vtname VARCHAR(20) NOT NULL,
    features VARCHAR(30) NOT NULL,
    wrate INT NOT NULL,
    drate INT NOT NULL,
    hrate INT NOT NULL,
    wirate INT NOT NULL,
    dirate INT NOT NULL,
    hirate INT NOT NULL,
    krate INT NOT NULL,
    PRIMARY KEY (vtname));

GRANT SELECT ON vehicleTypes TO PUBLIC;

CREATE TABLE customers
    (dlicense VARCHAR(10) NOT NULL,
    cellphone VARCHAR(12) NOT NULL,
    name VARCHAR(30) NOT NULL,
    address VARCHAR(50) NOT NULL,
    PRIMARY KEY (dlicense));

GRANT SELECT ON customers TO PUBLIC;

CREATE TABLE reservations
    (confNo VARCHAR(20) NOT NULL,
    vtname VARCHAR(40) NOT NULL,
    dlicense VARCHAR(10) NOT NULL,
    fromDate DATE NOT NULL,
    fromTime VARCHAR(15) NOT NULL,
    toDate DATE NOT NULL,
    toTime VARCHAR(15) NOT NULL,
    PRIMARY KEY (confNo));

GRANT SELECT ON reservations TO PUBLIC;

CREATE TABLE rentals
    (rid VARCHAR(20) NOT NULL,
    vlicense VARCHAR(10) NOT NULL,
    dlicense VARCHAR(10) NOT NULL,
    fromDate DATE NOT NULL,
    fromTime VARCHAR(15) NOT NULL,
    toDate DATE NOT NULL,
    toTime VARCHAR(15) NOT NULL,
    odometer INT NOT NULL,
    cardName VARCHAR(20) NOT NULL,
    cardNo VARCHAR(20) NOT NULL,
    expDate VARCHAR(10) NOT NULL,
    confNo VARCHAR(20) NOT NULL,
    PRIMARY KEY (rid));

GRANT SELECT ON rentals TO PUBLIC;

CREATE TABLE returns
    (rid VARCHAR(20) NOT NULL,
    rdate DATE NOT NULL,
    rtime VARCHAR(15) NOT NULL,
    odometer INT NOT NULL,
    fulltank VARCHAR(5) NOT NULL,
    value INT NOT NULL,
    PRIMARY KEY (rid));

GRANT SELECT ON returns TO PUBLIC;

insert into branch values ('122 Walter Hardwick Ave 305','Vancouver');
insert into branch values ('5202 Union St','Burnaby');

insert into vehicleTypes values ('Sedan', 'small', 500, 100, 15, 50, 10, 1,1);
insert into vehicleTypes values ('SUV', 'medium', 600, 130, 20, 60, 13, 5, 2);
insert into vehicleTypes values ('Minivan', 'big', 750, 150, 25, 75, 20, 7, 3);
insert into vehicleTypes values ('Truck', 'biggest', 1000, 200, 35, 100, 25, 10, 4);

INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (9990274029,'Honda','Mustang',1980,'Black',13334,'SUV','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (9559918184,'Toyota','Range Rover',2002,'Blue',13423,'Sedan','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (3426890585,'Mazda','E150',2009,'White',10408,'Sedan','122 Walter Hardwick Ave 305','Vancouver','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (5078672044,'Honda','Scirocco',1986,'White',13286,'Sedan','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (3379099627,'Honda','Reliant',1981,'White',13753,'SUV','122 Walter Hardwick Ave 305','Vancouver','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (2868269613,'Mazda','Pilot',2004,'Black',13912,'SUV','122 Walter Hardwick Ave 305','Vancouver','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (7027134705,'Honda','Cordia',1985,'Blue',13011,'SUV','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (9828494426,'Mazda','Ridgeline',2007,'White',11972,'Sedan','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (0884155811,'Honda','Forester',1998,'Red',12343,'Truck','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (9708084069,'Toyota','Astro',1996,'White',11966,'Sedan','122 Walter Hardwick Ave 305','Vancouver','maintenance');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (7441439302,'Mazda','Suburban 1500',1995,'White',14062,'Sedan','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (6141787096,'Honda','Lucerne',2011,'Black',12833,'Truck','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (3573117139,'Honda','911',1987,'Black',12010,'Minivan','122 Walter Hardwick Ave 305','Vancouver','maintenance');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (0203631226,'Honda','Express',2008,'Red',14576,'Sedan','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (6927931953,'Mazda','Sunbird',1984,'White',10956,'Sedan','122 Walter Hardwick Ave 305','Vancouver','maintenance');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (3101642574,'Mazda','F-Series Super Duty',2011,'Black',11121,'Sedan','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (5925542053,'Honda','F150',1999,'Blue',12420,'Truck','122 Walter Hardwick Ave 305','Vancouver','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (1860957536,'Mazda','80',1990,'Red',14917,'SUV','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (8402662609,'Honda','Aveo',2005,'Black',12052,'Minivan','122 Walter Hardwick Ave 305','Vancouver','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (8224549542,'Toyota','530',2007,'White',13138,'Sedan','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (9253170484,'Toyota','Skyhawk',1984,'Blue',13018,'Sedan','122 Walter Hardwick Ave 305','Vancouver','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (8672898524,'Mazda','MDX',2006,'Black',13174,'Minivan','5202 Union St','Burnaby','maintenance');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (7316284714,'Mazda','Miata MX-5',2011,'Black',14988,'Minivan','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (7361385729,'Toyota','Rally Wagon G2500',1995,'Black',14368,'Minivan','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (7313986440,'Honda','E-Class',1985,'Red',13298,'Minivan','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (2078823759,'Mazda','S10',2003,'White',12792,'Truck','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (7267147518,'Honda','Talon',1990,'Red',12660,'SUV','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (0965590089,'Honda','Grand Caravan',2002,'White',11422,'Truck','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (7536070144,'Honda','Passport',1996,'Blue',14550,'Minivan','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (1111527490,'Honda','6 Series',2012,'White',12156,'Truck','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (9248938434,'Mazda','Quest',2001,'Red',13377,'SUV','122 Walter Hardwick Ave 305','Vancouver','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (5789254942,'Honda','Suburban 1500',2007,'Red',14981,'Truck','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (2838178768,'Honda','Rio',2007,'Black',14813,'Truck','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (1576704785,'Toyota','Pajero',1998,'Black',13387,'Sedan','122 Walter Hardwick Ave 305','Vancouver','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (4412854876,'Mazda','G37',2009,'Blue',14611,'Minivan','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (6492902637,'Toyota','R-Class',2006,'White',12165,'Truck','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (4619380695,'Mazda','LS',2005,'Red',13140,'Minivan','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (2432095766,'Honda','900',1995,'White',11365,'Truck','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (2348089947,'Toyota','TL',2005,'White',11732,'Minivan','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (1913374467,'Mazda','HHR',2011,'Black',11349,'Truck','122 Walter Hardwick Ave 305','Vancouver','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (6035243517,'Honda','Cougar',1997,'Red',12342,'SUV','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (0643542027,'Toyota','Grand Caravan',2007,'White',14326,'Minivan','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (6449411147,'Toyota','4Runner',1997,'White',13922,'Sedan','5202 Union St','Burnaby','maintenance');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (1483405737,'Honda','3000GT',1998,'Blue',11041,'SUV','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (3183987600,'Mazda','CR-V',2011,'White',11347,'Sedan','5202 Union St','Burnaby','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (1622059824,'Mazda','Wrangler',1998,'Blue',14010,'Minivan','122 Walter Hardwick Ave 305','Vancouver','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (7540464445,'Toyota','Durango',2011,'White',14569,'Sedan','122 Walter Hardwick Ave 305','Vancouver','maintenance');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (0368582795,'Toyota','Quantum',1984,'Black',12345,'Minivan','5202 Union St','Burnaby','rented');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (6345492728,'Toyota','Neon',2002,'Black',13956,'Minivan','122 Walter Hardwick Ave 305','Vancouver','available');
INSERT INTO vehicles(vlicense,make,model,year,color,odometer,vtname,location,city,status) VALUES (7124333091,'Honda','Vitara',2004,'Red',13671,'Truck','122 Walter Hardwick Ave 305','Vancouver','available');


INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r2d406c3',9990274029,3227812967,'24-NOV-2019','12:00','02-DEC-2019','05:00',13334,'master',424007858932,'11-2021','cf5s385o2');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r8u492y2',9559918184,4873941288,'27-NOV-2019','00:30','06-DEC-2019','19:30',13423,'visa',139076097968,'10-2022','cf4a597k5');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r8p910x3',3426890585,4779321654,'20-NOV-2019','10:00','28-NOV-2019','02:00',10408,'master',905523660646,'12-2021','cf5y921x0');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r7y238b2',5078672044,6721294370,'21-NOV-2019','15:30','24-NOV-2019','06:00',13286,'master',325168565469,'12-2022','cf4u247k4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r4x057h2',3379099627,7003363267,'23-NOV-2019','03:30','27-NOV-2019','00:00',13753,'visa',892403643166,'11-2021','cf2x586b4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r6c282v4',2868269613,8891516538,'27-NOV-2019','06:30','07-DEC-2019','00:30',13912,'master',433455256511,'11-2020','cf3t067d2');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r5y643b6',7027134705,9921724452,'21-NOV-2019','09:00','26-NOV-2019','01:30',13011,'visa',821851618802,'12-2022','cf9n978i0');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r4i382e1',9828494426,9921724452,'23-NOV-2019','14:30','27-NOV-2019','16:00',11972,'master',022656369425,'12-2022','cf5o769a3');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r6e766e7',0884155811,4779321654,'21-NOV-2019','04:30','30-NOV-2019','10:00',12343,'visa',229865698116,'08-2022','cf5u036n1');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r4r194x8',9708084069,4779321654,'22-NOV-2019','05:00','29-NOV-2019','14:00',11966,'master',774177246216,'12-2021','cf4l569x4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r6h999l8',7441439302,9921724452,'20-NOV-2019','12:00','24-NOV-2019','12:30',14062,'master',180610137453,'11-2020','cf2j924k2');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r9k364j5',6141787096,1547743522,'20-NOV-2019','09:00','28-NOV-2019','02:30',12833,'visa',794478341976,'11-2021','cf1c600v1');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r5a538l4',3573117139,5638970134,'24-NOV-2019','00:30','03-DEC-2019','14:30',12010,'master',418441224525,'07-2021','cf4v508h8');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r7q849i2',0203631226,1547743522,'26-NOV-2019','06:00','05-DEC-2019','15:00',14576,'master',038808518438,'10-2021','cf8k324o4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r9s763m4',6927931953,4822050556,'25-NOV-2019','04:00','02-DEC-2019','16:00',10956,'visa',574700641046,'12-2021','cf1j450l8');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r4c680t0',3101642574,0447972529,'22-NOV-2019','03:00','30-NOV-2019','05:00',11121,'master',321215761882,'11-2022','cf9m461j4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r2n535h7',5925542053,9921724452,'24-NOV-2019','10:30','30-NOV-2019','10:00',12420,'visa',907682143538,'10-2020','cf6h403o0');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r6p568o3',1860957536,8490431922,'22-NOV-2019','17:30','29-NOV-2019','14:30',14917,'visa',993902748832,'12-2022','cf3s734v7');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r1v671i3',8402662609,7003363267,'21-NOV-2019','19:30','27-NOV-2019','16:30',12052,'master',740582834134,'12-2022','cf7y463r4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r7x894z2',8224549542,3227812967,'20-NOV-2019','10:30','28-NOV-2019','15:30',13138,'visa',159242865849,'12-2021','cf8s672u5');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r2b299c6',9253170484,1465902724,'20-NOV-2019','18:00','28-NOV-2019','01:00',13018,'visa',268988331379,'05-2022','cf8y423g8');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r0t849d3',8672898524,1465902724,'20-NOV-2019','02:30','25-NOV-2019','17:00',13174,'master',736072913867,'10-2022','cf2j435t0');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r5q429o5',7316284714,9536221055,'21-NOV-2019','05:00','29-NOV-2019','13:30',14988,'master',304339152602,'12-2020','cf0a950x5');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r0g166m1',7361385729,4736631732,'24-NOV-2019','19:30','29-NOV-2019','00:00',14368,'visa',586624011239,'12-2020','cf7w301h4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r2a552t4',7313986440,7097327405,'27-NOV-2019','12:30','02-DEC-2019','04:00',13298,'visa',698163340477,'12-2021','cf1r075k5');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r3r057b8',2078823759,1465902724,'20-NOV-2019','08:30','30-NOV-2019','05:30',12792,'master',245948545700,'12-2022','cf7l691g4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r6l018h7',7267147518,8891516538,'21-NOV-2019','12:00','28-NOV-2019','15:30',12660,'master',214158860281,'12-2022','cf1b770i9');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r0o873j6',0965590089,4736631732,'21-NOV-2019','05:00','25-NOV-2019','06:30',11422,'visa',784454511838,'12-2022','cf2h042u6');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r6q002a1',7536070144,5957641928,'21-NOV-2019','05:00','25-NOV-2019','17:30',14550,'master',690470067586,'09-2020','cf9s800x5');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r1r826k6',1111527490,6974015739,'23-NOV-2019','10:00','30-NOV-2019','15:30',12156,'master',268842485021,'12-2022','cf2p339v8');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r0d526b5',9248938434,5957641928,'20-NOV-2019','18:00','29-NOV-2019','03:30',13377,'master',986448678811,'11-2022','cf5p267o6');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r0q594s2',5789254942,4736631732,'23-NOV-2019','08:30','27-NOV-2019','02:30',14981,'visa',012184065960,'11-2022','cf4g528b6');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r4c860i9',2838178768,9672677537,'22-NOV-2019','13:00','25-NOV-2019','00:00',14813,'master',891143813414,'11-2022','cf2v296y0');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r4q437c2',1576704785,9921724452,'21-NOV-2019','17:00','30-NOV-2019','15:00',13387,'visa',492924530709,'12-2022','cf9r836m3');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r5t887w8',4412854876,9536221055,'21-NOV-2019','04:30','29-NOV-2019','08:00',14611,'master',297214736529,'09-2022','cf0z860f2');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r6n224p3',6492902637,9921724452,'20-NOV-2019','09:00','29-NOV-2019','07:30',12165,'visa',042143184940,'10-2022','cf2a412e2');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r1b149m1',4619380695,5403427422,'22-NOV-2019','02:30','25-NOV-2019','03:30',13140,'visa',538661914403,'12-2022','cf1m535b9');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r7v093k7',2432095766,1465902724,'22-NOV-2019','15:00','29-NOV-2019','07:00',11365,'visa',938674858395,'10-2020','cf0a753z5');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r6g832r0',2348089947,8891516538,'20-NOV-2019','01:30','26-NOV-2019','15:30',11732,'visa',950628302520,'12-2022','cf5r188m1');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r1w833m7',1913374467,4736631732,'22-NOV-2019','17:00','25-NOV-2019','15:00',11349,'visa',537633505245,'10-2021','cf3s408m8');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r4k254p2',6035243517,1547743522,'27-NOV-2019','19:00','01-DEC-2019','02:00',12342,'master',637606145401,'10-2021','cf0k620g3');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r2e494b9',0643542027,4822050556,'21-NOV-2019','09:30','27-NOV-2019','03:00',14326,'master',318253186974,'12-2022','cf9u597h4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r7l541z7',6449411147,5403427422,'24-NOV-2019','01:30','04-DEC-2019','08:00',13922,'master',667924494315,'10-2022','cf6i268e4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r3y837j6',1483405737,8891516538,'25-NOV-2019','07:30','04-DEC-2019','12:30',11041,'visa',433313769706,'12-2022','cf6g844g4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r8k759f4',3183987600,6974015739,'27-NOV-2019','08:30','30-NOV-2019','17:30',11347,'visa',978337862852,'12-2022','cf9s426k5');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r3x195q3',1622059824,8891516538,'27-NOV-2019','06:00','01-DEC-2019','09:30',14010,'visa',370417084688,'12-2021','cf9z794b9');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r0s509l7',7540464445,9921724452,'21-NOV-2019','00:30','26-NOV-2019','03:00',14569,'visa',560249332607,'05-2022','cf4i767t7');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r9o465g1',0368582795,6974015739,'26-NOV-2019','13:30','03-DEC-2019','04:30',12345,'visa',238991393397,'06-2021','cf0g887a1');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r0s819c3',6345492728,3227812967,'26-NOV-2019','04:30','30-NOV-2019','13:30',13956,'master',713433286102,'12-2022','cf1u262h4');
INSERT INTO rentals(rid,vlicense,dlicense,fromDate,fromTime,toDate,toTime,odometer,cardName,cardNo,expDate,confNo) VALUES ('r3l216n7',7124333091,5957641928,'26-NOV-2019','18:00','02-DEC-2019','13:00',13671,'visa',791654233576,'10-2022','cf3y998c4');


INSERT INTO customers(dlicense,cellphone,name,address) VALUES (4822050556,'222-199-5770','Merry','47784 Westport Way');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (1547743522,'460-455-2957','Skippy','6123 Ronald Regan Road');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (4779321654,'319-518-0403','Vicki','8 Monterey Circle');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (5957641928,'250-536-9156','Kalli','1 Tennyson Alley');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (3227812967,'795-955-9931','Chicky','136 Rieder Lane');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (9921724452,'487-594-0845','Agace','8 Express Place');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (9536221055,'677-887-3402','Melly','27 Fisk Plaza');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (5638970134,'729-678-8494','Marlon','196 Rusk Street');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (9672677537,'678-294-3160','Leona','59804 Jay Road');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (0447972529,'599-113-3463','Nada','731 La Follette Lane');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (8891516538,'599-327-1712','Lexie','9243 Pennsylvania Court');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (1465902724,'320-229-8932','Hersch','9 Muir Center');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (6721294370,'800-331-9401','Halley','58235 Bashford Circle');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (4736631732,'513-693-6731','Gabriell','23 Vahlen Drive');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (7097327405,'772-383-2499','Elinore','21720 Milwaukee Crossing');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (5403427422,'730-734-8212','Florida','18 Eagle Crest Hill');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (4873941288,'126-673-6377','Thorpe','8656 Holmberg Terrace');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (6974015739,'824-722-6926','Tessie','340 Sage Avenue');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (7003363267,'957-482-3836','Arlene','4602 Reindahl Alley');
INSERT INTO customers(dlicense,cellphone,name,address) VALUES (8490431922,'311-103-2953','Tripp','97793 Annamark Road');



INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r2d406c3','02-DEC-2019','05:00',14732,'true',1932);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r8u492y2','06-DEC-2019','19:30',14628,'true',639);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r8p910x3','28-NOV-2019','02:00',11165,'true',1585);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r7y238b2','24-NOV-2019','06:00',14424,'true',741);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r4x057h2','27-NOV-2019','00:00',15125,'true',1422);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r6c282v4','07-DEC-2019','00:30',14669,'false',1144);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r5y643b6','26-NOV-2019','01:30',14467,'true',1785);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r4i382e1','27-NOV-2019','16:00',13066,'true',1513);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r6e766e7','30-NOV-2019','10:00',13470,'false',1783);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r4r194x8','29-NOV-2019','14:00',13402,'true',1035);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r6h999l8','24-NOV-2019','12:30',15448,'true',1561);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r9k364j5','28-NOV-2019','02:30',14072,'true',793);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r5a538l4','03-DEC-2019','14:30',12540,'true',1315);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r7q849i2','05-DEC-2019','15:00',15810,'false',1208);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r9s763m4','02-DEC-2019','16:00',11735,'true',1646);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r4c680t0','30-NOV-2019','05:00',11733,'true',1525);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r2n535h7','30-NOV-2019','10:00',13257,'true',1635);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r6p568o3','29-NOV-2019','14:30',15670,'true',1068);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r1v671i3','27-NOV-2019','16:30',13550,'true',1580);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r7x894z2','28-NOV-2019','15:30',14278,'false',1864);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r2b299c6','28-NOV-2019','01:00',13575,'false',1129);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r0t849d3','25-NOV-2019','17:00',14546,'true',1636);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r5q429o5','29-NOV-2019','13:30',15620,'true',1138);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r0g166m1','29-NOV-2019','00:00',15234,'true',1196);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r2a552t4','02-DEC-2019','04:00',14670,'true',1981);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r3r057b8','30-NOV-2019','05:30',13387,'true',1148);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r6l018h7','28-NOV-2019','15:30',13209,'true',1096);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r0o873j6','25-NOV-2019','06:30',12058,'false',659);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r6q002a1','25-NOV-2019','17:30',15399,'true',1268);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r1r826k6','30-NOV-2019','15:30',13545,'true',987);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r0d526b5','29-NOV-2019','03:30',14779,'true',713);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r0q594s2','27-NOV-2019','02:30',15985,'true',1952);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r4c860i9','25-NOV-2019','00:00',15668,'true',1758);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r4q437c2','30-NOV-2019','15:00',14322,'true',744);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r5t887w8','29-NOV-2019','08:00',15592,'true',1662);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r6n224p3','29-NOV-2019','07:30',13051,'true',1968);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r1b149m1','25-NOV-2019','03:30',13982,'true',1893);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r7v093k7','29-NOV-2019','07:00',12161,'true',662);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r6g832r0','26-NOV-2019','15:30',12505,'true',1708);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r1w833m7','25-NOV-2019','15:00',12384,'false',1270);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r4k254p2','01-DEC-2019','02:00',13309,'false',1854);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r2e494b9','27-NOV-2019','03:00',14949,'true',1207);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r7l541z7','04-DEC-2019','08:00',14631,'true',1405);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r3y837j6','04-DEC-2019','12:30',12111,'true',1091);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r8k759f4','30-NOV-2019','17:30',12632,'true',1450);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r3x195q3','01-DEC-2019','09:30',15346,'true',1270);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r0s509l7','26-NOV-2019','03:00',15464,'true',1049);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r9o465g1','03-DEC-2019','04:30',13724,'true',1352);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r0s819c3','30-NOV-2019','13:30',14639,'true',1328);
INSERT INTO returns(rid,rdate,rtime,odometer,fulltank,value) VALUES ('r3l216n7','02-DEC-2019','13:00',14490,'true',1644);

INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5s385o2','Sedan',3227812967,'24-NOV-2019','12:00','02-DEC-2019','05:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf4a597k5','Sedan',4873941288,'27-NOV-2019','00:30','06-DEC-2019','19:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5y921x0','SUV',4779321654,'20-NOV-2019','10:00','28-NOV-2019','02:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf4u247k4','Minivan',6721294370,'21-NOV-2019','15:30','24-NOV-2019','06:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2x586b4','Minivan',7003363267,'23-NOV-2019','03:30','27-NOV-2019','00:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3t067d2','Sedan',8891516538,'27-NOV-2019','06:30','07-DEC-2019','00:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9n978i0','Sedan',9921724452,'21-NOV-2019','09:00','26-NOV-2019','01:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5o769a3','Sedan',9921724452,'23-NOV-2019','14:30','27-NOV-2019','16:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5u036n1','Sedan',4779321654,'21-NOV-2019','04:30','30-NOV-2019','10:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf4l569x4','Sedan',4779321654,'22-NOV-2019','05:00','29-NOV-2019','14:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2j924k2','Sedan',9921724452,'20-NOV-2019','12:00','24-NOV-2019','12:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1c600v1','SUV',1547743522,'20-NOV-2019','09:00','28-NOV-2019','02:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf4v508h8','Minivan',5638970134,'24-NOV-2019','00:30','03-DEC-2019','14:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf8k324o4','SUV',1547743522,'26-NOV-2019','06:00','05-DEC-2019','15:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1j450l8','Minivan',4822050556,'25-NOV-2019','04:00','02-DEC-2019','16:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9m461j4','Minivan',447972529,'22-NOV-2019','03:00','30-NOV-2019','05:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf6h403o0','Sedan',9921724452,'24-NOV-2019','10:30','30-NOV-2019','10:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3s734v7','Truck',8490431922,'22-NOV-2019','17:30','29-NOV-2019','14:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf7y463r4','Truck',7003363267,'21-NOV-2019','19:30','27-NOV-2019','16:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf8s672u5','Sedan',3227812967,'20-NOV-2019','10:30','28-NOV-2019','15:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf8y423g8','Truck',1465902724,'20-NOV-2019','18:00','28-NOV-2019','01:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2j435t0','Minivan',1465902724,'20-NOV-2019','02:30','25-NOV-2019','17:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf0a950x5','Truck',9536221055,'21-NOV-2019','05:00','29-NOV-2019','13:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf7w301h4','SUV',4736631732,'24-NOV-2019','19:30','29-NOV-2019','00:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1r075k5','Sedan',7097327405,'27-NOV-2019','12:30','02-DEC-2019','04:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf7l691g4','Truck',1465902724,'20-NOV-2019','08:30','30-NOV-2019','05:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1b770i9','Minivan',8891516538,'21-NOV-2019','12:00','28-NOV-2019','15:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2h042u6','Minivan',4736631732,'21-NOV-2019','05:00','25-NOV-2019','06:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9s800x5','SUV',5957641928,'21-NOV-2019','05:00','25-NOV-2019','17:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2p339v8','Minivan',6974015739,'23-NOV-2019','10:00','30-NOV-2019','15:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5p267o6','Minivan',5957641928,'20-NOV-2019','18:00','29-NOV-2019','03:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf4g528b6','Minivan',4736631732,'23-NOV-2019','08:30','27-NOV-2019','02:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2v296y0','Minivan',9672677537,'22-NOV-2019','13:00','25-NOV-2019','00:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9r836m3','Sedan',9921724452,'21-NOV-2019','17:00','30-NOV-2019','15:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf0z860f2','Minivan',9536221055,'21-NOV-2019','04:30','29-NOV-2019','08:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2a412e2','SUV',9921724452,'20-NOV-2019','09:00','29-NOV-2019','07:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1m535b9','Minivan',5403427422,'22-NOV-2019','02:30','25-NOV-2019','03:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf0a753z5','Truck',1465902724,'22-NOV-2019','15:00','29-NOV-2019','07:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5r188m1','Sedan',8891516538,'20-NOV-2019','01:30','26-NOV-2019','15:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3s408m8','Sedan',4736631732,'22-NOV-2019','17:00','25-NOV-2019','15:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf0k620g3','SUV',1547743522,'27-NOV-2019','19:00','01-DEC-2019','02:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9u597h4','Truck',4822050556,'21-NOV-2019','09:30','27-NOV-2019','03:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf6i268e4','Sedan',5403427422,'24-NOV-2019','01:30','04-DEC-2019','08:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf6g844g4','Sedan',8891516538,'25-NOV-2019','07:30','04-DEC-2019','12:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9s426k5','Truck',6974015739,'27-NOV-2019','08:30','30-NOV-2019','17:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9z794b9','Sedan',8891516538,'27-NOV-2019','06:00','01-DEC-2019','09:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf4i767t7','SUV',9921724452,'21-NOV-2019','00:30','26-NOV-2019','03:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf0g887a1','Minivan',6974015739,'26-NOV-2019','13:30','03-DEC-2019','04:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1u262h4','SUV',3227812967,'26-NOV-2019','04:30','30-NOV-2019','13:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3y998c4','Sedan',5957641928,'26-NOV-2019','18:00','02-DEC-2019','13:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf8i517w4','SUV',5638970134,'20-NOV-2019','08:30','27-NOV-2019','18:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1z536y3','Sedan',4736631732,'20-NOV-2019','09:30','25-NOV-2019','01:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf6p048e2','SUV',8490431922,'24-NOV-2019','03:30','01-DEC-2019','09:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf6v546r1','SUV',8490431922,'23-NOV-2019','11:00','27-NOV-2019','11:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf7r179z6','SUV',7097327405,'22-NOV-2019','04:00','02-DEC-2019','11:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf0i247c0','Sedan',5957641928,'21-NOV-2019','13:00','01-DEC-2019','10:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9a826k2','SUV',447972529,'20-NOV-2019','06:30','23-NOV-2019','14:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2i151c7','Minivan',1547743522,'26-NOV-2019','04:00','03-DEC-2019','18:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf0h214b0','Sedan',4779321654,'23-NOV-2019','03:00','27-NOV-2019','09:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1a921v5','Sedan',8891516538,'21-NOV-2019','06:00','29-NOV-2019','08:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5w594h7','SUV',8490431922,'24-NOV-2019','10:00','01-DEC-2019','17:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2b326n5','Sedan',4822050556,'27-NOV-2019','15:30','30-NOV-2019','16:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9v323x4','Minivan',5957641928,'25-NOV-2019','05:00','03-DEC-2019','09:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3i545f5','Truck',9536221055,'23-NOV-2019','06:00','01-DEC-2019','02:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2t024t3','Sedan',5957641928,'24-NOV-2019','01:00','03-DEC-2019','16:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3o702h9','Minivan',1465902724,'22-NOV-2019','13:30','30-NOV-2019','03:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3i177f9','Truck',9536221055,'25-NOV-2019','01:30','04-DEC-2019','07:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2x728t3','Minivan',9536221055,'26-NOV-2019','01:00','29-NOV-2019','11:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf7c613k6','SUV',6974015739,'24-NOV-2019','03:00','27-NOV-2019','15:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf0w665w3','SUV',4873941288,'21-NOV-2019','05:30','26-NOV-2019','11:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1d494h6','SUV',9536221055,'25-NOV-2019','15:30','01-DEC-2019','12:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3r430o7','Sedan',8490431922,'22-NOV-2019','15:00','29-NOV-2019','05:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1r562f1','Sedan',4779321654,'24-NOV-2019','15:30','29-NOV-2019','09:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf4j872a2','Truck',1465902724,'27-NOV-2019','15:00','03-DEC-2019','16:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf7g352p1','SUV',5638970134,'21-NOV-2019','15:00','27-NOV-2019','01:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf4i233u3','Minivan',3227812967,'21-NOV-2019','10:00','28-NOV-2019','12:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf7f852u6','Truck',5638970134,'23-NOV-2019','14:00','26-NOV-2019','13:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5n227w0','SUV',9921724452,'22-NOV-2019','01:30','28-NOV-2019','14:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1z020z9','Minivan',5957641928,'24-NOV-2019','13:30','01-DEC-2019','08:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf7i497l9','Minivan',447972529,'26-NOV-2019','19:30','06-DEC-2019','18:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf6s304e0','Minivan',4736631732,'27-NOV-2019','18:30','06-DEC-2019','04:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5m916u8','Truck',4873941288,'27-NOV-2019','18:30','04-DEC-2019','06:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3k824r5','Sedan',4779321654,'20-NOV-2019','11:00','27-NOV-2019','10:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf0d784h5','Minivan',4736631732,'22-NOV-2019','18:30','30-NOV-2019','01:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5g608x7','SUV',6974015739,'21-NOV-2019','17:00','30-NOV-2019','05:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1d082l9','Minivan',4736631732,'25-NOV-2019','14:30','29-NOV-2019','19:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2t884a5','SUV',7003363267,'27-NOV-2019','13:00','06-DEC-2019','15:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3e781j8','SUV',447972529,'24-NOV-2019','01:00','29-NOV-2019','10:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf8i302g3','Minivan',8891516538,'24-NOV-2019','06:00','29-NOV-2019','08:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf7s999x0','SUV',4822050556,'20-NOV-2019','14:00','30-NOV-2019','01:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1x839d6','Truck',3227812967,'27-NOV-2019','14:00','07-DEC-2019','16:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf0a678g7','Truck',3227812967,'23-NOV-2019','02:30','29-NOV-2019','08:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf1n170x8','SUV',5638970134,'25-NOV-2019','03:30','02-DEC-2019','18:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf8e230q2','Sedan',6974015739,'21-NOV-2019','16:30','28-NOV-2019','15:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf5w370q1','Truck',4736631732,'21-NOV-2019','09:30','28-NOV-2019','03:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf3i759z0','Truck',3227812967,'21-NOV-2019','17:30','25-NOV-2019','00:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf2z748d6','Sedan',4873941288,'21-NOV-2019','17:30','29-NOV-2019','12:30');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9j885m1','SUV',6721294370,'23-NOV-2019','12:00','29-NOV-2019','10:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf6f554x0','Sedan',8490431922,'21-NOV-2019','10:30','27-NOV-2019','00:00');
INSERT INTO reservations(confNo,vtname,dlicense,fromDate,fromTime,toDate,toTime) VALUES ('cf9z776g9','SUV',5957641928,'23-NOV-2019','19:00','27-NOV-2019','05:30');