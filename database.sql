DROP DATABASE IF EXISTS Mario2;
CREATE DATABASE Mario2;
USE Mario2;

-- table Orders (PID, OrderID)
-- table OrderID (Timestamp, Pickup, OrderNo)
-- table PizzaID (PID, Price)
-- table PizzaMenu (PID, Name, Ingredients)
-- table Addons()

CREATE TABLE OrderID(
    OrderID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    OrderTime Timestamp,
    PickupTime INTEGER,
    Price INTEGER
);
CREATE TABLE Orders(
	OrderID INTEGER NOT NULL,
    PID INTEGER NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES OrderID (OrderID)
    );
CREATE TABLE PizzaID(
	PID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Price INTEGER
);
CREATE TABLE PizzaMenu(
	PID INTEGER NOT NULL,
    Name VARCHAR(30),
    Ingredients VARCHAR(200)
);
CREATE TABLE Statistic(
	OrderID INTEGER NOT NULL,
    PID INTEGER NOT NULL
);
