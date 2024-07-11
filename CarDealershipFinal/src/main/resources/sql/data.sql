DROP DATABASE IF EXISTS cardealership;

CREATE DATABASE cardealership;

CREATE TABLE dealerships (
    dealership_id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(12)
);

CREATE TABLE vehicles (
    vehicle_id SERIAL PRIMARY KEY,
    VIN VARCHAR(50) UNIQUE,
    make VARCHAR(50),
    model VARCHAR(50),
    color VARCHAR(50),
    mileage INT,
    type VARCHAR(50),
    price DOUBLE PRECISION,
    year INT,
    sold BOOLEAN
);

CREATE TABLE inventory (
    dealership_id INT,
    vehicle_id INT,
    FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
);

CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    customer_name VARCHAR(50),
    address VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(20),
    email VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE sales_contracts(
    sale_id SERIAL PRIMARY KEY,
    vehicle_id INT,
    customer_id INT,
    sale_price DOUBLE PRECISION,
    sale_date DATE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles (vehicle_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE financing(
    sale_id INT PRIMARY KEY,
    rate INT,
    loan_length INT,
    monthly_payment INT,
    FOREIGN KEY (sale_id) REFERENCES sales_contracts(sale_id)
);

-- Inserting dealerships data
INSERT INTO dealerships (name, address, phone) VALUES
    ('ABC Motors', '123 Main St, Anytown, USA', '555-1234'),
    ('XYZ Auto', '456 Oak Ave, Othercity, USA', '555-5678');

-- Inserting vehicles data
INSERT INTO vehicles (VIN, make, model, color, mileage, type, price, year, sold) VALUES
    ('1HGCM82633A012345', 'Honda', 'Accord', 'Silver', 50000, 'Sedan', 15000.00, 2010, FALSE),
    ('5YJSA1H11EFP57900', 'Tesla', 'Model S', 'Red', 20000, 'Sedan', 60000.00, 2014, TRUE),
    ('1FTFW1EFXCKD07907', 'Ford', 'F-150', 'Blue', 30000, 'Truck', 25000.00, 2012, FALSE);

-- Inserting inventory data
INSERT INTO inventory (dealership_id, vehicle_id) VALUES
    (1, 1),
    (1, 2),
    (2, 3);

-- Inserting customers data
INSERT INTO customers (customer_name, address, city, state, zip_code, email, phone) VALUES
    ('John Doe', '789 Elm St, Hometown, USA', 'Hometown', 'CA', '12345', 'john.doe@example.com', '555-6789'),
    ('Jane Smith', '456 Pine Ave, Nearbytown, USA', 'Nearbytown', 'NY', '54321', 'jane.smith@example.com', '555-9876');

-- Inserting sales contracts data
INSERT INTO sales_contracts (vehicle_id, customer_id, sale_price, sale_date) VALUES
    (1, 1, 14000.00, '2023-01-15'),
    (2, 2, 55000.00, '2023-02-20');

-- Inserting financing data
INSERT INTO financing (sale_id, rate, loan_length, monthly_payment) VALUES
    (1, 3, 48, 325),
    (2, 2, 60, 900);