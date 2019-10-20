use master 
go

--drop database Sushi

create database Sushi
go

use Sushi
go

create table Introduction(
	imagePath varchar(500)
)
create table Contact(
	address varchar(3000),
	tel varchar(50),
	email varchar(500),
	workingHour varchar(3000),
	mapPath varchar(500)
)
create table Products(
	id int primary key identity(1,1),
	title varchar(3000),
	fullContent varchar(8000),
	shortContent varchar(8000),
	imagePath varchar(500),
	price float
)
