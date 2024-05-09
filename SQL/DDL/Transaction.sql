CREATE SEQUENCE TransID
	START WITH 1
	INCREMENT BY 1
	NO CACHE
	;
GO

-------------------------------------------------------------------------------------------------------------

CREATE TABLE TRANS
(
	ID BIGINT PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR TransID),
	[Date] DATE NOT NULL,
	PlayerID BIGINT CONSTRAINT FK_TRANS_PLAYERID FOREIGN KEY(PlayerID) references Player(ID),
	Amount INT NOT NULL,
	Method VARCHAR(20) NOT NULL
	CONSTRAINT CHK_Method CHECK(Method='Cash In' OR Method='Cash Out');
)
  
-------------------------------------------------------------------------------------------------------------

IF EXISTS(
  SELECT *
    FROM sys.triggers
   WHERE name = N'trans_method'
     AND parent_class_desc = N'OBJECT_OR_COLUMN'
)
	DROP TRIGGER gi203242.trans_method
GO

CREATE TRIGGER gi203242.trans_method
   ON TRANS 
   AFTER INSERT
AS
DECLARE @method VARCHAR(20)

SELECT @method = (Method) FROM INSERTED

IF @method = 'Cash In'
BEGIN 
	INSERT INTO CASH_IN(ID, Cash_In_Date, Amount, PlayerID) 
	SELECT ID, [Date], Amount, PlayerID FROM INSERTED
END
IF @method = 'Cash Out'
BEGIN 
	INSERT INTO CASH_OUT(ID, Cash_Out_Date, Amount, PlayerID) 
	SELECT ID, [Date], Amount, PlayerID FROM INSERTED
END
GO

-------------------------------------------------------------------------------------------------------------

ALTER TABLE TRANS
ADD CONSTRAINT DELETE_TRANACTIONS
FOREIGN KEY (PlayerID) REFERENCES Player(ID)
ON DELETE CASCADE;