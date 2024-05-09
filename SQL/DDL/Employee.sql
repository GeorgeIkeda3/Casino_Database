CREATE TABLE EMPLOYEE
(
	Ssn CHAR(9) CONSTRAINT PK_EMPLOYEE_SSN PRIMARY KEY, 
	[Name] VARCHAR(50) NOT NULL,
	DateOfBirth DATE NOT NULL CONSTRAINT CK_EMPLOYEE_DOB CHECK (DateOfBirth <= CAST(GETDATE() AS DATE)),
	Position VARCHAR(20) NOT NULL,
	Salary INT,
	Manager CHAR(9) CONSTRAINT FK_MANAGER FOREIGN KEY REFERENCES MANAGEMENT(Ssn)
);

--------------------------------------------------------------------------------------------------------------------

IF EXISTS(
  SELECT *
    FROM sys.triggers
   WHERE name = N'add_cashier'
     AND parent_class_desc = N'OBJECT_OR_COLUMN'
)
	DROP TRIGGER gi203242.add_cashier
GO

CREATE TRIGGER gi203242.add_cashier 
   ON EMPLOYEE 
   AFTER INSERT
AS
DECLARE @position VARCHAR(20)
DECLARE @name VARCHAR(50)

SELECT @position = (Position) FROM INSERTED
SELECT @name = ([Name]) FROM INSERTED

IF @position = 'Cashier'
BEGIN 
	INSERT INTO CASHIER([Name]) VALUES (@name)
END
GO

---------------------------------------------------------------------------------------------------------------------------

IF EXISTS(
  SELECT *
    FROM sys.triggers
   WHERE name = N'add_dealer'
     AND parent_class_desc = N'OBJECT_OR_COLUMN'
)
	DROP TRIGGER gi203242.add_dealer
GO

CREATE TRIGGER gi203242.add_dealer 
   ON EMPLOYEE 
   AFTER INSERT
AS
DECLARE @position VARCHAR(20)
DECLARE @name VARCHAR(50)

SELECT @position = (Position) FROM INSERTED
SELECT @name = ([Name]) FROM INSERTED

IF @position = 'Dealer'
BEGIN 
	INSERT INTO DEALER([Name]) VALUES (@name)
END
GO

------------------------------------------------------------------------------------------------------------------------------

IF EXISTS(
  SELECT *
    FROM sys.triggers
   WHERE name = N'add_pit'
     AND parent_class_desc = N'OBJECT_OR_COLUMN'
)
	DROP TRIGGER gi203242.add_pit
GO

CREATE TRIGGER gi203242.add_pit
   ON EMPLOYEE 
   AFTER INSERT
AS
DECLARE @position VARCHAR(20)
DECLARE @name VARCHAR(50)

SELECT @position = (Position) FROM INSERTED
SELECT @name = ([Name]) FROM INSERTED

IF @position = 'Pit Boss'
BEGIN 
	INSERT INTO PIT_BOSS([Name]) VALUES (@name)
END
GO
