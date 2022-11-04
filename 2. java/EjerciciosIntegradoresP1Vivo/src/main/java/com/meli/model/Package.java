package com.meli.model;

import java.util.List;

public class Package{

    private int id;
    private boolean completePackage = false;
    private List<Product> productList;

    public Package(int id, List<Product> productList, boolean completePackage) {
        this.id = id;
        this.productList = productList;
        this.completePackage = completePackage;
    }

    public boolean isCompletePackage() {
        return completePackage;
    }

    public void setCompletePackage(boolean completePackage) {
        this.completePackage = completePackage;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "\n" + "\t" +
                "Package{" + "\n" + "\t" + "\t" +
                "- id=" + id + "\n" + "\t" + "\t" +
                "- productList=" + productList + "\n" + "\t" +
                "}" + "\n" + "  ";
    }
}
