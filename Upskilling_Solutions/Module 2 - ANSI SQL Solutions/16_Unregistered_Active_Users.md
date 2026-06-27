# Exercise 16: Unregistered Active Users

## Query

```sql
SELECT 
    u.user_id,
    u.full_name AS user_name,
    u.email,
    u.registration_date AS account_created_date
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
WHERE u.registration_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
  AND r.registration_id IS NULL
ORDER BY u.user_id ASC;
```

---

## Explanation

This query is used to find users who signed up in the last 30 days but have not registered for any events yet. We perform a LEFT JOIN between the Users table and the Registrations table using the user's ID. In the WHERE clause, we check that the registration date of the user is within the last 30 days using the CURDATE() and DATE_SUB() functions, and we filter with r.registration_id IS NULL to only keep users who have no corresponding registration rows. Finally, we sort the results by user ID.

---

## Expected Output

```text
user_id  user_name  email  account_created_date
-------  ---------  -----  --------------------
(No rows returned due to the 30-day account age constraint)
```
