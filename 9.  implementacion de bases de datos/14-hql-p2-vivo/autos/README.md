# HQL
## Práctica de Consultas HQL

### Objetivos
* Crear consultas HQL
* Usar parámetros en consultas.
* Ubicar consultas correctamente dentro del proyecto.

### Consigna

Una empresa de seguros de autos necesita una aplicación que le permita administrar la información de los siniestros de los vehículos asegurados que son denunciados. Algunos vehículos son autos particulares y otros son autos utilitarios o camiones.

Para ello se pide construir una servicio Rest que permita lograrlo.

Para esta aplicación, tendremos dos entidades principales:

Vehículo, la cual tendrá los siguientes atributos:

* Id del vehículo
* Patente
* Marca
* Modelo
* Año de fabricación
* Cantidad de ruedas

Siniestro, la cual tendrá los siguientes atributos:

* Id del siniestro
* Fecha del siniestro
* Pérdida económica
* Id del vehículo denunciado

De las clases mencionadas, se sabe que un vehículo puede denunciar múltiples siniestros y un siniestro pertenece a un solo vehículo.

Se debe:

* Crear la aplicación utilizando la separación de capas adecuada.
* Crear los endpoints necesarios para crear y consultar los vehículos y siniestros denunciados.
* Utilizando consultas HQL, se pide:
  * Listar las patentes de todos los vehículos registrados.
  * Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
  * Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
  * Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
  * Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
  
    Almacenar el resultado de la consulta en una lista de listas de dos elementos; el primero será un Vehículo y el segundo un Integer. Habrá que crear la clase VehiculoSiniestro con su correspondiente constructor.
