create table userstore_h(
login varchar2(30) not null,
password varchar2(30) not null,
role varchar2(30)not null,
timest timestamp default current_timestamp
);
 

insert into userstore_h(login,password,role)  values('1332431','nagpur1234','executive');
insert into userstore_h(login,password,role)  values('1000000','1000000','Executive');
insert into userstore_h(login,password,role)  values('2000000','2000000','Cashier');

select * from userstore_h;
 
create table Customer_h1
 (
  ssnID number(9)  not null unique,
  customerID number(9)primary key ,
  customerName varchar2(30) not null,
  age number(3) not null,
  addressLine1 varchar2(50)  not null,
  addressLine2 varchar2(50),
  city varchar2(50) not null,
  state varchar2(50) not null
  );
  
  select * from Customer_h1;
  

  
  create sequence seq_id
  start with 100814333
  increment by 1
  nocache nocycle;
  
  create sequence seq_ssn
  start with 784545345
  increment by 1
  nocache nocycle;
  
  create table Account_h11
  (
   customerID number(9),
   account_id number(9) primary key,
   acc_type varchar2(6),
   balance number(15,4),
   cr DATE default(sysdate),
   cr_last DATE default(sysdate),
   duration number(10),
   foreign key (customerID) references Customer_h1 (customerID)
  );
  
  create sequence seq_acc
  start with 987895436
  increment by 1
  nocache nocycle;
  
  
  select * from Account_h11;
  
  select *  from Account_h11 a inner  join Customer_h1 b on a.customerid = b.customerid where  b.customerid=987895458 or  b.ssnid=987895458 or a.account_id=987895458;

  create table AccountStatus_h(
  customerid number(9),
  account_id number(9),
  accountType varchar(30),
  status varchar(30),
  message varchar(40),
  lastUpdated timestamp 
  );
  
  select * from AccountStatus_h;
  select * from Customer_h1;
 

  
    
  select * from CustomerStatus_h;

  select * from Account_h11 where account_id=987895520;
  
  
  