package Repository;

import Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    List<Product>products=new ArrayList<>();

    public void create(Product product){
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
