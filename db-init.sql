SET GLOBAL time_zone = '+2:00';

INSERT INTO city VALUES('1', 'Craiova');
INSERT INTO city VALUES('2', 'Bucuresti');
INSERT INTO city VALUES('3', 'Cluj');
INSERT INTO city VALUES('4', 'Sibiu');

INSERT INTO brand VALUES('1', 'Dacia');
INSERT INTO brand VALUES('2', 'BMW');
INSERT INTO brand VALUES('3', 'Mercedes');
INSERT INTO brand VALUES('4', 'Opel');
INSERT INTO brand VALUES('5', 'Peugeot');
INSERT INTO brand VALUES('6', 'Renault');

INSERT INTO fuel VALUES('1','Gasoline');
INSERT INTO fuel VALUES('2','Diesel');
INSERT INTO fuel VALUES('3','Hybrid');
INSERT INTO fuel VALUES('4','Electric');

INSERT INTO model VALUES('1', '320d', '2');
INSERT INTO model VALUES('2', '850i', '2');
INSERT INTO model VALUES('3', 'M3', '2');
INSERT INTO model VALUES('4', 'CLK', '3');
INSERT INTO model VALUES('5', 'CLS', '3');
INSERT INTO model VALUES('6', '220', '3');
INSERT INTO model VALUES('7', 'Logan', '1');
INSERT INTO model VALUES('8', 'Duster', '1');
INSERT INTO model VALUES('9', 'Dokker', '1');
INSERT INTO model VALUES('10', 'Astra', '4');
INSERT INTO model VALUES('11', 'Vectra', '4');
INSERT INTO model VALUES('12', 'Corsa', '4');
INSERT INTO model VALUES('13', '206', '5');
INSERT INTO model VALUES('14', '307', '5');
INSERT INTO model VALUES('15', '407', '5');
INSERT INTO model VALUES('16', 'Megane', '6');
INSERT INTO model VALUES('17', 'Clio', '6');
INSERT INTO model VALUES('18', 'Captur', '6');

INSERT INTO type VALUES('1', 'Sedan');
INSERT INTO type VALUES('2', 'Convertible');
INSERT INTO type VALUES('3', 'Coupe');
INSERT INTO type VALUES('4', 'SUV');

INSERT INTO status VALUES('1', 'ACTIVE');
INSERT INTO status VALUES('2', 'SOLD');
INSERT INTO status VALUES('3', 'DELETED');

INSERT INTO role VALUES('1', 'ROLE_USER');
INSERT INTO role VALUES('2', 'ROLE_ADMIN');