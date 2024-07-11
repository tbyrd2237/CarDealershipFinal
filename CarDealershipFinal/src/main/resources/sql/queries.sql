--Get all dealerships
SELECT * FROM dealerships;

--Find all vehicles for a specific dealership
SELECT *
FROM vehicles
JOIN inventory ON vehicles.vehicle_id = inventory.vehicle_id
WHERE inventory.dealership_id = 1;

--Find a car by VIN
SELECT *
FROM vehicles
WHERE VIN = '1HGCM82633A012345';

--Find the dealership where a certain car is located, by VIN
SELECT dealerships.address
FROM dealerships
JOIN inventory ON dealerships.dealership_id = inventory.dealership_id
JOIN vehicles ON inventory.vehicle_id = vehicles.vehicle_id
WHERE vehicles.VIN = '1HGCM82633A012345';

--Find all Dealerships that have a certain car type (i.e. Red Ford Mustang)
SELECT *
FROM dealerships
JOIN inventory ON dealerships.dealership_id = inventory.dealership_id
JOIN vehicles ON inventory.vehicle_id = vehicles.vehicle_id
WHERE vehicles.type = 'Sedan';

--Get all sales information for a specific dealer for a specific date range
SELECT *
FROM sales_contracts
JOIN vehicles ON sales_contracts.vehicle_id = vehicles.vehicle_id
JOIN inventory ON vehicles.vehicle_id = inventory.vehicle_id
WHERE sales_contracts.sale_date < '2023-01-19';
