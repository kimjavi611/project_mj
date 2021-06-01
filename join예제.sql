--  주문 vs 제품
-- right join : 오른쪽인 제품을 기준으로 join을 하는데 제품과 연결된 주문내역이 없으면
-- 주문에 해당하는 속성들의 값이 null로 채워서 보여줌
select * from example.주문
	right join 제품
    on 주문제품 = 제품번호;
-- 주문과 제품 테이블에서 그냥 join은 inner join(기본join)이면서, left join에 해당
select * from example.주문
	left join 제품
    on 주문제품 = 제품번호;
/* 
select * from A left join B on A.속성 = B.속성;는
select * from B right join A on A.속성 = B.속성; 과 같다*/
select * from example.주문
	 join 제품
    on 주문제품 = 제품번호;
