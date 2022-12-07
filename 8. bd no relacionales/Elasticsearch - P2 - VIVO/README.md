
Bases de Datos No Relacionales


 Elasticsearch
// Práctica grupal
Base de datos - Productos: zapatillas deportivas
Se solicita crear un índice (BBDD) en Elasticsearch, de zapatillas deportivas, donde se guardará información relacionada a estos productos.
Guardar 20 registros en la base de datos creada, considerando los campos que crea necesarios.
Comprobar con consultas los registros insertados en la nueva base de datos.
Utilizar como cliente API Rest, la consola Dev Tools de Kibana o Postman para realizar las operaciones.

Guía:
El formato API REST: http://host:port/[index]/[type]/[_action/id]

La primera parte (localhost) indica el host (servidor) donde está alojado Elasticsearch y el puerto predeterminado 9200. Ejemplo:
http://localhost:9200/empresa/colaborador/_search
La segunda parte (empresa) es el índice/index, seguido del nombre de la “tabla”/type (colaborador), seguido de la acción ( _search ).

Para ver el status de elasticsearch: http://localhost:9200

Para obtener una lista de todos los índices disponibles en elasticsearch, se puede utilizar la URL: 
http://localhost:9200/_cat/indices

Elasticsearch permite utilizar métodos HTTP como GET, POST, DELETE y PUT, justo con los datos que deberían estar en formato JSON.


Ejemplo de creación de un index de nombre “society”:




Ejemplo de inserción de un registro en el index “society”:

Consulta de el registro insertado en el index “society”:



