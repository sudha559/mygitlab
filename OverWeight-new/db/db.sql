DROP TABLE IF EXISTS `overweight`.`doctor`;
CREATE TABLE  `overweight`.`doctor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `Registerid` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `createdDate` datetime NOT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `state` varchar(45) NOT NULL,
  `zipcode` varchar(45) NOT NULL,
  `EXPERIENCE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `overweight`.`doctortreatment`;
CREATE TABLE  `overweight`.`doctortreatment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `createdDate` datetime NOT NULL,
  `level` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `doctor` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `overweight`.`patient`;
CREATE TABLE  `overweight`.`patient` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pid` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `ph` varchar(45) DEFAULT NULL,
  `doctor` varchar(45) NOT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `createdDate` datetime NOT NULL,
  `dob` datetime DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `overweight`.`treatment`;
CREATE TABLE  `overweight`.`treatment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PID` varchar(45) NOT NULL,
  `level` varchar(45) NOT NULL,
  `BP` varchar(45) NOT NULL,
  `sugar` varchar(45) NOT NULL,
  `weight` varchar(45) NOT NULL,
  `result` int(10) unsigned DEFAULT NULL,
  `createdDate` datetime NOT NULL,
  `bmi` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `overweight`.`user`;
CREATE TABLE  `overweight`.`user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `userid` varchar(45) NOT NULL,
  `createdDate` datetime NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `overweight`.`constrains`;
CREATE TABLE  `overweight`.`constrains` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `comments` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;