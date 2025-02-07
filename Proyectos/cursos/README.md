# Ejercicio Repaso 1 -> Estudiante de Programación

Un estudiante de programación desea llevar control de los temas que aprendió en diferentes cursos para luego poderlos incluir en su curriculum vitae. Para ello, creó una base de datos llamada **“estudio”**.

A partir de la creación de la base de datos, empezó con el desarrollo de una aplicación en la que modeló dos clases: **Curso** y **Tema**, en donde un curso puede contener varios temas (relación **1 a N**).

## Modelo de Clases

### **Clase Curso**
- `id_curso` (Long)
- `nombre` (String)
- `tipo_curso` (String)
- `fecha_finalización` (Date)
- `listaDeTemas` (List)
### **Clase Tema**
- `id_tema` (Long)
- `nombre` (String)
- `descripción` (String)

## Requisitos de la API

El estudiante desea desarrollar una API que le permita realizar las siguientes acciones:

1. **Crear un nuevo tema**
2. **Crear un nuevo curso**
3. **Obtener todos los cursos**
4. **Obtener todos los temas de un determinado curso**
5. **Obtener todos los cursos que contengan la palabra “Java” en su nombre**  
   _(Ejemplo: "Introducción a Java", "Java Avanzado", "Java para principiantes", etc.)_
6. **Modificar los datos de un curso**
7. **Modificar los datos de un determinado tema**
8. **Eliminar temas y cursos**

## 🛠️ Consideraciones Técnicas

✅ **Uso de los métodos HTTP correctos** según la acción a realizar.  
✅ **Aplicación de DTOs** para las respuestas.  
✅ **Buenas prácticas** en la arquitectura de la API.  
✅ **Control de acceso:**
- Los **endpoints GET** deben ser públicos.
- Los **demás endpoints** deben requerir autenticación.  
