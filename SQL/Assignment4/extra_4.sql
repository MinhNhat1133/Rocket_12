DROP DATABASE IF EXISTS test;
CREATE DATABASE test ;
USE test;

DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
EmployeeID INT UNSIGNED  PRIMARY KEY AUTO_INCREMENT,
EmployeeLastName varchar(100),
EmployeeFirstName VARCHAR(100),
EmployeeHireDate DATETIME,
EmployeeStatus varchar(100) ,
SupervisorID INT,
SocialSecurityNumber int ) ;

DROP TABLE IF EXISTS Work_done;
CREATE table Work_done (
workDoneID int UNSIGNED  PRIMARY KEY AUTO_INCREMENT, 
employeeID INT UNSIGNED,
moduleID   INT UNSIGNED,
workdoneDate DATETIME,
workdoneDescreptions varchar(100),
workdonestatus varchar (100)
);

DROP TABLE IF EXISTS project;
CREATE TABLE project (
projectID INT UNSIGNED  PRIMARY KEY AUTO_INCREMENT,
managerID INT UNSIGNED,
projectname VARCHAR(150),
projectstartdate DATETIME ,
projectDescirption DATETIME,
projectdetailt VARCHAR(100),
projectcompliton DATETIME ) ;

DROP TABLE IF EXISTS project_Modules;
CREATE TABLE project_Modules (
ModuleID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT  ,
projectID INT UNSIGNED,
projectModulesDate DATETIME,
projectModulesCompeOn DATETIME,
projectmodulesDescirption varchar(100) ) ;


-- viet ham tra ve thong tin nhan vien da tham gaia lam co ng giao viec va in ca thong tin cua ng giao viec 
 
 INSERT INTO test.employee (employeelastname	,employeefirstname ,EmployeeHireDate	,EmployeeStatus,SupervisorID,SocialSecurityNumber )
 VALUES						(	'Ngo'	 		, 	'Huy'			, 	'2019-12-20'	, null			, 	 2	 	,		null		  ),
							(	'Trung'	 		, 	'Kien'			, 	'2019-09-12'	, null			, 	 null	 ,		null		  ),
                            (	'Tran'	 		, 	'Dat'			, 	'2019-11-13'	, null			, 	 4	 	,		null		  ),
                            (	'Nguyen'	 	, 	'Binh'			, 	'2018-12-11'	, null			, 	 2	 	,		null		  ),
                            (	'Le'	 		, 	'Thuy'			, 	'2019-05-25'	, null			, 	 2	 	,		null		  );
                            
INSERT INTO test.project   (	managerID		,projectname	,projectstartdate  ,projectDescirption	,projectdetailt		,projectcompliton	 	)
 VALUES						(		1			,'java'	 		, 	'2020-11-03'	, null				, 	 null	 		,	'2020-12-12'	  	),
							(		2			,'Sql'	 		, 	'2020-09-24'	, null				, 	 null			,	'2020-12-02'	  	),
                            (		3			,'C++'	 		, 	'2020-10-03'	, null				, 	 null	 		,	'2021-03-17'		),
                            (		4			,'php'	 		,	'2020-11-27'	, null				, 	 null	 		,	'2021-03-26'		),
                            (		5			,'python'	 	, 	'2020-10-25'	, null				, 	 null	 		,	'2021-03-03'		);

INSERT INTO test.project_Modules   (projectID		,projectModulesDate  ,projectModulesCompeOn		,projectmodulesDescirption	)
 VALUES								(	5	 		, 	'2021-01-03'	, NULL						, 	 null	 			  	),
									(	4	 		, 	'2021-01-24'	, '2021-01-24'				, 	 null				 	),
									(	3	 		, 	'2021-03-20'	, NULL						, 	 null	 				),
									(	2	 		,	'2021-03-23'	, NULL						, 	 null	 				),
									(	1	 		, 	'2021-02-25'	, '2021-03-03'				, 	 null	 				);   
                  
 INSERT INTO test.Work_done		   (employeeID		,    moduleID		,workdoneDate	,workdoneDescreptions	,workdonestatus	)
 VALUES								(	1	 		, 		2			, null			, 	 null	 			,null			),
									(	2	 		, 	 	3			, null			, 	 null				,null			),
									(	3	 		, 	    4			, null			, 	 null	 			,null			),
									(	4	 		,		5			, null			, 	 null	 			,null			),
									(	5		 	, 		null		, null			, 	 null	 			,null			);  
                                    
                                    
-- Vi???t stored procedure (kh??ng c?? parameter) ????? Remove t???t c??? th??ng tin project ???? ho??n th??nh sau 3 th??ng k??? t??? ng??y hi???n                           
USE test;
DROP PROCEDURE IF EXISTS DELETE_project
DELIMITER $$
CREATE PROCEDURE DELETE_project()
BEGIN
		WITH Project_D AS (
		SELECT		* ,ModuleID as 'total'
		FROM		test.project P join project_modules PM On P.projectID = PM.projectID
		WHERE    	MONTH(P.projectcompliton) = MONTH(now() - INTERVAL 3 MONTH ))
		SELECT 		*
		FROM		test.employee E JOIN work_done W ON W.EmployeeID = E.employeeID
		WHERE		W.ModuleID = (SELECT moduleID FROM Project_D ) ;
END$$
DELIMITER $$
CALL test.DELETE_project();

-- Vi???t stored procedure (c?? parameter) ????? in ra c??c module ??ang ???????c th???c hi???n)
USE test;
DROP PROCEDURE IF EXISTS SELECT_MoDule;
DELIMITER $$
CREATE PROCEDURE SELECT_MoDule(IN n_MoDule VARCHAR(50))
BEGIN
		SELECT * FROM project_Modules 
        WHERE projectModulesCompeOn IS NULL;
END$$
DELIMITER $$
CALL SELECT_MoDule()
-- Vi???t h??m (c?? parameter) tr??? v??? th??ng tin 1 nh??n vi??n ???? tham gia l??m m???c d?? kh??ng ai giao vi???c cho nh??n vi??n ???? (trong b???ng Works)
USE test;
DROP PROCEDURE IF EXISTS SELECT_work;
DELIMITER $$
CREATE PROCEDURE SELECT_work(IN id_employee INT )
BEGIN
		SELECT *
        FROM Employee E LEFT JOIN Work_done W ON E.EmployeeID = W.employeeID
        WHERE W.moduleID is null ;
END$$
DELIMITER $$
call SELECT_work(2);
-- Vi???t h??m (c?? parameter) tr??? v??? th??ng tin 1 nh??n vi??n ???? tham gia l??m co nguoi giao vi???c cho nh??n vi??n ???? 
-- Va in ca thong tin cua supervisorID cua nguoi do 
USE test;
DROP PROCEDURE IF EXISTS SELECT_work1;
DELIMITER $$
CREATE PROCEDURE SELECT_work1(IN id_employee INT )
BEGIN
SELECT
	t.EmployeeID,
	CONCAT(t.EmployeeLastName,' ', t.EmployeeFirstName) as 'fullname',
	t.EmployeeHireDate,
	t.SupervisorID,
	(SELECT CONCAT(EmployeeLastName,' ', EmployeeFirstName) FROM employee WHERE EmployeeID = t.SupervisorID) AS SuperviorName
FROM employee t
WHERE
	SupervisorID is not null 
	AND EmployeeID IN (SELECT EmployeeID FROM work_done);
    END$$
DELIMITER $$
call SELECT_work1 (1)