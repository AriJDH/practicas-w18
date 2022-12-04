## Bases de Datos Relacionales


 DER y SQL
// Práctica integradora grupal



Objetivo
El objetivo de esta guía práctica es poder integrar los contenidos de bases de datos relacionales vistos hasta este momento. Para ello, se propone la siguiente práctica.
¡Buena suerte!  

 Escenario
Una empresa proveedora de Internet necesita una base de datos para almacenar cada uno de sus clientes junto con el plan/pack que tiene contratado.
Mediante un análisis previo se conoce que se tiene que almacenar la siguiente información:
De los clientes se debe registrar: dni, nombre, apellido, fecha de nacimiento, provincia, ciudad.
En cuanto a los planes de internet: identificación del plan, velocidad ofrecida en megas, precio, descuento.
 Ejercicio 1
Luego del planteo de los requerimientos de la empresa, se solicita modelar los mismos mediante un DER (Diagrama Entidad-Relación).

 Ejercicio 2 
Una vez modelada y planteada la base de datos, responder a las siguientes preguntas:

a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.


 Ejercicio 3
Una vez realizado el planteo del diagrama y de haber respondido estas preguntas, utilizar PHPMyAdmin o MySQL Workbench para ejecutar lo siguiente:
Se solicita crear una nueva base de datos llamada “empresa_internet”. 
Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
Realizar las asociaciones/relaciones correspondientes entre estos registros.

 Ejercicio 4
Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

