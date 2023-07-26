create database jdbc;
use jdbc;
create table employee(
emp_id int primary key,
ename varchar(50),
salary int);

insert into employee values(1,"Hari",100000000);
insert into employee values(2,"Bari",1000);
select * from employee;

delimiter $$
create procedure GetEmp()
begin
select * from employee; 
end$$
delimiter ;

delimiter $$
create procedure GetEmpId(In id int)
begin
select * 
from employee 
where emp_id=id;
end$$
delimiter ; 

delimiter $$
create procedure GetNameById(In id int, OUT empname VARCHAR(40))
begin
select ename
 from employee
 where emp_id=id into empname;
end$$
delimiter ;