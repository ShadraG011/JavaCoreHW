package ru.gb.jcore.hw3;

import java.util.List;

class Director extends Employee {

    public Director(String fio, int age, String post, String phone, int salary) {
        super(fio, age, post, phone, salary);
    }

    static void upSalary(List<Employee> employees) {
        upSalary(employees, 45, 5000);
    }

    static void upSalary(List<Employee> employees, int age, int addSalary) {
        for (Employee employee : employees) {
            if (!(employee instanceof Director)) {
                if (employee.getAge() >= age) {
                    employee.setSalary(employee.getSalary() + addSalary);
                }
            }
        }
    }
}
