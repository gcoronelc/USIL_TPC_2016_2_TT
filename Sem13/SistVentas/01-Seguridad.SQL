/*
Empresa        :  EGCC
Software       :  Sistema de Ventas
DBMS           :  MySQL
Esquema        :  VENTAS
Módulo         :  SEGURIDAD
Script         :  Crea la base de datos con sus respectivas tablas
Responsable    :  Ing. Eric Gustavo Coronel Castillo
Telefono       :  (511) 9966-64457
Email          :  gcoronelc@gmail.com
Blog           :  http://gcoronelc.blogspot.com
Creado el      :  31-OCT-2016
*/



-- =============================================
-- Creación de la Base de Datos
-- =============================================

DROP DATABASE IF EXISTS SISTVENTAS;

CREATE DATABASE SISTVENTAS;


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE SISTVENTAS;
SET NAMES 'utf8';


-- =============================================
-- CREACION DE TABLAS
-- =============================================

CREATE TABLE EMPLEADO
(
	idemp                INTEGER AUTO_INCREMENT,
	nombre               VARCHAR(50) NOT NULL,
	apellido             VARCHAR(50) NOT NULL,
	email                VARCHAR(50) NOT NULL,
	telefono             VARCHAR(20) NULL,
	dni                  VARCHAR(15) NOT NULL,
	direccion            VARCHAR(100) NOT NULL,
	estado               NUMERIC(2,0) NOT NULL CHECK ( estado IN (1, 0) ),
 	CONSTRAINT PK_EMPLEADO PRIMARY KEY (idemp)
);



CREATE TABLE USUARIO
(
	idemp                INTEGER NOT NULL,
	usuario              VARCHAR(20) NOT NULL,
	clave                VARCHAR(40) NOT NULL,
	estado               NUMERIC(2,0) NOT NULL  CHECK ( estado IN (1, 0) ),
	CONSTRAINT PK_USUARIO PRIMARY KEY (idemp),
	CONSTRAINT FK_USUARIO_EMPLEADO FOREIGN KEY (idemp) REFERENCES EMPLEADO (idemp)
);



CREATE TABLE ROL
(
	idrol                INTEGER AUTO_INCREMENT,
	nombre               VARCHAR(30) NOT NULL,
	descripcion          VARCHAR(150) NOT NULL,
	estado               NUMERIC(2,0) NOT NULL CHECK ( estado IN (1, 0) ),
	CONSTRAINT PK_ROL PRIMARY KEY (idrol)
);



CREATE TABLE PERMISO
(
	idrol                INTEGER NOT NULL,
	idemp                INTEGER NOT NULL,
	estado               NUMERIC(2,0) NOT NULL CHECK ( estado IN (1, 0) ),
	CONSTRAINT PK_PERMISO PRIMARY KEY (idrol,idemp),
	CONSTRAINT FK_PERMISO_USUARIO FOREIGN KEY FK_PERMISO_USUARIO (idemp) REFERENCES USUARIO (idemp),
	CONSTRAINT FK_PERMISO_ROL     FOREIGN KEY FK_PERMISO_ROL (idrol) REFERENCES ROL (idrol)
);


-- =============================================
-- INGRESO DE DATOS
-- =============================================


-- Tabla EMPLEADO

--    idemp   nombre    apellido  email     telefono   dni       direccion  estado   

INSERT INTO EMPLEADO 
VALUES(1001,'CLAUDIA  ALEJANDRA','RAMOS CASTILLO','cramos@gmail.com','98456732','98435687','LIMA',1);

INSERT INTO EMPLEADO 
VALUES(1002,'ALICIA ANGELICA','TORRES VILCA','atorres@gmail.com','967345634','56423698','MIRAFLORES',1);

INSERT INTO EMPLEADO  
VALUES(1003,'KARLA LIZETH','GUTIERREZ FERNANDEZ','kgutierrez@gmail.com','995466783','56324587','LINCE',1);

INSERT INTO EMPLEADO  
VALUES(1004,'FERNANDA LEONOR','CORONEL CARRASCO','fcoronel@gmail.com','986754373','45963258','LIMA',0);

