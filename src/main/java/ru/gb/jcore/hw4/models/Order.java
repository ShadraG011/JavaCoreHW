package ru.gb.jcore.hw4.models;

/**
 * Модель заказа
 */
public class Order {
    private int count;
    private Buyer buyer;
    private Product product;
    private int price;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    private int discount;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Order( Buyer buyer, Product product, int count) {
        this.count = count;
        this.buyer = buyer;
        this.product = product;
        this.price = product.getPrice();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
