
# Parte individual

Para poder llevar a cabo la parte individual tuve que hacer 
unas pequeñas modificaciones en la clase Post, agregandole dos atributos extras
- private boolean hasPromo;
- private Double discount;

Además mofique el método void addPost(PostDtoReq postReq); ya que creé
una función privada de la clase que hiciera un create de producto, esto
evitó que repitiera código ya que tenía que ocuparlo en otro método.

___

Con respecto a los endpoint que había que realizar como bonus hice los 
siguientes: 

### US 0012: Bonus 1
El primero fue el dado como ejemplo en la documentación, y tiene la posibilidad
de mostrar las publicaciones en orden descendente o ascendente de acuerdo a la fecha.

```bash
  GET /products/promo-post/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario |

Ejemplo

```bash
  /products/promo-post/list?order=fecha_asc
  /products/promo-post/list?order=fecha_desc
```

| Order | Description                       |
| :-------- | :-------------------------------- |
| `fecha_asc`      | Fecha ascendente (de más antigua a más nueva) |
| `fecha_desc`      | Fecha descendente (de más nueva a más antigua) |

___

### US 0012: Bonus 2
El segundo muestra la cantidad de producto con y sin descuento que tiene un vendedor.

```bash
  GET /products/post/count
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario |

___

### US 0012: Bonus 3
Y el tercero arroja la lista completa de productos que tiene un vendedor, están clasificados 
en productos con y sin promoción y a su vez también permite ordenar dichas listas
las publicaciones en orden descendente o ascendente de acuerdo a la fecha.

```bash
  GET /products/post/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario |

Ejemplo

```bash
  /products/post/list?order=fecha_asc
  /products/post/list?order=fecha_desc
```

| Order | Description                       |
| :-------- | :-------------------------------- |
| `fecha_asc`      | Fecha ascendente (de más antigua a más nueva) |
| `fecha_desc`      | Fecha descendente (de más nueva a más antigua) |


