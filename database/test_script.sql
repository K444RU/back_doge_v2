select *
from walking w
where city_id = 1
  and status = 'A'
  and ('2022-12-07' between date_from and date_to)
  and ('11:00:00' between time_from and time_to)
  and ('13:00:00' between time_from and time_to);


select *
from "order";


select *
from "order"
where status = 'A'
  and ('2022-12-07' = walking_date)
  and (('11:01:00' between time_from and time_to)
    or ('12:59:00' between time_from and time_to));