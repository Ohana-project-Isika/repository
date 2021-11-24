#  NB: DO NOT USE SQL COMMAND-LIKE NAMES FOR COLUMNS OR TABLES
#      PREFER @GeneratedValue(strategy = GenerationType.IDENTITY) TO @GeneratedValue(strategy = GenerationType.AUTO)
#      BECAUSE PRIMARY KEY DOES NOT HAVE A DEFAULT VALUE WITH THE LATTER WHILE IT DOES WITH THE FORMER

 USE `ohana-database`;
#COMMON----------------------------------------------------------------------------------------------------
#ADDRESS TABLE
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (1, 'Avenue Jean Jaurès', '93300', 'Aubervilliers', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (2, 'Allée de Vanteaux', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (3, 'Allée Isika', '87000', 'Limoges', 'France');
 
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (111, 'Avenue Jean Jaurès', '93300', 'Aubervilliers', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (122, 'Allée de Vanteaux', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (133, 'Allée Isika', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (144, 'Avenue Jean Jaurès', '93300', 'Aubervilliers', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (155, 'Allée de Vanteaux', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (166, 'Allée Isika', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (177, 'Allée Isika', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (188, 'Avenue Jean Jaurès', '93300', 'Aubervilliers', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (199, 'Allée de Vanteaux', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (110, 'Allée Isika', '87000', 'Limoges', 'France');
 
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (4, 'Rue de la mairie', '94400', 'Vitry-sur-seine', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (5, 'Avenue Jean Jaures', '92100', 'Boulogne-Billancourt', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (6, 'Boulevard Rosa Luxembourg', '75017', 'Paris', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (10, 'Avenue frédéric mistra', '30220', 'Aigues mortes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (11, 'rue saint placide', '75006', 'paris', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (12, 'rue de gometz', '91470', 'Les Molières', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (7, '11 rue Jean-Jacques Henner', '68130', 'Altkirch', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (8, 'rue Georges Clémenceau', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (9, 'route de Verdun', '21200', 'BEAUNE', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (16, 'rue de gometz', '91470', 'Les Molières', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (11, 'rue Jean-Jacques Henner', '68130', 'Altkirch', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (9, 'rue Georges Clémenceau', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (13, 'rue Georges Clémenceau', '06600', 'Antibes', 'France');

 
#CONTACT TABLE
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0111111111','0611111111','contact01@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0122222222','0622222222','contact02@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0133333333','0633333333','contact03@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0144444444','0644444444','contact04@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0155555555','0655555555','contact05@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0166666666','0666666666','contact06@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0111111111','0611111111','contact07@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0122222222','0622222222','contact08@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0133333333','0633333333','contact09@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0144444444','0644444444','contact10@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0155555555','0655555555','contact11@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0166666666','0666666666','contact12@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0166666666','0666666666','contact13@gmail.com');

 #INFOPERSON TABLE
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomun', 'prenomun', '1981-01-01',(SELECT idContact FROM contact WHERE email = 'contact01@gmail.com'), 14);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomdeux', 'prenomdeux', '1982-02-17', (SELECT idContact FROM contact WHERE email = 'contact02@gmail.com'), 15);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomtrois', 'prenomtrois', '1983-03-01', (SELECT idContact FROM contact WHERE email = 'contact03@gmail.com'), 16);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomquatre', 'prenomquatre', '1984-04-01', (SELECT idContact FROM contact WHERE email = 'contact04@gmail.com'), 17);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomcinq', 'prenomcinq', '1985-05-01', (SELECT idContact FROM contact WHERE email = 'contact05@gmail.com'), 18);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomsix', 'prenomsix', '1986-06-01', (SELECT idContact FROM contact WHERE email = 'contact06@gmail.com'), 19);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomsept', 'prenomsept', '1987-07-01',(SELECT idContact FROM contact WHERE email = 'contact07@gmail.com'), 20);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomhuit', 'prenomhuit', '1988-08-17', (SELECT idContact FROM contact WHERE email = 'contact08@gmail.com'), 21);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomneuf', 'prenomneuf', '1989-09-01', (SELECT idContact FROM contact WHERE email = 'contact09@gmail.com'), 22);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomdix', 'prenomdix', '1970-10-01', (SELECT idContact FROM contact WHERE email = 'contact10@gmail.com'), 23);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomonze', 'prenomonze', '1981-11-01', (SELECT idContact FROM contact WHERE email = 'contact11@gmail.com'), 24);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomdouze', 'prenomdouze', '1972-12-01', (SELECT idContact FROM contact WHERE email = 'contact12@gmail.com'), 25);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('nomtreize', 'prenomtreize', '1972-12-13', (SELECT idContact FROM contact WHERE email = 'contact13@gmail.com'), 26);
 
 #ACCOUNT TABLE
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('admin', '1111','ADMIN','2021-01-01',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomun'));
 
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('aapeec', '1111', 'ASSOCIATION','2021-01-01',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomdeux'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('actionSolidairePartage', '1111', 'ASSOCIATION','2021-01-02',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomtrois'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('AEJBM', '1111', 'ASSOCIATION','2021-01-03',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomquatre'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('efa', '1111', 'ASSOCIATION','2021-01-04',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomsix'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('enfanceEtPartage', '1111', 'ASSOCIATION','2021-01-05',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomsept'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('laVoixDeLEnfant', '1111', 'ASSOCIATION','2021-01-06',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomhuit'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('paroleDEnfant', '1111', 'ASSOCIATION','2021-01-07',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomneuf'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('Reves', '1111', 'ASSOCIATION','2021-01-08',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomdix'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('terreDesEnfants', '1111', 'ASSOCIATION','2021-01-09',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomonze'));
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('unEnfantDesSourires', '1111', 'ASSOCIATION','2021-01-10',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomdouze'));
 
 INSERT INTO Account (accountLogin, accountPassword, role, accountCreationDate, INFOPERSON_ID) VALUES ('particulier', '1111', 'PRIVATEPERSON','2021-01-01',(SELECT idInfoPers FROM infoperson WHERE lastName = 'nomtreize'));

 
 #ADMIN TABLE
 INSERT INTO Admin (ACCOUNT_ID) VALUES ((SELECT idAccount FROM account WHERE accountLogin = 'admin'));

 #SERVICE TABLE
 INSERT INTO Services(typeOfSub, priceOfSub) VALUES ('premium', 49);

# TICKETING TABLE
INSERT INTO ticketing (ticketing_name) VALUES ('billeterie');
INSERT INTO ticketing (ticketing_name) VALUES ('Je sais pas');
INSERT INTO ticketing (ticketing_name) VALUES ('Emmanuel');
INSERT INTO ticketing (ticketing_name) VALUES ('Jason');
INSERT INTO ticketing (ticketing_name) VALUES ('Vina');
INSERT INTO ticketing (ticketing_name) VALUES ('Jordan');
INSERT INTO ticketing (ticketing_name) VALUES ('Félicitations Jordan !');
INSERT INTO ticketing (ticketing_name) VALUES ('La billeterie du mardi soir');
INSERT INTO ticketing (ticketing_name) VALUES ('Je veux dormir');
INSERT INTO ticketing (ticketing_name) VALUES ('Besoin de vacances');

 #ASSOCIATION TABLE
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID, ticketing_id) VALUES ('aapeec', 'VALIDATED', '../resources/logoAssociation/aapeec.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 111),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'aapeec'),(SELECT ticketing_id FROM ticketing WHERE ticketing_name = 'billeterie'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID, ticketing_id) VALUES ('actionSolidairePartage', 'VALIDATED', '../resources/logoAssociation/actionSolidairePartage.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 122),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'actionSolidairePartage'), (SELECT ticketing_id FROM ticketing WHERE ticketing_name = 'Je sais pas'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID, ticketing_id) VALUES ('AEJBM', 'VALIDATED', '../resources/logoAssociation/AEJBM.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 133),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'AEJBM'), (SELECT ticketing_id FROM ticketing WHERE ticketing_name = 'Emmanuel'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID, ticketing_id) VALUES ('efa', 'VALIDATED', '../resources/logoAssociation/efa.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 144),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'efa'), (SELECT ticketing_id FROM ticketing WHERE ticketing_name = 'Jason'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID, ticketing_id) VALUES ('enfanceEtPartage', 'VALIDATED', '../resources/logoAssociation/enfanceEtPartage.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 155),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'enfanceEtPartage'), (SELECT ticketing_id FROM ticketing WHERE ticketing_name = 'Vina'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID, ticketing_id) VALUES ('laVoixDeLEnfant', 'VALIDATED', '../resources/logoAssociation/laVoixDeLEnfant.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 166),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'laVoixDeLEnfant'), (SELECT ticketing_id FROM ticketing WHERE ticketing_name = 'Jordan'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID, ticketing_id) VALUES ('paroleDEnfant', 'VALIDATED', '../resources/logoAssociation/paroleDEnfant.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 177),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'paroleDEnfant'), (SELECT ticketing_id FROM ticketing WHERE ticketing_name = 'Félicitations Jordan !'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID, ticketing_id) VALUES ('Reves', 'VALIDATED', '../resources/logoAssociation/Reves.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 188),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'Reves'), (SELECT ticketing_id FROM ticketing WHERE ticketing_name = 'La billeterie du mardi soir'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID, ticketing_id) VALUES ('terreDesEnfants', 'VALIDATED', '../resources/logoAssociation/terreDesEnfants.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 199),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'terreDesEnfants'), (SELECT ticketing_id FROM ticketing WHERE ticketing_name = 'Je veux dormir'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID, ticketing_id) VALUES ('unEnfantDesSourires', 'VALIDATED', '../resources/logoAssociation/unEnfantDesSourires.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 110),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'unEnfantDesSourires'), (SELECT ticketing_id FROM ticketing WHERE ticketing_name = 'Besoin de vacances'));

 #PRIVATEPERSON TABLE
 INSERT INTO PrivatePerson(photoProfil, ACCOUNT_ID ) VALUES ('photo1',(SELECT idAccount FROM account WHERE accountLogin = 'particulier'));
 
 #MEMBERSHIPMANAGE TABLE
 INSERT INTO Membershipmanage(ASSOCIATION_ID) VALUES (1);
 
 #MEMBERSHIP TABLE
 INSERT INTO Membership(nameMbs, priceOfFee, MEMBERSHIPMANAGE_ID) VALUES ('adhesion1', 20.00, 1);
 INSERT INTO Membership(nameMbs, priceOfFee, MEMBERSHIPMANAGE_ID) VALUES ('adhesion1', 30.00, 1);
 INSERT INTO Membership(nameMbs, priceOfFee, MEMBERSHIPMANAGE_ID) VALUES ('adhesion1', 40.00, 1);
 
 #MEMBER TABLE
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact14@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact15@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact16@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact17@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact18@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact19@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact20@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact21@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact22@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact23@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact24@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact25@gmail.com','0177777777', '0277777777');
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact26@gmail.com','0177777777', '0277777777');
 
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (14, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (15, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (16, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (17, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (18, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (19, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (20, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (21, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (22, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (23, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (24, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (25, 'rue Georges Member', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (26, 'rue Georges Member', '06600', 'Antibes', 'France');
 
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-14', 'tato', 'ziti', 27, 14);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-15', 'teto', 'yiti', 28, 15);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-16', 'tito', 'titi', 29, 16);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-17', 'toto', 'siti', 30, 17);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-18', 'tuto', 'riti', 31, 18);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-19', 'boto', 'viti', 32, 19);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-20', 'bato', 'witi', 33, 20);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-21', 'beto', 'liti', 34, 21);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-22', 'bito', 'miti', 35, 22);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-23', 'buto', 'niti', 36, 23);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-24', 'coto', 'citi', 37, 24);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-25', 'cato', 'giti', 38, 25);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-26', 'cito', 'hiti', 39, 26);
 
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'aa','0000', 'PRIVATEPERSON', 14);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'bb', '0000','PRIVATEPERSON', 15);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'cc', '0000','PRIVATEPERSON', 16);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'dd', '0000','PRIVATEPERSON', 17);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'ee', '0000','PRIVATEPERSON', 18);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'ff', '0000','PRIVATEPERSON', 19);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'gg', '0000','PRIVATEPERSON', 20);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'hh', '0000','PRIVATEPERSON', 21);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'ii', '0000','PRIVATEPERSON', 22);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'jj', '0000','PRIVATEPERSON', 23);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'kk', '0000','PRIVATEPERSON', 24);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'll', '0000','PRIVATEPERSON', 25);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'mm', '0000','PRIVATEPERSON', 26);


 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 13);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 14);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 15);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 16);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 17);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 18);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 19);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 20);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 21);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 22);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 23);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 24);
 INSERT INTO Privateperson(photoProfil, ACCOUNT_ID) VALUE ('photo', 25);

 

 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 1, 3);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 1, 4);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 1, 5);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 1, 6);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 2, 7);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 2, 8);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 2, 9);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 2, 10);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 3, 11);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 3, 12);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 3, 13);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-21', '2021-11-21', 3, 14);
 
 #PAIEMENT TABLE
 INSERT INTO Paiement(paymentRef, validated, paymentDate, ACCOUNT_ID) VALUES ('Ref1', 1, '2021-01-01', (SELECT idAccount FROM account WHERE accountLogin = 'particulier'));

