DROP DATABASE IF EXISTS security;
CREATE DATABASE security;
USE security;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
	id INT auto_increment PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	login VARCHAR(12) NOT NULL UNIQUE,
	password VARCHAR(60) NOT NULL,
	active BOOLEAN
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles(
	id INT auto_increment PRIMARY KEY,
	name VARCHAR(50) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles(
	id INT auto_increment PRIMARY KEY,
	userId int NOT NULL,
	FOREIGN KEY(userId) REFERENCES users(id),
	roleId int NOT NULL,
	FOREIGN KEY(roleId) REFERENCES roles(id)
);

insert users values (default,'vitor nascimento','vitor','$2a$08$b56Yf2Ro7nkjHv3o6T3uru8vSBvMJcHypw8eRNRp2PzkdtyBQBoGe',1);
insert roles values (default,'ADMIN');
insert user_roles values (default,1,1);
select * from users u join roles r JOIN user_roles ur on ur.userId = u.id and r.id = ur.roleId;