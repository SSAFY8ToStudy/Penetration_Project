# ๐ 1. ๊ดํต ํ๋ก์ ํธ ์ค๊ณ

> ์ฌ์ฉํ ํ๋ก๊ทธ๋จ : `GitMind`
> ๋ง์ธ๋๋งต : [GitMind Map](https://gitmind.com/app/doc/ypivoc04mm0cn2j55vuodawk1enhy26m) 
> ํ๋ก์ฐ์ฐจํธ : [GitMind FlowChart](https://gitmind.com/app/flowchart/796nxq0lvw0cn2j5l10e9v9jjvuxs43g)


### ๐ A. ๋ง์ธ๋๋งต

<img width="1334" alt="แแณแแณแแตแซแแฃแบ 2022-09-22 แแฉแแฅแซ 10 48 39" src="https://user-images.githubusercontent.com/72541544/191640593-7520a1f7-4624-4d77-ba3f-05dc2220c1da.png">


&nbsp;

### ๐ B. ํ๋ก์ฐ์ฐจํธ

<img width="842" alt="แแณแแณแแตแซแแฃแบ 2022-09-22 แแฉแแฎ 2 06 30" src="https://user-images.githubusercontent.com/72541544/191663560-bf811dcc-8755-4cdd-921d-3eb5f8ec2ff6.png">


&nbsp;


**โ๏ธ ํ์ฌ ๊ตฌํ๋์ด ์๋ ๊ฒ**
- ๋ฉ์ธ ํ๋ฉด ์ ํ ๋ฒํผ์ผ๋ก ์ง๋์ ํ์ด๋ธ ์ถ๋ ฅํ๊ธฐ
- ๋ก๊ทธ์ธ, ํ์๊ฐ์ ํ์ด์ง ๊ตฌํ


&nbsp;

&nbsp;



# ๐ 2. Work bench
> Workbench EER์ ํตํด table ์ค๊ณ (ERD ๋ค์ด์ด๊ทธ๋จ)


<img width="1290" alt="แแณแแณแแตแซแแฃแบ 2022-09-22 แแฉแแฅแซ 11 37 35" src="https://user-images.githubusercontent.com/72541544/191662844-a476852e-a49e-4a68-835f-1baf827c46da.png">

- `Schema Name` : `ssafyProject`
- `Character Set` : `utf8`
- `Collation` : `utf8_bin`

&nbsp;

**โ๏ธ user Table**
<img width="1116" alt="แแณแแณแแตแซแแฃแบ 2022-09-22 แแฉแแฎ 1 52 24" src="https://user-images.githubusercontent.com/72541544/191662855-a4dfee7a-0744-43de-a4d2-95c230985845.png">

- id(Primary Key, email, username, password)
- ํ์์ ๋ณด ํ์ด๋ธ

&nbsp;


**โ๏ธ Happy House**
> `Happy House`๋ ๋ฌด์์ธ๊ฐ?
> `Happy House`๋ ์ง๋, ํ์ด๋ธ ํํฐ๋ง ๊ฒ์


<img width="986" alt="แแณแแณแแตแซแแฃแบ 2022-09-22 แแฉแแฎ 1 52 34" src="https://user-images.githubusercontent.com/72541544/191662858-efb67941-baad-47f8-9d6c-5de1f5a9dc08.png">

- ์ํํธ ์ด๋ฆ, ์ธต, ๋ฉด์ , ๋ฒ์ ๋, ๊ฑฐ๋๊ธ์ก

&nbsp;

> **๐ก ์ฐธ๊ณ **
> Happy House๋ kakao api๋ฅผ ํตํด ์คํ๋๊ธฐ ๋๋ฌธ์, db ํ์ด๋ธ ์์ด๋ ๋ ๋ฏํ๋ค.

&nbsp;

**โ๏ธ ์์ฑ๋ sql๋ฌธ**

```sql
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssafyProject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafyProject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafyProject` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `ssafyProject` ;

-- -----------------------------------------------------
-- Table `ssafyProject`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafyProject`.`user` (
  `id` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafyProject`.`Happy House`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafyProject`.`Happy House` (
  `apartmentname` VARCHAR(45) NOT NULL,
  `layer` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  `dong` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  INDEX `fk_Happy House_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_Happy House_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafyProject`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `ssafyProject` ;

-- -----------------------------------------------------
-- Placeholder table for view `ssafyProject`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafyProject`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `ssafyProject`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ssafyProject`.`view1`;
USE `ssafyProject`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

```

&nbsp;

&nbsp;



# ๐ 3. Spring Boot
> `Intellij` ์ฌ์ฉ

<img width="1541" alt="แแณแแณแแตแซแแฃแบ 2022-09-22 แแฉแแฎ 2 23 10" src="https://user-images.githubusercontent.com/72541544/191665042-db213540-f2a3-4345-9ed4-165d308509a7.png">

- `๊ทธ๋ฃน` : `com.ssafy.penetration`
- `ํ๋ก์ ํธ ๋๋ ํฐ๋ฆฌ ์ด๋ฆ` : `penetration`
- `Java ๋ฒ์ ` : 11
- `Spring boot ๋ฒ์ ` : 2.7.3

&nbsp;

- Spring Web, Lombok, H2 Database, MySQL Driver

&nbsp;

&nbsp;


**โ๏ธ Intellij์์ mysql ํ์ธํ๊ธฐ**

<img width="891" alt="แแณแแณแแตแซแแฃแบ 2022-09-22 แแฉแแฎ 2 39 09" src="https://user-images.githubusercontent.com/72541544/191666727-6c9a7807-d353-4d0c-9691-3544a594cdd5.png">

&nbsp;

**โ๏ธ Directory**

> ๋๋ฉ์ธ ํ ์ฌ์ฉ

