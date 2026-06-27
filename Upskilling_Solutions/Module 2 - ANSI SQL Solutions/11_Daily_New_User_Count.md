# Exercise 11: Daily New User Count

## Query

```sql
SELECT 
    registration_date,
    COUNT(user_id) AS new_user_count
FROM Users
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)
GROUP BY registration_date
ORDER BY registration_date DESC;
```

---

## Explanation

This query is used to find the number of new user accounts created on each day over the past week (7 days). We query the Users table and filter the rows using the WHERE clause with the CURDATE() and DATE_SUB() functions to keep only registration dates within the 7-day rolling window. We group the results by registration_date and count the user IDs. Finally, we sort the output in descending order of the registration date to show the most recent signup counts first.

---

## Expected Output

```text
registration_date  new_user_count
-----------------  --------------
(No rows returned due to the 7-day rolling date threshold)
```
