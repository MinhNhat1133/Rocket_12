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
                                    
                                    
-- Viết stored procedure (không có parameter) để Remove tất cả thông tin project đã hoàn thành sau 3 tháng kể từ ngày hiện                           
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
CALL test.DELETE_project();-- ??????????????????

-- Viết stored procedure (có parameter) để in ra các module đang được thực hiện)
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
-- Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc dù không ai giao việc cho nhân viên đó (trong bảng Works)
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
-- Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm co nguoi giao việc cho nhân viên đó 
-- Va in ca thong tin cua supervisorID cua nguoi do 
USE test;
DROP PROCEDURE IF EXISTS SELECT_work2;
DELIMITER $$
CREATE PROCEDURE SELECT_work2(IN id_employee INT )
BEGIN
		WITH in4_Supervisor AS (
		SELECT		EmployeeID 
		FROM		work_done
		WHERE      ModuleID IS NOT NULL
         
    )
	SELECT 		*
    FROM		employee E JOIN Work_done W ON W.EmployeeID = E.employeeID
	WHERE		E.EmployeeID IN  (Select * FROM in4_Supervisor ) ;
END$$
DELIMITER $$
call SELECT_work2(2)