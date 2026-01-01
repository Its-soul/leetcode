select id , num from(
    select id, count(*) over(partition by id) as num 
    from(
        select requester_id as id from RequestAccepted
        union all 
        select accepter_id as id from RequestAccepted
        ) t
) x
group by id
order by num desc limit 1;