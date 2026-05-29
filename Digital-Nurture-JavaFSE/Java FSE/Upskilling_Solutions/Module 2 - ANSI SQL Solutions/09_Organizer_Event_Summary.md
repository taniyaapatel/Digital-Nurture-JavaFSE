# Exercise 9: Organizer Event Summary

## Query

```sql
SELECT 
    u.user_id AS organizer_id,
    u.full_name AS organizer_name,
    e.status AS event_status,
    COUNT(e.event_id) AS event_count
FROM Users u
INNER JOIN Events e ON u.user_id = e.organizer_id
GROUP BY u.user_id, u.full_name, e.status
ORDER BY u.user_id ASC, event_count DESC;
```

---

## Explanation

This query creates a summary report showing the number of events created by each organizer, grouped by their current status. We perform an INNER JOIN between the Users table and the Events table, matching the user's ID to the event's organizer ID. We group the results by the organizer's ID, name, and the event status to get separate counts for 'upcoming', 'completed', and 'cancelled' events. Finally, we sort the output in ascending order of organizer ID and descending order of event count.

---

## Expected Output

```text
organizer_id  organizer_name  event_status  event_count
------------  --------------  ------------  -----------
1             Alice Johnson   upcoming      1
2             Bob Smith       upcoming      1
3             Charlie Lee     completed     1
```
