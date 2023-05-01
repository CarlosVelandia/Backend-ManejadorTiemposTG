select count(1)
from proceso
where id_parque = :idParque
  and fecha_compra = :fechaCompra