package ru.gb.jcore.hw4.exceptions;

/**
 * Исключние для проверки количества товара
 */
public class CountException extends Exception {
    public CountException(String message) {
        super(message);
    }
}
