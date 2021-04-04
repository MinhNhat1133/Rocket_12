-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
USE testingsystem;
DELIMITER $$
DROP PROCEDURE IF EXISTS Select_AOD;
CREATE PROCEDURE Select_AOD(IN Department_Name NVARCHAR(100))
BEGIN
	SELECT 		A.Email, A.Username,A.FullName,A.PositionID, A.CreateDate 
    FROM		Department D 
	JOIN 		`Account` A ON D.DepartmentID = A.DepartmentID
    WHERE		DepartmentName = Department_Name;

END$$
DELIMITER ;
Call sp_accountOfDepartment('Marketing');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS SoAccountTrongMoigroup;
DELIMITER $$
CREATE PROCEDURE SoAccountTrongMoigroup(IN Group_no INT UNSIGNED)
BEGIN

	SELECT 		GroupID, COUNT(AccountID) as total
    FROM		GroupAccount 
    WHERE		GroupID = group_no
    GROUP BY	GroupID;
	
END$$
DELIMITER ;
Call SoAccountTrongMoigroup(3);

-- Question 3: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
USE testingsystem;
DELIMITER $$
DROP PROCEDURE IF EXISTS Total_Tq_of_Month;
CREATE PROCEDURE Total_Tq_of_Month()
BEGIN
	SELECT 		count(TypeID) as 'total'
    FROM		Question
	WHERE	MONTH(CreateDate) = Month(NOW())
END$$
DELIMITER ;
Call Total_Tq_of_Month();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
USE testingsystem;
DELIMITER $$
DROP PROCEDURE IF EXISTS Max_TypeQ;
CREATE PROCEDURE Max_TypeQ()
BEGIN
	WITH Count_TypeID AS(
		SELECT		COUNT(TypeID) as 'coun'
		FROM		Question 
		GROUP BY	TypeID
    )
	SELECT 		TypeID
    FROM		Question
    group by	 TypeID
    Having		count(TypeID) = (Select max(coun) FROM Count_TypeID ) ;
	
END$$
DELIMITER ;
Call Max_TypeQ();
-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
USE testingsystem;
DELIMITER $$
DROP PROCEDURE IF EXISTS N_Max_TypeQ;
CREATE PROCEDURE N_Max_TypeQ()
BEGIN
	WITH Count_TypeID AS(
		SELECT		COUNT(TypeID) as 'coun'
		FROM		Question 
		GROUP BY	TypeID
    )
	SELECT 		TQ.TypeName
    FROM		typequestion TQ JOIN Question Q ON TQ.typeID = Q.TypeID
    group by	 Q.TypeID
    Having		count(Q.TypeID) = (Select max(coun) FROM Count_TypeID ) ;
	
END$$
DELIMITER ;
call N_Max_TypeQ ();
-- Question 6
DROP PROCEDURE IF EXISTS N_Group_User ;
DELIMITER $$
CREATE PROCEDURE N_Group_User
(IN	n_group VARCHAR(50), IN in_select VARCHAR(50))
BEGIN
	
END$$
DELIMITER -- ???????????
-- Question 7: 
-- ??????????? 

-- Question8
USE testingsystem;
DROP PROCEDURE IF EXISTS MaxContent ;
DELIMITER $$
CREATE PROCEDURE MaxContent  (IN Type_Name ENUM ('Essay','Multiple-choice'))
BEGIN
IF (Type_Name='Essay') THEN 
SELECT Content,max((char_length(Content))) as 'total' 
FROM testingsystem.question where typeID = 1 ;
else 
SELECT Content,max((char_length(content))) as 'total'
FROM testingsystem.question WHERE TypeID =2 ;

END IF;
END $$
CALL Maxcontent ('Multiple-choice')$$
CALL Maxcontent('Essay');

-- question 9 
 USE testingsystem;
 DROP PROCEDURE IF EXISTS DELETE_Exam;
 DELIMITER $$
CREATE PROCEDURE DELETE_Exam (IN Exam_ID INT UNSIGNED)
BEGIN
	DELETE 
    FROM Exam 
    WHERE ExamID = Exam_ID;
 
END$$
DELIMITER $$
CALL DELETE_Exam(2)

-- Question 10 ??????????
-- Question 11 ??????????
-- Question 12 : Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
USE testingsystem;
DROP PROCEDURE IF EXISTS count_month;
DELIMITER $$
CREATE PROCEDURE count_month()
BEGIN
		SELECT C_Thang.month, COUNT(QuestionID) AS 'total_Question'
		FROM
		(	SELECT 1 AS MONTH
             UNION SELECT 2 AS MONTH
             UNION SELECT 3 AS MONTH
             UNION SELECT 4 AS MONTH
             UNION SELECT 5 AS MONTH
             UNION SELECT 6 AS MONTH
             UNION SELECT 7 AS MONTH
             UNION SELECT 8 AS MONTH
             UNION SELECT 9 AS MONTH
             UNION SELECT 10 AS MONTH
             UNION SELECT 11 AS MONTH
             UNION SELECT 12 AS MONTH ) AS C_Thang
		LEFT JOIN Question ON C_Thang.MONTH = MONTH(CreateDate)
		GROUP BY C_Thang.MONTH
		ORDER BY C_Thang.MONTH ;
END$$
DELIMITER $$
CALL count_month ();


-- cau 13