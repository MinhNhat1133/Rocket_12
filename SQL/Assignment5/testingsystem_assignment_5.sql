-- Testing System Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo  trước 1 năm trước
USE testingsystem;
DROP TRIGGER IF EXISTS trigger_creat_group_time;
DELIMiTER $$
CREATE TRIGGER trigger_creat_group_time 
BEFORE INSERT ON testingsystem.`group` 
FOR EACH ROW
BEGIN 
	IF NEW.CreateDate < date_sub(now(),interval 1 year ) 
    then SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'không thể nhập vào Group có ngày tạo  trước 1 năm trước';
    END IF;
END $$
DELIMiTER $$
-- use
INSERT INTO testingsystem.`group` 	(groupname ,CreatorID , CreateDate)
VALUES								('abcvf'	,1		   ,'2020-02-20')

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"
USE testingsystem;
DROP TRIGGER IF EXISTS trigger_insert_department;
DELIMiTER $$
CREATE TRIGGER trigger_insert_department  
BEFORE INSERT ON testingsystem.`Account` 
FOR EACH ROW
BEGIN
    IF NEW.DepartmentID = 2 Then
	SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END $$
DELIMiTER $$
-- use 
INSERT INTO testingsystem.`Account` 	(Email						, Username		, FullName						, DepartmentID		, PositionID	, CreateDate)
VALUES			
										('Dangkhoa112pv@gmail.com'	, 'Chau'		, 'Nguyen Dang khoa'			, 		2			, 		3		,NULL  )
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
CREATE view MaxAccounnt AS(
		SELECT		groupID
		FROM		groupaccount
		GROUP BY     groupID
        having 		COUNT(GroupID) >= 5 )
        
USE testingsystem;
DROP TRIGGER IF EXISTS trigger_group;
DELIMiTER $$
CREATE TRIGGER trigger_insert_department  
BEFORE INSERT ON testingsystem.`account`
FOR EACH ROW
BEGIN
 IF NEW.groupID = MaxAccounnt then 
	SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'Group is full, please choose in another group';
    END IF;
END $$ 
DELIMiTER $$                                    
                                        