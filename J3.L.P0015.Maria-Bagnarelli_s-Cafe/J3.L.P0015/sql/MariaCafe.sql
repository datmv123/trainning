use master 
go

--drop database MariaCafe

create database MariaCafe
go

use MariaCafe
go

create table Introduction(
	title varchar(3000),
	description varchar(8000),
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
	publishedDate date,
	price float
)
create table Information(
	content varchar(8000),
	address varchar(3000),
	phone varchar(50),
	author varchar(150)
)
