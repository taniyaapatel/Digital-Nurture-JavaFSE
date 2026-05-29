# Exercise 8: Sessions per Upcoming Event

## Query

```sql
SELECT 
    e.event_id,
    e.title AS event_name,
    e.start_date AS event_start_date,
    COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title, e.start_date
ORDER BY e.start_date ASC, session_count DESC;
```

---

## Explanation

This query counts how many sessions are scheduled for each upcoming event. We perform a LEFT JOIN between the Events and Sessions tables using the event ID so that upcoming events are listed even if they do not have any sessions yet. The WHERE clause filters for events where the status is 'upcoming'. We group by the event columns and sort chronologically by the event's start date so that the nearest events show up first.

---

## Expected Output

```text
event_id  event_name              event_start_date     session_count
--------  ----------------------  -------------------  -------------
1         Tech Innovators Meetup  2025-06-10 10:00:00  2
3         Frontend Bootcamp       2025-07-01 10:00:00  1
```
