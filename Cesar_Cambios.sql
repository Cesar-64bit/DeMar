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