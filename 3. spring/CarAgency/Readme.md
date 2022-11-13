Concesionaria de autos
Concesionaria de Autos
Una concesionaria de automóviles desea realizar un API REST que le permita realizar la carga de determinados autos usados. Para ello, necesitamos desarrollar los siguientes endpoints:

N°
Endpoint
Método
Descripción
1
v1/api/vehicles/
POST
Agrega un nuevo vehículo.
2
v1/api/vehicles/
GET
Retorna un listado de todos los usados seleccionados. No incluye services.
3
v1/api/vehicles/dates?since=’’to=’’
GET
Retorna el listado de los vehículos según fecha de fabricación.
4
v1/api/vehicles/prices?since=’’to=’’
GET
Muestra el listado de los vehículos según los precios dados.


5
v1/api/vehicles/{id}
GET
Muestra toda la información relacionada con el vehículo.




Dado que el dueño de la concesionaria es un cliente muy exigente, se sugiere realizar buenas prácticas de programación como por ejemplo la separación del proyecto según la Arquitectura Multicapas.
Tener en cuenta que por el momento, al no estar trabajando con bases de datos, podemos implementar collections (listas, arraylists, etc) para manejar los CRUD de manera lógica.
Por otro lado, un analista funcional nos proporciona el siguiente Payload de ejemplo para tener en cuenta a la hora de realizar un alta mediante el método POST:


{
"brand":"Chevrolet",
"model":"Corsa",
"manufacturingDate":"2080-11-20",
"numberOfKilometers":"115000",
"doors":"5",
"price":"90000",
"currency":"AR",
"services":[
{
"date":"2003-05-20",
"kilometers":"60000",
"descriptios":"Change air filters"
}
],
"countOfOwners":"2"
}

		
