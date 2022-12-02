*********************************************************************************
                    **EJERCICIOS BASES DE DATOS RELACIONALES**
*********************************************************************************


************************************** Ejercicio 1 **************************************

**BD Relacionales - Parte 1 - PG**
**Planteo Diagrama Entidad-Relación** // _Terminado_
Una mueblería necesita la implementación de una base de datos para controlar las ventas que realiza por día, el stock de sus artículos (productos) y la lista de sus clientes que realizan las compras.


Se necesita plantear:
- ¿Cuáles serían las entidades de este sistema?
- ¿Qué atributos se determinarán para cada entidad? (Considerar los que se crean necesarios)
- ¿Cómo se conformarán las relaciones entre entidades? ¿Cuáles serían las cardinalidades?
- Realizar un DER para modelar el escenario planteado.


************************************** Ejercicio 2 **************************************

**BD Relacionales - Parte 1 - VIVO**
**Diseño Diagrama Entidad-Relación** // _Terminado en equipo_
Realizar un diagrama de entidad - relación para el sistema de una concesionaria, que desea gestionar los servicios de los coches de sus clientes. 


Para el módulo del sistema, se necesita almacenar información de los clientes, los coches que estos poseen y los service/revisiones de cada uno de estos.
Utilizar el formato adecuado para representar las Primary y Foreign Key en el diagrama, además de los tipos de datos de cada atributo.

************************************** Ejercicio 3 **************************************

**Consultas SQL - Parte 2 - VIVO**
**Consultas a Base de Datos** _Terminado_

Se propone realizar las siguientes consultas a la base de datos movies_db.sql.
Importar el archivo movies_db.sql desde PHPMyAdmin o MySQL Workbench y resolver las siguientes consultas:
1. Mostrar todos los registros de la tabla de movies. 
2. Mostrar el nombre, apellido y rating de todos los actores.
3. Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
4. Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
5. Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
6. Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
7. Mostrar los títulos de las primeras tres películas en la base de datos.
8. Mostrar el top 5 de las películas con mayor rating.
9. Listar los primeros 10 actores.
10. Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
11. Mostrar a todos los actores cuyos nombres empiezan con Sam.
12. Mostrar el título de las películas que salieron entre el 2004 y 2008.
13. Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.

************************************** Ejercicio 4 **************************************
**DER y SQL** _PENDIENTE_
_Escenario_
Una empresa proveedora de Internet necesita una base de datos para almacenar cada uno de sus clientes junto con el plan/pack que tiene contratado.

Mediante un análisis previo se conoce que se tiene que almacenar la siguiente información:
- De los clientes se debe registrar: dni, nombre, apellido, fecha de nacimiento, provincia, ciudad.
- En cuanto a los planes de internet: identificación del plan, velocidad ofrecida en megas, precio, descuento.

_Ejercicio 1_
Luego del planteo de los requerimientos de la empresa, se solicita modelar los mismos mediante un DER (Diagrama Entidad-Relación).

_Ejercicio 2_
Una vez modelada y planteada la base de datos, responder a las siguientes preguntas:

a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.

_Ejercicio 3_
Una vez realizado el planteo del diagrama y de haber respondido estas preguntas, utilizar PHPMyAdmin o MySQL Workbench para ejecutar lo siguiente:
a. Se solicita crear una nueva base de datos llamada “empresa_internet”. 
b. Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
c. Realizar las asociaciones/relaciones correspondientes entre estos registros.

_Ejercicio 4_ 
Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

************************************** Ejercicio 5 **************************************

**Consultas SQL Avanzadas - Parte 1 - PG**
**Consultas SQL Avanzadas** _TERMINADO_
_Primera Parte_
Responder las siguientes preguntas:
1. ¿A qué se denomina JOIN en una base de datos y para qué se utiliza?
a. Se utiliza para obtener datos de varias tablas relacionadas entre sí. Consiste en combinar datos de una tabla con datos de la otra tabla, a partir de una o varias condiciones en común.
2. Explicar dos tipos de JOIN.
a. Inner Join se utiliza para traer los datos relacionados de dos o más tablas.
b. Left Join se utiliza para traer los datos de la tabla izquierda más los relacionados de la tabla derecha.
3. ¿Para qué se utiliza el GROUP BY?
a. Agrupa los resultados según las columnas indicadas. 
b. Genera un solo registro por cada grupo de filas que compartan las columnas indicadas.
c. Reduce la cantidad de filas de la consulta.
d. Se suele utilizar en conjunto con funciones de agregación, para obtener datos resumidos y agrupados por las columnas que se necesiten.
4. ¿Para qué se utiliza el HAVING? 
a. La cláusula HAVING se utiliza para incluir condiciones con algunas funciones SQL.
b. Afecta a los resultados traidos por Group By.
5. Escribir una consulta genérica para cada uno de los siguientes diagramas:

