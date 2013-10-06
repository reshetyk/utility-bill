INSERT INTO Customer (id, firstname, lastname) VALUES (1, 'Dave', 'Matthews');
INSERT INTO Customer (id, firstname, lastname) VALUES (2, 'Carter', 'Beauford');

INSERT INTO Apartment (id, name, expiryDate) VALUES (1, 'my home dnepr', '2010-12-31');
INSERT INTO Apartment (id, name, expiryDate) VALUES (2, 'home donetsk', '2011-03-31');
INSERT INTO Apartment (id, name, expiryDate) VALUES (3, 'other home', '2011-03-31');

INSERT INTO CustomerByApartment (customer_id, apartment_id) VALUES (1, 1);
INSERT INTO CustomerByApartment (customer_id, apartment_id) VALUES (1, 2);
INSERT INTO CustomerByApartment (customer_id, apartment_id) VALUES (2, 3);

