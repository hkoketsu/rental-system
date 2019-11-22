DROP TABLE vehicles;
DROP TABLE vehicleTypes;
DROP TABLE customers;
DROP TABLE reservations;
DROP TABLE rentals;
DROP TABLE returns;

CREATE TABLE branch
    (location VARCHAR(50) NOT NULL,
    city VARCHAR(20) NOT NULL,
    PRIMARY KEY (location, city));

CREATE TABLE vehicles
    (vlicense VARCHAR(10) NOT NULL,
    make VARCHAR(40) NOT NULL,
    model VARCHAR(40) NOT NULL,
    vtname VARCHAR(40) NOT NULL,
    location VARCHAR(50) NOT NULL,
    city VARCHAR(20) NOT NULL,
    status VARCHAR(15) NOT NULL,
    PRIMARY KEY (vlicense));

grant select on vehicle to public;

CREATE TABLE vehicleTypes
    (vtname VARCHAR(20) NOT NULL,
    features VARCHAR(30) NOT NULL,
    wrate INT(5) NOT NULL,
    drate INT(5) NOT NULL,
    hrate INT(5) NOT NULL,
    wirate INT(5) NOT NULL,
    dirate INT(5) NOT NULL,
    hirate INT(5) NOT NULL,
    krate INT(5) NOT NULL,
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
    cellphone VARCHAR(12) NOT NULL,
    fromDate DATE NOT NULL,
    fromTime TIME NOT NULL,
    toDate DATE NOT NULL,
    toTime TIME NOT NULL,
    PRIMARY KEY (confNo));

GRANT SELECT ON reservations TO PUBLIC;

CREATE TABLE rentals
    (rid VARCHAR(20) NOT NULL,
    vlicense VARCHAR(10) NOT NULL,
    cellphone VARCHAR(12) NOT NULL,
    fromDate DATE NOT NULL,
    fromTime INT(10) NOT NULL,
    cardName VARCHAR(20) NOT NULL,
    cardNo VARCHAR(20) NOT NULL,
    expDate DATE NOT NULL,
    confNo VARCHAR(20) NOT NULL,
    PRIMARY KEY (rid));

GRANT SELECT ON rentals TO PUBLIC;

CREATE TABLE returns
    (rid VINT(10) NOT NULL,
    date DATE NOT NULL,
    time INT(10) NOT NULL,
    fulltank VARCHAR(5) NOT NULL,
    value VARCHAR(10) NOT NULL,
    PRIMARY KEY (rid));

GRANT SELECT ON returns TO PUBLIC;

insert into branch values ('122 Walter Hardwick Ave 305','Vancouver');
insert into branch values ('1524 27th St E','Vancouver');
insert into branch values ('2179 148A St','Vancouver');
insert into branch values ('5228 Hollyfield Ave','Burnaby');
insert into branch values ('5202 Union St','Burnaby');

insert into vehicleTypes value ('Sedan', 'small', 500, 100, 15, 50, 10, 1);
insert into vehicleTypes value ('SUV', 'medium', 600, 130, 20, 60, 13, 5);
insert into vehicleTypes value ('Minivan', 'big', 750, 150, 25, 75, 20, 7);
insert into vehicleTypes value ('Truck', 'biggest', 1000, 200, 35, 100, 25, 10);

