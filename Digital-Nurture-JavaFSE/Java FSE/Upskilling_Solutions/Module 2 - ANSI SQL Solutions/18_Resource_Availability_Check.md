# Exercise 18: Resource Availability Check

## Query

```sql
SELECT 
    e.event_id,
    e.title AS event_name,
    e.status AS event_status,
    e.start_date AS event_start_date
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
WHERE r.resource_id IS NULL
ORDER BY e.event_id ASC;
```

---

## Explanation

This query is used to find all events that have no digital resources uploaded. We perform a LEFT JOIN between the Events table and the Resources table using the event ID. The WHERE clause checks for r.resource_id IS NULL, which filters the results to keep only events that did not have any matching records in the Resources table. We select the event details like ID, title, status, and start date, and sort the final list in ascending order of the event ID.

---

## Expected Output

```text
event_id  event_name  event_status  event_start_date
--------  ----------  ------------  ----------------
(No rows returned as all sample events have resources uploaded in the mock dataset)
```
