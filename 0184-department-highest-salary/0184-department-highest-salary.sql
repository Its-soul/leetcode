SELECT d.name AS Department, e.name AS Employee,
e.salary AS Salary FROM Department d,
Employee e WHERE e.departmentId = d.id 
AND (e.departmentId, salary) IN (SELECT departmentId, MAX(salary) FROM Employee GROUP BY departmentId)