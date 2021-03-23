-- Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'
SELECT P.`Name` 
FROM adventureworks.product P
JOIN adventureworks.productsubcategory PS
ON P.ProductSubcategoryID = PS.ProductSubcategoryID
WHERE PS.`Name` = 'Saddles';

-- Question 2: Thay đổi câu Query 1 để lấy được kết quả sau.
SELECT P.`Name` 
FROM adventureworks.product P
JOIN adventureworks.productsubcategory PS
ON P.ProductSubcategoryID = PS.ProductSubcategoryID
WHERE PS.`Name` like 'Bo%';

-- Question 3:Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring  Bike (nghĩa là ProductSubcategoryID = 3)
SELECT P.`Name` 
FROM adventureworks.product P
JOIN adventureworks.productsubcategory PS
ON P.ProductSubcategoryID = PS.ProductSubcategoryID
WHERE  P.ListPrice = (SELECT MIN(ListPrice) as 'sdfasdf'
FROM adventureworks.product ) 
and PS.ProductSubcategoryID = 3;
-- ???????????????????????????????????

-- Exercise 2: JOIN nhiều bảng
-- Question 1: Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008sample database. 
SELECT a.`name`AS Country,b.`name` AS province
FROM adventureworks.countryregion a
JOIN adventureworks.stateprovince b
on a.CountryRegionCode = b.CountryRegionCode;

-- Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada
SELECT a.`name`AS Country,b.`name` AS province
FROM adventureworks.countryregion a
JOIN adventureworks.stateprovince b
on a.CountryRegionCode = b.CountryRegionCode
WHERE a.`Name` = 'Germany' or a.`name` = 'Canada';

-- Question 3:SalesOrderID, OrderDate and SalesPersonID. Từ bảng SalesPerson, chúng ta lấy cột 
-- BusinessEntityID (là định danh của người sales), Bonus and the SalesYTD (là đã sale được bao nhiêu người trong năm nay)

SELECT SO.SalesOrderID, SO.OrderDate, SP.SalesPersonID, SP.SalesPersonID, SP.Bonus,SP.SalesYTD
FROM adventureworks.salesperson SP
JOIN adventureworks.salesorderheader SO
ON SP.SalesPersonID = SO.SalesPersonID;

-- Question 4:
SELECT SO.SalesOrderID, SO.OrderDate, E.Title as Jobtite, SP.Bonus,SP.SalesYTD
FROM adventureworks.salesorderheader SO
JOIN adventureworks.salesperson SP ON SP.SalesPersonID = SO.SalesPersonID
JOIN adventureworks.employee E ON E.ContactID = SO.ContactID
-- ???????????????????????????????