insert into vehicles values ('0027187292', 'Toyota', 'Elise', 2004, 'Red', 12767, 'Minivan', 'Burnaby', 'available');
insert into vehicles values ('6793029886', 'Honda', 'GX', 2005, 'White', 12636, 'Truck', 'Vancouver', 'rented');
insert into vehicles values ('2733759507', 'Honda', 'Grand Marquis', 1993, 'Black', 10666, 'Sedan', 'Vancouver', 'available');
insert into vehicles values ('3314466021', 'Mazda', 'M5', 2006, 'Red', 14424, 'Minivan', 'Burnaby', 'available');
insert into vehicles values ('5499169365', 'Honda', 'Silverado', 2002, 'Black', 14564, 'SUV', 'Vancouver', 'available');
insert into vehicles values ('5597872400', 'Honda', 'Mariner', 2011, 'Red', 14118, 'Minivan', 'Burnaby', 'available');
insert into vehicles values ('4378798336', 'Mazda', 'D350 Club', 1993, 'Blue', 13785, 'SUV', 'Vancouver', 'maintenance');
insert into vehicles values ('9990918023', 'Mazda', 'Odyssey', 2001, 'Red', 14247, 'Minivan', 'Burnaby', 'maintenance');
insert into vehicles values ('3155734639', 'Honda', 'CLS-Class', 2006, 'Blue', 12896, 'SUV', 'Vancouver', 'available');
insert into vehicles values ('9459185061', 'Mazda', 'Tucson', 2009, 'Black', 14629, 'Minivan', 'Vancouver', 'available');
insert into vehicles values ('0467515840', 'Honda', 'Savana 1500', 2011, 'Black', 12081, 'Sedan', 'Vancouver', 'available');
insert into vehicles values ('6212991243', 'Toyota', 'Coachbuilder', 1994, 'White', 11184, 'SUV', 'Vancouver', 'rented');
insert into vehicles values ('8834501322', 'Mazda', 'SJ', 1991, 'White', 11173, 'Sedan', 'Vancouver', 'available');
insert into vehicles values ('1119112303', 'Toyota', 'CTS', 2006, 'Black', 11284, 'Truck', 'Burnaby', 'available');
insert into vehicles values ('6666655133', 'Mazda', 'ZDX', 2012, 'Black', 12544, 'Truck', 'Burnaby', 'rented');
insert into vehicles values ('2838880349', 'Honda', 'Supra', 1993, 'Red', 11760, 'Sedan', 'Burnaby', 'rented');
insert into vehicles values ('1615147144', 'Mazda', 'Neon', 2002, 'Black', 14705, 'Minivan', 'Burnaby', 'rented');
insert into vehicles values ('6008985648', 'Honda', 'GTI', 1993, 'Blue', 10798, 'Sedan', 'Vancouver', 'available');
insert into vehicles values ('2825549029', 'Toyota', 'Eclipse', 2008, 'Black', 14588, 'Sedan', 'Burnaby', 'rented');
insert into vehicles values ('9170481083', 'Mazda', 'V70', 2000, 'White', 12105, 'Minivan', 'Burnaby', 'available');
insert into vehicles values ('4012940775', 'Mazda', 'Veracruz', 2012, 'Red', 14410, 'SUV', 'Vancouver', 'available');
insert into vehicles values ('4486041283', 'Mazda', 'SRX', 2005, 'Black', 11946, 'SUV', 'Vancouver', 'available');
insert into vehicles values ('7487186393', 'Mazda', 'A8', 1999, 'Black', 11741, 'Truck', 'Vancouver', 'available');
insert into vehicles values ('7627955874', 'Mazda', 'Econoline E150', 2002, 'Blue', 10374, 'Truck', 'Vancouver', 'maintenance');
insert into vehicles values ('2620647924', 'Toyota', 'Suburban 2500', 2005, 'Blue', 12185, 'Truck', 'Burnaby', 'available');
insert into vehicles values ('9190343093', 'Honda', 'Bonneville', 1966, 'White', 12652, 'Sedan', 'Burnaby', 'available');
insert into vehicles values ('4767464854', 'Honda', 'S-Class', 2011, 'Black', 13393, 'Truck', 'Burnaby', 'available');
insert into vehicles values ('9418857243', 'Mazda', 'Festiva', 1989, 'White', 10280, 'Truck', 'Burnaby', 'maintenance');
insert into vehicles values ('3026148237', 'Honda', '900', 1999, 'Black', 13850, 'Truck', 'Vancouver', 'rented');
insert into vehicles values ('6634634696', 'Mazda', 'Century', 1990, 'White', 10289, 'Sedan', 'Vancouver', 'rented');
insert into vehicles values ('0578978318', 'Honda', 'Vitara', 2002, 'White', 12835, 'Minivan', 'Burnaby', 'rented');
insert into vehicles values ('6325573757', 'Honda', 'Uplander', 2007, 'Blue', 14710, 'Truck', 'Burnaby', 'maintenance');
insert into vehicles values ('2639756524', 'Toyota', 'Dynasty', 1992, 'White', 13603, 'Truck', 'Burnaby', 'rented');
insert into vehicles values ('9441198145', 'Mazda', 'Escort', 1985, 'Black', 12766, 'SUV', 'Vancouver', 'maintenance');
insert into vehicles values ('6119151494', 'Honda', 'A5', 2012, 'Black', 12792, 'SUV', 'Burnaby', 'maintenance');
insert into vehicles values ('4480856757', 'Toyota', 'GTO', 1992, 'Red', 13022, 'Minivan', 'Vancouver', 'available');
insert into vehicles values ('5661668147', 'Mazda', 'Sephia', 1996, 'Blue', 14873, 'Sedan', 'Burnaby', 'maintenance');
insert into vehicles values ('8980247885', 'Toyota', 'CTS-V', 2006, 'Black', 13505, 'Minivan', 'Vancouver', 'rented');
insert into vehicles values ('0639411266', 'Honda', 'CL', 2001, 'Red', 12689, 'Minivan', 'Burnaby', 'maintenance');
insert into vehicles values ('0294575243', 'Honda', 'Challenger', 2000, 'Black', 10803, 'Sedan', 'Burnaby', 'available');
insert into vehicles values ('0825863554', 'Honda', 'Altima', 1997, 'Black', 13696, 'Truck', 'Burnaby', 'available');
insert into vehicles values ('3553754419', 'Mazda', 'Capri', 1986, 'White', 10684, 'SUV', 'Vancouver', 'maintenance');
insert into vehicles values ('9760323982', 'Honda', 'Ranger', 1994, 'White', 11329, 'Minivan', 'Burnaby', 'rented');
insert into vehicles values ('4794447892', 'Toyota', 'Bonneville', 1994, 'White', 10121, 'Truck', 'Burnaby', 'available');
insert into vehicles values ('3369038226', 'Honda', 'Avenger', 1996, 'White', 10560, 'Truck', 'Vancouver', 'available');
insert into vehicles values ('1104921731', 'Toyota', 'Grand Voyager', 1994, 'White', 14847, 'Truck', 'Vancouver', 'available');
insert into vehicles values ('4686223474', 'Honda', 'Regal', 1986, 'White', 13614, 'Truck', 'Vancouver', 'available');
insert into vehicles values ('4271321222', 'Mazda', 'i-Series', 2007, 'Red', 14480, 'Minivan', 'Burnaby', 'available');
insert into vehicles values ('4176400110', 'Toyota', 'Z3', 2000, 'Blue', 14870, 'SUV', 'Vancouver', 'rented');
insert into vehicles values ('3814568885', 'Toyota', 'Mazda5', 2010, 'White', 11793, 'SUV', 'Burnaby', 'rented');

