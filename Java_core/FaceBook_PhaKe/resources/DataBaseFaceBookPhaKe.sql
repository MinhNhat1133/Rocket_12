
DROP DATABASE IF EXISTS FacebookPhake;
CREATE DATABASE FacebookPhake;
USE FacebookPhake;
COMMIT;

/*============================== TẠO BẢNG DỮ LIỆU  =============================*/

-- Tao bang 1: User
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`(
	UserId 					SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    UserName	 			NVARCHAR(30) NOT NULL UNIQUE KEY,
    Age						TINYINT	UNSIGNED NOT NULL,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    `PassWord`				VARCHAR(10) NOT NULL	
);

-- Tao bang 2: 
DROP TABLE IF EXISTS `Relationship`;
CREATE TABLE `Relationship`(
	RelationshipID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	UserID1				TINYINT UNSIGNED NOT NULL,				-- UserID1.nguoi gui loi moi ket ban
    UserID2				TINYINT UNSIGNED NOT NULL,				-- UserID2.nguoi nhan loi moi ket ban
    `status`			ENUM('0','1','2','3') NOT NULL DEFAULT ('0'), -- ta mac dinh 0.dangCho,1.chapNhan,2.tuChoi,3.block
    `AddDate`            DATETIME DEFAULT NOW()
);

-- Tao bang 3: `message`
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`(
	MessageID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    UserSeID					VARCHAR(150) NOT NULL , 					-- UserSeID la id cua nguoi gui tn
    UserReID					VARCHAR(150) NOT NULL ,						-- UserReID la id cua nguoi nhan tin nhan
    Content               	 	NVARCHAR(250) NOT NULL,
    MessageDate					DATETIME DEFAULT NOW()
);

/*============================== THÊM DỮ LIỆU VÀO BẢNG =================================*/
/*======================================================================================*/
-- Thêm dữ liệu cho bảng `Account`
INSERT INTO `User`	(	UserName			,	Email							, 	Age		, 	`Password`		)
VALUE 				(	'dangblack'			,'haidang29productions@gmail.com'	,   19		,	'1234567p'		),
					(	'quanganh'			,'account1@gmail.com'				,   16		,	'1234568p'		),
                    (	'vanchien'			,'Account2@gmail.com'				, 	18		,	'1234569p'		),
                    (	'cocoduongqua'		,'account3@gmail.com'				, 	23		,	'1234566p'		),
                    (	'doccocaubai'		,'account4@gmail.com'				, 	24		,	'1234566p'		),
                    (	 'khabanh'			,'dapphatchetngay@gmail.com'		, 	24		,	'1234566p'		),
                    (	'huanhoahong'	    ,'songcodaoly@gmail.com'			, 	30		,	'1234568p'		),
                    (	'tungnui'	        ,'sontungmtp@gmail.com'				, 	23  	,	'1234567p'		),
                    (	'duongghuu'			,'duongghuu@gmail.com'				, 	20		,	'1234566p'		),
                    (	'vtiaccademy'		,'vtiaccademy@gmail.com'			, 	21		,	'1234568p'		),
					(	'quanganh2'			,'accounttest1@gmail.com'			,   16		,	'1234566p'		),
                    (	'vanchien2'			,'accounttest2@gmail.com'			, 	18		,	'1234568p'		),
                    (	'cocoduongqua2'		,'accounttest3@gmail.com'			, 	23		,	'1234566p'		),
                    (	'doccocaubai2'		,'accounttest5@gmail.com'			, 	24		,	'1234566p'		),
                    (	 'khabanh21'		,'dapphatchet4gay12@gmail.com'		, 	24		,	'1234566p'		),
                    (	'huanhoahong2'	    ,'songcodaoly123@gmail.com'			, 	30		,	'1234567p'		),
                    (	'tungnui2'	        ,'sontungmtp213@gmail.com'			, 	23  	,	'1234566p'		),
                    (	'duongghuu2'		,'duongghuu123@gmail.com'			, 	20		,	'1234564p'		),
                    (	'vtiaccademy2'		,'vtiaccademy3126@gmail.com'		, 	21		,	'1234568p'		),
					(	 'Minhnhat12'		,'Minhnhat1234gay12@gmail.com'		, 	24		,	'1234566p'		),
                    (	'Dangkhoa232'	    ,'Khoangao23123@gmail.com'			, 	30		,	'1234567p'		),
                    (	'Vanso12312'	      ,'Vanso23213@gmail.com'			, 	23  	,	'1234566p'		),
                    (	'Quangluan2'		,'QUangLuan2312@gmail.com'			, 	20		,	'1234564p'		),
                    (	'DucThanhmy2'		,'NguyenDuong33126@gmail.com'		, 	21		,	'1234568p'		);	
					



-- Thêm dữ liệu cho bảng `Relationship`
INSERT INTO `Relationship`	(	 UserID1	,	UserID2		,	`status`, `AddDate` )
VALUE 						(	  1			,		2		,		'1'	,'2019-03-05'),
							(     1			,		10		,		'1'	,'2020-03-07'),
							(     2			,		4		,		'1'	,'2020-03-09'),
							(  	  3			,		4		,		'2'	,'2020-03-10'),
							(  	  4			,		5		,		'3'	,'2020-03-28'),
							(	  5			,		6		,		'2'	,'2020-04-06'),
							(	  1			,		12		,		'3'	,'2020-04-07'),
							( 	  1			,		3		,		'1'	,'2020-04-08'),
							( 	  3			,		6		,		'2'	,'2020-04-09'),
							(	  10		,		7		,		'0'	,'2020-04-10'),
							(  	  5			,		1		,		'1'	,'2020-03-10'),
							(  	  9			,		5		,		'0'	,'2020-03-28'),
							(	  13		,		6		,		'1'	,'2020-04-06'),
							(	  1			,		13		,		'1'	,'2020-04-07'),
							( 	  1			,		5		,		'0'	,'2020-04-08'),
							( 	  3			,		1		,		'1'	,'2020-04-09'),
							(	  10		,		3		,		'0'	,'2020-04-10'),
							( 	  15		,		1		,		'1'	,'2020-04-09'),
							(	  5	   		,		11		,		'1'	,'2020-04-10');

-- Thêm dữ liệu cho bảng Group`Account`
INSERT INTO `message`		(  UserSeID	, UserReID	,	Content				, MessageDate)
VALUE 						(	1		,    2		,	'aloooo'			,'2021-03-25'),
							(	1		,    10		,	'Thang rank con nay','2021-05-07'),
							(	2		,    1		,	'ga vcl'			,'2021-03-09'),
							(	2		,    1		,	'tut rank roi'		,'2021-03-10'),
							(	5		,    11		,	'khong ranh'		,'2021-03-28'),
							(	1		,    3		,	'aloooooooo'		,'2021-02-27'),
							(	1		,    5		,	'Tetsing122445'		,'2021-04-07'),
							(	5		,    1		,	'guitinnahn111'		,'2021-04-18'),
							(	1		,    9		,	'chao ban '			,'2021-04-29'),
							(	3		,    4		,	'gay len em'		,'2021-05-12');


