# Exercise 5: Most Active Cities

## Query

```sql
SELECT 
    u.city AS user_city,
    COUNT(DISTINCT r.user_id) AS registered_user_count
FROM Users u
INNER JOIN Registrations r ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY registered_user_count DESC
LIMIT 5;
```

---

## Explanation

This query is used to find the top 5 cities with the highest number of unique registered users. We perform an INNER JOIN between the Users and Registrations tables to filter out users who haven't registered for any events. We use GROUP BY on the user's city and count the unique user IDs using COUNT(DISTINCT r.user_id) so that each user is counted only once per city. Finally, we sort the results in descending order of the registration count and use LIMIT 5 to get the top 5 most active cities.

---

## Expected Output

```text
user_city    registered_user_count
-----------  ---------------------
New York     1
Los Angeles  1
Chicago      1
```
