package ru.gb.jcore.hw4.enums;

/**
 * Перечисление скидок
 */
public enum Discounts {
    FULL_PRICE(100),
    NO_DISCOUNT(0),
    FREE_DISCOUNT(5),
    PREMIUM_DISCOUNT(10),
    MEGA_DISCOUNT(15),
    ULTRA_DISCOUNT(20);
    private int discount;

    Discounts(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }


}
