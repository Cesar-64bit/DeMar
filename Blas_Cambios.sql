-- CESAR_23/07/2022
INSERT INTO `demar`.`areas` (`nombre`, `insumo_entrada`, `cantidad_empleados`, `sueldo_base`, `hora_entrada`, `hora_salida`) VALUES ('Administración', 'insumo', '1', '0', '2020-01-01 07:00:00', '2020-01-01 15:00:00');
INSERT INTO `demar`.`areas` (`nombre`, `insumo_entrada`, `cantidad_empleados`, `sueldo_base`, `hora_entrada`, `hora_salida`) VALUES ('Recepcionista', 'insumo', '1', '0', '2020-01-01 07:00:00', '2020-01-01 15:00:00');
INSERT INTO demar.empleados (nombre, telefono, direccion, dias_laborados, fecha_contrato, imagen, idareas, estado) VALUES
("Cesar Oswaldo Bernal Sanchez", "3333333333", "C. Castillo", 6, "2022-09-28", "Aqui una imagen", 6, 1),
("Nadia Gomez Perez", "9999999999", "C. Castillo", 6, "2021-09-29", "Aqui una imagen2", 7, 1);
INSERT INTO demar.perfiles (nombre, descripcion) VALUES
("Administrador", "Tiene acceso a todo el sistema"),
("Recepcion", "Acceso a recepcion y detalles pedidos");
UPDATE demar.perfiles SET nombre="Recepcionista" WHERE id = 2;
INSERT INTO demar.usuarios (identificador, nombre, contraseña, idEmpleado, idPerfil, estado) VALUES
("1", "COBS", "cesar123", 6, 1, 1),
("2", "NGP", "nadia123", 7, 2, 1);



-- BLAS_24/07/2022
-- Procedimiento para BUSCAR UN PEDIDO CON FOLIO
USE `demar`;
DROP procedure IF EXISTS `buscarUnPedido`;
DELIMITER $$
USE `demar`$$
CREATE PROCEDURE `buscarUnPedido` (IN idPedido VARCHAR(11))
BEGIN
	SELECT * FROM demar.pedidos WHERE id = idPedido;
END$$
DELIMITER ;
-- -----------------------------------------------------------
-- Procedimiento para SELECCIONAR TODOS LOS PEDIDOS PENDIENTES
USE `demar`;
DROP procedure IF EXISTS `seleccionarPedidos`;
DELIMITER $$
USE `demar`$$
CREATE PROCEDURE `seleccionarPedidos` ()
BEGIN
	SELECT * FROM demar.pedidos;
END$$
DELIMITER ;
-- -----------------------------
-- Modificación en tabla PEDIDOS
ALTER TABLE `demar`.`pedidos` 
CHANGE COLUMN `estatus` `estado` INT(1) NULL DEFAULT NULL COMMENT '0 : entregado\\n1 : sin entregar' AFTER `idempleado`;
ALTER TABLE `demar`.`pedidos` 
CHANGE COLUMN `estado` `estado` INT(1) NOT NULL DEFAULT 1 COMMENT '0 : entregado\\\\n1 : sin entregar' ;
-- -------------------------------------------------------------------
-- Procedimiento para SELECCIONAR LOS PEDIDOS PENDIENTES O FINALIZADOS.
USE `demar`;
DROP procedure IF EXISTS `seleccionarPedidosPen`;
DELIMITER $$
USE `demar`$$
CREATE PROCEDURE `seleccionarPedidosPen` (IN estadoP INT(1))
BEGIN
	SELECT * FROM demar.pedidos WHERE estado = estadoP;
END$$
DELIMITER ;
-- --------------------------------------------------------------------------
-- Modificación en la descripción de pedidos.estado
ALTER TABLE `demar`.`pedidos` 
CHANGE COLUMN `estado` `estado` INT(1) NOT NULL DEFAULT 2 COMMENT '0 : entregado\\\\\\\\n1 : en proceso\\\\\\\\n2: pendiente' ;



-- PRUEBAS DE LOS PROCESOS ALMACENADOS --
call demar.buscarUnPedido('1');
call demar.seleccionarPedidos();
call demar.seleccionarPedidosPen('0');
call demar.seleccionarPedidosPen('1');


-- CESAR_26/07/2022
--- Procedimiento para MOSTRAR TODAS LAS AREAS
CREATE PROCEDURE seleccionarAreas();
SELECT *FROM areas;

--- Procedimiento para MOSTRAR UN AREA CON SU ID
CREATE PROCEDURE buscarUnArea(IN idArea VARCHAR(11));
SELECT *FROM areas WHERE id = idArea;

--------------------------------------------------------

--- PRUEBAS
call seleccionarAreas();
call buscarUnArea('3');