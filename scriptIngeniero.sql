drop table if exists OFI_EDIFICIO;

drop table if exists OFI_INSTITUCION;

drop table if exists OFI_SEDE;

drop table if exists SEG_PERFIL;

drop table if exists SEG_USUARIO;

drop table if exists SEG_USUARIO_PERFIL;

/*==============================================================*/
/* Table: OFI_EDIFICIO                                          */
/*==============================================================*/
create table OFI_EDIFICIO (
    COD_EDIFICIO varchar(8) not null,
    COD_SEDE varchar(8) not null,
    NOMBRE varchar(128) not null,
    PISOS numeric(2, 0) not null,
    SUPERFICIE numeric(7, 2),
    VERSION int not null,
    primary key (COD_EDIFICIO, COD_SEDE)
);

/*==============================================================*/
/* Table: OFI_INSTITUCION                                       */
/*==============================================================*/
create table OFI_INSTITUCION (
    COD_INSTITUCION numeric(3, 0) not null,
    RUC varchar(13) not null,
    RAZON_SOCIAL varchar(250) not null,
    VERSION int not null,
    primary key (COD_INSTITUCION)
);

/*==============================================================*/
/* Table: OFI_SEDE                                              */
/*==============================================================*/
create table OFI_SEDE (
    COD_SEDE varchar(8) not null,
    COD_INSTITUCION numeric(3, 0),
    NOMBRE varchar(100) not null,
    DIRECCION varchar(200),
    ES_PRINCIPAL boolean not null,
    FECHA_CREACION date not null,
    VERSION int not null,
    primary key (COD_SEDE)
);

alter table
    OFI_EDIFICIO
add
    constraint FK_EDIFICIO_A_SEDE foreign key (COD_SEDE) references OFI_SEDE (COD_SEDE) on delete restrict on update restrict;

alter table
    OFI_SEDE
add
    constraint FK_SEDE_A_INSTITUCION foreign key (COD_INSTITUCION) references OFI_INSTITUCION (COD_INSTITUCION) on delete restrict on update restrict;