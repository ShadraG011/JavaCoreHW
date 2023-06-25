package ru.gb.jcore.hw4.exceptions;

/**
 * Исключение для проверки покупателя
 */
public class CustomerException extends Exception {
    public CustomerException(String message) {
        super(message);
    }
}
