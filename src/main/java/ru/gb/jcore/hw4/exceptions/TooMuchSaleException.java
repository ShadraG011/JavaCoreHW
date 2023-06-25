package ru.gb.jcore.hw4.exceptions;

/**
 * Исключние для проверки назначенной скидки
 */
public class TooMuchSaleException extends Exception{
    public TooMuchSaleException(String message) {
        super(message);
    }
}
