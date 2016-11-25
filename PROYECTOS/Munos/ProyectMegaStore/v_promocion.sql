

create view v_promocion(idprom, fecinicio, fecfin, idprod, nombre, pactual, precio, oferta, estado, anulado)
as
select 
	b.idprom, b.fecinicio, b.fecfin, b.idprod, a.nombre, 
	a.precio, b.precio, b.oferta, b.estado, b.anulado 
from producto a
join promocion b on a.idprod = b.idprod;
