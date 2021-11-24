#  NB: DO NOT USE SQL COMMAND-LIKE NAMES FOR COLUMNS OR TABLES
#      PREFER @GeneratedValue(strategy = GenerationType.IDENTITY) TO @GeneratedValue(strategy = GenerationType.AUTO)
#      BECAUSE PRIMARY KEY DOES NOT HAVE A DEFAULT VALUE WITH THE LATTER WHILE IT DOES WITH THE FORMER

 USE `ohana-database`;
# COMMON----------------------------------------------------------------------------------------------------
# ADDRESS TABLE
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (1, 'avenue Margaret Hamilton', '93300', 'Aubervilliers', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (2, 'allée Ada Lovelace', '17000', 'La Rochelle', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (3, 'boulevard Turing', '87000', 'Limoges', 'France');
 
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (111, 'avenue Ada Lovelace', '93300', 'Aubervilliers', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (122, 'allée Hedy Lamarr', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (133, 'boulevard Turing', '87000', 'Limoges', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (144, 'avenue Anne-Marie Kermarrec', '35000', 'Rennes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (155, 'place Alice Recoque', '92060', 'La Défense', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (166, 'avenue Joëlle Coutaz', '38000', 'Grenoble', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (177, 'allée Ekaterina Samoutsevitch', '87000', 'Russels', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (188, 'rue Catherine Plaisant', '93300', 'Aubervilliers', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (199, 'allée Fleur Pellerin', '44000', 'Pellerin', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (110, 'place Véronique Plateau', '38000', 'Voiron', 'France');
 
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (4, 'rue de la Mairie', '94400', 'Vitry-sur-seine', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (5, 'avenue Brigitte Plateau', '92100', 'Boulogne-Billancourt', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (6, 'boulevard Rosa Luxembourg', '75017', 'Paris', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (10, 'avenue Frédéric mistra', '30220', 'Aigues mortes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (11, 'rue Saint-Placide', '75006', 'paris', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (12, 'rue de Gometz', '91470', 'Les Molières', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (7, 'rue Jean-Jacques Henner', '68130', 'Altkirch', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (8, 'rue Joan Clarke', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (3, 'route Christine Paulin', '21200', 'BEAUNE', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (16, 'rue Joëlle Coutaz', '91470', 'Les Molières', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (11, 'rue Jean-Jacques Henner', '68130', 'Altkirch', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (8, 'rue Alice Recoque', '06600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (13, 'rue Grace Hopper', '06600', 'Antibes', 'France');

 
# CONTACT TABLE
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0111111111','0611111111','contactasso@coutaz.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0222222222','0622222222','contact02@free.org');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0333333333','0633333333','contact03@free.fr');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0444444444','0644444444','contact04@laposte.net');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0555555555','0655555555','contact05@gmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0566666666','0666666666','contact06@gmail.es');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0411111111','0711111111','contact07@qq.cn');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0322222222','0722222222','contact08@hotmail.com');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0233333333','0733333333','contact09@laposte.net');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0144444444','0744444444','contact10@free.fr');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0255555555','0755555555','contact11@gfree.fr');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0366666666','0766666666','contact12@free.fr');
INSERT INTO Contact(phoneNb, phoneNb2, email) VALUES ('0466666666','0766666667','contact13@laposte.net');

 # INFOPERSON TABLE
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Lavie', 'Idola', '1981-01-01',(SELECT idContact FROM contact WHERE email = 'contact01@gmail.com'), 14);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Nestpas', 'Vilani', '1982-02-17', (SELECT idContact FROM contact WHERE email = 'Nestpasvilani@free.fr'), 15);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Hun', 'Tiago', '1983-03-01', (SELECT idContact FROM contact WHERE email = 'contact03@free.fr'), 16);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Longfleuve', 'Louisa', '1984-04-01', (SELECT idContact FROM contact WHERE email = 'contact04@free.fr'), 17);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Tranquille', 'Lorine', '1985-05-01', (SELECT idContact FROM contact WHERE email = 'contact05@gmail.com'), 18);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Cedans', 'Abda', '1986-06-01', (SELECT idContact FROM contact WHERE email = 'contact06@gmail.com'), 19);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Lepreuve', 'Nils', '1987-07-01',(SELECT idContact FROM contact WHERE email = 'contact07@hotmail.com'), 20);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Quelon', 'Sophie', '1988-08-17', (SELECT idContact FROM contact WHERE email = 'quelonsait@gmail.org'), 21);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Prograisse', 'Beta', '1989-09-01', (SELECT idContact FROM contact WHERE email = 'prgraisse@laposte.net'), 22);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Phoulong', 'Lao', '1970-10-01', (SELECT idContact FROM contact WHERE email = 'contact10@gmail.com'), 23);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Amiens', 'Jordan', '1981-11-01', (SELECT idContact FROM contact WHERE email = 'contact11@gmail.com'), 24);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Rennes', 'Vina', '1972-12-01', (SELECT idContact FROM contact WHERE email = 'contact12@gmail.com'), 25);
 INSERT INTO Infoperson (lastName, firstName, dateOfBirth, CONTACT_ID, ADDRESS_ID) VALUES ('Lorraine', 'Eugène', '1972-12-13', (SELECT idContact FROM contact WHERE email = 'contact13@gmail.com'), 26);
 
 # ACCOUNT TABLE
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

 
 # ADMIN TABLE
 INSERT INTO Admin (ACCOUNT_ID) VALUES ((SELECT idAccount FROM account WHERE accountLogin = 'admin'));

 # SERVICE TABLE
 INSERT INTO Services(typeOfSub, priceOfSub) VALUES ('premium', 49);
 
 # ASSOCIATION TABLE
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('aapeec', 'VALIDATED', '../resources/logoAssociation/aapeec.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 111),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'aapeec'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('actionSolidairePartage', 'VALIDATED', '../resources/logoAssociation/actionSolidairePartage.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 122),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'actionSolidairePartage'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('AEJBM', 'VALIDATED', '../resources/logoAssociation/AEJBM.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 133),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'AEJBM'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('efa', 'VALIDATED', '../resources/logoAssociation/efa.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 144),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'efa'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('enfanceEtPartage', 'VALIDATED', '../resources/logoAssociation/enfanceEtPartage.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 155),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'enfanceEtPartage'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('laVoixDeLEnfant', 'VALIDATED', '../resources/logoAssociation/laVoixDeLEnfant.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 166),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'laVoixDeLEnfant'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('paroleDEnfant', 'VALIDATED', '../resources/logoAssociation/paroleDEnfant.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 177),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'paroleDEnfant'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('Reves', 'VALIDATED', '../resources/logoAssociation/Reves.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 188),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'Reves'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('terreDesEnfants', 'VALIDATED', '../resources/logoAssociation/terreDesEnfants.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 199),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'terreDesEnfants'));
 INSERT INTO Association(nameAssos, validateStatusAsso, logoAsso, justifAsso, numSiret, ADDRESS_ID, SERVICES_ID, ACCOUNT_ID) VALUES ('unEnfantDesSourires', 'VALIDATED', '../resources/logoAssociation/unEnfantDesSourires.jpg', 'justif1', '111111111111111',(SELECT idAddress FROM address WHERE numRue = 110),(SELECT idServices FROM services WHERE typeOfSub = 'premium'),(SELECT idAccount FROM account WHERE accountLogin = 'unEnfantDesSourires'));

 # PRIVATEPERSON TABLE
 INSERT INTO PrivatePerson(photoProfil, ACCOUNT_ID ) VALUES ('photo1',(SELECT idAccount FROM account WHERE accountLogin = 'particulier'));
 
 # MEMBERSHIPMANAGE TABLE
 INSERT INTO Membershipmanage(ASSOCIATION_ID) VALUES (1);
 
 # MEMBERSHIP TABLE
 INSERT INTO Membership(nameMbs, priceOfFee, MEMBERSHIPMANAGE_ID) VALUES ('Lavie', 20.00, 1);
 INSERT INTO Membership(nameMbs, priceOfFee, MEMBERSHIPMANAGE_ID) VALUES ('Joyeux', 30.00, 1);
 INSERT INTO Membership(nameMbs, priceOfFee, MEMBERSHIPMANAGE_ID) VALUES ('Infante', 40.00, 1);
 
 # MEMBER TABLE
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact14@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact15@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact16@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact17@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact18@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact19@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact20@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact21@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact22@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact23@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact24@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact25@gmail.com','0177777777', '0277777777')
 INSERT INTO Contact(email, phoneNb, phoneNb2) VALUES ('contact26@gmail.com','0177777777', '0277777777')
 
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (14, 'rue Joelle Coutaz', '06460', 'Caussols', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (15, 'rue Véronique Cortier', '07600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (16, 'rue Marie-Paule Cani', '08600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (17, 'rue Alice Recoque', '09600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (18, 'place Alice Recoque', '10600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (19, 'rue Anne-Marie Kermarrec', '11600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (20, 'rue Georges Member', '12600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (21, 'rue Georges Member', '13600', 'Marseille', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (22, 'rue de la Paix', '14000', 'Caen', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (23, 'place de la Gare', '15600', 'Antibes', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (24, 'allée Fleur Pellerin', '31000', 'Toulouse', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (25, 'rue Véronique Plateau', '33000', 'Bordeaux', 'France');
 INSERT INTO Address (numRue, rue, codePostal, ville, pays) VALUES (26, 'rue Véronique Plateau', '64000', 'Pau', 'France');
 
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-01-14', 'Tato', 'Zitine', 27, 14);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2002-01-15', 'Treto', 'Yital', 28, 15);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2003-01-16', 'Triton', 'Aymen', 29, 16);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-03-17', 'Lotoun', 'ALpha', 30, 17);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-04-18', 'Lutoni', 'Maria', 31, 18);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-05-19', 'Boton', 'ALphan', 32, 19);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-06-20', 'Palato', 'Dominique', 33, 20);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-07-21', 'Betan', 'Martin', 34, 21);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-08-22', 'Cito', 'Martin', 35, 22);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-09-23', 'Clone', 'Mariane', 36, 23);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-10-24', 'Clamp', 'Dominique', 37, 24);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-11-25', 'Roux', 'Jasmine', 38, 25);
 INSERT INTO Infoperson(dateOfBirth, firstName, lastName, ADDRESS_ID, CONTACT_ID) VALUES ('2001-10-26', 'Klein', 'Jasmin', 39, 26);
 
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'tktcamarche','0000', 'PRIVATEPERSON', 14);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-22', 'bonjourvilani', '0000','PRIVATEPERSON', 15);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-22', 'chiffre13', '0000','PRIVATEPERSON', 16);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'debutant', '0000','PRIVATEPERSON', 17);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-23', 'equivalent', '0000','PRIVATEPERSON', 18);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'fincda', '0000','PRIVATEPERSON', 19);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-22', 'gagne', '0000','PRIVATEPERSON', 20);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'harmonie', '0000','PRIVATEPERSON', 21);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-22', 'idealement', '0000','PRIVATEPERSON', 22);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'joyeusement', '0000','PRIVATEPERSON', 23);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-23', 'karma6', '0000','PRIVATEPERSON', 24);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-21', 'liberation!', '0000','PRIVATEPERSON', 25);
 INSERT INTO Account(accountCreationDate, accountLogin, accountPassword, role, INFOPERSON_ID) VALUE ('2021-11-22', 'Amere2', '0000','PRIVATEPERSON', 26);
 
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
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-20', '2021-11-21', 1, 4);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-20', '2021-11-21', 1, 5);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-20', '2021-11-21', 1, 6);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-20', '2021-11-21', 2, 7);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-20', '2021-11-21', 2, 8);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-20', '2021-11-21', 2, 9);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-20', '2021-11-21', 2, 10);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-20', '2021-11-21', 3, 11);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-20', '2021-11-21', 3, 12);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-22', '2021-11-23', 3, 13);
 INSERT INTO Member(dateOfEnd, dateOfStart, MEMBERSHIP_ID, PRIVATEPERSON_ID) VALUE ('2022-11-22', '2021-11-23', 3, 14);
 
 
