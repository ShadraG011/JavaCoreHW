package ru.gb.jcore.hw4.enums;

/**
 * Перечисление гендеров
 */
public enum Gender {
    MALE("male"), FEMALE("female");

    public String getGender() {
        return gender;
    }

    String gender;
    Gender(String gender) {
        this.gender = gender;
    }
}
