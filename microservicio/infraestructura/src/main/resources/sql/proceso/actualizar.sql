update proceso
set id_usuario   = :idUsuario,
    id_etapa    = :idEtapa,
    fecha_compra = :fechaCompra,
    valor        = :valor
where id = :id