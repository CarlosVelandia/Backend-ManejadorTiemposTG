select count(1)
from tiquete
where id_parque = :idParque
  and fecha_compra = :fechaCompra