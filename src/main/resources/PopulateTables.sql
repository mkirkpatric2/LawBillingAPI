INSERT INTO bills (clientcode, biller, hours, details)
VALUES
    (1, 1, 1.4, 'reviewed complaint'),
    (1, 1, 2.5, 'drafted answer'),
    (1, 2, 1.8, 'edited answer'),
    (1, 3, 3.7, 'reviewed affidavit exhibits'),
    (1, 4, 4.4, 'compiled affidavit exhibits'),
    (2, 1, 2.2, 'reviewed depo transcript'),
    (3, 2, 1.5, 'preliminary hearing attendance'),
    (4, 4, 0.5, 'collated defense depo exhibits'),
    (5, 4, 1.2, 'Prepared response to rogs'),
    (6, 3, 0.3, 'prepared exhibits to motion')
;

INSERT INTO clients (clientname, isactive, leadattorney, clientphoneno, islit)
VALUES
    ('Mark Vend', true, 1, '1112223344', false),
    ('MMPA', true, 1, '12122323343', true),
    ('Andi Donnelly', true, 2, '1133444553', true),
    ('Jon Evron', false, 2, '1442332422', false),
    ('Gourmet Foods', true, 1, '3324424424', true),
    ('John Doe', true, 2, '9939294828', false)
;

INSERT INTO billers (name, attorney, hourlyrate)
VALUES
    ('Marko', true, 250),
    ('Lisa', true, 225),
    ('John', false, 75),
    ('Ligia', false, 110)
;