#EVENT---------------------------------------------------------------------------------------------------------------------------

# TICKETING TABLE
INSERT INTO ticketing (ticketing_name, association_idAssos) VALUES ('ticketing', (SELECT idAssos FROM association WHERE nameAssos = 'aapeec'));

# EVENT TABLE
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('background_childhood_event.jpg', 'Les Enfants d\'abord', 'Contre la maltraitance des enfants', '2022-01-01', '2022-01-01', '12:00', '05:00', (SELECT idAddress FROM Address WHERE numRue = 2), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('background_childhood_event.jpg', 'Ohana Kids', 'Gâtons nos enfants', '2021-12-01', '2021-12-01', '11:00', '05:00', (SELECT idAddress FROM Address WHERE numRue = 1), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('background_childhood_event.jpg', 'Sauvons les enfants', 'Contre la guerre', '2022-01-01', '2022-01-01', '12:00', '05:00', (SELECT idAddress FROM Address WHERE numRue = 7), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('background_childhood_event.jpg', 'Une famille, un enfant', 'Mieux que l\'orphelinat', '2022-01-01', '2022-01-01', '12:00', '05:00', (SELECT idAddress FROM Address WHERE numRue = 10), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('background_childhood_event.jpg', 'Comment garder nos enfants près de nous', 'Actions des parents que les enfants adorent', '2022-01-01', '2022-01-01', '12:00', '05:00', (SELECT idAddress FROM Address WHERE numRue = 8), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('background_childhood_event.jpg', 'Bien éduquer ses enfants', 'Education', '2022-01-01', '2022-01-01', '12:00', '05:00', (SELECT idAddress FROM Address WHERE numRue = 3), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('background_childhood_event.jpg', 'Jeux, danse', 'Divertissements pour enfants', '2022-01-01', '2022-01-01', '12:00', '05:00', (SELECT idAddress FROM Address WHERE numRue = 13), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('background_childhood_event.jpg', 'A l\'école', 'Contre la violence à l\'école', '2022-01-01', '2022-01-01', '12:00', '05:00', (SELECT idAddress FROM Address WHERE numRue = 8), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('background_childhood_event.jpg', 'Enfants, mirroir de la société', 'Enfants et société', '2022-01-01', '2022-01-01', '12:00', '05:00', (SELECT idAddress FROM Address WHERE numRue = 2), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));
INSERT INTO event (image_file_name, event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress, ticketing_id) VALUES ('background_childhood_event.jpg', 'Ne grandissons pas vite', 'Fait par des enfants pour des enfants', '2022-01-01', '2022-01-01', '12:00', '05:00', (SELECT idAddress FROM Address WHERE numRue = 13), (SELECT id FROM ticketing WHERE ticketing_name = 'ticketing'));

# TICKET TABLE
INSERT INTO ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'Les Enfants d\'abord'), 'REDUCED1', 'METROPOLITAN', 20);
INSERT INTO ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'Ohana Kids'), 'REDUCED1', 'METROPOLITAN', 10);
INSERT INTO ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'Ohana Kids'), 'REDUCED1', 'METROPOLITAN', 10);
