create table usuario
(
    id             int(11) not null auto_increment,
    nombre_usuario varchar(100) not null,
    cedula         varchar(15)  not null,
    primary key (id)
);
create table parque
(
    id            int(11) not null auto_increment,
    nombre_parque varchar(100) not null,
    codigo        varchar(45)  not null,
    direccion     varchar(45)  not null,
    telefono      varchar(20)  not null,
    primary key (id)
);

create table tiquete
(
    id           int(11) not null auto_increment,
    id_usuario   int(11) not null,
    id_parque    int(11) not null,
    fecha_compra date   not null,
    valor        double not null,
    primary key (id),
    foreign key (id_usuario) REFERENCES usuario (id),
    foreign key (id_parque) REFERENCES parque (id)
)
