package ru.gb.jcore.hm1.sample;

import ru.gb.jcore.hm1.regular.Module;
import ru.gb.jcore.hm1.regular.View;

import java.util.Scanner;

/**
 * Главный метод программы с точкой входа
 */
public class Main {
    /**
     * Точка входа в программу
     *
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество людских лет: ");
        int[] ages = Module.humanYearsCatYearsDogYears(sc.nextInt());
        System.out.println("\n" + View.printToScreen(ages));
    }
}
