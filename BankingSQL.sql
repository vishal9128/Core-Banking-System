create database bankmanagementsystem;
show databases;
use bankmanagementsystem;

create table signup(
	formno varchar(20) not null,
    Name varchar(30) not null,
    Fname varchar(30) not null,
    DOB varchar(30) not null,
    Gender varchar(30) not null,
    Email varchar(30) not null,
    Married_Status varchar(30) not null,
    Address varchar(30) not null,
    City varchar(30) not null,
    State varchar(30) not null,
    PinCode varchar(30)
);

select * from signup;


create table signup2(
	formno varchar(20) not null,
	Religion varchar(30),
    Category varchar(30),
    Income varchar(30),
    Education varchar(30),
    Occupation varchar(30),
    PanNum varchar(30),
    Aadhar varchar(30),
    SeniorCiti varchar(30),
    ExistingCust varchar(30)
);

select * from signup2;



create table signup3(
	formno varchar(20),
    AccountType varchar(30),
    cardnumber varchar(30),
    pinNumber varchar(30),
    service varchar(300)
);

select * from signup3;


create table login(
	formno varchar(20),
    cardnumber varchar(30),
    pinNumber varchar(30)
);

select * from login;


create table bank(
	pinNumber varchar(30),
    date varchar(50),
    type varchar(30),
    amount varchar(30)
);

select * from bank;


select * from login;
select * from signup;
select * from signup2;
select * from signup3;


show tables;

	