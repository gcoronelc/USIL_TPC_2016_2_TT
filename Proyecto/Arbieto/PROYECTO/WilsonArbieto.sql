/*
Empresa        :  USIL
Software       :  Sistema de Ventas
DBMS           :  MySQL
Esquema        :  WILSONSTORE
Script         :  Crea la base de datos con sus respectivas tablas
Responsable    :  JULIO CESAR ARBIETO CHAVEZ
                  JUAN ANDRADE PERALES
				  BRIGITH AMASIFUEN
Telefono       :  (51) 940-126-516
Email          :  arbieto.jc@gmail.com
Creado el      :  14-setiembre-2016

*/

-- =============================================
-- Creación de la Base de Datos
-- =============================================

DROP DATABASE IF EXISTS WilsonStore;


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================
use VENTAS_WilsonStore;

-- =============================================
-- creacion de la tabla ecepcionista
-- =============================================
create table Recepcionista(
    -> ID_recepcionista char(5) not null primary key,
    -> Nombre varchar(20) not null,
    -> Apellido varchar(20) not null,
    -> DNI varchar(8) not null,
    -> telefono varchar(9) not null,
    -> correo varchar(30) not null,
    -> clave varchar(30) not null);
-- =============================================
-- creacion de la tabla Administrador
-- =============================================
create table Administrador(
    -> ID_Administrador char(5) not null primary key,
    -> Nombre varchar(20) not null,
    -> Apellido varchar(20) not null,
    -> DNI varchar(8) not null,
    -> telefono varchar(9) not null,
    -> correo varchar(30) not null,
    -> clave varchar(30) not null);
-- =============================================
-- creacion de la tabla Usuario
-- =============================================
create table Usuario(
    -> ID_Usuario char(5) not null primary key,
    -> hora_Ingreso time not null,
    -> hora_salida time not null,
    -> totHoraPermanecida float not null,
    -> fecha date not null);
-- =============================================
-- creacion de las llaves foreanas
-- =============================================
-------------------(Usuario y Administrador)---------------------------------
MariaDB [VENTAS_WilsonStore]> alter table Usuario add column ID_Administrador char(5) not null;
MariaDB [VENTAS_WilsonStore]> alter table Usuario add foreign key(ID_Administrador) references Administrador(ID_Administrador);
-------------------(Recepcionista y Usuario)--------------------------------
MariaDB [VENTAS_WilsonStore]> alter table Usuario add column ID_recepcionista char(5) not null;
MariaDB [VENTAS_WilsonStore]> alter table Usuario add foreign key(ID_recepcionista) references Recepcionista(ID_recepcionista);
-- =============================================
-- creacion de la tabla Articulo
-- =============================================
MariaDB [VENTAS_WilsonStore]> create table Articulo(
    -> ID_Articulo char(5) not null primary key,
    -> Nombre varchar(20) not null,
    -> Precio numeric(8,2) not null,
    -> Stock integer);
-- =============================================
-- creacion de la tabla Categoria
-- =============================================
MariaDB [VENTAS_WilsonStore]> create table Categoria(
    -> ID_Categoria char(5) not null primary key,
    -> nombre varchar(50) not null);
--------------------(Categoria y Articulo)----------------
MariaDB [VENTAS_WilsonStore]> alter table Articulo add column ID_Categoria char(5) not null;
MariaDB [VENTAS_WilsonStore]> alter table Articulo add foreign key(ID_Categoria) references Categoria(ID_Categoria);
-- =============================================
-- creacion de la tabla Bono_Descuento
-- =============================================
MariaDB [VENTAS_WilsonStore]> create table Bono_Descuento(
    -> ID_Bono char(5) not null primary key,
    -> Motivo varchar(50) not null,
    -> PorcentajeDescuento varchar(15) not null);
-- =============================================
-- creacion de la tabla Bono_Descuento
-- =============================================
MariaDB [VENTAS_WilsonStore]> create table Detalle(
    -> ID_Detalle char(5) not null primary key,
    -> precio numeric(8,2) not null,
    -> cantidad numeric(8,2)not null,
    -> importe numeric(8,2) not null,
    -> impuesto numeric(8,2) not null,
    -> total numeric(8,2));
----------------------(Detalle y Articulo)----------------
MariaDB [VENTAS_WilsonStore]> alter table Detalle add column ID_Articulo char(5)not null;
MariaDB [VENTAS_WilsonStore]> alter table Detalle add foreign key(ID_Articulo) references Articulo(ID_Articulo);
----------------------(Detalle y Bono_Descuento)----------
MariaDB [VENTAS_WilsonStore]> alter table Detalle add column ID_Bono char(5) not null;
MariaDB [VENTAS_WilsonStore]> alter table Detalle add foreign key(ID_Bono) references Bono_Descuento(ID_Bono);
-- =============================================
-- creacion de la tabla Cliente
-- =============================================
MariaDB [VENTAS_WilsonStore]> create table Cliente(
    -> ID_Cliente char(5) not null primary key,
    -> Nombre varchar(20) not null,
    -> Apellido varchar(20) not null,
    -> DNI varchar(8) not null,
    -> telefono varchar(9) not null,
    -> correo varchar(30) not null,
    -> direccion varchar(30) not null);
-- =============================================
-- creacion de la tabla Venta
-- =============================================
MariaDB [VENTAS_WilsonStore]> create table Venta(
    -> ID_Venta char(5) not null primary key,
    -> fecha date not null);
------------------------(Venta y Cliente)-------------------------------
MariaDB [VENTAS_WilsonStore]> alter table Venta add column ID_Cliente char(5) not null;
MariaDB [VENTAS_WilsonStore]> alter table Venta add foreign key(ID_Cliente) references Cliente(ID_Cliente);
------------------------(Venta y Recepcionista)-------------------------
MariaDB [VENTAS_WilsonStore]> alter table Venta add column ID_recepcionista char(5) not null;
MariaDB [VENTAS_WilsonStore]> alter table Venta add foreign key(ID_recepcionista) references Recepcionista(ID_recepcionista);
------------------------(Venta y Detalle)-------------------------------
MariaDB [VENTAS_WilsonStore]> alter table Venta add column ID_Detalle char(5) not null;
MariaDB [VENTAS_WilsonStore]> alter table Venta add foreign key(ID_Detalle) references Detalle(ID_Detalle);
-- =============================================
-- creacion de la tabla Pago
-- =============================================
MariaDB [VENTAS_WilsonStore]> create table Pago(
    -> ID_Pago char(5) not null primary key,
    -> detalle varchar(50) not null,
    -> observacion varchar(50) not null);
------------------------(Venta y Pago)----------------
MariaDB [VENTAS_WilsonStore]> alter table Venta add column ID_Pago char(5) not null;
MariaDB [VENTAS_WilsonStore]> alter table Venta add foreign key(ID_Pago) references Pago(ID_Pago);
-- =============================================
-- creacion de la tabla TipoPago
-- =============================================
MariaDB [VENTAS_WilsonStore]> create table TipoPago(
    -> ID_Tipo char(5) not null primary  key,
    -> NombreTipo varchar(20) not null);
----------------------(TipoPago)-----------------------
MariaDB [VENTAS_WilsonStore]> alter table Pago add column ID_Tipo char(5) not null;
MariaDB [VENTAS_WilsonStore]> alter table Pago add foreign key(ID_Tipo) references TipoPago(ID_Tipo);

