# Exercise 21: Top Feedback Providers

## Query

```sql
SELECT 
    u.user_id,
    u.full_name AS user_name,
    COUNT(f.feedback_id) AS feedback_count
FROM Users u
INNER JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY feedback_count DESC, u.user_id ASC
LIMIT 5;
```

---

## Explanation

This query is used to find the top 5 users who have submitted the highest number of feedback reviews. We perform an INNER JOIN between the Users and Feedback tables so that we only include users who have actually submitted at least one review. We group the results by the user's ID and name, then use the COUNT(f.feedback_id) aggregate function to calculate their total feedback submissions. Finally, we sort the results in descending order of the feedback count and apply LIMIT 5 to get the top 5 users.

---

## Expected Output

```text
user_id  user_name    feedback_count
-------  -----------  --------------
2        Bob Smith    1
3        Charlie Lee  1
4        Diana King   1
```
