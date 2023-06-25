package ru.gb.jcore.hw4.database;

import ru.gb.jcore.hw4.enums.Gender;
import ru.gb.jcore.hw4.models.Buyer;
import ru.gb.jcore.hw4.models.Order;
import ru.gb.jcore.hw4.models.Product;

import java.util.ArrayList;

/**
 * Класс симулирующий базу данных
 */
public class ShopDataBase {
    private ArrayList<Buyer> buyerList = new ArrayList<>();
    private ArrayList<Product> productsList = new ArrayList<>();
    private ArrayList<Order> orderList = new ArrayList<>();
    public ArrayList<Buyer> getBuyerList() {
        return buyerList;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }


    /**
     * Метод добавления нового заказа в базу
     * @param order - объект заказа
     */
    public void addOrder(Order order) {
        orderList.add(order);
    }

    {
        buyerList.add(new Buyer("John", Gender.MALE.getGender(),20, "1234567890"));
        buyerList.add(new Buyer("Jane", Gender.FEMALE.getGender(), 25, "1234567890"));
        productsList.add(new Product("PlayStation 5", 49500, "premium"));
        productsList.add(new Product("PlayStation 4", 20000, "standard"));
        productsList.add(new Product("Iphone 14", 80700, "standard"));
        productsList.add(new Product("Galaxy S23 Ultra", 120500, "premium"));
        productsList.add(new Product("Acer nitro 5", 101800, "standard"));
    }

}
