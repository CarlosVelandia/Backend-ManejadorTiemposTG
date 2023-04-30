select tiquete.id,
       tiquete.fecha_compra,
       tiquete.valor,
       usuario.id as id_usuario,
       usuario.nombre_usuario,
       usuario.cedula,
       parque.id  as id_parque,
       parque.nombre_parque,
       parque.codigo,
       parque.direccion,
       parque.telefono
from tiquete
         inner join usuario on tiquete.id_usuario = usuario.id
         inner join parque on tiquete.id_parque = parque.id
order by tiquete.fecha_compra desc

