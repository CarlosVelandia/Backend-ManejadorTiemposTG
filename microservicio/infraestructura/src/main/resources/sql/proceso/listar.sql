select proceso.id,
       proceso.fecha_compra,
       proceso.valor,
       usuario.id as id_usuario,
       usuario.nombre_usuario,
       usuario.cedula,
       parque.id  as id_parque,
       parque.nombre_parque,
       parque.codigo,
       parque.direccion,
       parque.telefono
from proceso
         inner join usuario on proceso.id_usuario = usuario.id
         inner join parque on proceso.id_parque = parque.id
order by proceso.fecha_compra desc

