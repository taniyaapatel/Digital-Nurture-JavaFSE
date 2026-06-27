# Exercise 13: Average Feedback Rating per City

## Query

```sql
SELECT 
    e.city AS event_city,
    ROUND(AVG(f.rating), 2) AS average_feedback_rating,
    COUNT(f.feedback_id) AS total_reviews_received
FROM Events e
INNER JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.city
ORDER BY average_feedback_rating DESC;
```

---

## Explanation

This query is used to calculate the average feedback rating for events in each city. We perform an INNER JOIN between the Events table and the Feedback table on event_id to match each review to the city where the event took place. We group the results by the event's city name and apply the AVG() aggregate function to compute the mean rating, wrapping it in ROUND(..., 2) to format it to two decimal places. Finally, we sort the city averages in descending order to show the highest-rated cities first.

---

## Expected Output

```text
event_city  average_feedback_rating  total_reviews_received
----------  -----------------------  ----------------------
Chicago     4.50                     2
New York    3.00                     1
```
