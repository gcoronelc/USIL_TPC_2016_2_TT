

USE wilsonstore;


-- =============================================
-- Crea las tablas
-- =============================================


CREATE TABLE CATEGORIA
(
	idcat                INTEGER NOT NULL,
	nombre               VARCHAR(50) NOT NULL,
	descripcion          TEXT NOT NULL,
	CONSTRAINT PK_CATEGORIA PRIMARY KEY (idcat)
);



CREATE TABLE PRODUCTO
(
	idprod               INTEGER AUTO_INCREMENT,
	idcat                INTEGER NOT NULL,
	nombre               VARCHAR(100) NOT NULL,
	descripcion          TEXT NOT NULL,
	precio               NUMERIC(10,2) NOT NULL,
	stock                INTEGER NOT NULL,
	estado               INTEGER NOT NULL,
	CONSTRAINT PK_PRODUCTO PRIMARY KEY (idprod),
	FOREIGN KEY FK_PRODUCTO_CATEGORIA (idcat) REFERENCES CATEGORIA (idcat)
);



CREATE TABLE PROMOCION
(
	idprom               INTEGER NOT NULL,
	fecInicio            DATE NOT NULL,
	fecFin               DATE NOT NULL,
	precio               NUMERIC(10,2) NOT NULL,
	oferta               NUMERIC(10,2) NOT NULL,
	idprod               INTEGER NOT NULL,
	estado               INTEGER NOT NULL,
	anulado              INTEGER NOT NULL,
	CONSTRAINT PK_PROMOCION PRIMARY KEY (idprom),
	FOREIGN KEY FK_PROMOCION_PRODUCTO (idprod) REFERENCES PRODUCTO (idprod)
);



CREATE TABLE CAMPANIA
(
	idcamp               INTEGER AUTO_INCREMENT,
	nombre               VARCHAR(150) NOT NULL,
	descripcion          TEXT NOT NULL,
	fecInicio            DATE NOT NULL,
	fecFin               DATE NOT NULL,
	estado               INTEGER NOT NULL,
	anulado              INTEGER NOT NULL,
	CONSTRAINT PK_CAMPANIA PRIMARY KEY (idcamp)
);



CREATE TABLE DETCAMPANIA
(
	idcamp               INTEGER NOT NULL,
	idprod               INTEGER NOT NULL,
	precio               NUMERIC(10,2) NOT NULL,
	oferta               NUMERIC(10,2) NOT NULL,
	porcDcto             NUMERIC(10,2) NOT NULL,
	estado               INTEGER NOT NULL,
	anulado              INTEGER NOT NULL,
	CONSTRAINT PK_DETCAMPANIA PRIMARY KEY (idcamp,idprod),
	FOREIGN KEY FK_DETCAMPANIA_CAMPANIA (idcamp) REFERENCES CAMPANIA (idcamp),
	FOREIGN KEY FK_DETCAMPANIA_PRODUCTO (idprod) REFERENCES PRODUCTO (idprod)
);


-- =============================================
-- Datos
-- =============================================

-- Tabla CATEGORIA

INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(1,'LINEA BLANCA','Productos para tu hogar, como cocina, refrigaradora, etc.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(2,'MENAJE','Lo mejor del menaje del mundo a tu alcance.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(3,'CAMA','Las mejores marcas para tu mejores sueños.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(4,'MUEBLES','Variados modelos para cada rincon de tu casa.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(5,'ROPA DE DAMAS','Las mejores marcas del mundo a los precios mas bajos.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(6,'ROPA DE CABALLEROS','Variados modelos para tus mejores ocaciones.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(7,'ROPA DE SEÑORITAS','Las prendas mas lindas para que puedas lucirte.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(8,'ROPA DE NIÑOS','Todo lo necesario para tu niño');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(9,'ROPA DE NIÑAS','Tu niña merece los mejor.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(10,'ELECTRODOMESTICOS','Todas las marcas y modelos.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(11,'COMPUTO','Los ultimos modelos a los mejores precios.');


-- Tabla PRODUCTO

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(1,1,'COCINA',900.0,456,'La mejor cocina para tu mejor receta',1);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(2,7,'PANTALON',150.0,4567,'Diversos colores y modelos,',1);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(3,1,'REFRIGERADORA',1300.0,690,'Garantia de 2 años.',1);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(4,7,'POLO DE VERANO',95.00,150,'Colores frescos.',1);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(5,6,'CAMISA COLOR VERDE',140.00,250,'Lucete con una buena marca.',1);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(6,6,'CAMISA DE CUADROS PEQUEÑOS',140.00,350,'Modelo exclusivo.',0);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(7,6,'PANTALON MODELO A1',1180.00,450,'Especial para lucirte con tu pareja.',1);


-- Tabla PROMOCION


-- idprom    fecInicio  fecFin     precio     oferta     idprod     estado     anulado   

INSERT INTO PROMOCION VALUES(1,'20160701','20160731',950.0,799.0,1,1,0);
INSERT INTO PROMOCION VALUES(2,'20161101','20161130',900.0,750.0,1,1,0);