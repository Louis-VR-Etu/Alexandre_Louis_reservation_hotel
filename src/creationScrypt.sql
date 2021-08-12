CREATE DATABASE `hotelmanager`;
CREATE TABLE `customer` (
                            `mail` varchar(255)  NOT NULL,
                            `name` varchar(45) NOT NULL,
                            `surname` varchar(45) NOT NULL,
                            `birthDate` date NOT NULL,
                            `phoneNumber` varchar(255)  NOT NULL,
                            PRIMARY KEY (`mail`),
                            UNIQUE KEY `mail_UNIQUE` (`mail`)
);
CREATE TABLE `hotel` (
                         `name` varchar(255)  NOT NULL,
                         `address` varchar(255) NOT NULL,
                         `animals` bit(1) NOT NULL,
                         `allInclusivePrice` float NOT NULL,
                         PRIMARY KEY (`name`),
                         UNIQUE KEY `name_UNIQUE` (`name`)
) ;
CREATE TABLE `reservation` (
                               `beginningDate` date NOT NULL,
                               `roomNumber` int NOT NULL,
                               `roomHotelName` varchar(255) NOT NULL,
                               `endingDate` date NOT NULL,
                               `allInclusive` bit(1) NOT NULL,
                               `people` int NOT NULL,
                               `remarks` varchar(255) NOT NULL,
                               `additionalContact` varchar(255) DEFAULT NULL,
                               `couponCode` varchar(255) DEFAULT NULL,
                               `customerMail` varchar(255) NOT NULL,
                               PRIMARY KEY (`beginningDate`,`roomNumber`,`roomHotelName`),
                               KEY `roomNumber_idx` (`roomNumber`,`roomHotelName`),
                               KEY `customerReservation_idx` (`customerMail`),
                               CONSTRAINT `customerReservation` FOREIGN KEY (`customerMail`) REFERENCES `customer` (`mail`),
                               CONSTRAINT `reservedRoom` FOREIGN KEY (`roomNumber`, `roomHotelName`) REFERENCES `room` (`number`, `hotelName`)
);
CREATE TABLE `room` (
                        `number` int NOT NULL,
                        `hotelName` varchar(255) NOT NULL,
                        `floor` int NOT NULL,
                        `roomTypeName` varchar(255) NOT NULL,
                        PRIMARY KEY (`number`,`hotelName`),
                        KEY `name_idx` (`hotelName`),
                        KEY `roomTypename_idx` (`roomTypeName`),
                        CONSTRAINT `hotelName` FOREIGN KEY (`hotelName`) REFERENCES `hotel` (`name`),
                        CONSTRAINT `roomTypename` FOREIGN KEY (`roomTypeName`) REFERENCES `roomtype` (`typeName`)
);
CREATE TABLE `roomtype` (
                            `typeName` varchar(255) NOT NULL,
                            `price/night` float NOT NULL,
                            `singleBed` int NOT NULL,
                            `doubleBed` int NOT NULL,
                            PRIMARY KEY (`typeName`),
                            UNIQUE KEY `typeName_UNIQUE` (`typeName`)
);