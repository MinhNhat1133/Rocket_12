-- Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'
DROP VIEW IF EXISTS Name_Product;
CREATE VIEW Name_Product AS ( SELECT ProductSubcategoryID FROM adventureworks.productsubcategory WHERE `Name` = 'Saddles');
SELECT `Name` From adventureworks.product WHERE ProductSubcategoryID = (SELECT * FROM Name_Product);


-- Question 2: Thay đổi câu Query 1 để lấy được kết quả sau.
DROP VIEW IF EXISTS Name_Product2;
CREATE VIEW Name_Product2 AS ( SELECT ProductSubcategoryID FROM adventureworks.productsubcategory WHERE `Name` like 'Bo%');
SELECT `Name` From adventureworks.product WHERE ProductSubcategoryID IN (SELECT * FROM Name_Product2);

-- Question 3:Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring  Bike (nghĩa là ProductSubcategoryID = 3)
DROP VIEW IF EXISTS count_Listprice;
DROP VIEW IF EXISTS PS_ID;
CREATE VIEW count_Listprice AS (SELECT MIN(ListPrice) From adventureworks.product ) ;
CREATE VIEW PS_ID as (SELECT productsubcategoryID FROM adventureworks.productsubcategory WHERE ProductSubcategoryID = 3 ) ;
SELECT `name` FROM adventureworks.product WHERE ListPrice = (SELECT * FROM count_Listprice ) and (SELECT * FROM PS_ID) ;


-- Exercise 2: JOIN nhiều bảng
-- Question 1: Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008sample  database.
DROP VIEW IF EXISTS Name_Country_vs_Province ;
CREATE VIEW  Name_Country_vs_Province AS ( SELECT a.`name`AS Country,b.`name` AS province
FROM adventureworks.countryregion a
JOIN adventureworks.stateprovince b
on a.CountryRegionCode = b.CountryRegionCode);
SELECT * FROM Name_Country_vs_Province ;

-- Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada
DROP VIEW IF EXISTS Name_Country_vs_Province ;
CREATE VIEW  Name_Country_vs_Province AS ( SELECT a.`name`AS Country,b.`name` AS province
FROM adventureworks.countryregion a
JOIN adventureworks.stateprovince b
on a.CountryRegionCode = b.CountryRegionCode
WHERE a.`Name` = 'Germany' or a.`name` = 'Canada');
SELECT * FROM Name_Country_vs_Province ;

-- Question 3:SalesOrderID, OrderDate and SalesPersonID. Từ bảng SalesPerson, chúng ta lấy cột 
-- BusinessEntityID (là định danh của người sales), Bonus and the SalesYTD (là đã sale được bao nhiêu người trong năm nay)
DROP VIEW IF EXISTS I_OF_S  ;
CREATE VIEW  I_OF_S AS(
SELECT SO.SalesOrderID, SO.OrderDate, SP.SalesPersonID, SP.SalesPersonID, SP.Bonus,SP.SalesYTD
FROM adventureworks.salesperson SP
JOIN adventureworks.salesorderheader SO
ON SP.SalesPersonID = SO.SalesPersonID );
SELECT * FROM I_OF_S;

-- Question 4:
SELECT SO.SalesOrderID, SO.OrderDate, E.Title as Jobtite, SP.Bonus,SP.SalesYTD
FROM adventureworks.salesorderheader SO
JOIN adventureworks.salesperson SP ON SP.SalesPersonID = SO.SalesPersonID
JOIN adventureworks.employee E ON E.ContactID = SO.ContactID
-- ???????????????????????????????