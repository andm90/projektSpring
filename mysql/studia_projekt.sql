
DROP SCHEMA IF EXISTS `studia`;

CREATE SCHEMA `studia`;
USE `studia` ;

CREATE TABLE IF NOT EXISTS `studia`.`authority` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `studia`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `accepted` BOOLEAN NOT NULL,
  `role_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role` (`role_id`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `authority` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `studia`.`wig20` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `otwarcie` DOUBLE NOT NULL,
  `najwyzszy` DOUBLE NOT NULL,
  `najnizszy` DOUBLE NOT NULL,
  `zamkniecie` DOUBLE NOT NULL,
  `wolumen` INT NOT NULL,
  PRIMARY KEY (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


