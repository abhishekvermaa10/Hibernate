create database if not exists petistaan;
use petistaan;

create table owner_table (
	id integer not null auto_increment primary key,
	first_name varchar(255) not null,
    last_name varchar(255) not null,
    gender enum ('M','F') not null,
    city varchar(255) not null,
    state varchar(255) not null,
    mobile_number varchar(10) not null unique,
    email_id varchar(255) not null unique,
	pet_id integer not null unique,
    foreign key (pet_id) references pet_table(id)
);

create table domestic_pet_table (
	id integer not null primary key,
	date_of_birth date not null,
	gender enum ('M','F') not null,
	name varchar(255) not null,
	type enum ('BIRD','CAT','DOG','FISH','RABBIT') not null
);

CREATE TABLE wild_pet_table (
	id integer not null primary key,
	place_of_birth varchar(255) not null,
	gender enum ('M','F') not null,
	name varchar(255) not null,
	type enum ('BIRD','CAT','DOG','FISH','RABBIT') not null
);

CREATE TABLE pet_table (
	id integer not null primary key,
	gender enum ('M','F') not null,
	name varchar(255) not null,
	type enum ('BIRD','CAT','DOG','FISH','RABBIT') not null
);

CREATE TABLE pet_table_SEQ (
	next_val bigint
);

insert into pet_table_SEQ values (1);
insert into domestic_pet_table (id, name, date_of_birth, gender, type) values (?,?,?,?,?);
insert into wild_pet_table (id, name, place_of_birth, gender, type) values (?,?,?,?,?);
insert into owner_table (first_name, last_name, gender, city, state, mobile_number, email_id, pet_id) values (?,?,?,?,?,?,?,?);
select * from owner_table where id = ?;
update owner_table set pet_name = ? where id = ?;
delete from owner_table where id = ?;
select * from owner_table;