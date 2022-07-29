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

--------------------------------------------------------

--- PRUEBAS
call seleccionarAreas();
call buscarUnArea('3');