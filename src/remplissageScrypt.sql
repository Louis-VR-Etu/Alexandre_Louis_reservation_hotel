
INSERT INTO hotel(name,address,animals,allInclusivePrice) values (,,,)

INSERT INTO roomType(typeName,`price/night`,singleBed,doubleBed) values(,,,);


INSERT INTO room(number,hotelName,floor,roomTypeName) values(,,,);

INSERT INTO customer(mail,name,surname,birthDate,phoneNumber) values (,,,str_to_date(?,'%d/%m/%Y'),);

INSERT INTO reservation(beginningDate, roomNumber, roomHotelName, endingDate, allInclusive, people, remarks, additionalContact, couponCode, customerMail)
values(str_to_date(?,'%d/%m/%Y'),?,?,str_to_date(?,'%d/%m/%Y'),?,?,?,?,?,?)