# PAIEMENT TABLE
 INSERT INTO Paiement(paymentRef, validated, paymentDate, ACCOUNT_ID) VALUES ('Ref1', 1, '2021-01-01', (SELECT idAccount FROM account WHERE accountLogin = 'particulier'));

# EVENT---------------------------------------------------------------------------------------------------------------------------
# EVENT TABLE
INSERT INTO Event (event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress) VALUES ('nnnnnn', 'ffffffffffffffffffff', curdate(), '2022-01-01', curtime(), '05:00:00', (SELECT idAddress FROM Address WHERE numRue = 1));
INSERT INTO Event (event_name, event_description, start_date, end_date, start_time, end_time, address_idAddress) VALUES ('gggggg', 'rrrrrrrrrrrrrrrrrrrr', curdate(), '2022-01-01', curtime(), '05:00:00', (SELECT idAddress FROM Address WHERE numRue = 2));

# TICKET TABLE
INSERT INTO Ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'gggggg'), 'REDUCED1', 'METROPOLITAN', 20);
INSERT INTO Ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'nnnnnn'), 'REDUCED1', 'METROPOLITAN', 10);
INSERT INTO Ticket (event_id, rate_type, applied_TVA, pre_tax_price) VALUES ((SELECT id FROM Event WHERE event_name = 'nnnnnn'), 'REDUCED1', 'METROPOLITAN', 10);



