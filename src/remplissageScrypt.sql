set @@global.time_zone = '+00:00';
set @@session.time_zone = '+00:00';

INSERT INTO hotel(name,address,animals,allInclusivePrice) values ("Paradis","tout la haut",TRUE,150);
INSERT INTO hotel(name,address,animals,allInclusivePrice) values ("Enfer","tout en bas",FALSE,1);
INSERT INTO hotel(name,address,animals,allInclusivePrice) values ("Purgatoire","entre les deux",TRUE,10);
INSERT INTO hotel(name,address,animals,allInclusivePrice) values ("Buckingham Palace","Londres SW1A 1AA, Royaume-Uni",FALSE,300);
INSERT INTO hotel(name,address,animals,allInclusivePrice) values ("DisneyLand Paris","Bd de Parc, 77700 Coupvray, France",FALSE,200);

INSERT INTO roomType(typeName,`price/night`,singleBed,doubleBed) values('Deluxe', '3000', '0', '1');
INSERT INTO roomType(typeName,`price/night`,singleBed,doubleBed) values('Dormitory', '20', '1', '0');
INSERT INTO roomType(typeName,`price/night`,singleBed,doubleBed) values('Double Room', '60', '0', '2');
INSERT INTO roomType(typeName,`price/night`,singleBed,doubleBed) values('Family appartment', '200', '2', '1');
INSERT INTO roomType(typeName,`price/night`,singleBed,doubleBed) values('Single Room', '40', '1', '0');

INSERT INTO customer(mail,name,surname,birthDate,phoneNumber) values ('etu39998@henallux.be', 'De Jonge', 'Alexandre',str_to_date("11/04/2000",'%d/%m/%Y'),'0476037797');
INSERT INTO customer(mail,name,surname,birthDate,phoneNumber) values ('etu44348@henallux.be', 'Van Renterghem', 'Louis',str_to_date("01/09/1997",'%d/%m/%Y'),'0476485249');
INSERT INTO customer(mail,name,surname,birthDate,phoneNumber) values ('geGert@gmail.com', 'Clermont', 'Gertrude',str_to_date("24/11/1953",'%d/%m/%Y'),'081896489');
INSERT INTO customer(mail,name,surname,birthDate,phoneNumber) values ('markEmmanuel@gmail.com', 'Emmanuel', 'Mark',str_to_date("05/03/1964",'%d/%m/%Y'),'0474568249');
INSERT INTO customer(mail,name,surname,birthDate,phoneNumber) values ('piRCarre@gmail.com', 'Pierre', 'Pierre',str_to_date("15/01/1946",'%d/%m/%Y'),'081652189');

INSERT INTO room(number,hotelName,floor,roomTypeName) values(7,"Paradis",777,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(45,"Paradis",755,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(700,"Paradis",700,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(9,"Paradis",845,"Family Appartment");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(23,"Paradis",896,"Family Appartment");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(1001,"Paradis",861,"Family Appartment");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(894,"Paradis",962,"Double Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(9456,"Paradis",925,"Double Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(4,"Paradis",987,"Double Room");

INSERT INTO room(number,hotelName,floor,roomTypeName) values(1,"Enfer",-795,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(985,"Enfer",-764,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(623,"Enfer",-723,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(4,"Enfer",-801,"Deluxe");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(95,"Enfer",-832,"Deluxe");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(101,"Enfer",-899,"Deluxe");

INSERT INTO room(number,hotelName,floor,roomTypeName) values(89,"Purgatoire",-10,"Dormitory");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(7,"Purgatoire",-15,"Dormitory");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(9446,"Purgatoire",-19,"Dormitory");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(9854,"Purgatoire",-801,"Family appartment");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(452,"Purgatoire",-832,"Family appartment");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(10,"Purgatoire",-899,"Family appartment");

INSERT INTO room(number,hotelName,floor,roomTypeName) values(7,"Buckingham Palace",1,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(4,"Buckingham Palace",1,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(10,"Buckingham Palace",2,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(80,"Buckingham Palace",6,"Deluxe");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(75,"Buckingham Palace",6,"Deluxe");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(64,"Buckingham Palace",5,"Deluxe");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(40,"Buckingham Palace",3,"Double Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(44,"Buckingham Palace",4,"Double Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(49,"Buckingham Palace",4,"Double Room");

INSERT INTO room(number,hotelName,floor,roomTypeName) values(7,"DisneyLand Paris",1,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(14,"DisneyLand Paris",2,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(20,"DisneyLand Paris",2,"Single Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(79,"DisneyLand Paris",6,"Family appartment");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(67,"DisneyLand Paris",5,"Family appartment");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(61,"DisneyLand Paris",5,"Family appartment");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(30,"DisneyLand Paris",3,"Double Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(35,"DisneyLand Paris",3,"Double Room");
INSERT INTO room(number,hotelName,floor,roomTypeName) values(48,"DisneyLand Paris",4,"Double Room");

INSERT INTO reservation(beginningDate, roomNumber, roomHotelName, endingDate, allInclusive, people, remarks, additionalContact, couponCode, customerMail)
values(str_to_date("20/08/2021",'%d/%m/%Y'),61,"DisneyLand Paris",str_to_date("25/08/2021",'%d/%m/%Y'),TRUE,3,"vacancies","0476359875","981985","geGert@gmail.com");
INSERT INTO reservation(beginningDate, roomNumber, roomHotelName, endingDate, allInclusive, people, remarks, additionalContact, couponCode, customerMail)
values(str_to_date("03/04/2023",'%d/%m/%Y'),45,"Paradis",str_to_date("06/04/2023",'%d/%m/%Y'),FALSE,1,"Its Jesus","","","piRCarre@gmail.com");
INSERT INTO reservation(beginningDate, roomNumber, roomHotelName, endingDate, allInclusive, people, remarks, additionalContact, couponCode, customerMail)
values(str_to_date("07/07/2022",'%d/%m/%Y'),4,"Buckingham Palace",str_to_date("09/07/2022",'%d/%m/%Y'),TRUE,1,"visit","","1451","markEmmanuel@gmail.com");
INSERT INTO reservation(beginningDate, roomNumber, roomHotelName, endingDate, allInclusive, people, remarks, additionalContact, couponCode, customerMail)
values(str_to_date("08/07/2022",'%d/%m/%Y'),7,"Buckingham Palace",str_to_date("11/07/2022",'%d/%m/%Y'),FALSE,1,"visit alone","","","etu44348@henallux.be");
INSERT INTO reservation(beginningDate, roomNumber, roomHotelName, endingDate, allInclusive, people, remarks, additionalContact, couponCode, customerMail)
values(str_to_date("15/07/2022",'%d/%m/%Y'),4,"Buckingham Palace",str_to_date("18/07/2022",'%d/%m/%Y'),TRUE,1,"VIP","0478512056","","etu39998@henallux.be");
