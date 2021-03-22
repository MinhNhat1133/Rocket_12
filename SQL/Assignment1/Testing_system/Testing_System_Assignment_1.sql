-- Tạo database,
DROP DATABASE IF EXISTS Testingsystem1;
CREATE DATABASE Testingsystem1;
USE Testingsystem1;
-- Tạo bảng 
DROP TABLE IF EXISTS Department ;
CREATE TABLE Department (
    DepartmentID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName		NVARCHAR(30) NOT NULL UNIQUE KEY CHECK (length(DepartmentName)>=4)
);
DROP TABLE IF EXISTS `position` ;
CREATE TABLE `position` (
	PositionID 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY , 
    PositionName 	ENUM('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE KEY
); 
DROP TABLE IF EXISTS `Account` ;
CREATE TABLE  `Account` (
	AccountID				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) UNIQUE KEY DEFAULT('Unknown'),
    Email					VARCHAR(50) UNIQUE KEY DEFAULT('Unknown'), 
    Username				NVARCHAR(50) NOT NULL CHECK (length(Username)>=3),
    FullName				NVARCHAR(50) NOT NULL,
    DepartmentID			SMALLINT UNSIGNED NOT NULL,
    PositionID				SMALLINT UNSIGNED NOT NULL,
    CreateDate    			DATETIME NOT NULL ,
    CreateDate    			DATETIME  NOT NULL,
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
    FOREIGN KEY (PositionID)	REFERENCES `position`(PositionID)
);
DROP TABLE IF EXISTS `Group`  ;
CREATE TABLE `Group` (
	GroupID 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    GroupName 		NVARCHAR(50) NOT NULL UNIQUE KEY CHECK (length(GroupName)>=3),
    CreatorID		SMALLINT UNSIGNED NOT NULL,
    CreateDate		DATETIME NOT NULL ,
    FOREIGN KEY (CreatorID)	REFERENCES `Account`(AccountID)
);
DROP TABLE IF EXISTS GroupAccount ;
CREATE TABLE GroupAccount (
	GroupID 		SMALLINT UNSIGNED NOT NULL,
    AccountID 		SMALLINT NOT NULL   ,
    JoinDate		DATETIME NOT NULL ,
    JoinDate		DATETIME  NOT NULL,
    PRIMARY KEY (GroupID,AccountID),
    FOREIGN KEY (GroupID)	REFERENCES `Group`(GroupID)
);
DROP TABLE IF EXISTS TypeQuestion ;
CREATE TABLE TypeQuestion (
	TypeID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    TypeName	ENUM('Essay','Multiple-choice') NOT NULL UNIQUE KEY 
);
DROP TABLE IF EXISTS CategoryQuestion ;
CREATE TABLE CategoryQuestion (
	CategoryID 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    CategoryName 	NVARCHAR(30) NOT NULL UNIQUE KEY 
);
DROP TABLE IF EXISTS Question ;
CREATE TABLE Question (
	QuestionID 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content 		NVARCHAR(100) NOT NULL,
    CategoryID		SMALLINT UNSIGNED NOT NULL ,
    TypeID		 	SMALLINT UNSIGNED NOT NULL,
    CreatorID		SMALLINT UNSIGNED NOT NULL ,
    CreateDate		DATETIME NOT NULL,
    CreateDate		DATETIME  NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (TypeID) 	 REFERENCES TypeQuestion (TypeID),
    FOREIGN KEY (CreatorID)  REFERENCES `Account` (AccountID)
);
DROP TABLE IF EXISTS Answer ;
CREATE TABLE Answer (
	AnswerID 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content 		VARCHAR(100) NOT NULL,
    QuestionID		SMALLINT UNSIGNED NOT NULL,
    isCorrect		ENUM('T','F'),
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);
DROP TABLE IF EXISTS Exam ;
CREATE TABLE Exam (
	 ExamID			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` 			CHAR(20) NOT NULL ,
    Title			NVARCHAR(50) NOT NULL ,
    CategoryID		SMALLINT UNSIGNED NOT NULL,
    Duration		SMALLINT UNSIGNED NOT NULL,
    CreatorID		SMALLINT UNSIGNED NOT NULL,
    CreateDate		DATETIME NOT NULL,
    CreateDate		DATETIME  NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES `Account` (AccountID)
);
DROP TABLE IF EXISTS ExamQuestion ;
CREATE TABLE ExamQuestion (
	ExamID 			SMALLINT UNSIGNED NOT NULL,
    QuestionID 		SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY (ExamID,QuestionID),
    FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);
-- insert dữ liệu vào bảng 
-- Lenh :" insert into Ten_Bang (TenCot_1,TenCot_2,..TenCot_n) 
-- VALUES ('DuLieu_1'<Là dữ liệu đc đưa vào TenCot_1 >,'DuLieu_2',...DuLieu_n)
INSERT INTO Department	(DepartmentName)
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


INSERT INTO `Position` (PositionName)
VALUES
						('Dev'			),
						('Test'			),
						('Scrum Master'	),
						('PM'			);


INSERT INTO `Account` 	(Email						, Username		, FullName						, DepartmentID		, PositionID	, CreateDate)
VALUES			
						('MinhNhat12pv@gmail.com'	, 'Tòng'		, 'Tòng Minh Nhật'				, 		3			, 		3		, '2021-3-15' ),
						('DangKhoa@gmail.com'		, 'Tran'		, 'Trần Đăng Khoa'				, 		2			, 		4		, '2021-3-18' ),
						('NguyenGiang@gmail.com'	, 'Nguyễn'		, 'Nguyễn Hữu Đa'				, 		4			, 		1		, '2021-2-15' ),
                        ('Test1111@gmail.com'		, 'Quang'		, 'Quang Thi Xao'				, 		1			, 		3		, '2021-2-16' ),
						('ThanhdatGamer@gmail.com'	, 'Tran'		, 'Trần Thành Đạt'				, 		7			, 		1		, '2021-3-17' ),
						('NguyenMinh@gmail.com'		, 'Nguyen'		, 'Nguyen Dang Minh'			, 		5			, 		2		, '2021-2-15' ),
                        ('AduDarkwa@gmail.com'		, 'Bùi'			, 'Bui Minh Chau'				, 		9			, 		3		, '2021-2-19' ),
						('Yassuo@gmail.com'			, 'Ngo'			, 'Ngo Van Huy'					, 		6			, 		1		, '2021-3-20' ),
						('GenShinImpact@gmail.com'	, 'WiBu'		, 'WibuLỏd'						, 		10			, 		2		, '2021-3-15' ),
						('DeadNote@gmail.com'		, 'Nguyen'		, 'Nguyen Thao My'				, 		8			, 		1		, '2021-4-17' );	
 
 

INSERT INTO `Group`		(  GroupName					, CreatorID			, CreateDate)
VALUES 				
						(N'MainYasuoClub'				,   3				,'2021-03-17'),
						(N'Don 4 Get me'				,   2				,'2021-06-07'),
						(N'VTI Dev'						,   4				,'2019-09-25'),
						(N'GoodBoys'					,   1				,'2021-04-15'),
						(N'BadBoys'						,   7				,'2019-08-28'),
						(N'PhacBoys'					,   5				,'2020-12-06'),
						(N'Thieu Muoi Boys'				,   9				,'2021-07-07'),
						(N'MainZoe'						,   6				,'2021-03-17'),
						(N'WibuClub'					,   10				,'2021-03-15'),
						(N'LoliClub'					,   8				,'2020-09-28');



INSERT INTO GroupAccount	(  GroupID		, 	AccountID		, 	 JoinDate	 )
VALUES 						
							(	 1			, 	   1			,	'2021-02-14'),
							(	 2			, 	   2			,	'2021-03-17'),
							(	 3			, 	   3			,	'2020-12-17'),
							(	 3			, 	   4			,	'2019-11-10'),
							(	 4			, 	   5			,	'2021-01-28'),
							(	 5			, 	   6			,	'2021-04-20'),
							(	 6			, 	   7			,	'2019-05-07'),
							( 	10			, 	   8			,	'2020-12-18'),
							(	 8			,	   9			,	'2021-03-10'),
                            (	 8			,	   10			,	'2021-03-10'),
							(	 9			, 	   10			,	'2021-02-23');



INSERT INTO TypeQuestion	(TypeName	) 
VALUES 						
							('Essay'		  ), 
							('Multiple-Choice'); 


INSERT INTO CategoryQuestion (CategoryName		)
VALUES 						('Java'				),
							('VB.NET'			),
							('.NET'				),
							('SQL'				),
							('Postman'			),
							('Ruby'				),
							('PHP'				),
							('Python'			),
							('Shell'			),
							('Objective-C'		),
                            ('C++'				);
													

INSERT INTO Question	(Content					, CategoryID	,  TypeID	, CreatorID	, CreateDate )
VALUES 					
						(N'Khái niệm về java'		,	 3			,    2		,   1		,'2021-03-15'),
						(N'VB.NET là gì'			,	 4			,    2		,   2		,'2020-10-23'),
						(N'Trình bày về SQL'		,	 6			,    2		,   2		,'2019-12-19'),
						(N'Khái Niệm Postman'		,	 2			,    2		,   4		,'2021-03-16'),
						(N'Đặc điểm của JavaScrip'	,	 8			,    1		,   3		,'2021-03-15'),
						(N'Khái Niệm về Python'		,	 9			,    1		,   5		,'2021-03-15'),
						(N'Trình bày về Shell'		,	 1			,    2		,   6		,'2019-12-19'),
						(N'Nói về Objective-C'		,	 9			,    1		,   7		,'2021-03-16'),
						(N'trình bày về Ruby'		,	 7			,    1		,   10		,'2021-03-15'),
						(N'Trình bày về C++'		,	 2			,    2		,   9		,'2021-03-07'),
						(N'Trình bày về php'		,    1			,    1		,   8		,'2020-10-23');


INSERT INTO Answer		(  Content	, QuestionID , isCorrect	)
VALUES 		
						(N'Answer1'	,    1		 ,	'T'		),
						(N'Answer2'	,    2		 ,	'F'		),
						(N'Answer3'	,    3		 ,	'T'		),
						(N'Answer4'	,    4		 ,	'T'		),
						(N'Answer5'	,    5		 ,	'F'		),
						(N'Answer6'	,    6		 ,	'F'		),
						(N'Answer7'	,    7		 ,	'T'		),
						(N'Answer8'	,    8		 ,	'T'		),
						(N'Answer9'	,    9		 ,	'T'		),
						(N'Answer10',    10		 ,	'F'		),
						(N'Answer11',    11		 ,	'T'		);

INSERT INTO Exam	(`Code`			, Title						, CategoryID	, Duration		, CreatorID		, CreateDate )
VALUES 			
					(N'MADETHI1'		, N'Thi về Java'			,	1		,45				,   1			,'2021-03-15'),
					(N'MADETHI2'		, N'Thi về VB.NET'			,	2		,45				,   2			,'2021-03-15'),
                    (N'MADETHI3'		, N'Thi về SQL'				,	3		,60				,   3			,'2021-03-17'),
                    (N'MADETHI4'		, N'Thi về JavaScrip'		,	4		,60				,   4			,'2021-04-08'),
                    (N'MADETHI5'		, N'Thi về Python'			,	5		,45				,   4			,'2020-12-07'),
                    (N'MADETHI6'		, N'Thi về Shell'			,	6		,90				,   6			,'2021-03-17'),
                    (N'MADETHI7'		, N'Thi về C++'				,	7		,45				,   7			,'2021-03-17'),
                    (N'MADETHI8'		, N'Thi về C#'				,	8		,90				,   9			,'2020-12-25'),
                    (N'MADETHI9'		, N'Thi về Objective-C'		,	9		,120			,   9			,'2021-03-15'),
                    (N'MADETHI10'		, N'Thi về PHP'				,	10		,45				,   8			,'2020-12-25'),
					(N'MADETHI11'		, N'Thi về Ruby'			,	11		,120			,   10			,'2021-03-14');

                    
INSERT INTO 	ExamQuestion	(ExamID	,QuestionID	) 
VALUES 			
								(	1	,	2		),
								(	2	,	3		), 
								(	3	,	4		), 
								(	4	,	7		), 
								(	5	,	8		), 
								(	6	,	9		), 
								(	7	,	1		), 
								(	8	,	10		), 
								(	9	,	11		), 
								(	10	,	6		), 
								(	11	,	5		);                        

