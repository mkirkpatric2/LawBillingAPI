CREATE TABLE clients (
    clientcode SERIAL PRIMARY KEY,
    clientname VARCHAR(25) UNIQUE NOT NULL,
    isactive BOOLEAN NOT NULL,
    leadattorney INT NOT NULL,
    clientphoneno VARCHAR(15) NOT NULL,
    islit BOOLEAN NOT NULL
);

CREATE TABLE bills (
    id SERIAL PRIMARY KEY,
    clientcode INT NOT NULL,
    biller INT NOT NULL,
    hours NUMERIC(3, 2) NOT NULL,
    details VARCHAR(100) NOT NULL,
    paid BOOLEAN NOT NULL
);

CREATE TABLE billers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) UNIQUE NOT NULL,
    attorney BOOLEAN NOT NULL,
    hourlyrate INT NOT NULL
);