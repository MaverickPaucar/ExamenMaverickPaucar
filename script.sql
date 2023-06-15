drop table OFI_EDIFICIO;

drop table OFI_INSTITUCION;

drop table OFI_SEDE;

/*==============================================================*/
/* Table: OFI_EDIFICIO                                          */
/*==============================================================*/
create table OFI_EDIFICIO (
    COD_EDIFICIO VARCHAR(8) not null,
    COD_SEDE VARCHAR(8) not null,
    NOMBRE VARCHAR(128) not null,
    PISOS NUMERIC(2, 0) not null,
    SUPERFICIE NUMERIC(7, 2) not null,
    VERSION INT4 not null,
    constraint PK_OFI_EDIFICIO primary key (COD_EDIFICIO, COD_SEDE)
);

/*==============================================================*/
/* Table: OFI_INSTITUCION                                       */
/*==============================================================*/
create table OFI_INSTITUCION (
    COD_INSTITUCION NUMERIC(3, 0) not null,
    RUC VARCHAR(8) not null,
    RAZON_SOCIAL VARCHAR(250) not null,
    VERSION INT4 not null default 0,
    constraint PK_OFI_INSTITUCION primary key (COD_INSTITUCION)
);

/*==============================================================*/
/* Table: OFI_SEDE                                              */
/*==============================================================*/
create table OFI_SEDE (
    COD_SEDE VARCHAR(8) not null,
    COD_INSTITUCION NUMERIC(3, 0) null,
    NOMBRE VARCHAR(100) not null,
    DIRECCION VARCHAR(200) not null,
    ES_PRINCIPAL BOOL not null,
    FECHA_CREACION DATE not null,
    VERSION INT4 not null,
    constraint PK_OFI_SEDE primary key (COD_SEDE)
);

alter table
    OFI_EDIFICIO
add
    constraint FK_OFI_EDIF_REFERENCE_OFI_SEDE foreign key (COD_SEDE) references OFI_SEDE (COD_SEDE) on delete restrict on update restrict;

alter table
    OFI_SEDE
add
    constraint FK_OFI_SEDE_REFERENCE_OFI_INST foreign key (COD_INSTITUCION) references OFI_INSTITUCION (COD_INSTITUCION) on delete restrict on update restrict;