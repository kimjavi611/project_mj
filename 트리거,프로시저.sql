use portal;
/* 학생이 강의를 수강신청하면 해당 강의의 현재 정원이 1증가하는 트리거*/
drop trigger if exists insert_course;
delimiter //
create trigger insert_course after insert on course
for each row
begin
	update class
		set cl_now_count = cl_now_count +1
        where cl_code = new.co_cl_code;
end //
delimiter ;
show triggers;
use example;
/*주문테이블에 주문내역이 추가되면 제품 테이블의 재고량이 변하는 트리거를 작성하세요*/
drop trigger if exists insert_order;
delimiter //
create trigger insert_order after insert on `주문`
for each row
begin update `제품`
	set 재고량 = 재고량 - new.수량
    where 제품번호 = new.주문제품;
end //
delimiter ;
show triggers;

/* 프로시저 
drop procedure if exists 프로시저명;
delimiter 기호
create procedure 프로시저명(
	{in | out} 변수명1,
    {in | out} 변수명2,
    ...
)
begin
	구현;
end 기호
delimiter ;
-프로시저 호출
call 프로시저명(변수들);*/
drop procedure if exists addOrder;
delimiter //
create procedure addOrder(
	in _id varchar(20),
    in _product char(3),
    in _amount int,
    in _address varchar(30),
    in _date varchar(20)
)
begin
	declare _count int default 0;
    declare _order_num char(3); -- char는 default값을 안넣어줘도되나?
    set _count = (select count(*) from 주문) + 1;
    set _order_num = concat('o', _count);
    insert into `주문`
		values(_order_num, _id,_product, _amount,_address,_date);
	select * from `주문`;
end //
delimiter ;
call addOrder('apple','p01',15,'충북 청주시','2021-06-01'); 
-- 이 결과만 나와야되는게 아닌가?      
    
    
    
 