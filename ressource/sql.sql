create database calculMental;
use calculMental;

drop table user;
create table user(
	id int AUTO_INCREMENT PRIMARY KEY,
	login varchar(50),
	password varchar(50),
	maxscore int default 0,
	connections int default 0
);

insert into user(login,password) values('jean','123');
insert into user(login,password,maxscore) values('bon','123',1);

insert into user(login,password,maxscore) values ('a','a123',1);
insert into user(login,password,maxscore) values ('b','b123',1);
insert into user(login,password,maxscore) values ('c','c123',2);
insert into user(login,password,maxscore) values ('d','d123',2);
insert into user(login,password,maxscore) values ('e','e123',2);
insert into user(login,password,maxscore) values ('f','f123',2);
insert into user(login,password,maxscore) values ('g','g123',2);
insert into user(login,password,maxscore) values ('h','h123',2);
insert into user(login,password,maxscore) values ('i','i123',2);
insert into user(login,password,maxscore) values ('j','j123',2);
insert into user(login,password,maxscore) values ('k','k123',0);
insert into user(login,password,maxscore) values ('l','l123',0);
insert into user(login,password,maxscore) values ('m','m123',0);
insert into user(login,password,maxscore) values ('n','n123',0);
insert into user(login,password,maxscore) values ('o','o123',0);
insert into user(login,password,maxscore) values ('p','p123',0);
insert into user(login,password,maxscore) values ('k','k123',0);
insert into user(login,password,maxscore) values ('r','r123',0);
insert into user(login,password,maxscore) values ('s','s123',0);
insert into user(login,password,maxscore) values ('t','t123',0);
insert into user(login,password,maxscore) values ('u','u123',0);
insert into user(login,password,maxscore) values ('v','v123',0);
insert into user(login,password,maxscore) values ('w','w123',0);
insert into user(login,password,maxscore) values ('x','x123',0);
insert into user(login,password,maxscore) values ('y','y123',0);
insert into user(login,password,maxscore) values ('z','z123',0);

