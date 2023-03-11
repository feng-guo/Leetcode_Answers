# Write your MySQL query statement below
SELECT distinct p.email from person p INNER JOIN person q ON p.email = q.email and p.id <> q.id;