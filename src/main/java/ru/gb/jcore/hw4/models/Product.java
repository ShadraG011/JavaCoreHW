package ru.gb.jcore.hw4.models;

/**
 * Модель продукта
 */
public class Product {
    private String category;
    private String productName;
    private int price;

    public Product(String productName, int price, String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
