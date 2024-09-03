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

INSERT INTO diner_dietary_restriction (diner_id, dietary_restriction_type) VALUES ((SELECT id from diner where name = 'Michael'), (SELECT id from dietary_restriction_type where name = 'Vegetarian'))
INSERT INTO diner_dietary_restriction (diner_id, dietary_restriction_type) VALUES ((SELECT id from diner where name = 'George Michael'), (SELECT id from dietary_restriction_type where name = 'Vegetarian'))
INSERT INTO diner_dietary_restriction (diner_id, dietary_restriction_type) VALUES ((SELECT id from diner where name = 'George Michael'), (SELECT id from dietary_restriction_type where name = 'Gluten-Free'))
INSERT INTO diner_dietary_restriction (diner_id, dietary_restriction_type) VALUES ((SELECT id from diner where name = 'Lucile'), (SELECT id from dietary_restriction_type where name = 'Gluten-Free'))
INSERT INTO diner_dietary_restriction (diner_id, dietary_restriction_type) VALUES ((SELECT id from diner where name = 'Gob'), (SELECT id from dietary_restriction_type where name = 'Paleo'))
INSERT INTO diner_dietary_restriction (diner_id, dietary_restriction_type) VALUES ((SELECT id from diner where name = 'Maeby'), (SELECT id from dietary_restriction_type where name = 'Vegan'))


INSERT INTO restaurant_dietary_endorsement (restaurant_id, dietary_restriction_type) VALUES ((SELECT id from restaurant where name = 'Lardo'), (SELECT id from dietary_restriction_type where name = 'Gluten-Free'))
INSERT INTO restaurant_dietary_endorsement (restaurant_id, dietary_restriction_type) VALUES ((SELECT id from restaurant where name = 'Panadería Rosetta'), (SELECT id from dietary_restriction_type where name = 'Gluten-Free'))
INSERT INTO restaurant_dietary_endorsement (restaurant_id, dietary_restriction_type) VALUES ((SELECT id from restaurant where name = 'Panadería Rosetta'), (SELECT id from dietary_restriction_type where name = 'Vegetarian'))
INSERT INTO restaurant_dietary_endorsement (restaurant_id, dietary_restriction_type) VALUES ((SELECT id from restaurant where name = 'Tetetlán'), (SELECT id from dietary_restriction_type where name = 'Paleo'))
INSERT INTO restaurant_dietary_endorsement (restaurant_id, dietary_restriction_type) VALUES ((SELECT id from restaurant where name = 'Tetetlán'), (SELECT id from dietary_restriction_type where name = 'Gluten-Free'))
INSERT INTO restaurant_dietary_endorsement (restaurant_id, dietary_restriction_type) VALUES ((SELECT id from restaurant where name = 'u.to.pi.a'), (SELECT id from dietary_restriction_type where name = 'Vegan'))
INSERT INTO restaurant_dietary_endorsement (restaurant_id, dietary_restriction_type) VALUES ((SELECT id from restaurant where name = 'u.to.pi.a'), (SELECT id from dietary_restriction_type where name = 'Vegetarian'))


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
