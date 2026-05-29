# Exercise 25: Events Without Sessions

## Query

```sql
SELECT 
    e.event_id,
    e.title AS event_name,
    e.status AS event_status,
    e.start_date AS event_start_date
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE s.session_id IS NULL
ORDER BY e.event_id ASC;
```

---

## Explanation

This query is used to find events that do not have any sessions scheduled. We perform a LEFT JOIN between the Events table and the Sessions table matching on event_id. We apply a filter in the WHERE clause using s.session_id IS NULL to keep only those events that do not have any matching records in the Sessions table. Finally, we select the event details like ID, title, status, and start date, and sort the results by event ID.

---

## Expected Output

```text
event_id  event_name  event_status  event_start_date
--------  ----------  ------------  ----------------
(No rows returned as all sample events have sessions scheduled in the mock dataset)
```
