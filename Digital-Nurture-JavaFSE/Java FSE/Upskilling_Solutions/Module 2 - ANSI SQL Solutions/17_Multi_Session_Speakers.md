# Exercise 17: Multi-Session Speakers

## Query

```sql
SELECT 
    speaker_name,
    COUNT(session_id) AS total_sessions_handled,
    COUNT(DISTINCT event_id) AS distinct_events_count
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(session_id) > 1
ORDER BY total_sessions_handled DESC, speaker_name ASC;
```

---

## Explanation

This query is used to find speakers who are scheduled to present more than one session. We query the Sessions table, grouping the sessions by speaker_name to aggregate counts. We use COUNT(session_id) to calculate the total sessions handled by each speaker and COUNT(DISTINCT event_id) to see how many different events they are participating in. The HAVING clause filters out speakers who only have one session. Finally, we sort the results in descending order of the total sessions handled.

---

## Expected Output

```text
speaker_name  total_sessions_handled  distinct_events_count
------------  ----------------------  ---------------------
(No rows returned as no speaker has multiple sessions in the sample dataset)
```
