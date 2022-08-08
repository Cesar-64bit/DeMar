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


--- Procedimiento para seleccionar todos los empleados con estado = 1
CREATE PROCEDURE seleccionarEmpleados() 
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

--------------------------------------------------------

--- PRUEBAS
call seleccionarAreas();
call buscarUnArea('3');








--- SE CAMBIO DE DATETIME A TIME, PARA SOLAMENTE CAPTURAR LA HORA
ALTER TABLE `demar`.`areas` 
CHANGE COLUMN `hora_entrada` `hora_entrada` TIME NULL DEFAULT NULL ;

ALTER TABLE `demar`.`areas` 
CHANGE COLUMN `hora_salida` `hora_salida` TIME NULL DEFAULT NULL ;

