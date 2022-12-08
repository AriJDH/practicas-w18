Una entidad de la salud necesita del desarrollo de una API para realizar consultas respecto a la salud de una persona teniendo en cuenta determinados síntomas que pueda presentar.

Para esto, tendremos dos clases:

- Persona, cuyos atributos serán:
  - id
  - nombre
  - apellido
  - edad
- Síntoma, cuyos atributos serán:
  - codigo
  - nombre
  - nivel_de_gravedad

Nuestra aplicación deberá contar con la siguiente funcionalidad:

- Ver todos los síntomas que tenemos cargados.
  - PATH: /findSymptom


- Consultar si existe un síntoma ingresando su nombre. De existir, se deberá mostrar el nivel de gravedad 
del mismo. Utilizar la clase ResponseEntity para devolver la respuesta.
  - PATH: /findSymptom/{name}

- Visualizar a las personas que puedan ser del grupo de riesgo. Para ello, necesitamos visualizar un listado con el nombre y el apellido de aquellas personas mayores de 60 años que puedan poseer al menos un síntoma asociado. Como para la respuesta de esta consulta habrá que tener en cuenta la relación entre las dos tablas, se recomienda utilizar el patrón DTO.
  - PATH: /findRiskPerson

  Nota: Por el momento no se utilizará ninguna base de datos, por lo cual, los diferentes objetos se deben manejar mediante listas dinámicas (collections).


