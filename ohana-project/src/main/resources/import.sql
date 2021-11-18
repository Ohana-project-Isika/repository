#  NB: DO NOT USE SQL COMMAND-LIKE NAMES FOR COLUMNS OR TABLES
#      PREFER @GeneratedValue(strategy = GenerationType.IDENTITY) TO @GeneratedValue(strategy = GenerationType.AUTO)
#      BECAUSE PRIMARY KEY DOES NOT HAVE A DEFAULT VALUE WITH THE LATTER WHILE IT DOES WITH THE FORMER

USE `ohana-database`;

# ADDRESS TABLE
INSERT INTO address (numRue, rue, codePostal, ville, pays) VALUES (193, 'Avenue Jean Jaurès', '93300', 'Aubervilliers', 'France');
INSERT INTO address (numRue, rue, codePostal, ville, pays) VALUES (20, 'Allée de Vanteaux', '87000', 'Limoges', 'France');
INSERT INTO address (numRue, rue, codePostal, ville, pays) VALUES (20, 'Alee Isika', '69000', 'Lyon', 'France');

# PERSON INFO TABLE
INSERT INTO personinfo (lastName, firstName) VALUES ('ViNaMaJaJo', 'Gaga');

# INDIVIDUAL TABLE
INSERT INTO individual (firstName) VALUES ('Manu');

# CONTACT TABLE
INSERT INTO contact (phoneNb, phoneNb2, email, personInfo_idPersInfo) VALUES ('fdsff', 'dfdds', 'qsdfsdffqsd', (SELECT id FROM individual WHERE firstName = 'Manu'));

# ROLE TABLE
INSERT INTO role (role) VALUES (1);

# ASSOCIATION TABLE
INSERT INTO association (nameAssos, addressAsso_idAddress, role_idRole) VALUES ('assoce', (SELECT idAddress FROM address WHERE ville = 'Lyon'), (SELECT idRole FROM role WHERE role = 1));

# TICKETING TABLE
INSERT INTO ticketing (ticketing_name, association_idAssos) VALUES ('ticketing', (SELECT idAssos FROM association WHERE role_idRole = 1));

# EVENT TABLE
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('childbackground.jpg', 'Les Enfants d"abord', 'Contre la maltraitance des enfants', curdate(), '2022-01-01', '12:00', '05:00', (SELECT idAddress FROM Address WHERE ville = 'Aubervilliers'), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress) VALUES ('childhood.png', 'Ohana Kids', 'Gâtons nos enfants', curdate(), '2022-01-01', '11:00', '05:00', (SELECT idAddress FROM Address WHERE ville = 'Limoges'));

# TICKET TABLE
INSERT INTO ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'Les Enfants d"abord'), 'REDUCED1', 'METROPOLITAN', 20);
INSERT INTO ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'Ohana Kids'), 'REDUCED1', 'METROPOLITAN', 10);
INSERT INTO ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'Ohana Kids'), 'REDUCED1', 'METROPOLITAN', 10);

# ACCOUNT TABLE
INSERT INTO account (accountLogin, accountPassword) VALUES ('test', 'test');
