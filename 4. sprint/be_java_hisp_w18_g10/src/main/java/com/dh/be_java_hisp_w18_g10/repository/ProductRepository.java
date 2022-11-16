package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{

    private Map<Integer, Product> products = new HashMap<Integer, Product>();
    private Integer count = 0;

    public ProductRepository() {
        loadProducts();
    }

    public void loadProducts(){
        //TODO add products
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }
}
