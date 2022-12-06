**Ejercicio 1**

1. Crear una aplicación Spring Boot “MiniSeries” con las correspondientes dependencias en Spring Initializr.
2. Agregar los parámetros necesarios en el archivo de configuración application.properties. 
3.  Levantar la aplicación y comprobar que está funcionando el servicio h2 http://localhost:8080/h2-console.

4. Conectarse a la consola de h2 empleando los parámetros establecidos en el archivo application.properties.

5. Crear una clase MiniSerie dentro del paquete “model”, que tenga los atributos Long id, String name, Double rating e int amount_of_awards.

6. Para la clase del MiniSerie, generar sus métodos Getters y Setters y anotarla con @Entity. Anotar también el atributo id con @Id y su correspondiente estrategia de @GeneratedValue.

7. Crear una interfaz IMiniserieRepository en el paquete “repository” y anotarla con @Repository.

8. Hacer que la interfaz del punto 7 extienda a JpaRepository<Miniserie, Long>.

9. Levantar la aplicación y comprobar desde la consola de H2 que se haya creado una nueva tabla con el nombre “Miniserie” y los campos de la clase Miniserie creada.
