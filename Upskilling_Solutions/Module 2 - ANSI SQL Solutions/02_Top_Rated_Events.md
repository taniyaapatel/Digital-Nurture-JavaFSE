# Exercise 2: Top Rated Events

## Query

```sql
SELECT 
    e.event_id,
    e.title AS event_name,
    ROUND(AVG(f.rating), 2) AS average_rating,
    COUNT(f.feedback_id) AS feedback_count
FROM Events e
INNER JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(f.feedback_id) >= 10
ORDER BY average_rating DESC, feedback_count DESC;
```

---

## Explanation

The purpose of this query is to identify the best-rated events in the system based on average user ratings. We perform an INNER JOIN between the Events and Feedback tables and group by event details to compute aggregate ratings. To make the rating reliable and avoid bias from single reviews, we use the HAVING clause to filter out events with fewer than 10 feedback submissions. The output is sorted descending by the average rating and then by review volume to highlight the most popular, highly-rated events.

---

## Expected Output

```text
event_id  event_name  average_rating  feedback_count
--------  ----------  --------------  --------------
(Empty set returned because no sample events have at least 10 feedback submissions)
```
