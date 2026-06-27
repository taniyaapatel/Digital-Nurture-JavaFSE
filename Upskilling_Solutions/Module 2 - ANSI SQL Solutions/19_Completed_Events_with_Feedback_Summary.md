# Exercise 19: Completed Events Registration & Feedback Summary

## Query

```sql
SELECT 
    e.event_id,
    e.title AS event_name,
    COALESCE(reg.reg_count, 0) AS total_registrations,
    ROUND(feed.avg_rating, 2) AS average_feedback_rating
FROM Events e
LEFT JOIN (
    SELECT event_id, COUNT(registration_id) AS reg_count
    FROM Registrations
    GROUP BY event_id
) reg ON e.event_id = reg.event_id
LEFT JOIN (
    SELECT event_id, AVG(rating) AS avg_rating
    FROM Feedback
    GROUP BY event_id
) feed ON e.event_id = feed.event_id
WHERE e.status = 'completed'
ORDER BY average_feedback_rating DESC, total_registrations DESC;
```

---

## Explanation

This query is used to summarize the registration count and average feedback rating for all completed events. To avoid a Cartesian product when joining multiple one-to-many tables (Registrations and Feedback) to the Events table, we aggregate the registration count and feedback average in separate subqueries first. We then LEFT JOIN these subqueries back to the Events table. The WHERE clause filters for events with a 'completed' status, and the results are sorted with the highest average rating first and the most registrations second.

---

## Expected Output

```text
event_id  event_name          total_registrations  average_feedback_rating
--------  ------------------  -------------------  -----------------------
2         AI & ML Conference  2                    4.50
```
