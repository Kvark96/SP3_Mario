DROP DATABASE IF EXISTS Mario2;
CREATE DATABASE Mario2;
USE Mario2;

-- table Customers (CustID, Name, Tlf)
-- table Orders (PID, OrderID)
-- table OrderID (Timestamp, Pickup, OrderNo, CustID)
-- table PizzaID (PID, Price)
-- table PizzaMenu (PID, Name, Ingredients)
-- table Addons()

CREATE TABLE Orders(
	OrderID INTEGER NOT NULL PRIMARY KEY,
    PID INTEGER NOT NULL
    );
CREATE TABLE OrderID(
    OrderID INTEGER NOT NULL,
	CustID INTEGER NOT NULL PRIMARY KEY,
    OrderTime Timestamp,
    PickupTime TIME,
    FOREIGN KEY (OrderID) REFERENCES Orders (OrderID)
);
CREATE TABLE Customers(
	CustID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Tlf INTEGER,
    FOREIGN KEY (CustID) REFERENCES OrderID (CustID)
);
CREATE TABLE PizzaID(
	PID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Price INTEGER
);
CREATE TABLE PizzaMenu(
	PID INTEGER NOT NULL,
    Name VARCHAR(30),
    Ingredients VARCHAR(200),
    FOREIGN KEY (PID) REFERENCES PizzaID (PID)
);
CREATE TABLE Statistic(
	PizzaID INTEGER NOT NULL PRIMARY KEY,
    NumberSold INTEGER
);
