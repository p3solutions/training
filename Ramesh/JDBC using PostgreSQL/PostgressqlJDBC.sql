create table employee(
emp_id int primary key,
ename varchar(50),
salary int);

insert into employee values(1,'Ramesh',5000);
insert into employee values(2,'Clement',7000);
insert into employee values(3,'Saravana',9000);

select * from employee;

CREATE OR REPLACE FUNCTION GetEmp()
RETURNS SETOF employee AS
$$
BEGIN
    RETURN QUERY SELECT * FROM employee;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION GetEmpId(id_param INT)
RETURNS SETOF employee AS
$$
BEGIN
    RETURN QUERY SELECT * FROM employee WHERE emp_id = id_param;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION GetNameById(id INT, OUT empname VARCHAR)
AS $$
DECLARE
  emp_name VARCHAR;
BEGIN
  SELECT ename INTO emp_name
  FROM employee
  WHERE emp_id = id;
  empname := emp_name;  
END;
$$ LANGUAGE plpgsql;


