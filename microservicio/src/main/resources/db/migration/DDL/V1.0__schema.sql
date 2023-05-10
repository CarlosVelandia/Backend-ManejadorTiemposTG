create table usuario
(
    id             int(11) not null auto_increment,
    nombre_usuario varchar(100) not null,
    cedula         varchar(15)  not null,
    primary key (id)
);
create table etapa
(
    id            int(11) not null auto_increment,
    nombre_etapa varchar(100) not null,
    codigo        varchar(45)  not null,
    direccion     varchar(45)  not null,
    telefono      varchar(20)  not null,
    primary key (id)
);

create table proceso
(
    id           int(11) not null auto_increment,
    id_usuario   int(11) not null,
    id_etapa    int(11) not null,
    fecha_compra date   not null,
    valor        double not null,
    primary key (id),
    foreign key (id_usuario) REFERENCES usuario (id),
    foreign key (id_etapa) REFERENCES etapa (id)
)
