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



-- CESAR_28/07/2022
-- Procedimiento para MOSTRAR TODAS LAS AREAS
USE `demar`;
DROP procedure IF EXISTS `seleccionarAreas`;
DELIMITER $$
USE `demar`$$
CREATE PROCEDURE `seleccionarAreas` ()
BEGIN
	SELECT *FROM areas;
END$$
DELIMITER ;
-- ---------------------------------------------
-- Procedimientos para MOSTRAR UN AREA CON SU ID
USE `demar`;
DROP procedure IF EXISTS `buscarUnArea`;
DELIMITER $$
USE `demar`$$
CREATE PROCEDURE `buscarUnArea` (IN idArea VARCHAR(11))
BEGIN
	SELECT *FROM areas WHERE id = idArea;
END$$
DELIMITER ;



-- BLAS_28/07/2022
-- Procedimiento para SELECINAR PEDIDOS SEGUN LA FECHA, EL PROVEEDOR, EL EMPLEADO Y EL ESTADO.
USE `demar`;
DROP procedure IF EXISTS `seleccionarPedidosFiltros`;
DELIMITER $$
USE `demar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `seleccionarPedidosFiltros`
(IN fechaPedidoP DATETIME, IN idProveedorP INT(11), IN idEmpleadoP INT(11), IN estadoP INT(1))
BEGIN
	IF(fechaPedidoP!='' and idProveedorP!='' and idEmpleadoP!='')
    THEN SELECT * FROM demar.pedidos
    WHERE fecha_pedido=fechaPedidoP and idproveedor=idProveedorP and idempleado=idEmpleadoP and estado=estadoP;
    ELSEIF(fechaPedidoP!='' and idProveedorP='' and idEmpleadoP='')
    THEN SELECT * FROM demar.pedidos
    WHERE fecha_pedido = fechaPedidoP and estado=estadoP;
    ELSEIF(fechaPedidoP='' and idProveedorP!='' and idEmpleadoP='')
    THEN SELECT * FROM demar.pedidos WHERE idproveedor = idProveedorP;
    ELSEIF(fechaPedidoP='' and idProveedorP='' and idEmpleadoP!='')
    THEN SELECT * FROM demar.pedidos
    WHERE idempleado = idEmpleadoP and estado=estadoP;
    ELSEIF(fechaPedidoP!='' and idProveedorP!='' and idEmpleadoP='')
    THEN SELECT * FROM demar.pedidos
    WHERE fecha_pedido=fechaPedidoP and idproveedor=idProveedorP and estado=estadoP;
    ELSEIF(fechaPedidoP!='' and idProveedorP='' and idEmpleadoP!='')
    THEN SELECT * FROM demar.pedidos
    WHERE fecha_pedido=fechaPedidoP and idempleado=idEmpleadoP and estado=estadoP;
    ELSEIF(fechaPedidoP='' and idProveedorP!='' and idEmpleadoP!='')
    THEN SELECT * FROM demar.pedidos
    WHERE idproveedor=idProveedorP and idempleado=idEmpleadoP and estado=estadoP;
    ELSE SELECT * FROM demar.pedidos WHERE estado=estadoP;
    END IF;
END$$
DELIMITER ;
-- --------------------------------------------------------------------------------
-- Eliminación del procedimiento almacenado seleccionarPedidosPen (Quedo obsoleto).
USE `demar`;
DROP procedure IF EXISTS `seleccionarPedidosPen`;
-- ----------------------------------------------------------------
-- Procedimiento almacenado para SELECCIONAR LOS DETALLES_PEDIDOS DE UN PEDIDO
USE `demar`;
DROP procedure IF EXISTS `seleccionarDetallesPedidos`;
DELIMITER $$
USE `demar`$$
CREATE PROCEDURE `seleccionarDetallesPedidos` (IN idPedido INT(11))
BEGIN
	SELECT * FROM demar.detalles_pedidos
    WHERE pedido = idPedido;
END$$
DELIMITER ;
-- -----------------------------
-- Modificación a pedidos.estado
ALTER TABLE `demar`.`pedidos` 
CHANGE COLUMN `estado` `estado` INT(1) NOT NULL DEFAULT 3 COMMENT '0 : entregado\n1 : en proceso\n2: pendiente\n3: en captura' ;
-- ------------------------------------------------------
-- Procedimiento almacenado para INSERTAR UN NUEVO PEDIDO
USE `demar`;
DROP procedure IF EXISTS `demar`.`insertarPedido`;
DELIMITER $$
USE `demar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarPedido`(IN idProveedorP INT(11), IN idEmpleadoP INT(11))
BEGIN
	SET @pendiente = (SELECT id FROM demar.pedidos WHERE estado = '3');
    IF(@pendiente = null)
    THEN INSERT INTO `demar`.`pedidos` (`fecha_pedido`, `idproveedor`, `idempleado`) VALUES (now(), @pendiente, idEmpleadoP);
    END IF;
END$$
DELIMITER ;
;
-- 
-- 



-- PRUEBAS DE LOS PROCESOS ALMACENADOS --
call demar.buscarUnPedido('1');
call demar.seleccionarPedidos();
call demar.seleccionarPedidosPen('0');
call demar.seleccionarPedidosPen('1');
call demar.seleccionarPedidosFiltros('', '4', '', '1');
call demar.insertarPedido('3', '1');