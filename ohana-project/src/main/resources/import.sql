-- NB: DO NOT USE SQL COMMAND-LIKE NAMES FOR COLUMNS OR TABLES
--     PREFER @GeneratedValue(strategy = GenerationType.IDENTITY) TO @GeneratedValue(strategy = GenerationType.AUTO)
--     BECAUSE PRIMARY KEY DOES NOT HAVE A DEFAULT VALUE WITH THE LATTER WHILE IT DOES WITH THE FORMER

-- ADDRESS TABLE
INSERT INTO Address (city, department, streetNumber, street) VALUES ('Aubervilliers', '93', 192, 'Avenue Jean Jaurès');
INSERT INTO Address (city, department, streetNumber, street) VALUES ('Limoges', '87', 20, 'Allée de Vanteaux');


-- EVENT TABLE
INSERT INTO Event (eventName, description, startDate, address_id) VALUES ('nnnnnn', 'ffffffffffffffffffff', now(), (SELECT id FROM Address WHERE city = 'Aubervilliers' AND department = '93' AND streetNumber = 192 AND street = 'Avenue Jean Jaurès'));
INSERT INTO Event (eventName, description, startDate) VALUES ('gggggg', 'rrrrrrrrrrrrrrrrrrrr', now());

-- TICKET TABLE
INSERT INTO Ticket (event_id) VALUES ((SELECT id FROM Event WHERE eventName = 'nnnnnn'));
INSERT INTO Ticket (event_id) VALUES ((SELECT id FROM Event WHERE eventName = 'gggggg'));
