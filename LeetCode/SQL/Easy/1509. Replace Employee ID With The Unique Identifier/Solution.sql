# Write your MySQL query statement below
SELECT unique_id, name
FROM Employees e
LEFT JOIN 
EmployeeUNI emp
ON
e.id = emp.id;