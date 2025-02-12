-- Insertar pacientes
INSERT INTO pacientes (nombre, apellidos, dni, fecha_ingreso) VALUES ('Juan', 'Pérez', '12345678A', '2024-01-15');
INSERT INTO pacientes (nombre, apellidos, dni, fecha_ingreso) VALUES ('Ana', 'Gómez', '87654321B', '2024-02-01');

-- Insertar dentistas
INSERT INTO dentistas (nombre, apellidos, numero_matricula) VALUES ('Carlos', 'Fernández', 'MAT-001');
INSERT INTO dentistas (nombre, apellidos, numero_matricula) VALUES ('Laura', 'Martínez', 'MAT-002');

-- Insertar turnos
INSERT INTO appointment (paciente_id, dentista_id, Fecha) VALUES (1, 1, '2024-02-10');
INSERT INTO appointment (paciente_id, dentista_id, Fecha) VALUES (2, 2, '2024-02-15');
