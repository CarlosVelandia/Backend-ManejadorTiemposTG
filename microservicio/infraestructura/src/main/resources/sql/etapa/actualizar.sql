update etapa
set nombre_etapa = :nombre,
    codigo        = :codigo,
    direccion     = :direccion,
    telefono      = :telefono
where id = :id