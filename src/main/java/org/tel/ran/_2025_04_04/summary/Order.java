package org.tel.ran._2025_04_04.summary;

import java.util.List;

public class Order {
    int id;
    List<Product> products;

    public Order(int id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }
}
