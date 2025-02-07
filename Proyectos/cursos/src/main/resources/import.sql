-- Insertar cursos
INSERT INTO cursos (nombre, tipo_curso, fecha_finalizacion) VALUES ('Java Fundamentals', 'Online', '2025-06-30');
INSERT INTO cursos (nombre, tipo_curso, fecha_finalizacion) VALUES ('Spring Boot Advanced', 'Presencial', '2025-09-15');
INSERT INTO cursos (nombre, tipo_curso, fecha_finalizacion) VALUES ('Microservices with Spring', 'Online', '2025-12-01');

-- Insertar temas para los cursos
INSERT INTO temas (nombre, descripcion, curso_id) VALUES ('Introduction to Java', 'Basics of Java programming', 1);
INSERT INTO temas (nombre, descripcion, curso_id) VALUES ('OOP in Java', 'Object-Oriented Programming concepts', 1);
INSERT INTO temas (nombre, descripcion, curso_id) VALUES ('Spring Boot Basics', 'Introduction to Spring Boot', 2);
INSERT INTO temas (nombre, descripcion, curso_id) VALUES ('Spring Security', 'Authentication and Authorization in Spring Boot', 2);
INSERT INTO temas (nombre, descripcion, curso_id) VALUES ('Building Microservices', 'How to design and implement microservices', 3);
INSERT INTO temas (nombre, descripcion, curso_id) VALUES ('Service Discovery', 'Eureka and Consul for service discovery', 3);
