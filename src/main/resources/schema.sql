CREATE TABLE diner
(
    id    IDENTITY NOT NULL PRIMARY KEY,
    name  VARCHAR(255),
    dietary_restrictions INT ARRAY
);

CREATE TABLE dietary_restriction
(
    id    IDENTITY NOT NULL PRIMARY KEY,
    name  VARCHAR(255)
);

CREATE TABLE restaurant
(
    id    IDENTITY NOT NULL PRIMARY KEY,
    name  VARCHAR(255),
    dietary_endorsements INT ARRAY
);

CREATE TABLE restaurant_table
(
    id    IDENTITY NOT NULL PRIMARY KEY,
    restaurant_id INT,
    capacity  INT
);

ALTER TABLE restaurant_table
    ADD FOREIGN KEY (restaurant_id)
        REFERENCES restaurant(id);


CREATE TABLE reservation
(
    id    IDENTITY NOT NULL PRIMARY KEY,
    table_id INT,
    start_time  TIMESTAMP,
    end_time  TIMESTAMP,
    diners INT ARRAY
);

ALTER TABLE reservation
    ADD FOREIGN KEY (table_id)
        REFERENCES restaurant_table(id)