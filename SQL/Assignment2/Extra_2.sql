-- Exercise 1:Design a table
DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE Fresher;
USE Fresher;
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee(
	TraineeID 		 TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Full_Name 		 NVARCHAR (50) NOT NULL,
    Birth_Date 		 DATE ,
    Gender 			 ENUM ('male','female','unknown')NOT NULL ,
    ET_IQ  			 TINYINT UNSIGNED CHECK ( ET_IQ <= 20 ),
    ET_Gmath		 TINYINT UNSIGNED CHECK (ET_Gmath <= 20 ),
    ET_English		 TINYINT UNSIGNED CHECK (ET_English <= 50 ),
    Training_Class	 CHAR(20) NOT NULL ,
    Evaluation_Notes NVARCHAR(150)
);
-- Question 2: thêm trường VTI_Account với điều kiện not null & unique
ALTER TABLE Trainee
  ADD VTI_Account CHAR(20) NOT NULL UNIQUE ;
  
  -- =====================Exercise 2: Data Types :
		DROP TABLE IF EXISTS `Data_Types`;
		CREATE TABLE `Data_Type`(
		  ID		 	 MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		`Name` 			 VARCHAR (50) NOT NULL,
		`Code` 			 CHAR(5),
		 ModifiedDate 	 DATETIME
    );
  
  -- =====================Exercise 3: Data Types (2):
			DROP TABLE IF EXISTS `Data_Types2`;
		CREATE TABLE `Data_Type2`(
		  ID		 	MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		`Name` 			VARCHAR (50) NOT NULL,
		BirthDate 		DATE NOT NULL,
		Gender 			ENUM('Male','Female') DEFAULT ('Unknown'),
        IsDeletedFlag	BIT NOT NULL
    );
    -- Question 1: Thêm ít nhất 10 bản ghi vào table
INSERT INTO fresher.trainee (Full_Name			,Birth_Date		,Gender		, ET_IQ		,ET_Gmath	,ET_English	,Training_Class		,VTI_Account		,Evaluation_Notes)   
VALUES    					('Nguyễn hải Đăng'	,'1997-03-05'	,'male'		,	12		,	14		,	11		,'1'		 		, 'VTI0001'			,NULL			 ),
							('Nguyễn Hoàng Nam'	,'2000-12-21'	,'male'		,	11		,	13		,	20		,'2'		 		, 'VTI0002'			,NULL			 ),
							('Ngo Ba Kha'		,'1993-05-16'	,'unknown'	,	16		,  	19		,	11		,'3'		 		, 'VTI0003'			,NULL			 ),
							('Nguyen Van Chien'	,'1999-03-15'	,'male'		,	12		,	12		,	20		,'4'		 		, 'VTI0004'			,NULL			 ),
							('Duong Do'			,'1995-03-05'	,'male'		,	19		,	18		,	19		,'5'		 		, 'VTI0005'			,NULL			 ),
							('Bui Xuan Huan'	,'1994-03-13'	,'female'	,	06		,	13		,	18		,'6'		 		, 'VTI0006'			,NULL			 ),
							('Nguyen Hoang Lam ','2000-11-20'	,'unknown'	,	04		,	11		,	12		,'7'		 		, 'VTI0007'			,NULL			 ),
							('Duong Van Huu'	,'1999-12-29'	,'male'		,	16		,	20		,	18		,'8'		 		, 'VTI0008'			,NULL			 ),
							('Vi Ti Ai'			,'2000-12-11'	,'male'		,	20		,	20		,	20		,'9'		 		, 'VTI0009'			,NULL			 ),
							('HuanHoaHong'		,'2001-12-05'	,'male'		,	19		,	13		,	12		,'10'			 	, 'VTI00010'		,NULL			 );
                            
  -- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau  
  SELECT * FROM fresher.trainee ORDER BY Birth_Date;
  -- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
 SELECT DATEDIFF(Birth_Date,'2020-03-07'), ‘%Y’+0 AS age from fresher.trainee;
