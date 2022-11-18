Link Tracker

// Práctica integradora




Objetivo
Afianzar todos los conceptos vistos y repasar las anotaciones más usadas. 

¿Are you ready? 


Consigna
Link Tacker es un sistema para trackear/enmascarar URLs y poder obtener analítica de cuantas veces se llamó a cada uno de los links, así como también agregar reglas de negocio para el funcionamiento del redirect.

Se pide desarrollar una aplicación utilizando Spring Boot con Maven que soporte los siguientes casos de uso:

Crear un link: Endpoint POST para crear link a partir de una URL válida y tiene que devolver un JSON con el linkId para utilizar en la redirección.

Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que realizar un redirect a la URL enmascarada. Siempre y cuando el link sea válido. En el caso de que el link sea invalido devolver 404(INVESTIGAR REDIRECT).

Estadísticas por link: Endpoint GET que dado un link (ej: http://localhost:8080/metrics/{linkID} ) tiene que devolver la estadística de cantidad de veces que se redireccionó.


Invalidate link: Endpoint POST para invalidar un link (ej: http://localhost:8080/invalidate/{linkID} ).

Al crear los links se tiene que poder agregar un password que va a ser un query param al llamar a la redirección.

Nota: Repositorio a utilizar para guardar información, puede ser un HashMap<Integer, LinkDTO> o un List<LinkDTO>.
