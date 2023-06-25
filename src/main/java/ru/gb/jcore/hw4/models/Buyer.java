package ru.gb.jcore.hw4.models;

/**
 * Модель покупателя
 */

public class Buyer {
    private String fio;
    private String gender;
    private int age;
    private String number;

    public Buyer(String fio, String gender,int age, String number) {
        this.fio = fio;
        this.gender = gender;
        this.age = age;
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
