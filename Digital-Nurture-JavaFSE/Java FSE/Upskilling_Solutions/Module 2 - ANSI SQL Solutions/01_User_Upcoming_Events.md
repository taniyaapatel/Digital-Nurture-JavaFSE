# Exercise 1: User Upcoming Events

## Query

```sql
SELECT 
    u.user_id,
    u.full_name AS user_name,
    e.event_id,
    e.title AS event_name,
    e.city AS event_city,
    e.start_date AS event_start_date
FROM Users u
INNER JOIN Registrations r ON u.user_id = r.user_id
INNER JOIN Events e ON r.event_id = e.event_id
WHERE e.status = 'upcoming'
  AND u.city = e.city
ORDER BY e.start_date ASC;
```

---

## Explanation

This query is used to find all upcoming events that users have registered for in their own home city. We join the Users, Registrations, and Events tables together using their respective foreign keys to link users to their registered events. The WHERE clause filters the results to keep only events with an 'upcoming' status and matches the user's city to the event's city. Finally, the results are sorted chronologically by the start date of the events so users see their next upcoming local events first.

---

## Expected Output

```text
user_id  user_name      event_id  event_name              event_city  event_start_date
-------  -------------  --------  ----------------------  ----------  -------------------
1        Alice Johnson  1         Tech Innovators Meetup  New York    2025-06-10 10:00:00
```
