select CATEGORY,sum(sales) total_sales
from
(    
    select BOOK_ID,to_char(SALES_DATE,'yyyy-mm-dd') SALES_DATE, sales
    from book_sales 
    where to_char(sales_date,'yyyy-mm') = '2022-01'
) A
join
(
    select book_id,category
    from book
) B
on A.book_id = B.book_id
group by category
order by category;