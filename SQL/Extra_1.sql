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
    Gender 			 ENUM ('male','female','unknown')NOT NULL UNIQUE KEY,
    ET_IQ  			 TINYINT UNSIGNED CHECK ( ET_IQ <= 20 ),
    ET_Gmath		 TINYINT UNSIGNED CHECK (ET_Gmath <= 20 ),
    ET_English		 TINYINT UNSIGNED CHECK (ET_English <= 50 ),
    Training_Class	 CHAR(20) NOT NULL UNIQUE KEY,
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