#  NB: DO NOT USE SQL COMMAND-LIKE NAMES FOR COLUMNS OR TABLES
#      PREFER @GeneratedValue(strategy = GenerationType.IDENTITY) TO @GeneratedValue(strategy = GenerationType.AUTO)
#      BECAUSE PRIMARY KEY DOES NOT HAVE A DEFAULT VALUE WITH THE LATTER WHILE IT DOES WITH THE FORMER

 USE `ohana-database`;
#COMMON----------------------------------------------------------------------------------------------------
#ADDRESS TABLE
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (1, 'Avenue Jean Jaurès', '93300', 'Aubervilliers', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (2, 'Allée de Vanteaux', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (3, 'Allée Isika', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays, INFOPERSON_ID) VALUES (4, 'Rue de la mairie', '94400', 'Vitry-sur-seine', 'France', 1);
 INSERT INTO Address (numRue, rue, codePostal, ville, pays, INFOPERSON_ID) VALUES (5, 'Avenue Jean Jaures', '92100', 'Boulogne-Billancourt', 'France', 2);
 INSERT INTO Address (numRue, rue, codePostal, ville, pays, INFOPERSON_ID) VALUES (6, 'Boulevard Rosa Luxembourg', '75017', 'Paris', 'France', 3);
 
#CONTACT TABLE
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0111111111','0611111111','contact01@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0122222222','0622222222','contact02@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0133333333','0633333333','contact03@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0144444444','0644444444','contact04@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0155555555','0655555555','contact05@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0166666666','0666666666','contact06@gmail.com');

 #INFOPERSON TABLE
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID) VALUES ('nomun', 'prenomun', '1981-01-01',(SELECT idContact FROM contact WHERE email = 'contact01@gmail.com'));
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID) VALUES ('nomdeux', 'prenomdeux', '1982-02-17', (SELECT idContact FROM contact WHERE email = 'contact02@gmail.com'));
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID) VALUES ('nomtrois', 'prenomtrois', '1983-03-01', (SELECT idContact FROM contact WHERE email = 'contact03@gmail.com'));
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID) VALUES ('nomquatre', 'prenomquatre', '1984-04-01', (SELECT idContact FROM contact WHERE email = 'contact04@gmail.com'));
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID) VALUES ('nomcinq', 'prenomcinq', '1985-05-01', (SELECT idContact FROM contact WHERE email = 'contact05@gmail.com'));
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID) VALUES ('nomsix', 'prenomsix', '1986-06-01', (SELECT idContact FROM contact WHERE email = 'contact06@gmail.com'));
 
 #ACCOUNT TABLE
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('admin', '1111','ADMIN','2021-01-01',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomun'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('association', '1111', 'ASSOCIATION','2021-01-01',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomdeux'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('particulier', '1111', 'PARTICULIER','2021-01-01',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomtrois'));
 
 #ADMIN TABLE
 INSERT INTO Admin (ACCOUNT_ID) VALUES ((SELECT idAccount FROM account WHERE accountLogin = 'admin'));

 #SERVICE TABLE
 INSERT INTO Services(typeOfSub, priceOfSub) VALUES ('premium', 49);
 
 #ASSOCIATION TABLE
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('asso1', 'VALIDATED', 'logo1', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 4),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'association'));
 
 #PRIVATEPERSON TABLE
 INSERT INTO PrivatePerson(photoProfil, ACCOUNT_ID ) VALUES ('photo1',(SELECT idAccount FROM account WHERE accountLogin = 'particulier'));
 
 #PAIEMENT TABLE
 INSERT INTO Paiement(paymentRef, validated, paymentDate, ACCOUNT_ID) VALUES ('Ref1', 1, '2021-01-01', (SELECT idAccount FROM account WHERE accountLogin = 'particulier'));

#EVENT---------------------------------------------------------------------------------------------------------------------------
# EVENT TABLE
INSERT INTO Event (event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress) VALUES ('nnnnnn', 'ffffffffffffffffffff', curdate(), '2022-01-01', curtime(), '05:00:00', (SELECT idAddress FROM Address WHERE numRue = 1));
INSERT INTO Event (event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress) VALUES ('gggggg', 'rrrrrrrrrrrrrrrrrrrr', curdate(), '2022-01-01', curtime(), '05:00:00', (SELECT idAddress FROM Address WHERE numRue = 2));

# TICKET TABLE
INSERT INTO Ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'gggggg'), 'REDUCED1', 'METROPOLITAN', 20);
INSERT INTO Ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'nnnnnn'), 'REDUCED1', 'METROPOLITAN', 10);
INSERT INTO Ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'nnnnnn'), 'REDUCED1', 'METROPOLITAN', 10);


