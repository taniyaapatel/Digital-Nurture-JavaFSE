# Exercise 10: Feedback Gap

## Query

```sql
SELECT 
    e.event_id,
    e.title AS event_name,
    COUNT(DISTINCT r.registration_id) AS registration_count
FROM Events e
INNER JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.event_id, e.title
ORDER BY registration_count DESC, e.event_id ASC;
```

---

## Explanation

This query is used to find events that have registrations but have received zero feedback reviews. We join the Events table with the Registrations table using an INNER JOIN to make sure we only include events that people registered for. Then, we perform a LEFT JOIN with the Feedback table and check WHERE f.feedback_id IS NULL, which filters for events that don't have any feedback rows. We group by event details, count the registrations using COUNT(DISTINCT r.registration_id), and sort the results in descending order of registration count.

---

## Expected Output

```text
event_id  event_name              registration_count
--------  ----------------------  ------------------
3         Frontend Bootcamp       1
```
