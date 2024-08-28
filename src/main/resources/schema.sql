CREATE TABLE diner
(
    id    IDENTITY NOT NULL PRIMARY KEY,
    name  VARCHAR(255)
);

CREATE TABLE dietary_restriction_type
(
    id    IDENTITY NOT NULL PRIMARY KEY,
    name  VARCHAR(255)
);

CREATE TABLE restaurant
(
    id    IDENTITY NOT NULL PRIMARY KEY,
    name  VARCHAR(255)
);

CREATE TABLE diner_dietary_restriction
(
    diner_id INT,
    dietary_restriction_type INT
);
ALTER TABLE diner_dietary_restriction
    ADD FOREIGN KEY (diner_id)
        REFERENCES diner(id);
ALTER TABLE diner_dietary_restriction
    ADD FOREIGN KEY (dietary_restriction_type)
        REFERENCES dietary_restriction_type(id);

CREATE TABLE restaurant_dietary_endorsement
(
    restaurant_id INT,
    dietary_restriction_type INT
);
ALTER TABLE restaurant_dietary_endorsement
    ADD FOREIGN KEY (restaurant_id)
        REFERENCES restaurant(id);
ALTER TABLE restaurant_dietary_endorsement
    ADD FOREIGN KEY (dietary_restriction_type)
        REFERENCES dietary_restriction_type(id);

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
    diner_id INT
);

ALTER TABLE reservation
    ADD FOREIGN KEY (table_id)
        REFERENCES restaurant_table(id);

ALTER TABLE reservation
    ADD FOREIGN KEY (diner_id)
        REFERENCES diner(id);