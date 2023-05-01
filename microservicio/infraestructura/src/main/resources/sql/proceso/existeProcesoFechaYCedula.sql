select count(1)
from proceso
where id_usuario = :idUsuario
  and fecha_compra = :fechaCompra