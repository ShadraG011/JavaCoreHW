package ru.gb.jcore.hw5.task2;



public class App2 {
    public static void main(String[] args) {
        String srcPath = "src\\main\\java\\ru\\gb\\jcore\\hw5\\task2\\files\\test.txt";

        int fieldInt = 0;
        int[][] field = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 0, 0}
        };

        System.out.println("Начальное поле из цифр: ");
        showField(field);

        System.out.println("\nЯчейки поля преобразованные в одно числа типа int: ");
        fieldInt = fieldToFieldINt(field);
        System.out.println(fieldInt);

        System.out.println("\nЗапись в файл: ");
        FileWorker.writeFile(srcPath, fieldInt);

        System.out.println("\nЧтение из файла: ");
        int result = FileWorker.readFile(srcPath);
        System.out.println("Результат: " + result);

        System.out.println("\nРазвернутое игровое поле: ");
        showPlayField(result);


    }

    /**
     * Метод для разворачивания заполенного игрового поля
     * @param fieldInt - число типа int содержащего ячейки поля со значениями
     */
    public static void showPlayField(int fieldInt){
        int[][] field = new int[3][3];
        int rowSize = field.length;
        int colSize = field[1].length;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                field[(rowSize - 1) - i][(colSize - 1) - j] = fieldInt % 10;
                fieldInt /= 10;
            }
        }

        for (int[] ints : field) {
            System.out.println("-------------");
            for (int j = 0; j < colSize; j++) {
                if (ints[j] == 1)
                    System.out.print("| x ");
                if (ints[j] == 2)
                    System.out.print("| o ");
                if (ints[j] == 0)
                    System.out.print("| . ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    /**
     * Метод для отрисовки поля со значениями ячеек
     * @param field - двумерный массив со значениями ячеек
     */
    private static void showField(int[][] field) {
        for (int[] ints : field) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * Метод для преобразования массива ячеек поля в число типа int
     * @param field - двумерный массив со значениями ячеек
     * @return - число типа int со значениями ячеек
     */
    private static int fieldToFieldINt(int[][] field) {
        int fieldInt = 0;
        for (int[] ints : field) {
            for (int anInt : ints) {
                fieldInt = (fieldInt * 10) + anInt;
            }
        }
        return fieldInt;
    }


}
