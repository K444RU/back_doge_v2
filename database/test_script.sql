SELECT *
FROM walking w
WHERE city_id = 1
  AND status = 'A'
  AND ('2022-12-07' BETWEEN date_from AND date_to)
  AND ('11:00:00' BETWEEN time_from AND time_to)
  AND ('14:00:00' BETWEEN time_from AND time_to);


SELECT *
FROM "order";


SELECT *
FROM "order"
WHERE status = 'A'
    AND ('2022-12-07' = walking_date)
    AND ('12:01:00' BETWEEN time_from AND time_to)
   OR ('13:59:00' BETWEEN time_from AND time_to);


