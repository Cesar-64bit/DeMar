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

