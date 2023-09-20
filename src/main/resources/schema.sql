-- Create table "clients"
CREATE TABLE clients (
    id INT PRIMARY KEY,
    name VARCHAR(75),
    lastname VARCHAR(75),
    docnumber VARCHAR(75)
);

-- Create table "invoice"
CREATE TABLE invoice (
    id INT PRIMARY KEY,
    client_id INT,
    create_at DATETIME,
    total DOUBLE,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

-- Create table "products"
CREATE TABLE products (
    id INT PRIMARY KEY,
    description VARCHAR(150),
    code VARCHAR(50),
    stock INT,
    price DOUBLE
);

-- Create intermediate table "invoice_details"
CREATE TABLE invoice_details (
    invoice_detail_id INT PRIMARY KEY,
    invoice_id INT,
    amount INT,
    product_id INT,
    price DOUBLE,
    FOREIGN KEY (invoice_id) REFERENCES invoice(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);
