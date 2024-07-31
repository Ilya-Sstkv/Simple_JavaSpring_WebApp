A simple Web application that allows you to interact with a 'car database'. The database contains 4 columns: car's id, car's name, car's model and the number of wheels of the car.

Application inludes such features as adding and removing cars from the database, viewing and editing data of a certain car through a web browser.

The application is written on Java and created using Maven, Spring Framework, Thymeleaf, HTML and CSS. It also includes some field validation using Hibernate.
The database is created using PostgreSQL. The server is operated by Tomcat 10.1.25.
Interface language - English.

//Code for DB 'cars' creation:
CREATE TABLE cars(
id BIGSERIAL NOT NULL PRIMARY KEY,
car_name VARCHAR(20), NOT NULL
model VARCHAR(20),
wheel_num BIGINT);
