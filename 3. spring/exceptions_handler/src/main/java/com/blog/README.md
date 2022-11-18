Un conocido Youtuber desea crear un servicio REST para manejar un blog. Dentro del blog, se pueden realizar varias operaciones y algunas de ellas pueden generar excepciones. 
Éstas últimas deben tratarse de una manera adecuada y devolver mensajes breves y significativos en caso de que ocurran, dado que si esto no sucede, el Youtuber puede perder seguidores. 

Se debe crear una entidad llamada “EntradaBlog” con los siguientes atributos:
    Id del blog.
    Título del blog.
    Nombre del autor.
    Fecha de publicación.

La API debe ser capaz de:
Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente mostrando su “Id”. (URI: /blog).

En el caso de que ya exista una entrada de blog con ese “Id”, capturar la excepción y devolver un mensaje indicando dicha situación.


Devolver la información de una entrada de Blog específico, recibiendo el “Id” del mismo. (URI: /blog/{id}).
Si el “Id” ingresado no corresponde a ninguna entrada de Blog, indicarlo con un mensaje adecuado.
Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).


Implementar las clases de excepciones personalizadas que hagan falta.
Manejar el tratamiento de las excepciones utilizando alguno de los métodos vistos.

Nota: Como repositorio para guardar información se puede utilizar un HashMap<Integer, BlogDTO> o un List<BlogDTO>.

