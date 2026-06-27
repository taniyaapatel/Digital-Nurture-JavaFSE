# Exercise 15: Event Session Time Conflict Detection

## Query

```sql
SELECT 
    s1.event_id,
    e.title AS event_name,
    s1.session_id AS session_1_id,
    s1.title AS session_1_title,
    s1.start_time AS session_1_start,
    s1.end_time AS session_1_end,
    s2.session_id AS session_2_id,
    s2.title AS session_2_title,
    s2.start_time AS session_2_start,
    s2.end_time AS session_2_end
FROM Sessions s1
INNER JOIN Sessions s2 ON s1.event_id = s2.event_id
                      AND s1.session_id < s2.session_id
INNER JOIN Events e ON s1.event_id = e.event_id
WHERE s1.start_time < s2.end_time 
  AND s2.start_time < s1.end_time
ORDER BY s1.event_id ASC, s1.session_id ASC;
```

---

## Explanation

This query is used to detect sessions within the same event that have scheduling conflicts (overlapping time windows). We perform a self-join on the Sessions table (aliasing it as s1 and s2) matching on event_id. To prevent comparing a session with itself or listing the same conflict twice, we add the condition s1.session_id < s2.session_id. We also join the Events table to fetch the event name. The WHERE clause checks for overlaps using the condition s1.start_time < s2.end_time AND s2.start_time < s1.end_time.

---

## Expected Output

```text
event_id  event_name  session_1_id  session_1_title  session_1_start  session_1_end  session_2_id  session_2_title  session_2_start  session_2_end
--------  ----------  ------------  ---------------  ---------------  -------------  ------------  ---------------  ---------------  -------------
(No rows returned as there are no schedule conflicts in the sample dataset)
```
