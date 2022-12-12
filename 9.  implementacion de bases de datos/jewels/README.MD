## Desarrollo con Spring Boot / Joyería “Las Perlas”

// Práctica integradora

Objetivo
El objetivo principal de esta práctica es afianzar los conocimientos vistos e implementar un servicio con operaciones CRUD. 

¿Are you ready? 

Consigna

Una reconocida joyería desea implementar una API que permita las altas, bajas, modificaciones y lecturas/consultas de cada una de las joyas que tienen en exposición. Para ello, de cada joya se registran los siguientes datos: nro_identificatorio, nombre, material (oro, plata, etc), peso (en gramos), particularidad, posee_piedra, ventaONo.
A partir de esto, se necesita desarrollar una API que permita realizar un CRUD de cada joya. 

Para ello tener en cuenta que la API debe ser capaz de:

Crear una nueva joya y devolver el correspondiente status code con un mensaje informando su “nro identificatorio”. (URI: /jewerly/new).
Devolver el listado de todas las joyas registradas. (URI: /jewerly).
Eliminar “lógicamente” una joya. Para ello, se deberá contemplar un campo que se llama “ventaONo”, el cual debe ser verdadero al crear una nueva joya, y falso cuando se solicite el eliminado. En caso de estar eliminado lógicamente, no deberá ser devuelto en el listado de joyas registradas. (URI: /jewerly/delete/{id})
Actualizar los datos de una joya. Una vez actualizados, devolver un mensaje con el correspondiente status code y los datos de la joya modificada. (URI: /jewerly/update/{id_modificar}). Envía el objeto completo para editar (sin cambiar la id).


