update parque
set nombre_parque = :nombre,
    codigo        = :codigo,
    direccion     = :direccion,
    telefono      = :telefono
where id = :id