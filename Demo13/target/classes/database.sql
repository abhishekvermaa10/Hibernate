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

create table pet_table (
	id integer not null auto_increment primary key,
	date_of_birth date,
	place_of_birth varchar(255),
	gender enum ('M','F') not null,
	name varchar(255) not null,
	type enum ('BIRD','CAT','DOG','FISH','RABBIT') not null,
	category varchar(31) not null
);

insert into pet_table (name, date_of_birth, gender, type, category) values (?,?,?,?,'Domestic');
insert into pet_table (name, place_of_birth, gender, type, category) values (?,?,?,?,'Wild');
insert into owner_table (first_name, last_name, gender, city, state, mobile_number, email_id, pet_id) values (?,?,?,?,?,?,?,?);
select * from owner_table where id = ?;
update owner_table set pet_name = ? where id = ?;
delete from owner_table where id = ?;
select * from owner_table;