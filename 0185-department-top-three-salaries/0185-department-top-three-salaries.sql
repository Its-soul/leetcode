SELECT d.name Department, e.name Employee, e.salary Salary
FROM
(
    SELECT *,
           DENSE_RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC)
salary_rank FROM Employee ) e
JOIN Department d
ON d.id = e.departmentId
WHERE salary_rank <= 3
ORDER BY Department, Salary DESC;
