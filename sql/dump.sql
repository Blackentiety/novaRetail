CREATE DATABASE IF NOT EXISTS novaretail_legacy;
USE novaretail_legacy;

CREATE TABLE customer_transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    customer_email VARCHAR(150),
    customer_age INT,
    country VARCHAR(50),
    purchase_amount DOUBLE,
    clearance_level INT
);

INSERT INTO customer_transactions (customer_name, customer_email, customer_age, country, purchase_amount, clearance_level) VALUES
('Jean Dupont', 'jean.dupont@email.com', 34, 'France', 125.50, 2),
('Sarah Miller', 'sarah.m@webmail.us', 28, NULL, 450.00, 4), -- Donnée corrompue
('Akira Tanaka', 'a.tanaka@jp-service.jp', 45, 'Japan', 89.99, 1),
('Elena Rodriguez', 'elena.rod@provider.es', 31, 'Spain', 210.00, 3),
('Thomas Muller', 't.muller@deutsch.de', 52, NULL, 15.25, 1), -- Donnée corrompue
('Lucy Chen', 'lucy.chen@asia.com', 24, 'China', 560.75, 5),
('Omar Al-Farsi', 'omar.f@emirates.ae', 39, 'UAE', 1200.00, 5),
('Marie Lefebvre', 'm.lefebvre@bureau.fr', 41, 'France', 75.50, 2),
('John Doe', 'j.doe@unknown.com', 19, NULL, 5.00, 1),      -- Donnée corrompue
('Sofia Rossi', 's.rossi@italia.it', 33, 'Italy', 315.40, 3),
('Liam Wilson', 'liam.w@company.uk', 29, 'UK', 92.00, 2),
('Aya Nakamura', 'aya.n@musique.fr', 26, NULL, 850.00, 4),   -- Donnée corrompue
('Sven Berg', 's.berg@nordic.se', 50, 'Sweden', 42.10, 2),
('Chloe Dubois', 'chloe.d@service.be', 22, 'Belgium', 110.30, 3),
('Mateo Gomez', 'm.gomez@latam.mx', 37, NULL, 290.00, 4);    -- Donnée corrompue