CREATE TABLE CASH_IN
(
	ID BIGINT,
	Cash_In_Date Date,
	Amount float,
	PlayerID BIGINT CONSTRAINT FK_PlayerID_Out FOREIGN KEY(PlayerID) references Player(ID),
)

----------------------------------------------------------------------------------------------------------------------

IF EXISTS(
  SELECT *
    FROM sys.triggers
   WHERE name = N'cash_in_trans'
     AND parent_class_desc = N'OBJECT_OR_COLUMN'
)
	DROP TRIGGER gi203242.cash_in_trans
GO

CREATE TRIGGER gi203242.cash_in_trans 
   ON  gi203242.CASH_IN 
   AFTER INSERT
AS 
BEGIN
	SET NOCOUNT ON;

    UPDATE PLAYER_ACCOUNT
	SET Balance = Balance + Amount
	FROM inserted
	WHERE AccountID = PlayerID

END
GO

-------------------------------------------------------------------------------------------------------------------------

ALTER TABLE CASH_IN
ADD CONSTRAINT DELETE_TRANS
FOREIGN KEY (PlayerID) REFERENCES Player(ID)
ON DELETE CASCADE;
