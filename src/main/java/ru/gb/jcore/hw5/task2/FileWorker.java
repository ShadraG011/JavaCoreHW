package ru.gb.jcore.hw5.task2;

import java.io.*;
import java.nio.file.*;

public class FileWorker {

    /**
     * Метод для чтения файла
     *
     * @param srcPath - путь к файлу начинаемый с src
     * @return - преобразованное из байтов (считанных из файла) число типа int
     */
    public static int readFile(String srcPath) {
        String absoluteFilePath = Path.of(srcPath).toAbsolutePath().toString();
        int num4 = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath))) {
            byte num3 = (byte) br.read();
            while (num3 != -1) {
                if (num3 < 0) {
                    num4 = (num4 * 1000) + (256 + (int)(num3));
                } else
                    num4 = (num4 * 1000) + num3;
                num3 = (byte) br.read();
            }
            System.out.println("Successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return num4;
    }

    /**
     * Метод для записи числа в файл
     *
     * @param srcPath  - путь к файлу начинаемый с src
     * @param fieldInt - число для записи в файл
     */
    public static void writeFile(String srcPath, int fieldInt) {
        // Преобразование числа типа int в массив байтов для записи в файл, который должен иметь размер 3 байта
        byte[] fieldElements = new byte[3];
        for (int i = 0; i < fieldElements.length; i++) {
            fieldElements[(fieldElements.length - 1) - i] = (byte) (fieldInt % 1000);
            fieldInt /= 1000;
        }

        String absoluteFilePath = Path.of(srcPath).toAbsolutePath().toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(absoluteFilePath))) {
            for (byte elem : fieldElements) {
                writer.write(elem);
            }
            System.out.println("Successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
