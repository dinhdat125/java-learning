-- 1. Liệt kê các mặt hàng được bán trong ngày bất kỳ.
-- Kết quả trả về được sắp xếp theo CREATED_TIME desc, ID asc
SELECT it.ID AS ID,
	   it.NAME AS `NAME`,
       cast(od.CREATED_AT AS TIME) AS CREATED_TIME
  FROM item it
  JOIN item_detail itd
    ON it.ID = itd.ITEM_ID
  JOIN order_detail odd
    ON odd.ITEM_DETAIL_ID = itd.ID
  JOIN `order` od
    ON od.ID = odd.ORDER_ID
 WHERE cast(od.CREATED_AT AS DATE) = '2023-02-15'
 ORDER BY CREATED_TIME DESC, ID;
 
--  2. Thống kê số lượng mặt hàng đang tồn kho của mỗi loại hàng
SELECT itg.ID, 
	   itg.NAME,
       SUM(itd.AMOUNT) AMOUNT_OF_ITEMS
  FROM item_group itg
  JOIN item it
    ON itg.ID = it.ITEM_GROUP_ID
  JOIN item_detail itd
    ON itd.ITEM_ID = it.ID
 GROUP BY itg.ID, itg.NAME;

-- 3. Liệt kê top 3 mặt hàng được bán nhiều nhất trong năm bất kỳ.
-- Nếu có nhiều hơn 3 mặt hàng có số lượng lớn nhất bằng nhau, chọn mặt hàng có mã mặt hàng lớn hơn
SELECT it.NAME ITEM_NAME
  FROM item it
  JOIN item_detail itd
    ON it.ID = itd.ITEM_ID
  JOIN order_detail odd
    ON odd.ITEM_DETAIL_ID = itd.ID
  JOIN `order` od
    ON od.ID = odd.ORDER_ID
 WHERE year(od.CREATED_AT) = 2023
 GROUP BY it.ID, it.NAME
 ORDER BY sum(odd.AMOUNT) DESC, it.ID DESC
 LIMIT 3;