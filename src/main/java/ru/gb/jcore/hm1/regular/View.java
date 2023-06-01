package ru.gb.jcore.hm1.regular;

/**
 * Класс для оформленного вывода в консоль
 */
public class View {
    /**
     * @param ages - массив с людскими, кошачьими и собачьими годами
     * @return Оформленную строку для вывода на экран
     */
    public static String printToScreen(int[] ages) {
        return String.format("""
                Вы ввели %d человеческих лет.
                В кошачьих годах это будет: %d лет
                В собачьих годах это будет: %d лет""", ages[0], ages[1], ages[2]);
    }
}
