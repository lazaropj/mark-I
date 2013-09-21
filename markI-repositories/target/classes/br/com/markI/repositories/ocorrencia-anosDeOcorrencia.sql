--SQL
select distinct extract(year from o.data_ocorrencia) ano_ocorrencia from ocorrencia o order by ano_ocorrencia