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



-- Blas_13/08/2022 (Cesar me gano hacer el modelo de insumos xd).
-- El valor predeterminado para insumos.estado se modifico a 1.
-- ALTER TABLE `demar`.`insumos` 
-- CHANGE COLUMN `estado` `estado` INT(1) NOT NULL DEFAULT 1 COMMENT '0: Desactivado\n1: Activo\n' ;
-- -----------------------------------------------------
-- Procedimiento almacenado para AGREGAR UN NUEVO INSUMO
-- USE `demar`;
-- DROP procedure IF EXISTS `insumos_agregar`;
-- DELIMITER $$
-- USE `demar`$$
-- CREATE PROCEDURE `insumos_agregar` (IN nombreIn VARCHAR(30), IN proveedorIn INT(11), IN precioIn FLOAT, IN imagenIn VARCHAR(100))
-- BEGIN
-- 	  INSERT INTO `demar`.`insumos`(`nombre`, `proveedor`, `precio`, `imagen`)
--    VALUES (nombreIn, proveedorIn, precioIn, imagenIn);
-- END$$
-- DELIMITER ;
-- --------------------------------------------------------------------
-- Procedimiento almacenado para ACTUALIZAR LA INFORMACIÓN DE UN INSUMO
-- USE `demar`;
-- DROP procedure IF EXISTS `insumos_actualizar`;
-- DELIMITER $$
-- USE `demar`$$
-- CREATE PROCEDURE `insumos_actualizar` (IN nombreIn VARCHAR(30), IN proveedorIn INT(11), IN precioIn FLOAT, IN imagenIn VARCHAR(100), IN folioIn INT(11))
-- BEGIN
-- 	  UPDATE `demar`.`insumos` SET
--    `nombre` = nombreIn, `proveedor` = proveedorIn, `precio` = precioIn, `imagen` = imagenIn
--    WHERE (`folio` = folioIn);
-- END$$
-- DELIMITER ;
-- ----------------------------------------------------
-- Procedimiento almacenado para DESHABILITAR UN INSUMO
-- USE `demar`;
-- DROP procedure IF EXISTS `insumos_deshabilitar`;
-- DELIMITER $$
-- USE `demar`$$
-- CREATE PROCEDURE `insumos_deshabilitar` (IN folioIn INT(11))
-- BEGIN
-- 	   UPDATE `demar`.`insumos` SET
--     `estado` = '0'
--     WHERE (`folio` = folioIn);
-- END$$
-- DELIMITER ;
-- -------------------------------------------------
-- Procedimiento almacenado para HABILITAR UN INSUMO
-- USE `demar`;
-- DROP procedure IF EXISTS `insumos_habilitar`;
-- DELIMITER $$
-- USE `demar`$$
-- CREATE PROCEDURE `insumos_habilitar` (IN folioIn INT(11))
-- BEGIN
-- 	UPDATE `demar`.`insumos` SET
--     `estado` = '1'
--     WHERE (`folio` = folioIn);
-- END$$
-- DELIMITER ;
-- -----------------------------------------------------------
-- Procedimiento almacenado para SELECCIONAR TODOS LOS INSUMOS
-- USE `demar`;
-- DROP procedure IF EXISTS `insumos_selecTodos`;
-- DELIMITER $$
-- USE `demar`$$
-- CREATE PROCEDURE `insumos_selecTodos` (IN estadoIn INT(1)) 
-- BEGIN
-- 	IF(estadoIn != '' or estadoIn = 0) THEN
-- 		SELECT * FROM demar.insumos WHERE estado = estadoIn;
-- 	ELSE
-- 		SELECT * FROM demar.insumos;
-- 	END IF;
-- END$$
-- DELIMITER ;
-- -----------------------------------------------------------
-- Procedimiento almacenado para SELECCIONAR TODOS LOS INSUMOS
-- USE `demar`;
-- DROP procedure IF EXISTS `insumos_selecTodos`;
-- DELIMITER $$
-- USE `demar`$$
-- CREATE PROCEDURE `insumos_selecTodos` (IN estadoIn VARCHAR(1)) 
-- BEGIN
-- 	IF(estadoIn != '') THEN
-- 		SELECT * FROM demar.insumos WHERE estado = estadoIn;
-- 	ELSE
-- 		SELECT * FROM demar.insumos;
-- 	END IF;
-- END$$
-- DELIMITER ;
-- ----------------------------------------------------------------
-- Procedimiento almacenado para SELECCIONAR UN INSUMO con el folio
-- USE `demar`;
-- DROP procedure IF EXISTS `insumos_selecPorFolio`;
-- DELIMITER $$
-- USE `demar`$$
-- CREATE PROCEDURE `insumos_selecPorFolio` (IN folioIn INT(11), IN estadoIn VARCHAR(1)) 
-- BEGIN
-- 	IF(estadoIn != '') THEN
-- 		SELECT * FROM demar.insumos WHERE folio = folioIn and estado = estadoIn;
-- 	ELSE
-- 		SELECT * FROM demar.insumos WHERE folio = folioIn;
-- 	END IF;
-- END$$
-- DELIMITER ;
-- -----------------------------------------------------------------
-- Procedimiento almacenado para SELECCIONAR INSUMOS DE UN PROVEEDOR
USE `demar`;
DROP procedure IF EXISTS `insumos_selecPorProveedor`;
DELIMITER $$
USE `demar`$$
CREATE PROCEDURE `insumos_selecPorProveedor` (IN proveedorIn INT(11), IN estadoIn VARCHAR(1)) 
BEGIN
	IF(estadoIn != '') THEN
		SELECT * FROM demar.insumos WHERE proveedor = proveedorIn and estado = estadoIn;
	ELSE
 		SELECT * FROM demar.insumos WHERE proveedor = proveedorIn;
 	END IF;
 END$$
DELIMITER ;
-- ---------------------------------------------------------------------
-- Procedimiento almacenado para SELECCIONAR EL ULTIMO INSUMO registrado
-- USE `demar`;
-- DROP procedure IF EXISTS `insumos_selecUltimo`;
-- DELIMITER $$
-- USE `demar`$$
-- CREATE PROCEDURE `insumos_selecUltimo` () 
-- BEGIN
-- 	SELECT * FROM demar.insumos WHERE folio = (SELECT max(folio) FROM demar.insumos);
-- END$$
-- DELIMITER ;


-- PRUEBAS DE LOS PROCESOS ALMACENADOS --
call demar.buscarUnPedido('1');
call demar.seleccionarPedidos();
call demar.seleccionarPedidosPen('0');
call demar.seleccionarPedidosPen('1');
call demar.seleccionarPedidosFiltros('', '4', '', '1');
call demar.insertarPedido('3', '1');
-- call demar.insumos_agregar('Insumo Prueba', '4', '1245', '');
-- call demar.insumos_actualizar('Insumo Pruebaaaaa', '5', '12451', '', '7');
-- call demar.insumos_deshabilitar('1');
-- call demar.insumos_habilitar('1');
-- call demar.insumos_selecTodos('');
-- call demar.insumos_selecPorFolio('1', '1');
-- call demar.insumos_selecPorProveedor('2', '');
-- call demar.insumos_selecUltimo();