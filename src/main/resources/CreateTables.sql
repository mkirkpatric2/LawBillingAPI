CREATE TABLE clients (
    clientcode SERIAL PRIMARY KEY,
    clientname VARCHAR(25) UNIQUE,
    isactive BOOLEAN,
    leadattorney INT,
    clientphoneno VARCHAR(15)
);

CREATE TABLE bills (
    id SERIAL PRIMARY KEY,
    clientcode INT,
    biller INT,
    hours NUMERIC(1, 1),
    details VARCHAR(100)
);

CREATE TABLE billers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) UNIQUE,
    attorney BOOLEAN,
    hourlyrate NUMERIC(3,2)
);