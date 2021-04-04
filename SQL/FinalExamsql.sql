DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;
DROP TABLE IF EXISTS Country;
CREATE TABLE thuctap.Country (
	countryID SMALLINT UNSIGNED PRIMARY KEY,
	CountryName VARCHAR(50)
);
insert into country (countryID, CountryName) values (1, 'Greece');
insert into country (countryID, CountryName) values (2, 'Lithuania');
insert into country (countryID, CountryName) values (3, 'Indonesia');
insert into country (countryID, CountryName) values (4, 'malaysia');
insert into country (countryID, CountryName) values (5, 'China');
insert into country (countryID, CountryName) values (6, 'Solomon Islands');
insert into country (countryID, CountryName) values (7, 'Mongolia');
insert into country (countryID, CountryName) values (8, 'congo');
insert into country (countryID, CountryName) values (9, 'VietNam');
insert into country (countryID, CountryName) values (10, 'Argentina');
insert into country (countryID, CountryName) values (11, 'Portugal');
insert into country (countryID, CountryName) values (12, 'Indonesia');

DROP TABLE IF EXISTS location;
create table location (
	LocationID SMALLINT UNSIGNED PRIMARY KEY,
	StreetAddress VARCHAR(50),
	PostalCode VARCHAR(50),
	CountryID SMALLINT
);
insert into location (locationID, StreetAddress, PostalCode, CountryID) values (1, '8 Aberg Plaza', '4535-160', 1);
insert into location (locationID, StreetAddress, PostalCode, CountryID) values (2, '2841 Anderson Parkway', '188919', 2);
insert into location (locationID, StreetAddress, PostalCode, CountryID) values (3, '1954 Clarendon Avenue', null, 3);
insert into location (locationID, StreetAddress, PostalCode, CountryID) values (4, '32947 Autumn Leaf Terrace', '59600-000', 4);
insert into location (locationID, StreetAddress, PostalCode, CountryID) values (5, '224 Anzinger Point', null, 5);
insert into location (locationID, StreetAddress, PostalCode, CountryID) values (6, '30 Mcguire Lane', null, 6);
insert into location (locationID, StreetAddress, PostalCode, CountryID) values (7, '3437 Bartelt Point', null, 7);
insert into location (locationID, StreetAddress, PostalCode, CountryID) values (8, '68 Comanche Way', '46-220', 8);
insert into location (locationID, StreetAddress, PostalCode, CountryID) values (9, '806 Pierstorff Court', '270009', 9);
insert into location (locationID, StreetAddress, PostalCode, CountryID) values (10, '5 Mariners Cove Road', null, 10);

DROP TABLE IF EXISTS Employee;
create table Employee (
	Employee_ID SMALLINT UNSIGNED PRIMARY KEY,
	FullName VARCHAR(50) UNIQUE KEY,
	Email VARCHAR(50) UNIQUE KEY,
	Location_ID SMALLINT
);
insert into Employee (employee_ID, fullname, email, location_ID) values (1, 'Amargo Self', 'aself0@cpanel.net', 1);
insert into Employee (employee_ID, fullname, email, location_ID) values (2, 'Orran Sarre', 'osarre1@hostgator.com', 2);
insert into Employee (employee_ID, fullname, email, location_ID) values (3, 'Blaire Occleshaw', 'nn03@gmail.com', 3);
insert into Employee (employee_ID, fullname, email, location_ID) values (4, 'Jilleen Pobjay', 'jpobjay3@hp.com', 4);
insert into Employee (employee_ID, fullname, email, location_ID) values (5, 'Kelley Boman', 'kboman4@google.fr', 5);
insert into Employee (employee_ID, fullname, email, location_ID) values (6, 'Dory Imm', 'dimm5@theguardian.com', 6);
insert into Employee (employee_ID, fullname, email, location_ID) values (7, 'Kathi Bonett', 'kbonett6@dot.gov', 7);
insert into Employee (employee_ID, fullname, email, location_ID) values (8, 'Vittoria Moses', 'vmoses7@naver.com', 8);
insert into Employee (employee_ID, fullname, email, location_ID) values (9, 'Casey Bogays', 'cbogays8@feedburner.com', 9);
insert into Employee (employee_ID, fullname, email, location_ID) values (10, 'Dara Feares', 'dfeares9@eepurl.com', 9);

-- cau 2 :
-- lay tat ca cac nhan vien thuoc viet nam
DROP VIEW IF EXISTS locationID_of_Vn;
CREATE VIEW locationID_of_Vn AS 
(SELECT L.locationID 
FROM Location L JOIN
country C ON L.countryID = C.countryID 
WHERE C.countryname = 'VietNam' );
SELECT * FROM employee WHERE location_ID IN (SELECT * FROM locationID_of_Vn);
-- lay ra ten quoc gia cua employee co email la "nn03@gmail.com"
DROP VIEW IF EXISTS countryID_of_e;
CREATE VIEW countryID_of_e AS 
(SELECT L.countryID 
FROM Location L JOIN
Employee E ON L.locationID = E.location_ID 
WHERE E.Email = 'nn03@gmail.com' );
SELECT CountryName FROM country WHERE CountryID IN (SELECT * FROM countryID_of_e);
-- Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc.
SELECT C.CountryName,L.StreetAddress,count(E.location_ID) as 'total_Employees' 
FROM Employee E JOIN location L on E.location_ID = L.locationID
JOIN country C on c.countryID = L.countryID
GROUP BY E.location_ID;
-- Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
DROP TRIGGER IF EXISTS Max_e;
DELIMiTER $$
CREATE TRIGGER Max_e
BEFORE INSERT ON thuctap.employee
FOR EACH ROW
BEGIN 
	IF NEW.location_ID IN (SELECT location_ID
					    FROM Employee
					    GROUP BY location_ID
                        HAVING COUNT(location_ID) = 10 ) THEN
	SIGNAL SQLSTATE '12345' 
	SET MESSAGE_TEXT = 'THIS COUNTRY CAN NOT BE ADDED MORE THAN 10 EMPLOYEE';
    END IF;
END $$
DELIMiTER $$
-- Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở location đó sẽ có location_id = null
DROP TRIGGER IF EXISTS delete_location;
DELIMITER $$
CREATE TRIGGER delete_location 
BEFORE DELETE ON location 
FOR EACH ROW
BEGIN
UPDATE employee SET locationID = 
NULL WHERE locationID = OLD.locationID;
END; 
$$ DELIMITER ;

