package com.example.animora.object;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static Order instance;
    private List<Product> items; // List of products in the order
    private double total;

    private Order() {
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public List<Product> getItems() {
        return items;
    }

    public void addItem(Product product) {
        items.add(product);
        total += product.getPrice(); // Update total when a product is added
    }

    public double getTotal() {
        return total;
    }

    public void clearOrder() {
        items.clear();
        total = 0.0;
    }
}