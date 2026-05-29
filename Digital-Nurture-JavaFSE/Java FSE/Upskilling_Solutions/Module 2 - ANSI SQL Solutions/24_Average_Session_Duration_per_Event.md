# Exercise 24: Average Session Duration per Event

## Query

```sql
SELECT 
    e.event_id,
    e.title AS event_name,
    ROUND(AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)), 2) AS average_session_duration_minutes,
    COUNT(s.session_id) AS total_sessions_analyzed
FROM Events e
INNER JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
ORDER BY average_session_duration_minutes DESC, e.event_id ASC;
```

---

## Explanation

This query is used to calculate the average duration of sessions in minutes for each event. We join the Events table with the Sessions table using an INNER JOIN, matching them on event_id. We use the TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time) function to find the length of each session in minutes, and then use AVG() to find the average, rounding the result to two decimal places. Finally, we group the results by event and sort them in descending order of average session duration.

---

## Expected Output

```text
event_id  event_name              average_session_duration_minutes  total_sessions_analyzed
--------  ----------------------  --------------------------------  -----------------------
3         Frontend Bootcamp       120.00                            1
2         AI & ML Conference      90.00                             1
1         Tech Innovators Meetup  67.50                             2
```
