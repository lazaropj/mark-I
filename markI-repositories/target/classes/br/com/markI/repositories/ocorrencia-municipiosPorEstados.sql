--SQL
select 
 distinct m.denominacao as nome,m.id,
 m.latitude,m.longitude

from ocorrencia o
left join municipio m on m.id = o.municipio

where 
uf= :siglaUF
<#if anos??>
and
extract(year from o.data_ocorrencia) in (:anos)
</#if>
