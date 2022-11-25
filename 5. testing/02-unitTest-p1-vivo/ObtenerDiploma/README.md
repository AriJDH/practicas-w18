# Test Unitarios Con y Sin Mocks
## Práctica individual

### Objetivos

Tomando como base el proyecto “**ObtenerDiploma**”, adjunto completamente implementado, se deberán realizar las pruebas unitarias (Unit Test) para las capas de controladores, servicios y repositorios.
¡Buena suerte!

### Ejercicio 1
#### Test Unitarios sin Mocks
Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de repositorio **StudentDAO** y **StudentRepository**. Tener en cuenta múltiples escenarios y “**casos borde**” de cada comportamiento.

* Casos nulos, vacíos, inválidos.
* Agregar un alumno.
* Buscar un alumno por Id.
* Modificar los datos de un alumno.
* Eliminar un alumno.
* Listar todos los alumnos.

### Ejercicio 2
#### Test Unitarios con Mocks
Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de servicios **ObtenerDiplomaService**. Tener en cuenta múltiples escenarios y “**casos borde**” de cada comportamiento.

* Casos nulos, vacíos, inválidos.
* Datos de Salida idénticos a datos de Entrada.
* Cálculo del Promedio.
* Leyenda del Diploma.
* Mensaje de Diploma con Honores.

**Pasos del test Unitario con Mocks**
* Crear el mock **IStudentDAO**.
* Inyectarlo en **ObtenerDiplomaService**.
* Configurar su comportamiento (setup) con el método **when**.
* Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.

### Ejercicio 3
#### Test Unitarios con Mocks
Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de servicios **StudentService**, **mockeando** sus dependencia con los repositorios.

**Pasos del test Unitario con Mocks**
* Crear el mock **IStudentDAO**.
* Crear el mock **IStudentRepository**.
* Inyectarlos en **StudentService**.
* Configurar su comportamiento (setup) con el método **when**.
* Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.

### Ejercicio 4
#### Test Unitarios con Mocks
Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de controlador **ObtenerDiplomaController**, mockeando su dependencia con el servicio.

**Pasos del test Unitario con Mocks**
* Crear el mock **IObtenerDiplomaService**
* Inyectarlo en **ObtenerDiplomaController**.
* Configurar su comportamiento (setup) con el método **when**.
* Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.

### Ejercicio 5
#### Test Unitarios con Mocks
Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de controlador **StudentController**, **mockeando** su dependencia con el servicio.

**Pasos del test Unitario con Mocks**
* Crear el mock **IStudentService**
* Inyectarlo en **StudentController**.
* Configurar su comportamiento (setup) con el método **when**.
* Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.
