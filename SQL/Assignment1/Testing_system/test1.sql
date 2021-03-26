DROP DATABASE IF EXISTS test;
CREATE DATABASE test ;
USE test;

DROP TABLE IF EXISTS project_Modules;
CREATE TABLE project_Modules (
ModuleID INT UNSIGNED  ,
projectID INT UNSIGNED,
projectModulesDate DATETIME,
projectModulesCompeOn DATETIME,
projectmodulesDescirption varchar(100) ) ;

DROP TABLE IF EXISTS work_done;
CREATE table Work_done (
workDoneID int UNSIGNED, 
employeeID INT UNSIGNED,
workdoneDate DATETIME,
workdoneDescreptions varchar(100),
workdonestatus varchar (100)
);
DROP TABLE IF EXISTS project;
CREATE TABLE project (
projectID INT UNSIGNED ,
projectname VARCHAR(150),
projectstartdate DATETIME ,
projectDescirption DATETIME,
projectdetailt VARCHAR(100),
projectcompliton DATE ) ;

DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
employeeID INT UNSIGNED ,
employeelastname varchar(100),
employeefirstname VARCHAR(100),
employeehiredate DATETIME,
employeestatus varchar(100) ,
supervisorID INT,
socialsecuritynumber int ) ;
-- viet ham tra ve thong tin nhan vien da tham gaia lam co ng giao viec va in ca thong tin cua ng giao viec 
 
 INSERT INTO project_Modules (ModuleID,projectID,employeeID,projectModulesDate,projectModulesCompeOn,projectmodulesDescirption)
 VALUES						(1		 ,1			,1			,'2021-03-17'	  ,
