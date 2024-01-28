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
    email_id varchar(255) not null unique
);

create table pet_table (
	id integer not null auto_increment primary key,
	date_of_birth date not null,
	gender enum ('M','F') not null,
	name varchar(255) not null,
	type enum ('BIRD','CAT','DOG','FISH','RABBIT') not null,
	owner_id integer not null,
	foreign key (owner_id) references owner_table(id)
);

insert into owner_table (first_name, last_name, gender, city, state, mobile_number, email_id) values (?,?,?,?,?,?,?);
insert into pet_table (name, date_of_birth, gender, type, owner_id) values (?,?,?,?,?);
select * from owner_table where id = ?;
update owner_table set pet_name = ? where id = ?;
delete from owner_table where id = ?;
select * from owner_table;