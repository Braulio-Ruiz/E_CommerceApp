package com.braulioruiz.e_commerceapp.models;

/**
 * Modelo que representa un producto.
 */
public class Product {
    private String name;
    private double price;
    private boolean selected;

    public Product(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
        this.name = name;
        this.price = price;
        this.selected = false; // Estado inicial
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", selected=" + selected + "}";
    }
}
