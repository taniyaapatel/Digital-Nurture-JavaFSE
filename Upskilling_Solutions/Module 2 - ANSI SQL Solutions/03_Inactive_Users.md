# Exercise 3: Inactive Users

## Query

```sql
SELECT 
    u.user_id,
    u.full_name AS user_name,
    u.email,
    u.registration_date AS account_created_date
FROM Users u
WHERE NOT EXISTS (
    SELECT 1 
    FROM Registrations r 
    WHERE r.user_id = u.user_id 
      AND r.registration_date >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)
)
ORDER BY u.user_id ASC;
```

---

## Explanation

This query helps us find users who have not registered for any events in the last 90 days. We query the Users table and use a NOT EXISTS subquery against the Registrations table to exclude anyone who has active registration rows dated within the last 90 days. The date constraint is computed dynamically using the CURDATE() and DATE_SUB() functions. The final list is sorted in ascending order of the user ID to check the oldest or first inactive accounts first.

---

## Expected Output

```text
user_id  user_name      email              account_created_date
-------  -------------  -----------------  --------------------
1        Alice Johnson  alice@example.com  2024-12-01
2        Bob Smith      bob@example.com    2024-12-05
3        Charlie Lee    charlie@example.c  2024-12-10
4        Diana King     diana@example.com  2025-01-15
5        Ethan Hunt     ethan@example.com  2025-02-01
```
