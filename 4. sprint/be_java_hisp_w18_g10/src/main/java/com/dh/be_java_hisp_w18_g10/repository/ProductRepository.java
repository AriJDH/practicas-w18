package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{

    private Map<Integer, Product> products = new HashMap<Integer, Product>();

    public ProductRepository() {
    }

    public void loadProducts(){
        //TODO add products
        for (int i = 0; i < 10; i++) {
            products.put(i, new Product(i,
                    "product"+i,
                    "type_"+i,
                    "brand_"+i,
                    "color_"+i,
                    "notes_"+i));
        }

    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }
}
