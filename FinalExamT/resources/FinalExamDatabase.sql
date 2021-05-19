-- create database
DROP DATABASE IF EXISTS FinalExam;
CREATE DATABASE FinalExam;
USE FinalExam;

-- create table: User
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` ( 	
	UserId 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`email` 		CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
	`fullName` 		NVARCHAR(50) NOT NULL,
    ProjectID		SMALLINT UNSIGNED,
    ProSkill		ENUM('Dev','Test','Sql','Java') 
);

-- create table: Manager
DROP TABLE IF EXISTS 	`Manager`;
CREATE TABLE IF NOT EXISTS `Manager` ( 	
	ManagerId 				SMALLINT UNSIGNED NOT NULL,
	`expInYear` 	SMALLINT UNSIGNED NOT NULL
);

-- create table: Project
DROP TABLE IF EXISTS 	Project;
CREATE TABLE IF NOT EXISTS Project ( 	
	ProjectID 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	teamSize	 	SMALLINT UNSIGNED,
	ManagerID		SMALLINT UNSIGNED
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data User
INSERT INTO `User` 	(`email`,						`password`,		`fullName`				,ProjectID	,ProSkill)
VALUE				('hanhhanoi1999@vti.com.vn',		'123456A',		'Tong Minh Nhat'	,	   5	,NULL), 
					('hung122112@vti.com.vn',			'123456A',		'Nguyen Thanh Hung'	,	   3	,'Test'), 
					('cananh.tuan12@vti.com.vn',		'123456A',		'Cao tuan anh'		,	   5	,'Dev' ), 
					('toananh123@vti.com.vn',			'123456A',		'Nguyen Huu Tai'	,	   5	,NULL  ), 
					('duynguyen123@vti.com.vn',			'123456A',		'Nguyen Duy'		,		1	,'Dev' ), 
					('manhhung123@vti.com.vn',			'123456A',		'Nguyen Manh Hung'	,		1	,'Dev' ),
					('maianhng@gmail.com.vn', 			'123456A',		'Nguyen Mai Anh'	,		1	,NULL  ),
					('tuan1234@gmail.com.vn', 			'123456A',		'Nguyen Văn Tuan'	,		2	 ,NULL ),
					('thuyhanoi@gmail.com.vn', 			'123456A',		'Nguyrn Thi Thuy'	,		2	,'Dev' ),
					('quanganh@gmail.com.vn', 			'123456A',		'Nguyen Quang Anh'	,		1	,'Test'),
					('hunghoang@gmail.com.vn', 			'123456A',  	'Vu Hoàng Hung'		,		3	,NULL  ),
					('quocanh12@gmail.com.vn', 			'123456A',		'Nguyen Quoc Anh'	,		1	,'sql' ),
					('vananhb1@gmail.com.vn', 			'123456A',		'Nguyen Van Anh'	,		2	,NULL  ),
					('trinh123@gmail.com.vn', 			'123456A',		'Nguyen Thi Trinh'	,		3	,'Dev' ),
					('tuanhung@gmail.com.vn', 			'123456A',		'Vũ Tuan Hung'		,		3	,'Dev' ),
					('xuanmai12@gmail.com.vn', 			'123456A',		'Nguyen Xuan Mai'	,		2	,'Dev' ),
					('hungnguyen@gmail.com.vn', 		'123456A',		'Pham Quang Hung'	,		3	,'Dev' );

-- Add data Manager
INSERT INTO Manager (ManagerId,	`expInYear`	)
VALUE				(1,			5		), 
					(4,			1		), 
					(8,			2		), 
					(7,			3		), 
					(9,			5		), 
					(11,		7		), 
					(13,		8		);
                        
-- Add data Project
INSERT INTO Project 	(teamSize	,ManagerID)
VALUE					(	2		,	1	 ), 
						(	4		,	4	 ), 
						(	6		,	8	 ), 
						(	8		, 	13	 ), 
						(	10		,	7	 );
                        