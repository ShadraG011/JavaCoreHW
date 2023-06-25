package ru.gb.jcore.hw4.controllers;

import ru.gb.jcore.hw4.database.ShopDataBase;
import ru.gb.jcore.hw4.enums.Discounts;
import ru.gb.jcore.hw4.exceptions.CountException;
import ru.gb.jcore.hw4.exceptions.CustomerException;
import ru.gb.jcore.hw4.exceptions.ProductException;
import ru.gb.jcore.hw4.exceptions.TooMuchSaleException;
import ru.gb.jcore.hw4.models.Buyer;
import ru.gb.jcore.hw4.models.Order;
import ru.gb.jcore.hw4.models.Product;

import java.util.ArrayList;
import java.util.Random;

/**
 * Класс для обработки совершения покупки
 */
public class ProductBuying {
    private static ShopDataBase db = new ShopDataBase();
    private static ArrayList<Buyer> buyers = db.getBuyerList();
    private static ArrayList<Product> products = db.getProductsList();


    /**
     * Метод проверки существования покупателя
     *
     * @param fio - фамилия, имя отчество одной строкой
     * @return покупателя, при его отсутствии возвращает null
     */
    private static Buyer checkBuyer(String fio) {
        return buyers.stream().filter(buyer -> buyer.getFio().equals(fio)).findAny().orElse(null);
    }

    /**
     * Метод проверки существования товара
     *
     * @param productName - наименование товара одной строкой
     * @return товар, при его отсутствии возвращает null
     */
    private static Product checkProduct(String productName) {
        return products.stream().filter(product -> product.getProductName().equals(productName)).findAny().orElse(null);
    }

    /**
     * Метод для совершения покупки
     *
     * @param buyerFio    - ФИО
     * @param productName - наименование товара
     * @param count       - количество товара
     * @return заколненный объект заказа
     * @throws CustomerException - покупателя не существует
     * @throws ProductException  - товара не существует
     * @throws CountException    - ошибка ввода количества товара
     */
    public static Order makePurchase(String buyerFio, String productName, int count) throws CustomerException, ProductException, CountException {
        Buyer buyer = checkBuyer(buyerFio);
        Product product = checkProduct(productName);
        if (buyer == null)
            throw new CustomerException("Такого покупателя не существует!");
        if (product == null)
            throw new ProductException("Такого товара не существует!\n");
        if (count < 1 || count > Discounts.FULL_PRICE.getDiscount())
            throw new CountException("Ошибка ввода количества, по умолчанию в заказ был включен 1 товар");
        return new Order(buyer, product, count);
    }

    /**
     * Метод для начисления скидки
     *
     * @param order - обект заказа
     * @throws TooMuchSaleException - при товаре премиум класса и скидке более 15%
     */
    public static void assignDiscount(Order order) throws TooMuchSaleException {
        Random rd = new Random();

        int randomDiscount = rd.nextInt(Discounts.values().length - 1);

        if (order.getProduct().getCategory().equals("premium") && randomDiscount > 3) {
            order.setDiscount(Discounts.NO_DISCOUNT.getDiscount());
            throw new TooMuchSaleException("Максимальная скидка на товары премиум класса 15%");
        }
        switch (randomDiscount) {
            case 0 -> {
                order.setPrice((order.getPrice() * (Discounts.FULL_PRICE.getDiscount() - Discounts.NO_DISCOUNT.getDiscount()) / Discounts.FULL_PRICE.getDiscount()));
                order.setDiscount(Discounts.NO_DISCOUNT.getDiscount());
            }
            case 1 -> {
                order.setPrice((order.getPrice() * (Discounts.FULL_PRICE.getDiscount() - Discounts.FREE_DISCOUNT.getDiscount()) / Discounts.FULL_PRICE.getDiscount()));
                order.setDiscount(Discounts.FREE_DISCOUNT.getDiscount());
            }
            case 2 -> {
                order.setPrice((order.getPrice() * (Discounts.FULL_PRICE.getDiscount() - Discounts.PREMIUM_DISCOUNT.getDiscount()) / Discounts.FULL_PRICE.getDiscount()));
                order.setDiscount(Discounts.PREMIUM_DISCOUNT.getDiscount());
            }
            case 3 -> {
                order.setPrice((order.getPrice() * (Discounts.FULL_PRICE.getDiscount() - Discounts.MEGA_DISCOUNT.getDiscount()) / Discounts.FULL_PRICE.getDiscount()));
                order.setDiscount(Discounts.MEGA_DISCOUNT.getDiscount());
            }
            case 4 -> {
                order.setPrice((order.getPrice() * (Discounts.FULL_PRICE.getDiscount() - Discounts.ULTRA_DISCOUNT.getDiscount()) / Discounts.FULL_PRICE.getDiscount()));
                order.setDiscount(Discounts.ULTRA_DISCOUNT.getDiscount());
            }
        }
    }
}

