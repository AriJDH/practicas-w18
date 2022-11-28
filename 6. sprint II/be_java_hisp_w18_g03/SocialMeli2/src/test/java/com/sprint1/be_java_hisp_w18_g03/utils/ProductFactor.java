package com.sprint1.be_java_hisp_w18_g03.utils;

import com.sprint1.be_java_hisp_w18_g03.entity.Category;
import com.sprint1.be_java_hisp_w18_g03.entity.Product;

public class ProductFactor {

    public static Product getProduct() {
        return new Product(1, "Producto", "marca", "color", "tipo", "Sin nota",
                new Category(1, "String"), 800.0, false, 0.0);
    }
}
