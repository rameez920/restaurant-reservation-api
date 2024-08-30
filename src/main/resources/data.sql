INSERT INTO diner (name) VALUES ('Michael')
INSERT INTO diner (name) VALUES ('George Michael')
INSERT INTO diner (name) VALUES ('Lucile')
INSERT INTO diner (name) VALUES ('Gob')
INSERT INTO diner (name) VALUES ('Tobias')
INSERT INTO diner (name) VALUES ('Maeby')


INSERT INTO restaurant (name) VALUES ('Lardo')
INSERT INTO restaurant (name) VALUES ('Panadería Rosetta')
INSERT INTO restaurant (name) VALUES ('Tetetlán')
INSERT INTO restaurant (name) VALUES ('Falling Piano Brewing Co')
INSERT INTO restaurant (name) VALUES ('u.to.pi.a')

INSERT INTO dietary_restriction_type (name) VALUES ('Vegetarian')
INSERT INTO dietary_restriction_type (name) VALUES ('Gluten-Free')
INSERT INTO dietary_restriction_type (name) VALUES ('Paleo')
INSERT INTO dietary_restriction_type (name) VALUES ('Vegan')

INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Lardo'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Lardo'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Lardo'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Lardo'))

INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Lardo'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Lardo'))

INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (6, (SELECT id FROM restaurant WHERE name = 'Lardo'))


INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Panadería Rosetta'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Panadería Rosetta'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Panadería Rosetta'))

INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Panadería Rosetta'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Panadería Rosetta'))

INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Tetetlán'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Tetetlán'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Tetetlán'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Tetetlán'))

INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Tetetlán'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Tetetlán'))

INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (6, (SELECT id FROM restaurant WHERE name = 'Tetetlán'))


INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))

INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (4, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))

INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (6, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (6, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (6, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (6, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (6, (SELECT id FROM restaurant WHERE name = 'Falling Piano Brewing Co'))

INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'u.to.pi.a'))
INSERT INTO restaurant_table (capacity, restaurant_id) VALUES (2, (SELECT id FROM restaurant WHERE name = 'u.to.pi.a'))


-- INSERT INTO diner_dietary_restriction (diner_id, dietary_restriction_type) VALUES
