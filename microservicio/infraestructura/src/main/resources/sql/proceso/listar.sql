select proceso.id,
       proceso.fecha_compra,
       proceso.valor,
       usuario.id as id_usuario,
       usuario.nombre_usuario,
       usuario.cedula,
       etapa.id  as id_etapa,
       etapa.nombre_etapa,
       etapa.codigo,
       etapa.direccion,
       etapa.telefono
from proceso
         inner join usuario on proceso.id_usuario = usuario.id
         inner join etapa on proceso.id_etapa = etapa.id
order by proceso.fecha_compra desc

