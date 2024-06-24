create database LoanManagementSystem;
use LoanManagementSystem;

CREATE TABLE Customer (
    customer_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    credit_score INT NOT NULL
);

CREATE TABLE Loan (
    loan_id INT PRIMARY KEY,
    customer_id INT,
    principal_amount DECIMAL(10, 2) NOT NULL,
    interest_rate DECIMAL(5, 2) NOT NULL,
    loan_term INT NOT NULL,
    loan_type VARCHAR(20) NOT NULL,
    loan_status VARCHAR(20) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

-- Inserting records into Customer table
INSERT INTO Customer (customer_id, name, email, phone, address, credit_score) VALUES
(1, 'John Doe', 'john.doe@example.com', '123-456-7890', '123 Elm Street', 750),
(2, 'Jane Smith', 'jane.smith@example.com', '234-567-8901', '456 Oak Avenue', 780),
(3, 'Jim Brown', 'jim.brown@example.com', '345-678-9012', '789 Pine Lane', 690),
(4, 'Lucy Green', 'lucy.green@example.com', '456-789-0123', '321 Birch Boulevard', 710),
(5, 'Mark Black', 'mark.black@example.com', '567-890-1234', '654 Cedar Court', 680),
(6, 'Nancy White', 'nancy.white@example.com', '678-901-2345', '987 Maple Street', 720),
(7, 'Paul Blue', 'paul.blue@example.com', '789-012-3456', '123 Oak Avenue', 660),
(8, 'Kathy Red', 'kathy.red@example.com', '890-123-4567', '456 Pine Lane', 800),
(9, 'George Pink', 'george.pink@example.com', '901-234-5678', '789 Birch Boulevard', 770),
(10, 'Betty Yellow', 'betty.yellow@example.com', '012-345-6789', '321 Cedar Court', 740),
(11, 'Sam Orange', 'sam.orange@example.com', '123-456-7891', '654 Maple Street', 760),
(12, 'Ann Purple', 'ann.purple@example.com', '234-567-8902', '987 Elm Street', 730),
(13, 'Tom Gray', 'tom.gray@example.com', '345-678-9013', '123 Oak Avenue', 750),
(14, 'Diana Silver', 'diana.silver@example.com', '456-789-0124', '456 Pine Lane', 780),
(15, 'Steve Gold', 'steve.gold@example.com', '567-890-1235', '789 Birch Boulevard', 690);

-- Inserting records into Loan table
INSERT INTO Loan (loan_id, customer_id, principal_amount, interest_rate, loan_term, loan_type, loan_status) VALUES
(1, 1, 25000.00, 5.5, 60, 'CarLoan', 'Approved'),
(2, 2, 200000.00, 3.5, 360, 'HomeLoan', 'Approved'),
(3, 3, 15000.00, 6.0, 48, 'CarLoan', 'Pending'),
(4, 4, 180000.00, 4.0, 360, 'HomeLoan', 'Approved'),
(5, 5, 30000.00, 5.0, 60, 'CarLoan', 'Pending'),
(6, 6, 220000.00, 3.8, 360, 'HomeLoan', 'Approved'),
(7, 7, 12000.00, 6.5, 48, 'CarLoan', 'Approved'),
(8, 8, 190000.00, 4.2, 360, 'HomeLoan', 'Pending'),
(9, 9, 27000.00, 5.3, 60, 'CarLoan', 'Approved'),
(10, 10, 230000.00, 3.6, 360, 'HomeLoan', 'Approved'),
(11, 11, 14000.00, 6.2, 48, 'CarLoan', 'Pending'),
(12, 12, 210000.00, 3.9, 360, 'HomeLoan', 'Approved'),
(13, 13, 26000.00, 5.4, 60, 'CarLoan', 'Approved'),
(14, 14, 200000.00, 3.7, 360, 'HomeLoan', 'Pending'),
(15, 15, 17000.00, 6.1, 48, 'CarLoan', 'Approved');
