_**REFACTORIZACIÓN DE CÓDIGO**_

Para poder implementar buenas prácticas de desarrollo y de testeo hice ajustes al código, tratando de 
minimizar lo máximo posible la cantidad de cambios pero realizando las correcciones que hicieron falta a 
mi criterio.

***************************************

_**TESTS UNITARIOS**_

**Ejercicio 1**

_Test Unitarios sin Mocks_

Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de repositorio 
**StudentDAO** y **StudentRepository**. Tener en cuenta múltiples escenarios y **“casos borde”** de cada 
comportamiento.

- Casos nulos, vacíos, inválidos.
- Agregar un alumno.
- Buscar un alumno por Id.
- Modificar los datos de un alumno.
- Eliminar un alumno.
- Listar todos los alumnos

**Ejercicio 2**

_Test Unitarios con Mocks_

Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de servicios **ObtenerDiplomaService**. Tener en cuenta múltiples escenarios y **“casos borde”** de cada comportamiento.

- Casos nulos, vacíos, inválidos.
- Datos de Salida idénticos a datos de Entrada.
- Cálculo del Promedio.
- Leyenda del Diploma.
- Mensaje de Diploma con Honores.

**Pasos del test Unitario con Mocks**
- Crear el mock **IStudentDAO**.
- Inyectarlo en **ObtenerDiplomaService**.
- Configurar su comportamiento (setup) con el método **when**.
- Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.

**Ejercicio 3**

_Test Unitarios con Mocks_

Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de servicios **StudentService**, **mockeando** sus dependencia con los repositorios.

**Pasos del test Unitario con Mocks**
- Crear el mock IStudentDAO.
- Crear el mock IStudentRepository.
- Inyectarlos en StudentService.
- Configurar su comportamiento (setup) con el método when.
- Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.

**Ejercicio 4**

_Test Unitarios con Mocks_

Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de controlador ObtenerDiplomaController, mockeando su dependencia con el servicio.

**Pasos del test Unitario con Mocks**

- Crear el mock IObtenerDiplomaService
- Inyectarlo en ObtenerDiplomaController.
- Configurar su comportamiento (setup) con el método when.
- Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.

**Ejercicio 5**

_Test Unitarios con Mocks_

Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de controlador StudentController, mockeando su dependencia con el servicio.

**Pasos del test Unitario con Mocks**

- Crear el mock IStudentService
- Inyectarlo en StudentController.
- Configurar su comportamiento (setup) con el método when.
- Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.

***************************************
_**TESTS DE INTEGRACIÓN**_

**Ejercicio 1**

Se requiere crear los tests de integración necesarios para cubrir el comportamiento de la capa de los controladores ObtenerDiplomaController y StudentController. Tener en cuenta múltiples escenarios, incluidos las validaciones, mensajes de error y Excepciones.

**Ejercicio 2**

Luego de finalizados los ejercicios (y prácticas) anteriores verificar que se haya obtenido una cobertura de líneas (coverage) superior al 80%. De no alcanzarse ese nivel, revisar tanto los Tests de Unidad (con y sin Mocks) como los Tests de Integración hasta que se logre el estándar requerido.
