# Exercise 4: Peak Session Hours

## Query

```sql
SELECT 
    e.event_id,
    e.title AS event_name,
    COUNT(s.session_id) AS peak_session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
                    AND TIME(s.start_time) >= '10:00:00'
                    AND TIME(s.end_time) <= '12:00:00'
GROUP BY e.event_id, e.title
ORDER BY peak_session_count DESC, e.event_id ASC;
```

---

## Explanation

Here we count how many sessions are scheduled during the peak morning hours of 10:00 AM and 12:00 PM for each event in the database. We use a LEFT JOIN to combine the Events table and Sessions table on the event ID, applying the time filters inside the join condition. This ensures that even events with zero peak-hour sessions are still listed in our results with a count of 0. Finally, we group by event and sort the list descending by count to show the busiest events first.

---

## Expected Output

```text
event_id  event_name              peak_session_count
--------  ----------------------  ------------------
1         Tech Innovators Meetup  1
2         AI & ML Conference      0
3         Frontend Bootcamp       1
```
