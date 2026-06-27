# Exercise 22: Duplicate Registrations Check

## Query

```sql
SELECT 
    r.user_id,
    u.full_name AS user_name,
    r.event_id,
    e.title AS event_name,
    COUNT(r.registration_id) AS registration_count
FROM Registrations r
INNER JOIN Users u ON r.user_id = u.user_id
INNER JOIN Events e ON r.event_id = e.event_id
GROUP BY r.user_id, u.full_name, r.event_id, e.title
HAVING COUNT(r.registration_id) > 1
ORDER BY registration_count DESC, r.user_id ASC;
```

---

## Explanation

This query checks for duplicate registrations where a user has registered for the same event more than once. We join the Registrations table with the Users and Events tables using INNER JOINs to get the user names and event titles. We group the results by user_id and event_id (along with the names and titles) to get the registration count for each combination. The HAVING clause filters the grouped rows to keep only those where the count is greater than 1, highlighting duplicates. The results are sorted in descending order of the registration count.

---

## Expected Output

```text
user_id  user_name  event_id  event_name  registration_count
-------  ---------  --------  ----------  ------------------
(No rows returned as there are no duplicate registrations in the sample dataset)
```
