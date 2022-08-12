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
CREATE PROCEDURE agregarPagos(IN total FLOAT, IN tipoPago VARCHAR(10), IN fecha DATETIME, IN empleado INT(11), IN detallesPedidos INT(11))
INSERT INTO pagos(total, tipo_pago, fecha, empleado, idDetallesPedido)
values (total, tipoPago, fecha, empleado, detallesPedidos);

--------------------------------------------------------

--- PRUEBAS
call seleccionarAreas();
call buscarUnArea('3');








--- SE CAMBIO DE DATETIME A TIME, PARA SOLAMENTE CAPTURAR LA HORA
ALTER TABLE `demar`.`areas` 
CHANGE COLUMN `hora_entrada` `hora_entrada` TIME NULL DEFAULT NULL ;

ALTER TABLE `demar`.`areas` 
CHANGE COLUMN `hora_salida` `hora_salida` TIME NULL DEFAULT NULL ;



--- SE MODIFICÓ LA COLUMNA FLOAT PARA DEFINIR EL RANGO
ALTER TABLE `demar`.`pagos` 
CHANGE COLUMN `total` `total` DOUBLE NULL DEFAULT NULL ;

