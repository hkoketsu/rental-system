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
    cellphone VARCHAR(12) NOT NULL,
    fromDate DATE NOT NULL,
    fromTime VARCHAR(15) NOT NULL,
    toDate DATE NOT NULL,
    toTime VARCHAR(15) NOT NULL,
    PRIMARY KEY (confNo));

GRANT SELECT ON reservations TO PUBLIC;

CREATE TABLE rentals
    (rid VARCHAR(20) NOT NULL,
    vlicense VARCHAR(10) NOT NULL,
    cellphone VARCHAR(12) NOT NULL,
    fromDate DATE NOT NULL,
    fromTime VARCHAR(15) NOT NULL,
    toDate DATE NOT NULL,
    toTime VARCHAR(15) NOT NULL,
    odometer INT NOT NULL,
    cardName VARCHAR(20) NOT NULL,
    cardNo VARCHAR(20) NOT NULL,
    expDate DATE NOT NULL,
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

insert into vehicles values ('0027187292', 'Toyota', 'Elise', 2004, 'Red', 12767, 'Minivan', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('6793029886', 'Honda', 'GX', 2005, 'White', 12636, 'Truck', '122 Walter Hardwick Ave 305', 'Vancouver', 'rented');
insert into vehicles values ('2733759507', 'Honda', 'Grand Marquis', 1993, 'Black', 10666, 'Sedan', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('3314466021', 'Mazda', 'M5', 2006, 'Red', 14424, 'Minivan', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('5499169365', 'Honda', 'Silverado', 2002, 'Black', 14564, 'SUV', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('5597872400', 'Honda', 'Mariner', 2011, 'Red', 14118, 'Minivan', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('4378798336', 'Mazda', 'D350 Club', 1993, 'Blue', 13785, 'SUV', '122 Walter Hardwick Ave 305', 'Vancouver', 'maintenance');
insert into vehicles values ('9990918023', 'Mazda', 'Odyssey', 2001, 'Red', 14247, 'Minivan', '5202 Union St', 'Burnaby', 'maintenance');
insert into vehicles values ('3155734639', 'Honda', 'CLS-Class', 2006, 'Blue', 12896, 'SUV', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('9459185061', 'Mazda', 'Tucson', 2009, 'Black', 14629, 'Minivan', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('0467515840', 'Honda', 'Savana 1500', 2011, 'Black', 12081, 'Sedan', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('6212991243', 'Toyota', 'Coachbuilder', 1994, 'White', 11184, 'SUV', '122 Walter Hardwick Ave 305', 'Vancouver', 'rented');
insert into vehicles values ('8834501322', 'Mazda', 'SJ', 1991, 'White', 11173, 'Sedan', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('1119112303', 'Toyota', 'CTS', 2006, 'Black', 11284, 'Truck', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('6666655133', 'Mazda', 'ZDX', 2012, 'Black', 12544, 'Truck', '5202 Union St', 'Burnaby', 'rented');
insert into vehicles values ('2838880349', 'Honda', 'Supra', 1993, 'Red', 11760, 'Sedan', '5202 Union St', 'Burnaby', 'rented');
insert into vehicles values ('1615147144', 'Mazda', 'Neon', 2002, 'Black', 14705, 'Minivan', '5202 Union St', 'Burnaby', 'rented');
insert into vehicles values ('6008985648', 'Honda', 'GTI', 1993, 'Blue', 10798, 'Sedan', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('2825549029', 'Toyota', 'Eclipse', 2008, 'Black', 14588, 'Sedan', '5202 Union St', 'Burnaby', 'rented');
insert into vehicles values ('9170481083', 'Mazda', 'V70', 2000, 'White', 12105, 'Minivan', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('4012940775', 'Mazda', 'Veracruz', 2012, 'Red', 14410, 'SUV', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('4486041283', 'Mazda', 'SRX', 2005, 'Black', 11946, 'SUV', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('7487186393', 'Mazda', 'A8', 1999, 'Black', 11741, 'Truck', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('7627955874', 'Mazda', 'Econoline E150', 2002, 'Blue', 10374, 'Truck', '122 Walter Hardwick Ave 305', 'Vancouver', 'maintenance');
insert into vehicles values ('2620647924', 'Toyota', 'Suburban 2500', 2005, 'Blue', 12185, 'Truck', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('9190343093', 'Honda', 'Bonneville', 1966, 'White', 12652, 'Sedan', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('4767464854', 'Honda', 'S-Class', 2011, 'Black', 13393, 'Truck', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('9418857243', 'Mazda', 'Festiva', 1989, 'White', 10280, 'Truck', '5202 Union St', 'Burnaby', 'maintenance');
insert into vehicles values ('3026148237', 'Honda', '900', 1999, 'Black', 13850, 'Truck', '122 Walter Hardwick Ave 305', 'Vancouver', 'rented');
insert into vehicles values ('6634634696', 'Mazda', 'Century', 1990, 'White', 10289, 'Sedan', '122 Walter Hardwick Ave 305', 'Vancouver', 'rented');
insert into vehicles values ('0578978318', 'Honda', 'Vitara', 2002, 'White', 12835, 'Minivan', '5202 Union St', 'Burnaby', 'rented');
insert into vehicles values ('6325573757', 'Honda', 'Uplander', 2007, 'Blue', 14710, 'Truck', '5202 Union St', 'Burnaby', 'maintenance');
insert into vehicles values ('2639756524', 'Toyota', 'Dynasty', 1992, 'White', 13603, 'Truck', '5202 Union St', 'Burnaby', 'rented');
insert into vehicles values ('9441198145', 'Mazda', 'Escort', 1985, 'Black', 12766, 'SUV', '122 Walter Hardwick Ave 305', 'Vancouver', 'maintenance');
insert into vehicles values ('6119151494', 'Honda', 'A5', 2012, 'Black', 12792, 'SUV', '5202 Union St', 'Burnaby', 'maintenance');
insert into vehicles values ('4480856757', 'Toyota', 'GTO', 1992, 'Red', 13022, 'Minivan', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('5661668147', 'Mazda', 'Sephia', 1996, 'Blue', 14873, 'Sedan', '5202 Union St', 'Burnaby', 'maintenance');
insert into vehicles values ('8980247885', 'Toyota', 'CTS-V', 2006, 'Black', 13505, 'Minivan', '122 Walter Hardwick Ave 305', 'Vancouver', 'rented');
insert into vehicles values ('0639411266', 'Honda', 'CL', 2001, 'Red', 12689, 'Minivan', '5202 Union St', 'Burnaby', 'maintenance');
insert into vehicles values ('0294575243', 'Honda', 'Challenger', 2000, 'Black', 10803, 'Sedan', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('0825863554', 'Honda', 'Altima', 1997, 'Black', 13696, 'Truck', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('3553754419', 'Mazda', 'Capri', 1986, 'White', 10684, 'SUV', '122 Walter Hardwick Ave 305', 'Vancouver', 'maintenance');
insert into vehicles values ('9760323982', 'Honda', 'Ranger', 1994, 'White', 11329, 'Minivan', '5202 Union St', 'Burnaby', 'rented');
insert into vehicles values ('4794447892', 'Toyota', 'Bonneville', 1994, 'White', 10121, 'Truck', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('3369038226', 'Honda', 'Avenger', 1996, 'White', 10560, 'Truck', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('1104921731', 'Toyota', 'Grand Voyager', 1994, 'White', 14847, 'Truck', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('4686223474', 'Honda', 'Regal', 1986, 'White', 13614, 'Truck', '122 Walter Hardwick Ave 305', 'Vancouver', 'available');
insert into vehicles values ('4271321222', 'Mazda', 'i-Series', 2007, 'Red', 14480, 'Minivan', '5202 Union St', 'Burnaby', 'available');
insert into vehicles values ('4176400110', 'Toyota', 'Z3', 2000, 'Blue', 14870, 'SUV', '122 Walter Hardwick Ave 305', 'Vancouver', 'rented');
insert into vehicles values ('3814568885', 'Toyota', 'Mazda5', 2010, 'White', 11793, 'SUV', '5202 Union St', 'Burnaby', 'rented');


insert into rentals values ('r8v372l6', '4271321222', '778-256-2892', '11-AUG-2019', '23:28', '15-AUG-2019', '01:13', 14495, 'master', '561467482879', '10-SEP-2020', 'cf6x893s8');
insert into rentals values ('r0o812v9', '1104921731', '604-473-6551', '17-NOV-2019', '08:10', '20-NOV-2019', '12:14', 11602, 'visa', '845684737557', '23-SEP-2020', 'cf5e234d2');
insert into rentals values ('r1w648t9', '4794447892', '604-960-1292', '08-AUG-2019', '19:35', '12-AUG-2019', '00:09', 11800, 'master', '656972259298', '26-AUG-2020', 'cf1m652m8');
insert into rentals values ('r9d935o3', '0294575243', '604-862-3210', '11-JUL-2019', '20:12', '19-JUL-2019', '12:49', 12252, 'master', '826407514208', '01-SEP-2020', 'cf9j621t1');
insert into rentals values ('r3l102d9', '6119151494', '778-103-3525', '22-OCT-2019', '09:53', '30-OCT-2019', '14:37', 12070, 'visa', '561303488148', '17-SEP-2020', 'cf3u217b8');
insert into rentals values ('r0n899a2', '0639411266', '604-742-8883', '10-OCT-2019', '17:38', '20-OCT-2019', '21:59', 12909, 'master', '439700026507', '12-SEP-2020', 'cf4v458y6');
insert into rentals values ('r1z430k5', '9190343093', '778-562-6633', '13-AUG-2019', '15:15', '13-AUG-2019', '02:31', 14223, 'visa', '511282634366', '30-AUG-2020', 'cf3j004j9');
insert into rentals values ('r5e531m7', '3369038226', '604-676-2347', '01-OCT-2019', '05:35', '05-OCT-2019', '04:43', 13627, 'visa', '526178712056', '21-AUG-2020', 'cf7q816u0');
insert into rentals values ('r9j121g2', '4176400110', '604-114-6909', '23-JUN-2019', '18:25', '25-JUN-2019', '16:58', 13385, 'master', '853208021451', '21-SEP-2020', 'cf2t251n8');
insert into rentals values ('r3f894d3', '4486041283', '604-196-0247', '29-JUN-2019', '05:21', '03-JUL-2019', '00:52', 13588, 'master', '284747763035', '22-SEP-2020', 'cf7a322m0');
insert into rentals values ('r0y670o2', '4686223474', '604-537-9772', '25-JUN-2019', '04:17', '30-JUN-2019', '03:36', 11445, 'master', '402220901598', '17-SEP-2020', 'cf9n063o9');
insert into rentals values ('r9g441f8', '9760323982', '604-281-3817', '26-JUN-2019', '14:52', '30-JUN-2019', '17:16', 13589, 'master', '898358901022', '04-AUG-2020', 'cf8s852w4');
insert into rentals values ('r0m516t2', '6325573757', '778-069-9266', '06-OCT-2019', '10:49', '12-OCT-2019', '15:26', 12347, 'visa', '850817006249', '09-AUG-2020', 'cf5h884x0');
insert into rentals values ('r7z848s1', '7487186393', '604-041-5530', '11-MAY-2019', '03:38', '17-MAY-2019', '23:05', 14736, 'master', '215794843698', '16-AUG-2020', 'cf8q500t6');
insert into rentals values ('r3t113b7', '2639756524', '604-738-7238', '31-JUL-2019', '09:57', '09-AUG-2019', '21:55', 11506, 'visa', '668731776494', '07-SEP-2020', 'cf6p446m1');

insert into customers (dlicense, cellphone, name, address) values ('QK06-N418Q', '778-256-2892', 'Marna', '1295 Calypso Center');
insert into customers (dlicense, cellphone, name, address) values ('IN65-M688P', '604-862-3210', 'Nate', '80224 Messerschmidt Plaza');
insert into customers (dlicense, cellphone, name, address) values ('RN63-T839Y', '604-960-1292', 'Vivianne', '807 Debra Lane');
insert into customers (dlicense, cellphone, name, address) values ('JT96-M354X', '604-473-6551', 'Abra', '15632 Harper Road');
insert into customers (dlicense, cellphone, name, address) values ('UV31-M204P', '604-537-9772', 'Marget', '45925 Larry Hill');
insert into customers (dlicense, cellphone, name, address) values ('KO76-E138C', '778-069-9266', 'Jorie', '88 Claremont Junction');
insert into customers (dlicense, cellphone, name, address) values ('FV09-Q094J', '604-024-5610', 'Yorgos', '475 Morrow Drive');
insert into customers (dlicense, cellphone, name, address) values ('MF73-P436X', '778-103-3525', 'Brianna', '1 Sunfield Parkway');
insert into customers (dlicense, cellphone, name, address) values ('BS53-F417V', '604-404-8946', 'Biddie', '841 idge Point');
insert into customers (dlicense, cellphone, name, address) values ('PA54-X962R', '604-196-0247', 'Pepe', '47869 Fordem Avenue');
insert into customers (dlicense, cellphone, name, address) values ('XD02-T391D', '604-121-0953', 'Dari', '56304 Service Terrace');
insert into customers (dlicense, cellphone, name, address) values ('CP53-I288A', '604-281-3817', 'Miran', '0 Lerdahl Hill');
insert into customers (dlicense, cellphone, name, address) values ('US32-B170G', '604-742-8883', 'Valentino', '88 Schurz Crossing');
insert into customers (dlicense, cellphone, name, address) values ('HZ91-J502D', '778-466-4023', 'Vera', '60417 Colorado Plaza');
insert into customers (dlicense, cellphone, name, address) values ('CA37-X440B', '604-738-7238', 'Vivien', '61 Eastlawn Way');
insert into customers (dlicense, cellphone, name, address) values ('UB76-M784C', '604-676-2347', 'Clio', '6 Carey Circle');
insert into customers (dlicense, cellphone, name, address) values ('OL07-P265M', '778-562-6633', 'Karolina', '710 Independence Circle');
insert into customers (dlicense, cellphone, name, address) values ('EL97-U110N', '604-114-6909', 'Allix', '4 Monterey Way');
insert into customers (dlicense, cellphone, name, address) values ('ID06-O589S', '778-838-9345', 'Clair', '0 Drewry Lane');
insert into customers (dlicense, cellphone, name, address) values ('XR88-F302P', '604-041-5530', 'Dar', '9 Ronald Regan Trail');

insert into returns values ('r8v372l6', '15-AUG-2019', '01:13', 15095, 'true', 700);
insert into returns values ('r0o812v9', '20-NOV-2019', '12:14', 11902, 'true', 1000);
insert into returns values ('r1w648t9', '12-AUG-2019', '00:09', 12100, 'true', 500);
insert into returns values ('r9d935o3', '19-JUL-2019', '12:49', 12652, 'true', 1500);
insert into returns values ('r3l102d9', '30-OCT-2019', '14:37', 12570, 'true', 240);
insert into returns values ('r0n899a2', '20-OCT-2019', '21:59', 13209, 'true', 600);
insert into returns values ('r1z430k5', '13-AUG-2019', '02:31', 14723, 'true', 700);
insert into returns values ('r5e531m7', '05-OCT-2019', '04:43', 13827, 'true', 800);
insert into returns values ('r9j121g2', '25-JUN-2019', '16:58', 13685, 'true', 600);
insert into returns values ('r3f894d3', '03-JUL-2019', '00:52', 13988, 'true', 800);
insert into returns values ('r0y670o2', '30-JUN-2019', '03:36', 11945, 'true', 1200);
insert into returns values ('r9g441f8', '30-JUN-2019', '17:16', 13689, 'true', 900);
insert into returns values ('r0m516t2', '12-OCT-2019', '15:26', 12747, 'true', 400);
insert into returns values ('r7z848s1', '17-MAY-2019', '23:05', 14966, 'true', 600);
insert into returns values ('r3t113b7', '09-AUG-2019', '21:55', 11906, 'true', 750);

/*
These is the current upcomming rerservations
*/
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf0n750q8', '4012940775', '778-069-9266', '26-NOV-2019', '12:45', '30-NOV-2019', '23:07');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf1t478o7', '4767464854', '778-466-4023', '28-NOV-2019', '13:40', '03-DEC-2019', '13:47');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf8c946l1', '4480856757', '604-041-5530', '01-DEC-2019', '11:43', '10-DEC-2019', '19:16');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf4o953e3', '4271321222', '604-281-3817', '02-DEC-2019', '12:26', '12-DEC-2019', '00:58');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf3d219l5', '0294575243', '604-404-8946', '09-DEC-2019', '03:16', '13-DEC-2019', '00:29');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf2u350k7', '3369038226', '604-862-3210', '25-NOV-2019', '16:00', '30-NOV-2019', '17:27');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf5q827a2', '8834501322', '778-103-3525', '11-DEC-2019', '09:03', '16-DEC-2019', '07:42');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf5x611s6', '5597872400', '604-114-6909', '08-DEC-2019', '07:45', '12-DEC-2019', '20:57');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf0w812k5', '0027187292', '604-473-6551', '03-DEC-2019', '12:33', '09-DEC-2019', '00:24');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf6w956f9', '1119112303', '778-838-9345', '05-DEC-2019', '22:05', '10-DEC-2019', '16:26');

/*
These are the completed reservations, matched with the renatals and return 
*/
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf6x893s8', '4271321222', '778-256-2892', '11-AUG-2019', '23:28', '15-AUG-2019', '01:13');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf5e234d2', '1104921731', '604-473-6551', '17-NOV-2019', '08:10', '20-NOV-2019', '12:14');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf1m652m8', '4794447892', '604-960-1292', '08-AUG-2019', '19:35', '12-AUG-2019', '00:09');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf9j621t1', '0294575243', '604-862-3210', '11-JUL-2019', '20:12', '19-JUL-2019', '12:49');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf3u217b8', '6119151494', '778-103-3525', '22-OCT-2019', '09:53', '30-OCT-2019', '14:37');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf4v458y6', '0639411266', '604-742-8883', '10-OCT-2019', '17:38', '20-OCT-2019', '21:59');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf3j004j9', '9190343093', '778-562-6633', '13-AUG-2019', '15:15', '13-AUG-2019', '02:31');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf7q816u0', '3369038226', '604-676-2347', '01-OCT-2019', '05:35', '05-OCT-2019', '04:43');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf2t251n8', '4176400110', '604-114-6909', '23-JUN-2019', '18:25', '25-JUN-2019', '16:58');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf7a322m0', '4486041283', '604-196-0247', '29-JUN-2019', '05:21', '03-JUL-2019', '00:52');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf9n063o9', '4686223474', '604-537-9772', '25-JUN-2019', '04:17', '30-JUN-2019', '03:36');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf8s852w4', '9760323982', '604-281-3817', '26-JUN-2019', '14:52', '30-JUN-2019', '17:16');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf5h884x0', '6325573757', '778-069-9266', '06-OCT-2019', '10:49', '12-OCT-2019', '15:26');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf8q500t6', '7487186393', '604-041-5530', '11-MAY-2019', '03:38', '17-MAY-2019', '23:05');
insert into reservations (confNo, vtname, cellphone, fromDate, fromTime, toDate, toTime) values ('cf6p446m1', '2639756524', '604-738-7238', '31-JUL-2019', '09:57', '09-AUG-2019', '21:55');