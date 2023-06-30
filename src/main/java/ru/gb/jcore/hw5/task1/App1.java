package ru.gb.jcore.hw5.task1;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;



public class App1 {


    public static void main(String[] args) {
        String srcDirectory = "src\\main\\java\\ru\\gb\\jcore\\hw5\\task2";
        String targetDirectory = "src\\main\\java\\ru\\gb\\jcore\\hw5\\task1\\backup";
        createBackup(srcDirectory, targetDirectory);

    }

    /**
     * Метод для создания резервной копии файлов из одной директории в другую
     * @param srcDirectory - исходная директория
     * @param targetDirectory - дирекория для резервной копии
     */
    public static void createBackup(String srcDirectory, String targetDirectory) {
        File src = new File(srcDirectory);
        File target = new File(targetDirectory);
        try {
            FileUtils.copyDirectory(src, target);
            System.out.println("Файлы успешно скопированы!");
        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
