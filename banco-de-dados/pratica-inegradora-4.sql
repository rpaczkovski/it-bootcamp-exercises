CREATE DATABASE pratice_bill;
use pratice_bill;


CREATE TABLE address(
	id integer primary key not null auto_increment,
    name varchar(40) not null,
    neighborhood varchar(40) not null,
    number varchar(40),
    address varchar(40) not null
);


CREATE TABLE client(
	id integer primary key not null auto_increment,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    address_id int not null,
    foreign key(address_id) references address(id)
);


CREATE TABLE bill(
	id integer not null primary key auto_increment,
    date date not null,
    client_id int not null,
    method_payment decimal default 0.0,
    quantity integer not null,
    value decimal not null,
    tax decimal default 0.0,
    obs varchar(40),
    foreign key(client_id) references client(id)
);