-- Question 4: 
SELECT * FROM fresher.trainee 
WHERE ET_IQ + ET_Gmath>=20 
AND ET_IQ>=8
AND ET_Gmath>=8
AND ET_English>=18;
-- Question 5 xóa thực tập sinh có TraineeID = 3
DELETE FROM fresher.trainee
WHERE traineeID = 3;
-- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2"
UPDATE trainee
SET Training_class = '2'
WHERE TraineeID = 05;
-- ================Exercise 2====
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
Department_Number TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
 Department_Name  NVARCHAR(50) NOT NULL  );
 
DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE Employee_Table (
Employee_Number 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
Employee_Name  		NVARCHAR(50) NOT NULL,
Department_Number	TINYINT UNSIGNED NOT NULL,
FOREIGN KEY (Department_Number)  REFERENCES  Department(Department_Number)
 );
 
 DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE Employee_Skill_Table (
Employee_Number	 TINYINT UNSIGNED NOT NULL	, 
 Skill_Code 	 NVARCHAR(50) NOT NULL,
 Date_Registered DATETIME ,
 FOREIGN KEY (Employee_Number) REFERENCES Employee_Table(Employee_Number));
 
 -- Question 2: Thêm ít nhất 10 bản ghi vào table
 INSERT INTO  Department	(Department_Name		)
VALUES 			
							(N'Marketing'		),
							(N'Sale'			),
							(N'Bảo vệ'			),
							(N'Nhân sự'			),
							(N'Kỹ Thuật'		),
							(N'Tài chính'		),
							(N'Phó giám đốc'	),
							(N'Giám đốc'		),
							(N'Thư kí'			),
							(N'Bán hàng	'		);
                            
 INSERT INTO Employee_Table		(  Employee_Name				, Department_Number	)
VALUES 				
								(N'MainYasuoClub'				,   3				),
								(N'Don 4 Get me'				,   3				),
								(N'VTI Dev'						,   4				),
								(N'GoodBoys'					,   1			    ),
								(N'BadBoys'						,   3				),
								(N'PhacBoys'					,   5				),
								(N'Thieu Muoi Boys'				,   3				),
								(N'MainZoe'						,   9				),
								(N'WibuClub'					,   10				),
								(N'LoliClub'					,   8				);
                                
 INSERT INTO Employee_Skill_Table		( Employee_Number , 	 Skill_Code				,  Date_Registered)
VALUES 				
										(		1				,N'java'					,  	'2021-03-17'),
										(		1				,N'VB.NET'					, 	'2021-06-07'),
										(		3				,N'.NET'					,   '2019-09-25'),
										(		2				,N'SQL'						,   '2021-04-15'),
										(		1				,N'postman'					,   '2019-08-28'),
										(		4				,N'Ruby'					,   '2020-12-06'),
										(		5				,N'PHP'						,  	'2021-07-07'),
										(		6				,N'C++'						,   '2021-03-17'),
										(		7				,N'C#'						,   '2021-03-15'),
										(		9				,N'python'					,   '2020-09-28');
	 
 --    Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
 SELECT ET.Employee_Name as 'TenNhanVien'
 FROM Employee_Table ET
 JOIN Employee_Skill_Table EST ON ET.Employee_Number = EST.Employee_Number
 WHERE EST.Skill_Code = 'Java';
 -- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT D.Department_Name AS 'Ten phong ban', count(ET.Department_Number) as 'soluong'
FROM Department D 
JOIN Employee_Table ET 
ON D.Department_Number = ET.Department_Number
GROUP BY ET.Department_Number
HAVING count(ET.Department_Number) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban. 
SELECT D.Department_Name as 'TenPhongBan', ET.Employee_Name as 'TenNhanVien' 
FROM Department D
JOIN Employee_Table ET
ON  D.Department_Number = ET.Department_Number;
-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
 SELECT ET.Employee_Name as 'TenNhanVien' , count(EST.Employee_Number) as 'SoSkill'
 FROM Employee_Table ET
 JOIN Employee_Skill_Table EST
 on ET.Employee_Number = EST.Employee_Number
 GROUP BY EST.Employee_Number
 HAVING count(EST.Employee_Number) > 1 