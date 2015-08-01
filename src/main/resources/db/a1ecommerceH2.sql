
-- -----------------------------------------------------
-- Table `a1ecommerce`.`ProductCategory`
-- -----------------------------------------------------

CREATE TABLE `ProductCategory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` TINYTEXT NULL,
  `Description` TEXT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `Products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` TINYTEXT NULL,
  `Quantity` INT NULL,
  `Price` INT NULL,
  `ImagePath` TEXT NULL,
  `ProductCategoryToProducts` INT NOT NULL,
  `Description` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Products_ProductCategory_idx` (`ProductCategoryToProducts` ASC),
  CONSTRAINT `fk_Products_ProductCategory`
    FOREIGN KEY (`ProductCategoryToProducts`)
    REFERENCES `ProductCategory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

