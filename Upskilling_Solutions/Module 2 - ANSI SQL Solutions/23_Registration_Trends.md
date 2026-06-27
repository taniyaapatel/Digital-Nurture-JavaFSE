# Exercise 23: Registration Trends

## Query

```sql
SELECT 
    DATE_FORMAT(registration_date, '%Y-%m') AS registration_month,
    COUNT(registration_id) AS total_registrations
FROM Registrations
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY DATE_FORMAT(registration_date, '%Y-%m')
ORDER BY registration_month ASC;
```

---

## Explanation

This query is used to analyze registration trends over the last 12 months. We query the Registrations table and use a WHERE clause with CURDATE() and DATE_SUB() to limit the records to a rolling 12-month window. To group the registrations by month, we use the DATE_FORMAT() function with the '%Y-%m' pattern to extract the year and month from the registration date. Finally, we count the registrations for each month and sort the results chronologically in ascending order.

---

## Expected Output

```text
registration_month  total_registrations
------------------  -------------------
(No rows returned due to the 12-month rolling constraint)
```
