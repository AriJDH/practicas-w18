**User Story**

Historia de usuario narrada desde el punto de vista del personal administrativo del instituto educativo. 

El servicio (end-point) es expuesto desde el instituto educativo para ser consumido por cualquier persona autorizada de la misma que lo solicite.

**US-0001:** Calcular el promedio de todas las notas obtenidas por un alumno teniendo en cuenta las materias 
cursadas. Elaborar un mensaje personalizado dependiendo del promedio.

**Consigna**

Se desea realizar las validaciones correspondientes en la Historia de Usuario presentada. Para ello tener en cuenta StudentDTO y SubjectDTO de la resolución adjunta sin validaciones y la siguiente tabla de validaciones y sus correspondientes comportamientos esperados:

Atributo | Tipo | ¿Obligatorio? | Validación | Mensaje de error 

studentName | String | SI 
- Que el campo no esté vacío.
- Que empiece con mayúscula.
- Longitud máxima de 50 caracteres.
- El nombre del alumno no puede estar vacío.
- El nombre del alumno debe comenzar con mayúscula.
- La longitud del nombre no puede superar los 50 caracteres.

subjects | List<SubjectDTO> | SI
- Que la lista no esté vacía.
- La lista no puede ser vacía.

name | String | SI
- Que el campo no esté vacío.
- Que empiece con mayúscula.
- Longitud máxima de 30 caracteres.
- El nombre de la materia no puede estar vacío.
- El nombre de la materia debe comenzar con mayúscula.
- La longitud del nombre no puede superar los 30 caracteres.

score | Double | SI
- Que el campo no esté vacío.
- Mínimo 0.0
- Máximo 10-0
- La nota no puede estar vacía.
-  La mínima nota es 0.0.
- La máxima nota es 10.0.

**Representación JSON**

Se define el payload necesario para proceder con la carga, como así también la respuesta (response) en el formato JSON.

ENTRADA (PAYLOAD):

`{
"studentName": "Juan",
"subjects":
[
{
"name": "Matemática",
"score": 10
},
{
"name": "Física",
"score": 7
},
{
"name": "Química",
"score": 6
}
...
]
}`

SALIDA (RESPONSE):

`{
"studentName": "Juan",
"message": "El Alumno Juan ha obtenido un promedio de 7.6",
"averageScore": 7.6,
"subjects":
[
{
"name": "Matemática",
"score": 10
},
{
"name": "Física",
"score": 7
},
{
"name": "Química",
"score": 6
}
...
]
}`


