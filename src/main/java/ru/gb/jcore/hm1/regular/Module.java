package ru.gb.jcore.hm1.regular;

/**
 * Класс содержащий методы с логикой программы
 */
public class Module {
    /**
     * Метод для перевода людских лет в кошачьи и собачьи
     *
     * @param humanYears - количество людских лет
     * @return массив с введёнными людскими годами и вычисленными кошачьими и собачьими годами
     */
    public static int[] humanYearsCatYearsDogYears(int humanYears) {
        int catYears;
        int dogYears;
        if (humanYears == 1) {
            catYears = 15;
            dogYears = 15;
        } else if (humanYears == 2) {
            catYears = 24;
            dogYears = 24;
        } else {
            catYears = 24 + ((humanYears - 2) * 4);
            dogYears = 24 + ((humanYears - 2) * 5);
        }
        return new int[]{humanYears, catYears, dogYears};
    }
}
