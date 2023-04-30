select count(1)
from tiquete
where id_usuario = :idUsuario
  and fecha_compra = :fechaCompra