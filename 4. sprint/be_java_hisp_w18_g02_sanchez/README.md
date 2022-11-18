
# SocialMeli
## Aclaraciones.
En la etapa grupal no incluimos los atributos hasPromo y discount en la entidad Post. 
Consideré mas conveniente modificar la entidad, los DTOs y métodos pertinentes 
para acomodar estos datos, que resolverlo con una nueva clase derivada de Post.
Esto me permitió re-utilizar algunos métodos ya existentes como por ejemplo addPost
en la capa de servicio, siendo necesarias solamente modificaciones mínimas. Esto también
permite que en la respuesta exitosa de US0006 (Recent Post) se pueda ver si la publicación
se trata de una oferta o no.

Teniendo en cuenta la recomendación de lanzar excepciones en la capa de servicio en lugar de la
de repositorio, en los requerimientos individuales apliqué el feedback recibido.

Se adjunta JSON para importar pruebas con Postman.






## Requerimientos opcionales (Bonus)

#### US 0012 Get Seller Promo List

```http
  GET /products/promo-post/list?user_id={userId}&order={order}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `user_id` | `int` | **Required**. Seller's ID. |

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `order` | `String` | **Optional**. Order criteria (name_asc or name_desc)|


##### Successful response example:

```json
{
    "posts": [
        {
            "date": "10-11-2022",
            "product": {
                "type": "Camiseta",
                "brand": "Puma",
                "color": "Celeste",
                "notes": "Todos los talles.",
                "product_id": 21,
                "product_name": "Camiseta oficial selección uruguaya de fútbol."
            },
            "category": 77,
            "price": 3500.0,
            "discount": 20.0,
            "user_id": 3,
            "post_id": 3,
            "has_promo": true
        },
        {
          ...  
        }
    ],
    "user_id": 3,
    "user_name": "LaOfertaPerfecta"
}
```

##### Error response example:

```json
{
    "message": "No se encontró un usuario con id 63",
    "status": 400
}
```



#### US 0013 Get All Promos

```http
  GET /products/promo-post/list/all?order={order}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `order`      | `String` | **Optional**. Order criteria (name_asc or name_desc) |


##### Successful response example:

```json
[
    {
        "date": "10-11-2022",
        "product": {
            "type": "Camiseta",
            "brand": "Puma",
            "color": "Celeste",
            "notes": "Todos los talles.",
            "product_id": 21,
            "product_name": "Remera oficial selección uruguaya de fútbol."
        },
        "category": 77,
        "price": 3500.0,
        "discount": 20.0,
        "user_id": 4,
        "post_id": 7,
        "has_promo": true
    },
    {
       ...
    }
]
```

##### Error response example:

```json
{
    "message": "No hay promociones para mostrar.",
    "status": 400
}
```