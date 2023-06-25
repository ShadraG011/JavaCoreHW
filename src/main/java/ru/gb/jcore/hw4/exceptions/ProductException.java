package ru.gb.jcore.hw4.exceptions;

/**
 * Исключение для проверки товара
 */
public class ProductException extends Exception {
    public ProductException(String message) {
        super(message);
    }
}
