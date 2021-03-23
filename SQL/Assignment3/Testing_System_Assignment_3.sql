-- ==============Exercise 1: Tiếp tục với Database Testing System

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
DROP VIEW IF EXISTS testingsystem.DanhSachNV_Sale;
CREATE VIEW testingsystem.DanhSachNV_sale AS
SELECT A.*,D.DepartmentName
FROM testingsystem.`account` A 
JOIN testingsystem.department D
ON A.DepartmentID  = D.DepartmentID 
WHERE D.DepartmentName = 'sale';
SELECT * FROM  testingsystem.DanhSachNV_Sale;
 
 -- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
 DROP VIEW IF EXISTS testingsystem.Ac_ThamGiaNHieuGroupNhat;
CREATE VIEW testingsystem.Ac_ThamGiaNHieuGroupNhat AS
SELECT A.*,count(GA.AccountID) as Tong_Group_Tham_gia
FROM  testingsystem.`account` A 
JOIN  testingsystem.groupaccount GA
ON  A.AccountID = GA.AccountID 
GROUP BY GA.AccountID 
HAVING count(GA.AccountID ) =
 (SELECT max(total) as 'max' 
 FROM (SELECT count(AccountID) as total FROM testingsystem.groupaccount 
 GROUP BY AccountID  ) AS AB);
SELECT * FROM  testingsystem.Ac_ThamGiaNHieuGroupNhat;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài
DROP VIEW IF EXISTS testingsystem.Questions_co_Content_qua_dai;
CREATE VIEW testingsystem.Questions_co_Content_qua_dai AS
SELECT * FROM testingsystem.question
WHERE char_length(content) >= 30 ;
SELECT * FROM  testingsystem.Questions_co_Content_qua_dai;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS testingsystem.PhongBanCoNhieu_Nv_Nhat;
CREATE VIEW testingsystem.PhongBanCoNhieu_Nv_Nhat AS
SELECT D.*,count(A.DepartmentID) as 'TongNV'
FROM testingsystem.department D
JOIN testingsystem.`account` A
ON D.DepartmentID  = A.DepartmentID 
GROUP BY A.DepartmentID
HAVING count(A.DepartmentID) = (SELECT max(Total) as "max" 
from (SELECT count(DepartmentID) as total FROM `Account` GROUP BY DepartmentID ) as ST );
SELECT * FROM  testingsystem.PhongBanCoNhieu_Nv_Nhat;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
DROP VIEW IF EXISTS testingsystem.CH_cua_user_ho_Nguyen;
CREATE VIEW testingsystem.CH_cua_user_ho_Nguyen as
SELECT Q.*, A.FullName 
FROM testingsystem.question Q
JOIN testingsystem.`account` A
 ON Q.CreatorID = A.AccountID
WHERE A.FullName like 'Nguyen%';
SELECT * FROM testingsystem.CH_cua_user_ho_Nguyen;
