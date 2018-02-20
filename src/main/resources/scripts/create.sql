create table IF NOT EXISTS CONSOLE(
	name varchar(25) PRIMARY KEY,
	companyId int
);
create table IF NOT EXISTS VIDEOGAME(
	name varchar(25) PRIMARY KEY,
	age varchar(25),
	releaseDate date ,
	companyId int
);
create table IF NOT EXISTS COMPANY(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name varchar(25) ,
	creationDate date
);