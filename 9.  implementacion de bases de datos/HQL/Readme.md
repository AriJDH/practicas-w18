HQL
Requerimientos previos para la práctica
Base de Datos MySQL:
Tener acceso a la base de datos <movies_db.sql> en MySQL. Se adjunta el archivo sql para implementarla.
Tener un usuario con todos los permisos para la Base de Datos.
Aplicación del proyecto:
Tener configurado el archivo pom.xml con las dependencias necesarias.
Tener configurado el archivo aplication.properties con la conexión a la BD.
Tener la estructura del proyecto creada.
Tener creado el paquete de la capa “model” con sus entidades y Dtos.
Tener creado el paquete de la capa “repository” con sus interfaces.
Tener creado el paquete de la capa “service” y sus implementaciones.
Tener creado el paquete de la capa “controller” y sus endpoints.

Consignas:
Listar todos los actores que tengan declarada una película favorita.
Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
Listar todos los actores que trabajan en la <película recibida por parámetro>
Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
Listar todas las películas que pertenezcan al <género recibido por parámetro>
Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>

Bonus

Implementar nuevas funcionalidades en la API desarrollada, agregando las consultas que se crean necesarias o apropiadas. Se valora la creatividad. Cabe destacar que este punto del ejercicio es OPCIONAL.
