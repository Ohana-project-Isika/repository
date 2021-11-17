#  NB: DO NOT USE SQL COMMAND-LIKE NAMES FOR COLUMNS OR TABLES
#      PREFER @GeneratedValue(strategy = GenerationType.IDENTITY) TO @GeneratedValue(strategy = GenerationType.AUTO)
#      BECAUSE PRIMARY KEY DOES NOT HAVE A DEFAULT VALUE WITH THE LATTER WHILE IT DOES WITH THE FORMER

USE `ohana-database`;

# ADDRESS TABLE
INSERT INTO Address (street_number, suffix, street_name, street_complement, postcode, city) VALUES (193, 'TER', 'Avenue Jean Jaurès', '', '93300', 'Aubervilliers');
INSERT INTO Address (street_number, suffix, street_name, street_complement, postcode, city) VALUES (20, 'BIS', 'Allée de Vanteaux', '', '87000', 'Limoges');

# EVENT TABLE
INSERT INTO Event (event_name, event_description, start_date, end_date, start_time, end_time, address_id) VALUES ('nnnnnn', 'ffffffffffffffffffff', curdate(), '2022-01-01', curtime(), '05:00:00', (SELECT id FROM Address WHERE city = 'Aubervilliers'));
INSERT INTO Event (event_name, event_description, start_date, end_date, start_time, end_time, address_id) VALUES ('gggggg', 'rrrrrrrrrrrrrrrrrrrr', curdate(), '2022-01-01', curtime(), '05:00:00', (SELECT id FROM Address WHERE city = 'Limoges'));

# TICKET TABLE
INSERT INTO Ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'gggggg'), 'REDUCED1', 'METROPOLITAN', 20);
INSERT INTO Ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'nnnnnn'), 'REDUCED1', 'METROPOLITAN', 10);
INSERT INTO Ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'nnnnnn'), 'REDUCED1', 'METROPOLITAN', 10);