update vehicles set v.location = b.location from branch b inner join vehicles v on b.city = v.city;

insert into rentals values ('r8v372l6', '4271321222', '778-256-2892', '08/11/2019', '23:28', '08/15/2019', '1:13', 14495, 'master', '561467482879', '09/10/2020', 'cf6x893s8');
insert into rentals values ('r0o812v9', '1104921731', '604-473-6551', '11/17/2019', '8:10', '11/20/2019', '12:14', 11602, 'visa', '845684737557', '09/23/2020', 'cf5e234d2');
insert into rentals values ('r1w648t9', '4794447892', '604-960-1292', '08/08/2019', '19:35', '08/12/2019', '0:09', 11800, 'master', '656972259298', '08/26/2020', 'cf1m652m8');
insert into rentals values ('r9d935o3', '0294575243', '604-862-3210', '07/11/2019', '20:12', '07/19/2019', '12:49', 12252, 'master', '826407514208', '09/01/2020', 'cf9j621t1');
insert into rentals values ('r3l102d9', '6119151494', '778-103-3525', '10/22/2019', '9:53', '10/30/2019', '14:37', 12070, 'visa', '561303488148', '09/17/2020', 'cf3u217b8');
insert into rentals values ('r0n899a2', '0639411266', '604-742-8883', '10/10/2019', '17:38', '10/20/2019', '21:59', 12909, 'master', '439700026507', '09/12/2020', 'cf4v458y6');
insert into rentals values ('r1z430k5', '9190343093', '778-562-6633', '08/13/2019', '15:15', '08/13/2019', '2:31', 14223, 'visa', '511282634366', '08/30/2020', 'cf3j004j9');
insert into rentals values ('r5e531m7', '9190343093', '604-676-2347', '10/01/2019', '5:35', '10/05/2019', '4:43', 13627, 'visa', '526178712056', '08/21/2020', 'cf7q816u0');
insert into rentals values ('r9j121g2', '4176400110', '604-114-6909', '06/23/2019', '18:25', '06/25/2019', '16:58', 13385, 'master', '853208021451', '09/21/2020', 'cf2t251n8');
insert into rentals values ('r3f894d3', '4486041283', '604-196-0247', '06/29/2019', '5:21', '07/03/2019', '0:52', 13588, 'master', '284747763035', '09/22/2020', 'cf7a322m0');
insert into rentals values ('r0y670o2', '4686223474', '604-537-9772', '06/25/2019', '4:17', '06/30/2019', '3:36', 11445, 'master', '402220901598', '09/17/2020', 'cf9n063o9');
insert into rentals values ('r9g441f8', '9760323982', '604-281-3817', '06/26/2019', '14:52', '06/30/2019', '17:16', 13589, 'master', '898358901022', '08/04/2020', 'cf8s852w4');
insert into rentals values ('r0m516t2', '6325573757', '778-069-9266', '10/06/2019', '10:49', '10/12/2019', '15:26', 12347, 'visa', '850817006249', '08/09/2020', 'cf5h884x0');
insert into rentals values ('r7z848s1', '7487186393', '604-041-5530', '05/11/2019', '3:38', '05/17/2019', '23:05', 14736, 'master', '215794843698', '08/16/2020', 'cf8q500t6');
insert into rentals values ('r3t113b7', '2639756524', '604-738-7238', '07/31/2019', '9:57', '08/09/2019', '21:55', 11506, 'visa', '668731776494', '09/07/2020', 'cf6p446m1');

