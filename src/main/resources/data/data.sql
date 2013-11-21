INSERT INTO Customer (id, userName, firstname, lastname, password, emailAddress, active) VALUES (1, 'daveM', 'Dave', 'Matthews', 'pass1', 'dave@email.com', 1);
INSERT INTO Customer (id, userName, firstname, lastname, password, emailAddress, active) VALUES (2, 'carterB', 'Carter', 'Beauford', 'pass2', 'carter@email.com', 1);

INSERT INTO Apartment (id, name, expiryDate) VALUES (1, 'my home dnepr', '2010-12-31');
INSERT INTO Apartment (id, name, expiryDate) VALUES (2, 'home donetsk', '2011-03-31');
INSERT INTO Apartment (id, name, expiryDate) VALUES (3, 'other home', '2011-03-31');

INSERT INTO CustomerByApartment (customer_id, apartment_id) VALUES (1, 1);
INSERT INTO CustomerByApartment (customer_id, apartment_id) VALUES (1, 2);
INSERT INTO CustomerByApartment (customer_id, apartment_id) VALUES (2, 3);

INSERT INTO UserAuthorities (customer_id, authorities) VALUES (1, 'ROLE_ADMIN');
INSERT INTO UserAuthorities (customer_id, authorities) VALUES (2, 'ROLE_USER');
