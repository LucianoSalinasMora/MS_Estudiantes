INSERT IGNORE INTO estudiantes (rut, nombres, apellidos, email, telefono, fecha_nacimiento, fecha_ingreso, direccion, estado_matricula)
VALUES ('20.123.456-7', 'Diego Andrés', 'Mendoza Silva', 'diego.mendoza@alumnos.cl', '+56987654321', '2003-05-14', '2023-03-06', 'Av. Libertador Bernardo O Higgins 1450, Santiago', 'VIGENTE')
ON DUPLICATE KEY UPDATE rut=rut;