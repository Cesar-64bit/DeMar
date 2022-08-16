-- CESAR_26/07/2022
--- Procedimiento para MOSTRAR TODAS LAS AREAS
CREATE PROCEDURE seleccionarAreas();
SELECT *FROM areas;

--- Procedimiento para MOSTRAR UN AREA CON SU ID
CREATE PROCEDURE buscarUnArea(IN idArea VARCHAR(11));
SELECT *FROM areas WHERE id = idArea;


--- Procedimiento para agregar una nueva área
DELIMITER $$
CREATE PROCEDURE agregarArea(IN nArea VARCHAR(30), IN insumo VARCHAR(30), IN cEmpleados VARCHAR(11), IN sBase VARCHAR(11), IN hEntrada VARCHAR(15), IN hSalida VARCHAR(15))
BEGIN
INSERT INTO areas (nombre, insumo_entrada, cantidad_empleados, sueldo_base, hora_entrada, hora_salida) 
VALUES
(nArea, insumo, cEmpleados, sBase, hEntrada, hSalida);
END$$
DELIMITER ;

--- Procedimiento para eliminar un área con el nombre
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarArea`(IN nomArea VARCHAR(30))
DELETE FROM areas WHERE nombre = nomArea

--- Procedimiento para modificar los datos de áreas
DELIMITER $$
CREATE PROCEDURE modificarAreas(IN nArea VARCHAR(30), IN insumo VARCHAR(30), IN cEmpleados VARCHAR(11), IN sBase VARCHAR(11), IN hEntrada VARCHAR(15), IN hSalida VARCHAR(15), IN auxNom VARCHAR(30))
BEGIN
UPDATE areas SET nombre = nArea, insumo_entrada = insumo, cantidad_empleados = cEmpleados, sueldo_base = sBase, hora_entrada = hEntrada, hora_salida = hSalida WHERE nombre = auxNom;
END$$
DELIMITER ;


-- CESAR_08/08/2022

--- Procedimiento para seleccionar todos los empleados con estado = 1
CREATE PROCEDURE selecEmpleadoActivos() 
SELECT *FROM empleados WHERE estado = 1;

--- Procedimiento para filtrar las areas y agregarlas al JComboBox
CREATE PROCEDURE filtrarAreas()
SELECT nombre FROM areas;


--- Procedimiento para agregar empleados
CREATE PROCEDURE agregarEmpleado(IN nombre VARCHAR(50), IN telefono VARCHAR(15), IN direccion VARCHAR(50), IN dias VARCHAR(11), IN fechaContrato VARCHAR(10), IN area VARCHAR(10))
INSERT INTO empleados(nombre, telefono, direccion, dias_laborados, fecha_contrato, idareas, estado)
VALUES (nombre, telefono, direccion, dias, fechaContrato, area, 1);

--- Procedimiento para modificar ewmpleados
CREATE PROCEDURE modificarEmpleados(IN idEmpleado VARCHAR(11), IN nombre VARCHAR(50), IN telefono VARCHAR(15), IN direccion VARCHAR(50), IN dias VARCHAR(11), IN fechaContrato VARCHAR(10), IN area VARCHAR(10), IN rutaImagen VARCHAR(100))
UPDATE empleados SET nombre = nombre, telefono = telefono, direccion = direccion, dias_laborados = dias, fecha_contrato = fechaContrato, imagen = rutaImagen, idareas = area WHERE id = idEmpleado;

-- Procedimiento para optener el ID de una Area
CREATE PROCEDURE obtenerIDArea(IN nombreArea VARCHAR(30)) SELECT id FROM areas WHERE nombre=nombreArea;

--- Procedimiento para eliminar (cambiar estado a 0) de un empleado
CREATE PROCEDURE eliminarEmpleado(IN idEmpleado VARCHAR(11)) UPDATE empleados SET  estado = 0 WHERE id = idEmpleado;

--- Procedimiento para selecccionar todos los proveedores con estatus = 1
CREATE PROCEDURE selecProveedoresActivos() SELECT *FROM proveedores WHERE estatus = 1;

--- Procedimiento para agregar empleados
CREATE PROCEDURE agregarProveedor(IN nombre VARCHAR(30), IN insumo VARCHAR(10), IN telefono VARCHAR(15))
INSERT INTO proveedores(nombre, insumo, telefono, estatus)
VALUES (nombre, insumo, telefono, 1); 

--- Procedimiento para eliminar (cambiar de estatis a 0) a un proveedor
CREATE PROCEDURE eliminarProveedor(IN idProveedor VARCHAR(11)) UPDATE proveedores SET estatus = 0 WHERE id = idProveedor;

--- Procedimiento para modificar proveedores
CREATE PROCEDURE modificarProveedores(IN idProveedor VARCHAR(11), IN nombre VARCHAR(30), IN insumo VARCHAR(10), IN telefono VARCHAR(15))
UPDATE proveedores SET nombre = nombre, insumo = insumo, telefono = telefono WHERE id = idProveedor;

-- Procedimiento para seleccionar todos los pagos
CREATE PROCEDURE selecPagos() SELECT *FROM pagos;

--- Procedimiento para agregar pagos
USE `demar`;
DROP procedure IF EXISTS `agregarPagos`;

USE `demar`;
DROP procedure IF EXISTS `demar`.`agregarPagos`;
;

DELIMITER $$
USE `demar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregarPagos`(IN total VARCHAR(11), IN tipoPago VARCHAR(10), IN fecha VARCHAR(30), IN empleado VARCHAR(11), IN detallesPedidos VARCHAR(11))
INSERT INTO pagos(total, tipo_pago, fecha, empleado, idDetallesPedido)
values (total, tipoPago, fecha, empleado, detallesPedidos)$$

DELIMITER ;
;

--- Procedimiento para eliminar un pago
CREATE PROCEDURE eliminarPagos(IN folioPago INT(11)) DELETE FROM pagos WHERE folio = folioPago;

--- Procedimiento para modificar un pago
CREATE PROCEDURE modificarPagos(IN folioPago VARCHAR(11), IN total VARCHAR(11), IN tipoPago VARCHAR(10), IN fecha VARCHAR(30), IN empleado VARCHAR(11), IN detallesPedidos VARCHAR(11))
UPDATE pagos SET folio = folioPago, total = total, tipo_pago = tipoPago, fecha = fecha, empleado = empleado, idDetallesPedido = detallesPedidos WHERE folio = folioPago;

--- Configuración para eliminar filas con id anidadas en otras tablas
SET FOREIGN_KEY_CHECKS=0;

--- Procedimiento para filtar los empleados
CREATE PROCEDURE filtrarEmpleados() SELECT nombre FROM empleados;

--- Procedimiento para obtener el ID del empleado
CREATE PROCEDURE idEmpleado(IN nomEmpleado VARCHAR(50)) SELECT id FROM empleados WHERE nombre = nomEmpleado;

--- Procedimiento para agregar recepciones
CREATE PROCEDURE agregarRecepciones(IN fecha VARCHAR(30), IN cantidad varchar(11), IN idEmpleado VARCHAR(11))
INSERT INTO recepciones(fecha, cantidad, idEmpleado, estado)
VALUES (fecha, cantidad, idEmpleado, 1);

--- Procedimiento para la eliminación lógica de una recepción
CREATE PROCEDURE eliminarRecepcion(IN folioRec VARCHAR(11)) UPDATE recepciones SET estado = 0 WHERE folio = folioRec;


--- Procedimiento para modificar una recepcion
CREATE PROCEDURE modificarRecepcion(IN folioRec VARCHAR(11), IN fecha VARCHAR(30), IN cantidad varchar(11), IN idEmpleado VARCHAR(11))
UPDATE recepciones SET fecha = fecha, cantidad = cantidad, idEmpleado = idEmpleado WHERE folio = folioRec;


--- Procedimiento para agregar Gastos
USE `demar`;
DROP procedure IF EXISTS `agregarGastos`;

USE `demar`;
DROP procedure IF EXISTS `demar`.`agregarGastos`;
;

DELIMITER $$
USE `demar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregarGastos`(IN tipo VARCHAR(50), IN cantidad VARCHAR(11), IN fecha VARCHAR(30), IN idempleado VARCHAR(11))
INSERT INTO gastos(tipo, cantidad, fecha, idempleado)
VALUES(tipo, cantidad, fecha, idempleado)$$

DELIMITER ;
;

--- Procedimiento para modificar Gastos
CREATE PROCEDURE modificarGastos(IN idGasto VARCHAR(11), IN tipo VARCHAR(50), IN cantidad VARCHAR(11), IN fecha VARCHAR(30), IN idempleado VARCHAR(11))
UPDATE gastos SET tipo = tipo, cantidad = cantidad, fecha = fecha, idempleado = idempleado WHERE id = idGasto;

--- PProcedimiento para eliminar Gastos
CREATE PROCEDURE eliminarGastos(IN idGasto VARCHAR(11)) DELETE FROM gastos WHERE id = idGasto;

--- Procedimiento para selecctionar todos los gastos sin excepcion
CREATE PROCEDURE selecGastos() SELECT *FROM gastos;

--- Procedimiento para seleccionar los insumos con estado = 1
CREATE PROCEDURE selectInsumos() SELECT *FROM insumos WHERE estado = 1;

--- Procedimiento para filtrar los proveedores
CREATE PROCEDURE filProveedores() SELECT NOMBRE FROM proveedores;

--- Procedimiento para obtener el ID de un proveedor
CREATE PROCEDURE idProveedor(IN nomProveedor VARCHAR(30)) SELECT id FROM proveedores WHERE nombre = nomProveedor;


--- Procedimiento para agregar un insumos
CREATE PROCEDURE agregarInsumos(IN nombre VARCHAR(30), IN proveedor VARCHAR(11), IN precio VARCHAR(11))
INSERT INTO insumos(nombre, proveedor, precio, estado) 
VALUES(nombre, proveedor, precio, 1);

--- Procedimiento para modificar un insumo
CREATE PROCEDURE modificarInsumo(IN folioInsumo VARCHAR(11), IN nombre VARCHAR(30), IN proveedor VARCHAR(11), IN precio VARCHAR(11))
UPDATE insumos SET nombre = nombre, proveedor = proveedor, precio = precio WHERE folio = folioInsumo;


--- Procedimiento para la eliminación lógica de un insumo
CREATE PROCEDURE eliminarInsumo(IN folioInsumo VARCHAR(11))
UPDATE insumos SET estado = 0 WHERE folio = folioInsumo;

--- Procedimiento para seleccionar los préstamos con estado = 1
CREATE PROCEDURE selecPrestamos() SELECT *FROM prestamos WHERE estado = 1;

--- Procedimiento para agregar préstamos
CREATE PROCEDURE agregarPrestamos(IN fechaPrestamo VARCHAR(30), IN fechaPago VARCHAR(30), IN empleado VARCHAR(11), IN tipoPlazo VARCHAR(15), IN cantidad VARCHAR(11), IN plazosTotales VARCHAR(11), IN plazosPagados VARCHAR(11))
INSERT INTO prestamos(fecha, fechaPagado, cantidad, plazosTotales, plazosPagados, tipoPlazos, idEmpleado, estado)
VALUES(fechaPrestamo, fechaPago, cantidad, plazosTotales, plazosPagados, tipoPlazo, empleado, 1);

--- Procedimiento para modificar préstamos
CREATE PROCEDURE modificarPrestamos(IN idPrestamo VARCHAR(11), IN fechaPrestamo VARCHAR(30), IN fechaPago VARCHAR(30), IN empleado VARCHAR(11), IN tipoPlazo VARCHAR(15), IN cantidad VARCHAR(11), IN plazosTotales VARCHAR(11), IN plazosPagados VARCHAR(11))
UPDATE prestamos set fecha = fechaPrestamo, fechaPagado = fechaPago, cantidad = cantidad, plazosTotales = plazosTotales, plazosPagados = plazosPagados, tipoPlazos = tipoPlazo, idEmpleado = empleado WHERE id = idPrestamo;

--- Procedimiento para eliminar préstamos
CREATE PROCEDURE eliminarPrestamos(IN idPrestamo VARCHAR(11)) UPDATE prestamos SET estado = 0 WHERE id = idPrestamo;

--- Procedimiento para buscar un empleado con el ID
CREATE PROCEDURE buscarUnEmpleado(IN idEmpleado VARCHAR(11)) SELECT *FROM empleados WHERE id = idEmpleado;

--- Procedimiento para buscar un pago con el ID
CREATE PROCEDURE buscarUnPago(IN folioPago VARCHAR(11)) SELECT *FROM pagos WHERE folio = folioPago;

--- Procedimiento para buscar un préstamo con el ID
CREATE PROCEDURE buscarUnPrestamo(IN idPrestamo VARCHAR(11)) SELECT *FROM prestamos WHERE id = idPrestamo;

--- Procedimiento para buscar una recepción con el ID
CREATE PROCEDURE buscarUnaRecepcion(IN folioRecepcion VARCHAR(11)) SELECT *FROM recepciones WHERE folio = folioRecepcion;

--- Procedimiento para buscar un gasto con el ID
CREATE PROCEDURE buscarUnGasto(IN idGasto VARCHAR(11)) SELECT *FROM gastos WHERE id = idGasto;

--- Procedimiento para buscar un insumo con el ID
CREATE PROCEDURE buscarUnInsumo(IN folioInsumo VARCHAR(11)) SELECT *FROM insumos WHERE folio = folioInsumo;

--- Procedimiento para buscar un usuario
CREATE PROCEDURE buscarUnUsuario(IN id VARCHAR(11)) SELECT *FROM usuarios WHERE identificador =  id;

--- Procedimiento para mostrar los usuarios
CREATE PROCEDURE selecUsuariosActivos() SELECT *FROM usuarios WHERE estado = 1;

--- Procedimiento para filtar perfiles
CREATE PROCEDURE filtrarPerfiles() SELECT nombre FROM perfiles;

CREATE PROCEDURE idRol(IN nomRol VARCHAR(50)) SELECT id FROM perfiles WHERE nombre = nomRol;

--------------------------------------------------------

--- PRUEBAS
call seleccionarAreas();
call buscarUnArea('3');








--- SE CAMBIO DE DATETIME A TIME, PARA SOLAMENTE CAPTURAR LA HORA
ALTER TABLE `demar`.`areas` 
CHANGE COLUMN `hora_entrada` `hora_entrada` TIME NULL DEFAULT NULL ;

ALTER TABLE `demar`.`areas` 
CHANGE COLUMN `hora_salida` `hora_salida` TIME NULL DEFAULT NULL ;

ALTER TABLE `demar`.`gastos` 
CHANGE COLUMN `cantidad` `cantidad` DOUBLE NULL DEFAULT NULL ;

ALTER TABLE `demar`.`prestamos` 
CHANGE COLUMN `tipoPlazos` `tipoPlazos` VARCHAR(15) NOT NULL COMMENT '0: Semanales\\n1: Quinsenales\\n2: Mensuales\\n3: Libre (A como el empleado pueda pagarlo)' ;


--- SE MODIFICO agregarEmpelados
USE `demar`;
DROP procedure IF EXISTS `agregarEmpleado`;

USE `demar`;
DROP procedure IF EXISTS `demar`.`agregarEmpleado`;
;

DELIMITER $$
USE `demar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregarEmpleado`(IN nombre VARCHAR(50), IN telefono VARCHAR(15), IN direccion VARCHAR(50), IN dias VARCHAR(11), IN fechaContrato VARCHAR(10), IN area VARCHAR(10), IN rutaImagen VARCHAR(100))
INSERT INTO empleados(nombre, telefono, direccion, dias_laborados, fecha_contrato, imagen, idareas, estado)
VALUES (nombre, telefono, direccion, dias, fechaContrato, rutaImagen, area, 1)$$

DELIMITER ;
;


USE `demar`;
DROP procedure IF EXISTS `filtrarEmpleados`;

USE `demar`;
DROP procedure IF EXISTS `demar`.`filtrarEmpleados`;
;

DELIMITER $$
USE `demar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `filtrarEmpleados`()
SELECT nombre FROM empleados WHERE estado = 1;$$

DELIMITER ;
;

