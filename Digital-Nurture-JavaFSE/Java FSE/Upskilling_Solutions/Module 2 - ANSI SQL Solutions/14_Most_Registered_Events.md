# Exercise 14: Most Registered Events

## Query

```sql
SELECT 
    e.event_id,
    e.title AS event_name,
    COUNT(r.registration_id) AS total_registrations
FROM Events e
LEFT JOIN Registrations r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_registrations DESC, e.event_id ASC
LIMIT 3;
```

---

## Explanation

This query is used to find the top 3 events with the highest number of user registrations. We perform a LEFT JOIN between the Events table and the Registrations table using the event ID so that even events with zero registrations are included in the results. We group by event details and count registrations using COUNT(r.registration_id). The results are sorted in descending order of registration count, and we use LIMIT 3 to retrieve only the top three most registered events.

---

## Expected Output

```text
event_id  event_name              total_registrations
--------  ----------------------  -------------------
1         Tech Innovators Meetup  2
2         AI & ML Conference      2
3         Frontend Bootcamp       1
```
