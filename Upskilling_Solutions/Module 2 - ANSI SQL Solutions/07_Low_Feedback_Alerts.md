# Exercise 7: Low Feedback Alerts

## Query

```sql
SELECT 
    u.user_id,
    u.full_name AS user_name,
    e.event_id,
    e.title AS event_name,
    f.rating,
    f.comments
FROM Feedback f
INNER JOIN Users u ON f.user_id = u.user_id
INNER JOIN Events e ON f.event_id = e.event_id
WHERE f.rating < 3
ORDER BY f.rating ASC, u.user_id ASC;
```

---

## Explanation

This query is designed to find all feedback records where the rating is poor, specifically less than 3. We perform INNER JOINs to connect the Feedback table with the Users table and the Events table to retrieve the reviewer's name and the event's title. The WHERE clause filters the results using the condition rating < 3. Finally, the list is sorted in ascending order of the rating and user ID so that the lowest ratings appear at the very top for quick review.

---

## Expected Output

```text
user_id  user_name  event_id  event_name  rating  comments
-------  ---------  --------  ----------  ------  --------
(No rows returned because all sample reviews are rated 3, 4, or 5)
```
