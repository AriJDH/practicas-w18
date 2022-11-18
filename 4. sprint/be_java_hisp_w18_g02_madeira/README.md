# Social MELI
Adds feature to follow sellers and their publications.

## API Reference

- **Notes:** 
Past endpoints still function. Attributes added to the entity `Post` and created new DTOs to present the new views required.

#### US0010 : Add Promo Post
Save a Promo Post.

```http
  POST /products/promo-post
```

| Body          | Type           | Description                       |
| :--------     | :-------       | :-------------------------------- |
| `promoPostDto`| `PromoPostDto` | **Required**. Promo Post to save  |


#### US0011 : Count Promo Products
Count Promo Post of Seller.

```http
  GET /products/promo-post/count
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `user_id` | `string` | **Required**. Seller ID           |

#### US0012 : Get Promo Products from Seller
Gets a list of Promo Posts.

```http
  GET /products/promo-post/list
```

| Parameter | Type     | Description                                  |
| :-------- | :------- | :--------------------------------            |
| `user_id` | `int`    | **Required**. Seller ID                      |
| `order`   | `String` | Sorting criteria (`date_asc` or `date_desc`) |


#### US0013 : Recommend Seller to Follow by Promo
Gets all the sellers that are not followed by the User, returns the seller with
the most Promo Posts and shows the list of Promo Posts.

```http
  GET /users/{userId}/recommend/promo-post/
```

| Parameter | Type     | Description                                         |
| :-------- | :------- | :--------------------------------                   |
| `user_id` | `int`    | **Required**. User that will get the recommendation |
| `order`   | `String` | Sorting criteria (`date_asc` or `date_desc`)        |

### Changes

- Utility class `DTOConverter` to map DTO to entity and viceversa.
- `findById` throws an exception if the user is not found.