# PROJECT TABLE
INSERT INTO project (name, financialGoal, startDate, endDate, description, ASSOCIATION_ID) VALUES ('Architecture JEE', 500000,'2022-12-05', '2022-03-05', 
'Il fut un temps, nous étions en avance. Aujourd’hui, l’informatique facilite beaucoup plus la gestion d’une association ainsi que sa visibilité. Seulement voilà, nous sommes une association et nous avons consacré tous nos fonds à nos actions sur le terrain.
…  et nos fonds dépendent grandement de la générosité de chacun pour pouvoir préserver au mieux notre autonomie et notre innovation en termes d’actions auprès des adolescents.
', 1);
INSERT INTO project (name, financialGoal, startDate, endDate, description, ASSOCIATION_ID) VALUES ('Un clown dans ma chambre', 70000,'2021-12-01', '2022-03-03', 
'À côté des psychologues et des psychiatres qui tentent de soigner par la parole et l’écoute, les clowns agissent, par le jeu, en véritable contre-pied à cette forme de souffrance.', 2);
INSERT INTO project (name, financialGoal, startDate, endDate, description, ASSOCIATION_ID) VALUES ('Mon cahier pour en parler', 10000,'2021-08-15', '2022-01-01', 
'Bien souvent l\'entourage est démuni : que dire aux enfants ? Comment parler de la mort avec eux et les accompagner au mieux ? Dans le contexte actuel qui nous confronte sans cesse à la mort, ce cahier proposé gratuitement est d\'autant plus utile et nécessaire.', 3);
INSERT INTO project (name, financialGoal, startDate, endDate, description, ASSOCIATION_ID) VALUES ('Le lieu-dit', 150000,'2021-11-26', '2021-12-26', 
'La France est multiculturelle. La gastronomie française est étendue. Mais de quelle cuisine parlons-nous exactement ?
Quoi de mieux qu’initier les enfants aux cuisines françaises venues du monde entier en créant un lieu unique d’ateliers de cuisine et de restauration pour petits … et grands', 4); 
 
', 4);