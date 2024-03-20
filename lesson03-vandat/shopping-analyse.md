+Class
Customer: id, name, phone, andress
Item	: id, os, color, cost

b1: create an list of customers
b2: create array of items in store
b3: shopping function
- who is buying
- list of items
- amount of each item
- datetime
-> Order: customer, item_details[], date_time
-> ItemDetail: item, quantity

c1: KH1, Adam, 123, NY
c2: KH2, Eva, 546, LA

i1: SS10+, Android, Black, 620
i2: SS20U, Android, Green, 840
i3: IP4, IOS, White, 280
i4: IP12, ISO, Black, 880
i5: WP8, WindowPhone, Blue, 560

o1: c1, {id1(i1, 3), id2(i2, 1), id3(i2, 1)}, date_time 
o1: c2, {id1(i3, 3), id2(i2, 2), id3(i4, 1)}, date_time 
o3: c1, {id1(i5, 2)}, date_time 

function: export(order) -> TotalOfAmount:Void