INSERT INTO EMPLEADO  
VALUES(1005,'JUAN CARLOS','ROMERO CARRASCO','jcarlos@gmail.com','986544521','45636545','LA MOLINA',1);

INSERT INTO EMPLEADO  
VALUES(1006,'ALICIA JANETH','ARBIETO MENDOZA','aarbieto@gmail.com','975698451','96584521','LA MOLINA',1);

INSERT INTO EMPLEADO  
VALUES(1007,'CRISTINA ELENA','ALFARO VELAZQUE','calfarov@gmail.com','965486267','10365845','LOS OLIVOS',1);


-- Tabla USUARIO

-- idemp   usuario   clave   estado 

INSERT INTO USUARIO VALUES(1001,'claudia',SHA('suerte'),1);
INSERT INTO USUARIO VALUES(1002,'alicia',SHA('maravilla'),1);
INSERT INTO USUARIO VALUES(1003,'karla',SHA('princesa'),1);
INSERT INTO USUARIO VALUES(1004,'leonor',SHA('cerebro'),1);
INSERT INTO USUARIO VALUES(1006,'janeth',SHA('felicidad'),1);
INSERT INTO USUARIO VALUES(1007,'cristina',SHA('encantadora'),1);


-- Tabla: ROLES

-- idrol       nombre       descripcion        estado      

INSERT INTO ROL VALUES(1,'Administrador','No tiene ningun tipo de restricción',1);
INSERT INTO ROL VALUES(2,'Vendeor','Tiene acceso a los módulos de Ventas y Consultas',1);
INSERT INTO ROL VALUES(3,'Operador','Tiene acceso a los módulos de Mantenimiento, Consultas y Reportes',1);
INSERT INTO ROL VALUES(4,'Usuario','Tiene acceso a los módulos de Consultas y Reportes',1);



-- Tabla: PERMISOS

-- idrol   idemp    estado

-- Usuario 1001

INSERT INTO PERMISO VALUES(1,1001,1);
INSERT INTO PERMISO VALUES(2,1001,0);
INSERT INTO PERMISO VALUES(3,1001,0);
INSERT INTO PERMISO VALUES(4,1001,0);


-- Usuario 1002

INSERT INTO PERMISO VALUES(1,1002,0);
INSERT INTO PERMISO VALUES(2,1002,1);
INSERT INTO PERMISO VALUES(3,1002,0);
INSERT INTO PERMISO VALUES(4,1002,0);


-- Usuario 1003

INSERT INTO PERMISO VALUES(1,1003,0);
INSERT INTO PERMISO VALUES(2,1003,0);
INSERT INTO PERMISO VALUES(3,1003,1);
INSERT INTO PERMISO VALUES(4,1003,0);


-- Usuario 1004

INSERT INTO PERMISO VALUES(1,1004,0);
INSERT INTO PERMISO VALUES(2,1004,0);
INSERT INTO PERMISO VALUES(3,1004,0);
INSERT INTO PERMISO VALUES(4,1004,1);


-- Usuario 1006

INSERT INTO PERMISO VALUES(1,1006,0);
INSERT INTO PERMISO VALUES(2,1006,0);
INSERT INTO PERMISO VALUES(3,1006,1);
INSERT INTO PERMISO VALUES(4,1006,0);

-- Usuario 1007

INSERT INTO PERMISO VALUES(1,1007,0);
INSERT INTO PERMISO VALUES(2,1007,1);
INSERT INTO PERMISO VALUES(3,1007,0);
INSERT INTO PERMISO VALUES(4,1007,0);


-- =============================================
-- USUARIO PARA LAS APLICACIONES
-- =============================================

USE MYSQL;
GRANT ALL PRIVILEGES ON *.* TO 'ventas'@'%' IDENTIFIED BY 'admin' WITH GRANT OPTION;
FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON *.* TO 'ventas'@'localhost' IDENTIFIED BY 'admin' WITH GRANT OPTION;
FLUSH PRIVILEGES;

USE SISTVENTAS;





