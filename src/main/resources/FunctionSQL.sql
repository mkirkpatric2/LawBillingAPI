-- Select all bills tx
-- Rounds any post-cent digits.
-- Including a column in the billers table that shows TX rate for non-attorneys would
-- be a better and more elegant solution, but I wanted to figure this one out at this stage.
-- ClientTx.getAllbills()
SELECT a.id, b.name, a.details, a.hours,
       CASE
           WHEN b.attorney=false THEN b.hourlyrate*.75
           ELSE b.hourlyrate
       END AS rate,
       ROUND(CASE
           WHEN b.attorney=false THEN b.hourlyrate*.75*a.hours
           ELSE b.hourlyrate*a.hours
       END, 2) AS subtotal
FROM bills a
JOIN billers b ON a.biller = b.id
WHERE clientcode = 1; -- where clientcode is changed based on the request

-- ClientLit.getAllbills()
SELECT a.id, b.name, a.details, a.hours, b.hourlyrate as rate,
       ROUND(b.hourlyrate*a.hours, 2) AS subtotal
FROM bills a
         JOIN billers b ON a.biller = b.id
WHERE clientcode = 1; -- where clientcode is changed based on the request
