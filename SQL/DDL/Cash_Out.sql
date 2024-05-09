CREATE TABLE CASH_OUT
(
	ID BIGINT,
	Cash_Out_Date Date,
	Amount float,
	PlayerID BIGINT CONSTRAINT FK_PlayerID_Out FOREIGN KEY(PlayerID) references Player(ID),
)

----------------------------------------------------------------------------------------------------------------------

IF EXISTS(
  SELECT *
    FROM sys.triggers
   WHERE name = N'cash_out_trans'
     AND parent_class_desc = N'OBJECT_OR_COLUMN'
)
	DROP TRIGGER gi203242.cash_out_trans
GO

CREATE TRIGGER gi203242.cash_out_trans 
   ON  gi203242.CASH_OUT
   AFTER INSERT
AS 
BEGIN
	SET NOCOUNT ON;

    UPDATE PLAYER_ACCOUNT
	SET Balance = Balance - Amount
	FROM inserted
	WHERE AccountID = PlayerID

END
GO

-------------------------------------------------------------------------------------------------------------------

ALTER TABLE CASH_OUT
ADD CONSTRAINT DELETE_TRANS_OUT
FOREIGN KEY (PlayerID) REFERENCES Player(ID)
ON DELETE CASCADE;
