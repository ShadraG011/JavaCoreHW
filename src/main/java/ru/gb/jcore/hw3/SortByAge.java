package ru.gb.jcore.hw3;

import java.util.Comparator;

public class SortByAge implements Comparator<Employee> {

    /**
     * Метод для сортировки по Возросту при помощи Comparator
     * @param employee1 the first object to be compared.
     * @param employee2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Employee employee1, Employee employee2) {
        if (employee1.getAge() < employee2.getAge())
            return -1;
        else if (employee1.getAge() > employee2.getAge())
            return 1;
        return 0;
    }
}
