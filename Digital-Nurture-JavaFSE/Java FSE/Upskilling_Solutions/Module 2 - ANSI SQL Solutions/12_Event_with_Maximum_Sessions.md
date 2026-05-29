# Exercise 12: Event with Maximum Sessions

## Query

```sql
WITH EventSessionCounts AS (
    SELECT 
        e.event_id,
        e.title AS event_name,
        COUNT(s.session_id) AS session_count,
        DENSE_RANK() OVER (ORDER BY COUNT(s.session_id) DESC) AS ranking
    FROM Events e
    INNER JOIN Sessions s ON e.event_id = s.event_id
    GROUP BY e.event_id, e.title
)
SELECT 
    event_id,
    event_name,
    session_count
FROM EventSessionCounts
WHERE ranking = 1;
```

---

## Explanation

This query finds the event or events that have the highest number of sessions. To handle potential ties where multiple events have the same maximum session count, we use a Common Table Expression (CTE) with the DENSE_RANK() window function. The window function ranks each event based on its session count in descending order. In the outer query, we select the event details and filter with WHERE ranking = 1, ensuring that all events sharing the maximum session count are returned.

---

## Expected Output

```text
event_id  event_name              session_count
--------  ----------------------  -------------
1         Tech Innovators Meetup  2
```
