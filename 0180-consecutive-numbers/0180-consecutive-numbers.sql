SELECT DISTINCT a.num AS consecutiveNUms
FROM Logs a
JOIN Logs b 
  ON b.id = a.id + 1  AND b.num = a.num
JOIN Logs c
  ON c.id = b.id + 1  AND c.num = b.num;
