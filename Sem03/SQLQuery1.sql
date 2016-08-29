create database martukawa1
go
use martukawa1
go
create table tp_usuario(
id integer identity(1,1)not null primary key,
descripcion varchar(30))
go
create table usuario(
id integer identity(1,1)not null primary key,
usuario varchar(20) unique,
contra varchar(100),
nombre varchar(100),
tp_user integer references tp_usuario(id))
go
create table tp_cliente(
id integer identity(1,1)not null primary key,
descripcion varchar(30),
descuento decimal)
go
create table cliente(
id integer identity(1,1)not null primary key,
usuario varchar(20) unique,
contra varchar(20),
tp_cliente integer references tp_cliente(id))
go
create table tp_producto(
id integer identity(1,1) primary key,
descripcion varchar(30))
go
create table cliente_tpprod(
id integer identity(1,1) primary key,
id_cliente integer references cliente(id),
tp_producto integer references tp_producto(id),
descuento decimal(3,2),
motivo varchar(100),
fec_ini date,
fec_fin date
)
go
create table producto(
id integer identity(1,1) primary key,
tp_producto integer references tp_producto(id),
nombre varchar(100),
precio real,
descripcion text)
go
create table venta(
id integer identity(1,1) primary key, 
is_cliente integer references cliente(id),
fecha date,
is_usuario_reg integer references usuario(id),
)
go
create table venta_detalle(
id integer identity(1,1) primary key, 
id_venta integer references venta(id),
id_producto integer references producto(id),
cantidad int
)