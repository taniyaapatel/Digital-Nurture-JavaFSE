# Exercise 6: Event Resource Summary

## Query

```sql
SELECT 
    e.event_id,
    e.title AS event_name,
    SUM(CASE WHEN r.resource_type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count,
    SUM(CASE WHEN r.resource_type = 'image' THEN 1 ELSE 0 END) AS image_count,
    SUM(CASE WHEN r.resource_type = 'link' THEN 1 ELSE 0 END) AS link_count,
    COUNT(r.resource_id) AS total_resources
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_resources DESC, e.event_id ASC;
```

---

## Explanation

In this exercise, we generate a report showing the breakdown of resources like PDFs, images, and links uploaded for each event. We use a LEFT JOIN between the Events and Resources tables to ensure that events with zero resources are still listed in the report. By using conditional aggregation with SUM and CASE WHEN, we can pivot and count the resources of each type (pdf, image, link) as separate columns. The overall resource count is calculated using COUNT(r.resource_id), and we sort the final list in descending order of total resources.

---

## Expected Output

```text
event_id  event_name              pdf_count  image_count  link_count  total_resources
--------  ----------------------  ---------  -----------  ----------  ---------------
1         Tech Innovators Meetup  1          0            0           1
2         AI & ML Conference      0          1            0           1
3         Frontend Bootcamp       0          0            1           1
```
