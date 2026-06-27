# Exercise 20: User Engagement Index

## Query

```sql
SELECT 
    u.user_id,
    u.full_name AS user_name,
    COALESCE(reg.event_registrations_count, 0) AS events_registered,
    COALESCE(feed.feedback_submitted_count, 0) AS feedbacks_submitted
FROM Users u
LEFT JOIN (
    SELECT user_id, COUNT(registration_id) AS event_registrations_count
    FROM Registrations
    GROUP BY user_id
) reg ON u.user_id = reg.user_id
LEFT JOIN (
    SELECT user_id, COUNT(feedback_id) AS feedback_submitted_count
    FROM Feedback
    GROUP BY user_id
) feed ON u.user_id = feed.user_id
ORDER BY events_registered DESC, feedbacks_submitted DESC, u.user_id ASC;
```

---

## Explanation

This query builds a user engagement index that shows the number of events registered and feedback forms submitted by each user. To prevent a Cartesian product when joining two independent one-to-many tables (Registrations and Feedback) to the Users table, we aggregate the registrations and feedback counts in separate subqueries first. Then, we use LEFT JOINs to connect these subqueries back to the Users table so that all users are listed. Finally, we use COALESCE to display 0 for users with no registrations or feedback, and sort the results descending by registrations and feedback counts.

---

## Expected Output

```text
user_id  user_name      events_registered  feedbacks_submitted
-------  -------------  -----------------  -------------------
2        Bob Smith      1                  1
3        Charlie Lee    1                  1
4        Diana King     1                  1
1        Alice Johnson  1                  0
5        Ethan Hunt     1                  0
```
