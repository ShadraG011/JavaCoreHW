package ru.gb.jcore.hw3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Random rd = new Random();
        List<Employee> employees = new ArrayList<Employee>(); // создание списка для сотрудников

        employees.add(new Director("Гардаш Владислав Викторович", 40, "Director", "89557822356", 200000)); // Добавление директора


        /**
         * Заполнение списка сотрудников
         */
        for (int i = 1; i < 15; i++) {
            employees.add(new Employee(
                    "Работник: " + (i + 1),
                    rd.nextInt(30, 50), // Рандомный возраст
                    "Должность: " + (i + 1),
                    "89*********",
                    rd.nextInt(50000, 190000))); // Рандомная зарплата
        }

        System.out.println("Список сотрудников без сортировки");
        showEmployeesList(employees);

        String sortBy = sortEmployees(employees); // производится сортировка
        if (sortBy != null) {
            System.out.println("\nСписок сотрудников после сортировки по " + sortBy);
            showEmployeesList(employees);
        }

        Director.upSalary(employees, 35, 10000); // увеличение зарплаты сотрудникам

        System.out.println("\nСписок сотрудников без сортировки после изменения зарплаты");
        showEmployeesList(employees);

        sortBy = sortEmployees(employees); // производится сортировка
        if (sortBy != null) {
            System.out.println("\nСписок сотрудников с измененной зарплатой после сортировки по " + sortBy);
            showEmployeesList(employees);
        }
    }

    /**
     * Метод для вывода на экран всех сотрудников
     * @param employees
     */
    public static void showEmployeesList(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * Метод для выбора критерия сортировки
     * @param employees
     * @return
     */
    public static String sortEmployees(List<Employee> employees) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Для сортировки по возрасту нажмите введите \"1\", для сортировки  по зарплате введите \"2\": ");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            Collections.sort(employees, new SortByAge());
        } else if (choice.equals("2")) {
            Collections.sort(employees, new SortBySalary());
        } else {
            System.out.println("Ошибка ввода");
            return null;
        }
        return choice.equals("1") ? "возрасту" : "зарплате";
    }
}
