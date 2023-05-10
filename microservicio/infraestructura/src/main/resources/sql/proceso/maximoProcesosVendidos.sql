select count(1)
from proceso
where id_etapa = :idEtapa
  and fecha_compra = :fechaCompra