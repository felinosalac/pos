CREATE TABLE `pos`.`pos_users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `address_1` VARCHAR(45) NOT NULL,
  `address_2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NULL,
  `date_created` DATETIME NOT NULL,
  `date_updated` DATETIME NOT NULL,
  `date_deleted` DATETIME NULL,
  `deleted` INT NULL,
  `need_update` VARCHAR(45) NULL,
  `active` INT NULL,
  `updated_by` INT NULL,
  `deleted_by` INT NULL,
  `created_by` INT NULL,
  `picture` BLOB NULL,
  `signature` BLOB NULL,
  `address_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idpos_users_UNIQUE` (`id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `address_id_UNIQUE` (`address_id` ASC));
  
  ALTER TABLE `pos`.`pos_users` 
CHANGE COLUMN `address_id` `address_id` INT NULL DEFAULT NULL ;

ALTER TABLE `pos`.`pos_users` 
CHANGE COLUMN `deleted` `deleted` BIT(1) NULL DEFAULT NULL ,
CHANGE COLUMN `need_update` `need_update` BIT(1) NULL DEFAULT NULL ,
CHANGE COLUMN `active` `active` BIT(1) NULL DEFAULT NULL ;


ALTER TABLE `pos`.`pos_users` 
CHANGE COLUMN `id` `id` BIGINT(11) NOT NULL ,
CHANGE COLUMN `updated_by` `updated_by` BIGINT(11) NULL DEFAULT NULL ,
CHANGE COLUMN `deleted_by` `deleted_by` BIGINT(11) NULL DEFAULT NULL ,
CHANGE COLUMN `created_by` `created_by` BIGINT(11) NULL DEFAULT NULL ,
CHANGE COLUMN `address_id` `address_id` BIGINT(11) NULL DEFAULT NULL ;


