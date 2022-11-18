
# SocialMeli

Red social de meli.

## US 0013

* **URL**

  /users

* **Method:**

  `GET`

* **Success Response:**

  * **Code:** 200  
    **Content:** `[
    {"user_id": 1,
    "user_name": "Juan Perez"
    },
    { "user_id": 2,
    "user_name": "Maria Rodriguez"
    },
    ]`

## US 0014

* **URL**

  /products/post

* **Method:**

  `GET`
  
* **Data Params**

  **Required:**
 
    `user_id=[Integer]`

    **Not Required:**

    `order=[String]`

* **Success Response:**

  * **Code:** 200  
    **Content:** `{
    "posts": [{ "date": "18-11-2022", "product": {"type": "Acessorio","brand": "Logitech","color": "Negro",
    "notes": "Usa pila AA.",
    "product_id": 1,
    "product_name": "Mouse inalámbrico"
    },
    "category": 1,
    "price": 15.5,
    "user_id": 3,
    "post_id": 1
    }
    ],
    "user_id": 3}`
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST  
    **Content:** `{
    "message": "El usuario 5 no existe",
    "status": 400}`

## Cambios en el proyecto base
* Cambio en la implementación del método addPost (capa de servicio) para poder reutilizar el código implementado en el método addPromoPost. Para esto se agregó un constructor en el dto PromoPostDtoReq para poder crear un PromoPostDtoReq en base a un PostDtoReq
* Se modificó la entidad Post agregando dos nuevos atributos (hasPromo y discount) para cumplir con los nuevos requerimientos de US 0010 y US 0011