insert into customers (dlicense, cellphone, name, address) values ('QK06-N418Q', '778-256-2892', 'Marna', '1295 Calypso Center');
insert into customers (dlicense, cellphone, name, address) values ('IN65-M688P', '604-862-3210', 'Nate', '80224 Messerschmidt Plaza');
insert into customers (dlicense, cellphone, name, address) values ('RN63-T839y', '604-960-1292', 'Vivianne', '807 Debra Lane');
insert into customers (dlicense, cellphone, name, address) values ('JT96-M354x', '604-473-6551', 'Abra', '15632 Harper Road');
insert into customers (dlicense, cellphone, name, address) values ('UV31-M204p', '604-537-9772', 'Marget', '45925 Larry Hill');
insert into customers (dlicense, cellphone, name, address) values ('KO76-E138C', '778-069-9266', 'Jorie', '88 Claremont Junction');
insert into customers (dlicense, cellphone, name, address) values ('FV09-Q094J', '604-024-5610', 'Yorgos', '475 Morrow Drive');
insert into customers (dlicense, cellphone, name, address) values ('MF73-P436X', '778-103-3525', 'Brianna', '1 Sunfield Parkway');
insert into customers (dlicense, cellphone, name, address) values ('BS53-F417V', '604-404-8946', 'Biddie', '841 idge Point');
insert into customers (dlicense, cellphone, name, address) values ('PA54-X962R', '604-196-0247', 'Pepe', '47869 Fordem Avenue');
insert into customers (dlicense, cellphone, name, address) values ('XD02-T391D', '604-121-0953', 'Dari', '56304 Service Terrace');
insert into customers (dlicense, cellphone, name, address) values ('CP53-I288A', '604-281-3817', 'Miran', '0 Lerdahl Hill');
insert into customers (dlicense, cellphone, name, address) values ('US32-B170g', '604-742-8883', 'Valentino', '88 Schurz Crossing');
insert into customers (dlicense, cellphone, name, address) values ('HZ91-J502d', '778-466-4023', 'Vera', '60417 Colorado Plaza');
insert into customers (dlicense, cellphone, name, address) values ('CA37-X440b', '604-738-7238', 'Vivien', '61 Eastlawn Way');
insert into customers (dlicense, cellphone, name, address) values ('UB76-M784c', '604-676-2347', 'Clio', '6 Carey Circle');
insert into customers (dlicense, cellphone, name, address) values ('OL07-P265m', '778-562-6633', 'Karolina', '710 Independence Circle');
insert into customers (dlicense, cellphone, name, address) values ('EL97-U110N', '604-114-6909', 'Allix', '4 Monterey Way');
insert into customers (dlicense, cellphone, name, address) values ('ID06-O589S', '778-838-9345', 'Clair', '0 Drewry Lane');
insert into customers (dlicense, cellphone, name, address) values ('XR88-F302p', '604-041-5530', 'Dar', '9 Ronald Regan Trail');

