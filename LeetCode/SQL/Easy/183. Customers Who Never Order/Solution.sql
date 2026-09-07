# Write your MySQL query statement below
SELECT c.name as customers
FROM customers c
LEFT JOIN orders o
ON c.id = o.customerId
WHERE o.id IS NULL;