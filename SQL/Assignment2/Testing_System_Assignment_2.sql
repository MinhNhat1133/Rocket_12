-- Question 1: lấy ra tất cả các phòng ban
SELECT * 
FROM testingsystem.Department 
ORDER BY  DepartmentID;

-- Question 2: lấy ra id của phòng ban có tên là "Sale"
SELECT DepartmentID 
FROM testingsystem.Department 
WHERE DepartmentName = 'sale' ;

-- Question 3: lấy ra thông tin account có full name dài nhất
SELECT * 
FROM testingsystem.`Account` 
WHERE length(FullName) = (SELECT max(char_length(fullname)) FROM testingsystem.`account` );

-- Question 4: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT GroupName 
FROM testingsystem.`group`
WHERE CreateDate <  '2019-12-20'
;
-- Questtion 5: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID,count(QuestionID) As 'số lượng câu trả lời'
FROM testingsystem.answer 
GROUP BY QuestionID
HAVING count(QuestionID) >=4 ;

-- Question 6: Lấy ra 5 group được tạo gần đây nhất
SELECT GroupName,CreateDate 
FROM testingsystem.`group`
ORDER BY CreateDate 
DESC LIMIT 5 ;

-- Question 8: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE  FROM testingsystem.exam
WHERE CreateDate < '2019-12-20';

-- Question 9: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và 
-- email thành loc.nguyenba@vti.com.vn
UPDATE `account` 
SET fullname = 'Nguyễn Bá Lộc',
	Email = 'loc.nguyenba@vti.com.vn'
WHERE AccountID = 5;
    
-- Question 10: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban 
SELECT 	 	A.AccountID, A.Email, A.Username, A.fullname, A.PositionID, A.CreateDate, D.DepartmentID, D.departmentname
FROM 		testingsystem.`Account` A
JOIN 		testingsystem.Department D	
ON 			A.DepartmentID = D.DepartmentID; 

-- Question 11: Viết lệnh để lấy ra tất cả các developer
SELECT 	  	A.AccountID, A.Email, A.Username, A.fullname, A.CreateDate, A.PositionID, P.PositionName
FROM 		testingsystem.`Account` A
JOIN 		testingsystem.`Position` P	
ON 			A.positionID = P.positionID 
WHERE 		positionName = 'dev' ; 

-- Question 12: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 	    D.DepartmentName,count(A.departmentID) AS 'Số lượng nhân viên'
FROM 		testingsystem.Department D
JOIN 		testingsystem.`Account` A	
ON 			D.DepartmentID = A.DepartmentID 
GROUP BY	A.departmentID
HAVING 		count(A.departmentID) > 3 ; 

-- Question 13: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 	    Q.questionID, Q.content,Q.categoryID,Q.TypeID, Q.CreateDate, count(EQ.questionID) AS 'SoLuongCauHoiDuocDung'
FROM 		testingsystem.Question Q 
JOIN 		testingsystem.ExamQuestion EQ	
ON 			Q.QuestionID = EQ.QuestionID 
GROUP BY	EQ.QuestionID
HAVING 		count(EQ.questionID) = (SELECT MAX(A) AS  'MaxQuestion'
FROM (SELECT COUNT(QuestionID) AS A
FROM 		testingsystem.ExamQuestion   
GROUP BY	QuestionID) AS Soluong );

-- Question 14: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT 	    C.CategoryID, C.CategoryName, count(Q.CategoryID) AS 'SoLuongDuocDung'
FROM 		testingsystem.Categoryquestion C 
JOIN 		testingsystem.Question Q	
ON 			C.CategoryID = Q.CategoryID 
GROUP BY	Q.CategoryID;
-- Question 15: Lấy ra Question có nhiều câu trả lời nhất
SELECT 	    Q.questionID, Q.content,Q.categoryID,Q.TypeID, Q.CreateDate, count(A.questionID) AS 'SoLuongCauTraLoi'
FROM 		testingsystem.Question Q 
JOIN 		testingsystem.Answer A	
ON 			Q.QuestionID = A.QuestionID 
GROUP BY	A.QuestionID
HAVING 		count(A.questionID) = (SELECT MAX(A) AS  'MaxAnswer'
FROM (SELECT COUNT(QuestionID) AS A
FROM 		testingsystem.answer   
GROUP BY	QuestionID) AS Soluong );

-- Question 16: Tìm chức vụ có ít người nhất
SELECT  P.positionID, P.PositionName, count(A.positionID) as 'SốNgười'
FROM testingsystem.`position` P
JOIN testingsystem.`account`  A on P.PositionID= A.PositionID
GROUP BY A.PositionID
HAVING 		COUNT(A.PositionID) = (SELECT Min(A) AS  'Minposition'
FROM (SELECT COUNT(PositionID) AS A
FROM 	 	testingsystem.`account`   
GROUP BY	PositionID) AS Soluong );
-- Question 17: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM 
	SELECT 
    b.DepartmentName,
	c.PositionName,
	count(*) AS total 
FROM 
	testingsystem.`Account` a 
	LEFT JOIN testingsystem.Department b ON a.DepartmentID = b.DepartmentID
	LEFT JOIN testingsystem.Position c ON a.PositionID = c.PositionID
GROUP BY
	b.DepartmentName,
	c.PositionName
ORDER BY 
b.DepartmentName,
	c.PositionName;

--  Question 18: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT 		AC.AccountID as 'ID NguoiTaoCauHoi',AC.FullName as 'TenNguoiTaoCauHoi', Q.QuestionID AS 'ID CauHoi', Q.Content AS 'NoiDungCauHoi', T.TypeName AS 'LoaiCauHoi', A.Content AS 'CauTraLoi', Q.CreateDate AS 'NgayTaoCauHoi'
FROM		testingsystem.question Q 
JOIN 		testingsystem.`account` AC ON	Q.CreatorID = AC.AccountID
JOIN		testingsystem.typequestion T ON Q.TypeID = T.TypeID
JOIN		testingsystem.answer A ON Q.QuestionID = A.QuestionID; 

-- Question 19: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT T.TypeName as 'LoaiCauHoi', COUNT(T.TypeID) as 'SoLuong' 
FROM testingsystem.typequestion T
JOIN testingsystem.question Q ON T.TypeID = Q.TypeID
GROUP BY Q.TypeID ;



