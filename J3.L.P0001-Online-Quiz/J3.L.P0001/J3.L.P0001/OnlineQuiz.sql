use master
go

drop database OnlineQuiz

create database OnlineQuiz
go

use OnlineQuiz
go

create table Users(
	username varchar(150) primary key,
	password varchar(150),
	email varchar(150)
)
create table Questions(
	id int primary key identity(1,1),
	question varchar(300),
	creattionDate date,
	authorName varchar(150),
	optionA varchar(200),
	optionB varchar(200),
	optionC varchar(200),
	optionD varchar(200),
	optionAIsAnswer bit default 0,
	optionBIsAnswer bit default 0,
	optionCIsAnswer bit default 0,
	optionDIsAnswer bit default 0
)

create table Roles(
	id int primary key identity(1,1),
	name varchar(150)
)
create table Features(
	id int primary key identity(1,1),
	url varchar(150)
)
create table Users_Roles(
	username varchar(150),
	roleId int,

	primary key(username, roleId)
)
create table Roles_Features(
	roleId int,
	featureId int,

	primary key (roleId, featureId)
)
alter table Roles_Features add foreign key(roleId) references Roles(id)
alter table Roles_Features add foreign key(featureId) references Features(id)
alter table Users_Roles add foreign key(roleId) references Roles(id)
alter table Users_Roles add foreign key(username) references Users(username)
alter table Questions add foreign key(authorName) references Users(username)
--
  insert into Roles values ('Teacher')
  insert into Roles values ('Student')

 insert into Features values ('/home')
 insert into Features values ('/register')
insert into Features values ('/take-quiz')
 insert into Features values ('/make-quiz')
 insert into Features values ('/logout')
 insert into Features values ('/do-quiz')
insert into Features values ('/submit-quiz')
insert into Features values ('/list-quiz')
insert into Features values ('/edit-quiz')
 insert into Features values ('/detail-quiz')
 insert into Features values ('/delete-quiz')

insert into Roles_Features (roleId,featureId) values (1,1)
insert into Roles_Features (roleId,featureId) values (1,2)
insert into Roles_Features (roleId,featureId) values (1,3)
insert into Roles_Features (roleId,featureId) values (1,4)
insert into Roles_Features (roleId,featureId) values (1,5)
insert into Roles_Features (roleId,featureId) values (1,6)
insert into Roles_Features (roleId,featureId) values (1,7)
insert into Roles_Features (roleId,featureId) values (1,8)
insert into Roles_Features (roleId,featureId) values (1,9)
insert into Roles_Features (roleId,featureId) values (1,10)
insert into Roles_Features (roleId,featureId) values (1,11)

insert into Roles_Features (roleId,featureId) values (2,1)
insert into Roles_Features (roleId,featureId) values (2,2)
insert into Roles_Features (roleId,featureId) values (2,3)
insert into Roles_Features (roleId,featureId) values (2,6)
insert into Roles_Features (roleId,featureId) values (2,7)
insert into Roles_Features (roleId,featureId) values (2,5)
