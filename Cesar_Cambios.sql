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

--------------------------------------------------------

--- PRUEBAS
call seleccionarAreas();
call buscarUnArea('3');








--- SE CAMBIO DE DATETIME A TIME, PARA SOLAMENTE CAPTURAR LA HORA
ALTER TABLE `demar`.`areas` 
CHANGE COLUMN `hora_entrada` `hora_entrada` TIME NULL DEFAULT NULL ;

ALTER TABLE `demar`.`areas` 
CHANGE COLUMN `hora_salida` `hora_salida` TIME NULL DEFAULT NULL ;
