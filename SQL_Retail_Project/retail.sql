CREATE DATABASE retail_db;
USE retail_db;
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(50),
    city VARCHAR(50));
    
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    name VARCHAR(50),
    category VARCHAR(50),
    price DECIMAL(10,2));
    
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id));
    
CREATE TABLE Order_Items (
    order_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id));
    
SHOW TABLES;

INSERT INTO Customers VALUES
(1, 'Monica', 'Chennai'),
(2, 'Ravi', 'Bangalore'),
(3, 'Anu', 'Delhi'),
(4, 'Kiran', 'Hyderabad'),
(5, 'Sneha', 'Mumbai'),
(6, 'Arjun', 'Pune'),
(7, 'Divya', 'Chennai'),
(8, 'Rahul', 'Kolkata'),
(9, 'Meena', 'Coimbatore'),
(10, 'Vikram', 'Jaipur');
DESCRIBE Customers;
SELECT * FROM Customers;

INSERT INTO Products VALUES
(101, 'Laptop', 'Electronics', 50000),
(102, 'Phone', 'Electronics', 20000),
(103, 'Shoes', 'Fashion', 3000),
(104, 'Watch', 'Accessories', 2500),
(105, 'Bag', 'Fashion', 1500),
(106, 'Headphones', 'Electronics', 3000),
(107, 'T-shirt', 'Fashion', 800),
(108, 'Keyboard', 'Electronics', 1200),
(109, 'Mouse', 'Electronics', 700),
(110, 'Sunglasses', 'Accessories', 2000);
SELECT * FROM Products;

INSERT INTO Orders VALUES
(1001, 1, '2024-01-10'),
(1002, 2, '2024-01-15'),
(1003, 3, '2024-02-05'),
(1004, 4, '2024-02-20'),
(1005, 5, '2024-03-01'),
(1006, 6, '2024-03-10');
SELECT * FROM Orders;

INSERT INTO Order_Items VALUES
(1001, 101, 1),
(1001, 103, 2),
(1002, 102, 1),
(1002, 105, 2),
(1003, 104, 1),
(1003, 107, 3),
(1004, 106, 2),
(1005, 108, 1),
(1005, 109, 2),
(1006, 110, 1);
SELECT * FROM Order_Items;

-- Find top-selling products
SELECT p.name, SUM(oi.quantity) AS total_sold
FROM Order_Items oi
JOIN Products p ON oi.product_id = p.product_id
GROUP BY p.name
ORDER BY total_sold DESC;

-- Identify most valuable customers
SELECT c.name,SUM(p.price * oi.quantity) as total_spent from Customers c JOIN
Orders o ON c.customer_id=o.customer_id JOIN Order_Items oi ON o.order_id=oi.order_id JOIN
Products p ON oi.product_id=p.product_id GROUP BY c.name ORDER BY total_spent DESC;

-- Monthly revenue calculation
SELECT MONTH(o.date) AS month, 
SUM(p.price * oi.quantity) AS revenue
FROM Orders o
JOIN Order_Items oi ON o.order_id = oi.order_id
JOIN Products p ON oi.product_id = p.product_id
GROUP BY month;

-- Category-wise sales analysis
SELECT p.category,SUM(oi.quantity) as total_sales FROM
Products p JOIN Order_items oi ON p.product_id = oi.product_id GROUP BY p.category;
INSERT INTO Customers VALUES (11, 'Karthik', 'Madurai');

-- Detect inactive customers                                                             
SELECT c.name
FROM Customers c
LEFT JOIN Orders o ON c.customer_id = o.customer_id
WHERE o.order_id IS NULL;