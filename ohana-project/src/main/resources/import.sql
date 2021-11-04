-- NB: DO NOT USE SQL COMMAND-LIKE NAMES FOR COLUMNS OR TABLE
--     PREFER @GeneratedValue(strategy = GenerationType.IDENTITY) TO @GeneratedValue(strategy = GenerationType.AUTO)
--     BECAUSE PRIMARY KEY DOES NOT HAVE A DEFAULT VALUE WITH THE LATTER WHILE IT DOES WITH THE FORMER

-- ADDRESS TABLE
INSERT INTO Address (city, department, streetNumber, street) VALUES ('Aubervilliers', '93', 193, 'Avenue Jean Jaurès');


