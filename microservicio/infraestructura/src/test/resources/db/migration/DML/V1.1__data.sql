insert into usuario(id, nombre_usuario, cedula)
values (1, 'test', '123456');
insert into usuario(id, nombre_usuario, cedula)
values (2, 'test eliminar', '1234567890');
insert into usuario(id, nombre_usuario, cedula)
values (3, 'test actualizar', '0987654');
insert into etapa(id, nombre_etapa, codigo, direccion, telefono)
values (1, 'test listar', '987654', 'Calle 1 # 2-3', '456789');
insert into etapa(id, nombre_etapa, codigo, direccion, telefono)
values (2, 'test actualizar', '333333', 'Calle 3 # 3-3', '333333');
insert into etapa(id, nombre_etapa, codigo, direccion, telefono)
values (3, 'test eliminar', '222222', 'Calle 2 # 2-2', '222222');
insert into proceso(id, id_usuario, id_etapa, fecha_compra, valor)
values (1, 1, 1, '2021-03-18', 15000);
insert into proceso(id, id_usuario, id_etapa, fecha_compra, valor)
values (2, 1, 1, '2021-03-19', 30000);
insert into proceso(id, id_usuario, id_etapa, fecha_compra, valor)
values (3, 1, 1, '2021-03-19', 30000);


