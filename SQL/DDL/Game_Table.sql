CREATE TABLE GAME_TABLE
(
	Num VARCHAR(20) CONSTRAINT PK_TABLE_NUM PRIMARY KEY,
	Player1 BIGINT CONSTRAINT FK_PLAYER1_ID FOREIGN KEY REFERENCES PLAYER(ID),
	Player2 BIGINT CONSTRAINT FK_PLAYER2_ID FOREIGN KEY REFERENCES PLAYER(ID),
	Player3 BIGINT CONSTRAINT FK_PLAYER3_ID FOREIGN KEY REFERENCES PLAYER(ID),
	Player4 BIGINT CONSTRAINT FK_PLAYER4_ID FOREIGN KEY REFERENCES PLAYER(ID),
	Player5 BIGINT CONSTRAINT FK_PLAYER5_ID FOREIGN KEY REFERENCES PLAYER(ID),
	Player6 BIGINT CONSTRAINT FK_PLAYER6_ID FOREIGN KEY REFERENCES PLAYER(ID),
	Player7 BIGINT CONSTRAINT FK_PLAYER7_ID FOREIGN KEY REFERENCES PLAYER(ID),
	Player8 BIGINT CONSTRAINT FK_PLAYER8_ID FOREIGN KEY REFERENCES PLAYER(ID),
)