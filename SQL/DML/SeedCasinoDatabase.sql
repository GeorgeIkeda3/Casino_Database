--Insert values into Employee Table, 2 of each position
INSERT INTO EMPLOYEE(Ssn, [Name], DateOfBirth, Position, Salary) VALUES ('012345678', 'Stephen Murphy', '1945-08-09', 'Dealer', 25000, 753146283);
INSERT INTO EMPLOYEE(Ssn, [Name], DateOfBirth, Position, Salary) VALUES ('123456789', 'George Ikeda', '1986-07-26', 'Cashier', 100000, 258741369);
INSERT INTO EMPLOYEE(Ssn, [Name], DateOfBirth, Position, Salary) VALUES ('5555555555', 'Greg Diaz', '1965-12-01', 'Dealer', 75000, 753146283);
INSERT INTO EMPLOYEE(Ssn, [Name], DateOfBirth, Position, Salary) VALUES ('987654321', 'Stella Stout', '1963-07-19', 'Pit Boss', 250000, 684123957);
INSERT INTO EMPLOYEE(Ssn, [Name], DateOfBirth, Position, Salary) VALUES ('999999999', 'Jackson Browne', '2000-09-23', 'Cashier', 50000, 258741369);
INSERT INTO EMPLOYEE(Ssn, [Name], DateOfBirth, Position, Salary) VALUES ('456987123', 'Heather Smith', '1995-01-30', 'Pit Boss', 100000, 684123957);

--Insert values into Management Table
INSERT INTO MANAGEMENT(Ssn, [Name], Position, DateOfBirth, Salary) VALUES (258741369, 'Jesus Christ', 'Cashier', '0001-12-25', 1000000);
INSERT INTO MANAGEMENT(Ssn, [Name], Position, DateOfBirth, Salary) VALUES (753146283, 'Joe Biden', 'Dealer', '1945-06-15', 750000);
INSERT INTO MANAGEMENT(Ssn, [Name], Position, DateOfBirth, Salary) VALUES (684123957, 'Mother Theresa', 'Pit Boss', '1932-12-04', 80000);

--Insert values into Player Table
INSERT INTO PLAYER(ID, [Name], Email, DateOfBirth) VALUES (1234, 'George Ikeda', 'email@email.com', '1963-07-19');
INSERT INTO PLAYER(ID, [Name], Email, DateOfBirth) VALUES (8878, 'Stella', 'test@test.com', '1986-07-26');
INSERT INTO PLAYER(ID, [Name], Email, DateOfBirth) VALUES (5555, 'Victor Ikeda-Wood', 'fancyboy@fancy.com', '1988-03-21');
INSERT INTO PLAYER(ID, [Name], Email, DateOfBirth) VALUES (9513, 'Lisa Dapkus', 'dinodapkus@meta.com', '1994-07-19');
INSERT INTO PLAYER(ID, [Name], Email, DateOfBirth) VALUES (3573, 'Dorothy Oz', 'witch@witches.com', '1950-11-11');
INSERT INTO PLAYER(ID, [Name], Email, DateOfBirth) VALUES (3011, 'Gandalf Grey', 'wizard@lotr.com', '1920-04-20');
INSERT INTO PLAYER(ID, [Name], Email, DateOfBirth) VALUES (96354, 'Bart Simpson', 'elbarto@simps.com', '1989-03-04');
INSERT INTO PLAYER(ID, [Name], Email, DateOfBirth) VALUES (041633, 'Montana Griz', 'griz@umt.edu', '1420-10-31');

--Insert values into Transaction Table
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 5555, 250, 'Cash In');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2019-02-08', 9513, 2500, 'Cash In');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2000-03-07', 3573, 1000000, 'Cash In');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2022-02-22', 3011, 10, 'Cash In');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2018-12-12', 96354, 458, 'Cash In');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2012-06-14', 41633, 758, 'Cash In');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-24', 5555, 25000, 'Cash In');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2014-09-10', 1234, 1000, 'Cash In');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2023-08-16', 9513, 6969, 'Cash In');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-05-01', 5555, 420, 'Cash In');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 8878, 750, 'Cash Out');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 9513, 450, 'Cash Out');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 96354, 58, 'Cash Out');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 041633, 700, 'Cash Out');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 3011, 5, 'Cash Out');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 3573, 75000, 'Cash Out');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 1234, 800, 'Cash Out');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 9513, 420, 'Cash Out');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 3573, 951, 'Cash Out');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 8878, 800, 'Cash Out');
INSERT INTO TRANS([Date], PlayerID, Amount, Method) VALUES ('2024-01-01', 5555, 250, 'Cash Out');
