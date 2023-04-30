update tiquete
set id_usuario   = :idUsuario,
    id_parque    = :idParque,
    fecha_compra = :fechaCompra,
    valor        = :valor
where id = :id