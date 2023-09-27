create database fadb;
use fadb;
create table EMPLOYEE(
	ID INT auto_increment NOT NULL primary key,
    First_Name varchar(50) not null,
    Last_Name varchar(50) not null
);
select * from fadb.employee;