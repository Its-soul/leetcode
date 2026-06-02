# Write your MySQL query statement below
with recursive tree_cte as(
    select id, p_id from Tree
    where p_id IS NULL

    union all

    select t.id, t.p_id from tree t
    join tree_cte tc
    on t.p_id = tc.id 
)

select tc.id, case
    when tc.p_id is null then 'Root'
    when tc.id not in(
        select distinct p_id
        from Tree
        where p_id is not null
    )
    then 'Leaf'
    Else 'Inner'
    end as type
From tree_cte tc
Order by id;