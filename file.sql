CREATE DATABASE `stud_prof_car_subj` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
create table driver(
id_d integer primary key auto_increment,
id integer not null,
type integer not null,
experience double not null,
license varchar(10) not null unique,
unique(id,type)
);

create table student(
id integer primary key auto_increment,
fio varchar(30) not null,
point double not null,
date_born date not null,
gr_name integer not null
);

create table professor(
id integer primary key auto_increment,
fio varchar(30) not null,
age integer not null
);

create table prof_subject(
id integer primary key auto_increment,
id_prof integer references professor(id) on delete cascade on update cascade,
id_subject integer references subject(id) on delete cascade on update cascade,
unique(id_prof,id_subject)
);

create table subject(
id integer primary key auto_increment,
name varchar(10) not null
);

create table stud_prof(
id integer primary key auto_increment,
id_stud integer references student(id) on delete cascade on update cascade, 
id_prof integer references professor(id) on delete set null on update cascade,
unique(id_stud,id_prof)
);

create table car(
id integer primary key auto_increment,
model varchar(10) not null,
color varchar(10) not null,
number varchar(5) not null unique,
id_driver integer references driver(id_d) on delete cascade on update cascade
);

-------------------------------------------------------------------------

insert into student(fio, point, date_born,gr_name) values ('AAA', 3.7, '02.09.2000',505);
insert into student(fio, point, date_born,gr_name) values ('BBB', 4.7, '02.09.2000',202);
insert into student(fio, point, date_born,gr_name) values ('CCC', 2.9, '02.10.2001',199);
insert into student(fio, point, date_born,gr_name) values ('DDD', 3.9, '02.09.2000',505);

insert into professor (fio, age) values ('AAA', 40);
insert into professor (fio, age) values ('BBB', 78);
insert into professor (fio, age) values ('CCC', 91);
insert into professor (fio, age) values ('DDD', 33);

insert into stud_prof (id_stud, id_prof) VALUES (1,1);
insert into stud_prof (id_stud, id_prof) VALUES (1,3);
insert into stud_prof (id_stud, id_prof) VALUES (1,4);
insert into stud_prof (id_stud, id_prof) VALUES (2,1);
insert into stud_prof (id_stud, id_prof) VALUES (2,2);
insert into stud_prof (id_stud, id_prof) VALUES (2,4);
insert into stud_prof (id_stud, id_prof) VALUES (3,1);
insert into stud_prof (id_stud, id_prof) VALUES (3,3);
insert into stud_prof (id_stud, id_prof) VALUES (3,4);
insert into stud_prof (id_stud, id_prof) VALUES (4,1);
insert into stud_prof (id_stud, id_prof) VALUES (4,4);

insert into driver (type, id, experience, license) VALUES (1,1,1,'ghz12');
insert into driver (type, id, experience, license) VALUES (1,2,1,'abc34');
insert into driver (type, id, experience, license) VALUES (1,4,3.6,'zvv77');
insert into driver (type, id, experience, license) VALUES (0,1,10,'aso63');
insert into driver (type, id, experience, license) VALUES (0,2,5,'hkl09');
insert into driver (type, id, experience, license) VALUES (0,3,2,'jbn76');
insert into driver (type, id, experience, license) VALUES (0,4,13,'ifg45');

insert into car (model, color, number, id_driver) VALUES ('opel', 'black', 'qwe12',1);
insert into car (model, color, number, id_driver) VALUES ('bmv', 'black', 'frt33',2);
insert into car (model, color, number, id_driver) VALUES ('lada', 'white', 'gtr57',3);
insert into car (model, color, number, id_driver) VALUES ('mercedes', 'pink', 'qqq32',4);
insert into car (model, color, number, id_driver) VALUES ('nissan', 'black', 'ggg55',5);
insert into car (model, color, number, id_driver) VALUES ('opel', 'silver', 'ert51',6);
insert into car (model, color, number, id_driver) VALUES ('lada', 'black', 'cvb38',7);

insert into subject(name) values ('Math');
insert into subject(name) values ('Literature');
insert into subject(name) values ('Physics');
insert into subject(name) values ('Informatic');

insert into prof_subject(id_prof, id_subject) values (1,1);
insert into prof_subject(id_prof, id_subject) values (1,2);
insert into prof_subject(id_prof, id_subject) values (1,4);
insert into prof_subject(id_prof, id_subject) values (4,1);
insert into prof_subject(id_prof, id_subject) values (4,2);
insert into prof_subject(id_prof, id_subject) values (4,4);
insert into prof_subject(id_prof, id_subject) values (2,2);
insert into prof_subject(id_prof, id_subject) values (2,1);
insert into prof_subject(id_prof, id_subject) values (3,1);
insert into prof_subject(id_prof, id_subject) values (3,3);