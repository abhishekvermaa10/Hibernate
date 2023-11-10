create database if not exists petistaan;
use petistaan;

create table owner_table (
    id integer not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    gender enum ('M','F') not null,
    city varchar(255) not null,
    state varchar(255) not null,
    mobile_number varchar(10) not null unique,
    email_id varchar(255) not null unique,
    pet_id integer not null,
    pet_name varchar(255) not null,
    pet_date_of_birth date not null,
    pet_gender enum ('M','F') not null,
	pet_type enum ('BIRD','CAT','DOG','FISH','RABBIT') not null
);

insert into owner_table (id, first_name, last_name, gender, city, state, mobile_number, email_id, pet_id, pet_name, pet_date_of_birth, pet_gender, pet_type) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
select * from owner_table where id = ?;
update owner_table set pet_name = ? where id = ?;
delete from owner_table where id = ?;
select * from owner_table;