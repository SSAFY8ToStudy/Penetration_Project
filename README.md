# 📚 1. 관통 프로젝트 설계

> 사용한 프로그램 : `GitMind`
> 마인드맵 : [GitMind Map](https://gitmind.com/app/doc/ypivoc04mm0cn2j55vuodawk1enhy26m) 
> 플로우차트 : [GitMind FlowChart](https://gitmind.com/app/flowchart/796nxq0lvw0cn2j5l10e9v9jjvuxs43g)


### 📖 A. 마인드맵

<img width="1334" alt="스크린샷 2022-09-22 오전 10 48 39" src="https://user-images.githubusercontent.com/72541544/191640593-7520a1f7-4624-4d77-ba3f-05dc2220c1da.png">


&nbsp;

### 📖 B. 플로우차트

<img width="842" alt="스크린샷 2022-09-22 오후 2 06 30" src="https://user-images.githubusercontent.com/72541544/191663560-bf811dcc-8755-4cdd-921d-3eb5f8ec2ff6.png">


&nbsp;


**✔️ 현재 구현되어 있는 것**
- 메인 화면 선택 버튼으로 지도와 테이블 출력하기
- 로그인, 회원가입 페이지 구현


&nbsp;

&nbsp;



# 📚 2. Work bench
> Workbench EER을 통해 table 설계 (ERD 다이어그램)


<img width="1290" alt="스크린샷 2022-09-22 오전 11 37 35" src="https://user-images.githubusercontent.com/72541544/191662844-a476852e-a49e-4a68-835f-1baf827c46da.png">

- `Schema Name` : `ssafyProject`
- `Character Set` : `utf8`
- `Collation` : `utf8_bin`

&nbsp;

**✔️ user Table**
<img width="1116" alt="스크린샷 2022-09-22 오후 1 52 24" src="https://user-images.githubusercontent.com/72541544/191662855-a4dfee7a-0744-43de-a4d2-95c230985845.png">

- id(Primary Key, email, username, password)
- 회원정보 테이블

&nbsp;


**✔️ Happy House**
> `Happy House`란 무엇인가?
> `Happy House`는 지도, 테이블 필터링 검색


<img width="986" alt="스크린샷 2022-09-22 오후 1 52 34" src="https://user-images.githubusercontent.com/72541544/191662858-efb67941-baad-47f8-9d6c-5de1f5a9dc08.png">

- 아파트 이름, 층, 면적, 법정동, 거래금액

&nbsp;

> **💡 참고**
> Happy House는 kakao api를 통해 실행되기 때문에, db 테이블 없어도 될듯하다.

&nbsp;

**✔️ 생성된 sql문**

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



# 📚 3. Spring Boot
> `Intellij` 사용

<img width="1541" alt="스크린샷 2022-09-22 오후 2 23 10" src="https://user-images.githubusercontent.com/72541544/191665042-db213540-f2a3-4345-9ed4-165d308509a7.png">

- `그룹` : `com.ssafy.penetration`
- `프로젝트 디렉터리 이름` : `penetration`
- `Java 버전` : 11
- `Spring boot 버전` : 2.7.3

&nbsp;

- Spring Web, Lombok, H2 Database, MySQL Driver

&nbsp;

&nbsp;


**✔️ Intellij에서 mysql 확인하기**

<img width="891" alt="스크린샷 2022-09-22 오후 2 39 09" src="https://user-images.githubusercontent.com/72541544/191666727-6c9a7807-d353-4d0c-9691-3544a594cdd5.png">

&nbsp;

**✔️ Directory**

> 도메인 형 사용