insert into returns values ('r8v372l6', '08/15/2019', '1:13', 15095, 'true', 700);
insert into returns values ('r0o812v9', '11/20/2019', '12:14', 11902, 'true', 1000);
insert into returns values ('r1w648t9', '08/12/2019', '0:09', 12100, 'true', 500);
insert into returns values ('r9d935o3', '07/19/2019', '12:49', 12652, 'true', 1500);
insert into returns values ('r3l102d9', '10/30/2019', '14:37', 12570, 'true', 240);
insert into returns values ('r0n899a2', '10/20/2019', '21:59', 13209, 'true', 600);
insert into returns values ('r1z430k5', '08/13/2019', '2:31', 14723, 'true', 700);
insert into returns values ('r5e531m7', '10/05/2019', '4:43', 13827, 'true', 800);
insert into returns values ('r9j121g2', '06/25/2019', '16:58', 13685, 'true', 600);
insert into returns values ('r3f894d3', '07/03/2019', '0:52', 13988, 'true', 800);
insert into returns values ('r0y670o2', '06/30/2019', '3:36', 11945, 'true', 1200);
insert into returns values ('r9g441f8', '06/30/2019', '17:16', 13689, 'true', 900);
insert into returns values ('r0m516t2', '10/12/2019', '15:26', 12747, 'true', 400);
insert into returns values ('r7z848s1', '05/17/2019', '23:05', 14966, 'true', 600);
insert into returns values ('r3t113b7', '08/09/2019', '21:55', 11906, 'true', 750);

insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf0n750q8', '4012940775', '778-069-9266', '11/26/2019', '12:45', '11/30/2019', '23:07');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf1t478o7', '4767464854', '778-466-4023', '11/28/2019', '13:40', '12/03/2019', '13:47');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf8c946l1', '4480856757', '604-041-5530', '12/01/2019', '11:43', '12/10/2019', '19:16');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf4o953e3', '4271321222', '604-281-3817', '12/02/2019', '12:26', '12/12/2019', '0:58');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf3d219l5', '0294575243', '604-404-8946', '12/09/2019', '3:16', '12/13/2019', '0:29');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf2u350k7', '3369038226', '604-862-3210', '11/25/2019', '16:00', '11/30/2019', '17:27');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf5q827a2', '8834501322', '778-103-3525', '12/11/2019', '9:03', '12/16/2019', '7:42');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf5x611s6', '5597872400', '604-114-6909', '12/08/2019', '7:45', '12/12/2019', '20:57');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf0w812k5', '0027187292', '604-473-6551', '12/03/2019', '12:33', '12/09/2019', '0:24');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf6w956f9', '1119112303', '778-838-9345', '12/05/2019', '22:05', '12/10/2019', '16:26');