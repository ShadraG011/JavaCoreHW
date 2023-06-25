package ru.gb.jcore.hw4;

import ru.gb.jcore.hw4.controllers.ProductBuying;
import ru.gb.jcore.hw4.database.ShopDataBase;
import ru.gb.jcore.hw4.exceptions.CustomerException;
import ru.gb.jcore.hw4.exceptions.TooMuchSaleException;
import ru.gb.jcore.hw4.models.Order;

import java.util.ArrayList;

/**
 * Задание про интернет-магазин:
 * Класс «Эмуляция интернет-магазина».
 * 1. Написать классы покупатель (ФИО, возраст, телефон), товар (название, цена) и
 * заказ (объект покупатель, объект товар, целочисленное количество).
 * <p>
 * 2. Создать массив покупателей (инициализировать 2 элемента), массив товаров
 * (инициализировать 5 элементов) и массив заказов (пустой на 5 элементов).
 * <p>
 * 3. Создать статический метод «совершить покупку» со строковыми параметрами,
 * соответствующими полям объекта заказа. Метод должен вернуть объект заказа.
 * <p>
 * 4. Если в метод передан несуществующий покупатель – метод должен выбросить
 * исключение CustomerException, если передан несуществующий товар, метод
 * должен выбросить исключение ProductException, если было передано отри-
 * цательное или слишком больше значение количества (например, 100), метод
 * должен выбросить исключение AmountException.
 * <p>
 * Вызвать метод совершения покупки несколько раз таким образом, чтобы запол-
 * нить массив покупок возвращаемыми значениями. Обработать исключения сле-
 * дующим образом (в заданном порядке):
 * – если был передан неверный товар – вывести в консоль сообщение об ошибке, не совершать данную покупку;
 * – если было передано неверное количество – купить товар в количестве 1;
 * – если был передан неверный пользователь – завершить работу приложения с исключением.
 * <p>
 * Вывести в консоль итоговое количество совершённых покупок после выполне-
 * ния основного кода приложения.
 */

/**
 * Домашнее задание
 * Добавить перечисление с гендерами. В класс покупателя добавить свойство «пол» со значением созданного перечисления. Добавить геттеры, сеттеры.
 *
 * Добавить в приложение Магазин учет цены товара - в Заказ добавить поле стоимость. Добавить перечисление с размерами скидок - 0, 5, 10, 15, 20%.
 * Написать метод, при вызове которого на переданный тип товара незначается рандомная скидка из перечисления (меняем значение поля price)
 *
 * ** Товарам добавить категорию. Задать категории Стандарт и Премиум.
 * Если на товар категории Премиум назначилась скидка более 15%, выбросить исключение TooMuchSaleException(msg),
 * сообщение с ошибкой вывести в консоль, цену товара не менять.
 */

/**
 * Главный класс Приложения магазина
 */
public class WebShop {

    public static void main(String[] args) {
        WebShop webShop = new WebShop();
        webShop.placeOrders();
    }

    private ShopDataBase db = new ShopDataBase();
    private ArrayList<Order> orders = db.getOrderList();

    /**
     * Метод для заполнение заказов
     */
    public void placeOrders() {
        String[] products = {"PlayStation 50", "PlayStation 4", "Iphone 14", "Galaxy S23 Ultra", "Acer nitro 5"};
        String[] buyers = {"John", "Jane", "John", "John", "Jane Jones"};
        int[] count = {3, 3, 300, 3, 3};

        for (int i = 0; i < 5; i++) {
            try {
                if (count[i] < 1 || count[i] > 100) {
                    db.addOrder(ProductBuying.makePurchase(buyers[i], products[i], 1));
                }
                db.addOrder(ProductBuying.makePurchase(buyers[i], products[i], count[i]));
            } catch (CustomerException e) {
                System.out.println(e.getMessage());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (db.getOrderList().size() > 0) {
                setDiscount(db.getOrderList().get(db.getOrderList().size() - 1));
                showOrders(db.getOrderList().get(db.getOrderList().size() - 1));
            }
        }
    }

    /**
     * Метод для установки скидки
     * @param order - объект заказа
     */
    public void setDiscount(Order order) {
        try {
            ProductBuying.assignDiscount(order);
        } catch (
                TooMuchSaleException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод для отображения заказа
     * @param order - объект заказа
     */
    public void showOrders(Order order) {
        System.out.println("Покупатель: " + order.getBuyer().getFio() + " | Пол: " + order.getBuyer().getGender());

        System.out.println("Товар: " + order.getProduct().getProductName()
                + " | Цена: " + order.getProduct().getPrice() + " руб. "
                + "(Цена со скидкой " + order.getDiscount() + " %: " + order.getPrice() + " руб.)");

        System.out.println("Количество товара: " + order.getCount() + " | Общая сумма: " + (order.getCount() * order.getPrice()) + "\n");
    }
}
