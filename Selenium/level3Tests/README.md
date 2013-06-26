Tests to implement
===================

A customer calls to buy 2 articles

Operator : TDC_SHIRYU
Sales channel : TDC_Plateau_Téléphonique
Product : quantity = 2
Contact : Aika Osamu (no 201) 
Shipment : Courrier [Mail], later print
Payment : Bank Card VAD, no 5200000000000007	Order is successful closed and displayed in file detail
Check gauges
Check audience sub-category + category
Check price + simple frees (if exist)
Check order amount + frees (if exist)
Check histories (purchase + cultural + shipment + reglement)

Packages :

callcenter.sale.DatedPass
callcenter.sale.OpenPass
callcenter.sale.Service
callcenter.sale.Voucher


A customer buys 2 articles	

Sales channel : TicketShop TDC
Product : quantity = 2
Shipment : Print@home
Payment : Credit Card, VISA no 4900000000000003	Order is closed and displayed in "my orders"
Check gauges
Check audience sub-category + category
Check price + simple frees (if exist)
Check order amount + frees (if exist)
Check histories (my orders + my tickets)

Packages :     

B2cjs.sale.DatedPass
B2cjs.sale.OpenPass
B2cjs.sale.Service
B2cjs.sale.Voucher
B2cjs.sale.Goods




