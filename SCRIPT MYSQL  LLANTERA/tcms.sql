CREATE DATABASE clms;
USE clms;
CREATE TABLE proveedor(
   id_proveedor INT PRIMARY KEY,
   nombre_proveedor VARCHAR(100),
   nombre_empresa VARCHAR(150),
   telefono_empresa VARCHAR(10),
   correo_empresa VARCHAR(255)
)ENGINE=InnoDB;
DELETE FROM proveedor WHERE nombre_proveedor = 'Valeria Villanueva';
SELECT * FROM proveedor;
CREATE TABLE cliente(
   id_cliente INT PRIMARY KEY,
   nombre_cliente VARCHAR(100),
   direccion_cliente VARCHAR(150),
   telefono_cliente VARCHAR(10),
   correo_cliente VARCHAR(255)
)ENGINE=InnoDB;
SELECT * FROM cliente;
CREATE TABLE empleado(
   id_empleado INT PRIMARY KEY,
   nombre_empleado VARCHAR(100),
   direccion_empleado VARCHAR(150),
   telefono_empleado VARCHAR(10),
   fecha_nacimiento VARCHAR(100),
   pass_word VARCHAR(20),
   estatus VARCHAR(25)
)ENGINE=InnoDB;
DROP TABLE empleado;
SELECT * FROM empleado;
CREATE TABLE producto(
   id_producto INT PRIMARY KEY,
   nombre_producto VARCHAR(100),
   descripcion VARCHAR(300),
   stock int,
   precio_venta int
)ENGINE=InnoDB;
DROP TABLE producto;

DESCRIBE producto;
SELECT * FROM producto;
DELETE FROM producto WHERE nombre_producto = 'Llantas Fire';

CREATE TABLE pedido(
   id_pedido INT PRIMARY KEY,
   fecha_pe VARCHAR(100),
   fk_id_empleado INT NOT NULL,
   fk_id_proveedor INT NOT NULL,
   FOREIGN KEY(fk_id_empleado) REFERENCES empleado(id_empleado),
   FOREIGN KEY(fk_id_proveedor) REFERENCES proveedor(id_proveedor)
)ENGINE=InnoDB;
select * from pedido;
DESCRIBE pedido;
DELETE FROM pedido WHERE id_pedido = 1;
INSERT INTO pedido VALUES(1,'14/11/2021',1,1);

CREATE TABLE detalle_pedido(
   id_detalle_pedido INT PRIMARY KEY,
   cantidad INT,
   precio INT,
   fk_id_pedido INT NOT NULL,
   fk_id_producto INT NOT NULL,
   FOREIGN KEY(fk_id_pedido) REFERENCES pedido(id_pedido),
   FOREIGN KEY(fk_id_producto) REFERENCES producto(id_producto)
)ENGINE=InnoDB;
select * from detalle_pedido;
SELECT * FROM producto;
DROP TABLE detalle_pedido;
select * from detalle_pedido where fk_id_pedido = 27;

insert into detalle_pedido values (1,1,100,1,1);
insert into detalle_pedido values (2,2,200,1,2);
CREATE TABLE IVA(
   id_IVA INT PRIMARY KEY,
   porcentaje FLOAT,
   fecha_aplicacion VARCHAR(300)
)ENGINE=InnoDB;
DESCRIBE IVA;
SELECT * FROM IVA;
CREATE TABLE venta(
   id_venta INT PRIMARY KEY,
   fecha_venta VARCHAR(100),
   fkv_id_empleado INT NOT NULL,
   fkv_id_cliente INT NOT NULL,
   FOREIGN KEY(fkv_id_empleado) REFERENCES empleado(id_empleado),
   FOREIGN KEY(fkv_id_cliente) REFERENCES cliente(id_cliente)
)ENGINE=InnoDB;
select * from venta;
insert into venta values(1,'14/11/2021',2,1);


CREATE TABLE detalle_venta(
	id_detalle_venta INT PRIMARY KEY,
    cantidad INT,
    precio INT,
    fk_id_venta INT NOT NULL,
    fk_id_producto INT NOT NULL,
    FOREIGN KEY(fk_id_venta) REFERENCES venta(id_venta),
    FOREIGN KEY(fk_id_producto) REFERENCES producto(id_producto)
)ENGINE=InnoDB;
select * from detalle_venta;
DROP TABLE detalle_venta;
insert into detalle_venta values(1,1,150,1,2);