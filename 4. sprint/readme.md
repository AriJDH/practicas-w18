Para el ejercicio bonus se implemento el endpoint presentado en las ppt del ejercicio.
Para los casos de prueba, se utilizaron las IDS 1 y 2 (hardcodeadas en la base de datos) y se usaron los siguientes Endpoints en Postman:


 -POST http://localhost:8080/users/{userId}/follow/{userIdToFollow}
 -GET http://localhost:8080/users/{userId}/followers/count
 -GET http://localhost:8080/users/{userId}/followers/list
 -GET localhost:8080/users/{userId}/followed/list
 -POST localhost:8080/products/post con JSON:
    {
      "user_id": 2,
      "date": "2021-04-09",
      "product": {
          "product_id": 7,
          "product_name": "Silla Gamer",
          "type": "Gamer",
          "brand": "Racer",
          "color": "Red & Black",
          "notes": "Special Edition"
      },
      "category": 100,
      "price": 1500.50
    }
-GET localhost:8080/products/followed/{UserId}/list
-POST localhost:8080/users/{userId}/unfollow/{UserIdToUnfollow}
-GET localhost:8080/users/{UserId}/followers/list?order=name_asc
-GET localhost:8080/users/{UserId}/followers/list?order=name_desc
-GET localhost:8080/users/{UserId}/followed/list?order=name_asc
-GET localhost:8080/users/{UserId}/followed/list?order=name_desc
-GET localhost:8080/products/followed/{UserId}/list?order=date_asc
-GET localhost:8080/products/followed/{UserId}/list?order=date_desc
-POST localhost:8080/products/promo-post con JSON:
  {
      "user_id": 1,
      "date": "29-04-2021",
      "product": {
          "product_id": 9,
          "product_name": "Silla Gamer",
          "type": "Gamer",
          "brand": "Racer",
          "color": "Red & Black",
          "notes": "Special Edition"
      },
      "category": 100,
      "price": 1500.50,
      "has_promo": true,
      "discount": 0.25
  }
-GET localhost:8080/products/promo-post/count?user_id={UserId}
-GET localhost:8080/products/promo-post/list?user_id={UserId}