SELECT movies.*, actors.first_name, actors.last_name 

FROM movies INNER JOIN actors 

ON movies.id = actors.favorite_movie_id;

SELECT * FROM movies mo LEFT JOIN actors ac ON mo.id = ac.favorite_movie_id;

_Segunda Parte_
Se propone realizar las siguientes consultas a la base de datos movies_db.sql trabajada en la primera clase.

Importar el archivo movies_db.sql desde PHPMyAdmin o MySQL Workbench y resolver las siguientes consultas:
1. Mostrar el título y el nombre del género de todas las series.
2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.


************************************** Ejercicio 6 **************************************

**Consultas SQL Avanzadas - Parte 1 - VIVO**
**Consultas SQL Avanzadas** _TERMINADO EN EQUIPO_

Se requiere obtener las siguientes consultas:
1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
2. Visualizar los departamentos con más de cinco empleados.
3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
5. Mostrar el nombre del empleado que tiene el salario más bajo.
6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.


************************************** Ejercicio 7 **************************************

**Consultas SQL Avanzadas** _EN DESARROLLO_

En base al mismo, plantear las consultas SQL para resolver los siguientes requerimientos:

1. Listar los datos de los autores.
2. Listar nombre y edad de los estudiantes
3. ¿Qué estudiantes pertenecen a la carrera informática?
4. ¿Qué autores son de nacionalidad francesa o italiana?
5. ¿Qué libros no son del área de internet?
6. Listar los libros de la editorial Salamandra.
7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
10. ¿Qué libros se prestaron al lector “Filippo Galli”?
11. Listar el nombre del estudiante de menor edad.
12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
13. Listar los libros que pertenecen a la autora J.K. Rowling.
14. Listar títulos de los libros que debían devolverse el 16/07/2021.

Implementar la base de datos en PHPMyAdmin o MySQL Workbench, cargar cinco registros en cada tabla y probar algunas consultas planteadas en el Ejercicio 1. 


************************************** Ejercicio 8 **************************************
**Optimización de Bases de Datos - Parte 2 - PG**
**Normalización** _PENDIENTE_

_Escenario_

Luego de un análisis realizado en un sistema de facturación, se ha detectado un mal diseño en la base de datos. La misma, cuenta con una tabla facturas que almacena datos de diferente naturaleza. 

Como se puede observar, la tabla cuenta con datos que podrían ser normalizados y separados en diferentes entidades.


_Ejercicio_

Se solicita para el escenario anterior: 

- Aplicar reglas de normalización y elaborar un modelo de DER que alcance la tercera forma normal (3FN).
- Describir con sus palabras cada paso de la descomposición y aplicación de las reglas para visualizar el planteo realizado.

************************************** Ejercicio 9 **************************************
 **Creación de Tablas Temporales e Índices** _PENDIENTE_

_Ejercicio 1_
1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

_Ejercicio 2_
1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

************************************** Ejercicio 10 **************************************
**Consultas SQL Avanzadas 2** _PENDIENTE_

Resolver las siguientes consignas
1. Tomando la base de datos movies_db.sql, se solicita:
2. Agregar una película a la tabla movies.
3. Agregar un género a la tabla genres.
4. Asociar a la película del punto 1. con el género creado en el punto 2.
5. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
6. Crear una tabla temporal copia de la tabla movies.
7. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
8. Obtener la lista de todos los géneros que tengan al menos una película.
9. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
10. Crear un índice sobre el nombre en la tabla movies.
11. Chequee que el índice fue creado correctamente.
12. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
13. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

