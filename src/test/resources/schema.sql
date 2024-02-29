DROP TABLE IF EXISTS reservations, tables, clients;

CREATE TABLE tables
(
    id              INT PRIMARY KEY,
    available_seats INT,
    busy_at         DATETIME
);

CREATE TABLE reservations
(
    id               INT PRIMARY KEY,
    reservation_time DATETIME,
    table_id         INT,
    FOREIGN KEY (table_id) REFERENCES tables (id)
);

CREATE TABLE clients
(

    id       INT PRIMARY KEY ,

    nom      VARCHAR(50) NOT NULL,

    prenom   VARCHAR(20) NOT NULL,

    email    VARCHAR(60) NOT NULL,

    password VARCHAR(60) NOT NULL

);