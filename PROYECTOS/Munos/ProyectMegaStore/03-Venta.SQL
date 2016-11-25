
USE wilsonstore;


-- =============================================
-- Crea las tablas
-- =============================================

CREATE TABLE VENTA
(
	idventa              INTEGER AUTO_INCREMENT,
	idemp                INTEGER NOT NULL,
	cliente              VARCHAR(100) NOT NULL,
	fecha                DATE NOT NULL,
	importe              NUMERIC(10,2) NOT NULL,
	impuesto             NUMERIC(10,2) NOT NULL,
	total                NUMERIC(10,2) NOT NULL,
	CONSTRAINT PK_VENTA PRIMARY KEY (idventa),
	FOREIGN KEY FK_VENTA_USUARIO (idemp) REFERENCES USUARIO (idemp)
);



CREATE TABLE TIPO_PAGO
(
	idtipo               INTEGER NOT NULL,
	nombre               VARCHAR(50) NOT NULL,
	CONSTRAINT PK_TIPO_PAGO PRIMARY KEY (idtipo)
);



CREATE TABLE PAGO
(
	idpago               INTEGER AUTO_INCREMENT,
	idventa              INTEGER NOT NULL,
	idtipo               INTEGER NOT NULL,
	detalle              VARCHAR(100) NOT NULL,
	importe              NUMERIC(10,2) NOT NULL,
	obs                  VARCHAR(1000) NOT NULL,
	CONSTRAINT PK_PAGO PRIMARY KEY (idpago),
	FOREIGN KEY FK_PAGO_VENTA (idventa) REFERENCES VENTA (idventa),
	FOREIGN KEY FK_PAGO_TIPO_PAGO (idtipo) REFERENCES TIPO_PAGO (idtipo)
);



CREATE UNIQUE INDEX U_PAGO_UNIQUE ON PAGO
(
	idventa,
	idtipo
);



CREATE TABLE DETALLE
(
	iddetalle            INTEGER AUTO_INCREMENT,
	idventa              INTEGER NOT NULL,
	idprod               INTEGER NOT NULL,
	cant                 INTEGER NOT NULL,
	precatalogo          NUMERIC(10,2) NOT NULL,
	preventa             NUMERIC(10,2) NULL,
	subtotal             NUMERIC(10,2) NULL,
	CONSTRAINT PK_DETALLE PRIMARY KEY (iddetalle),
	FOREIGN KEY FK_DETALLE_PRODUCTO (idprod) REFERENCES PRODUCTO (idprod),
	FOREIGN KEY FK_DETALLE_VENTA (idventa) REFERENCES VENTA (idventa)
);



CREATE UNIQUE INDEX U_DETALLE ON DETALLE
(
	idventa,
	idprod
);



-- =============================================
-- Datos
-- =============================================

INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(1,'EFECTIVO');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(2,'TARJETA CREDITO');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(3,'TARJETA DE DEBITO');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(4,'CHEQUE');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(5,'NOTA DE CREDITO');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(6,'BONO EFECTIVO');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(7,'VUELTO');





