package ru.gb.jcore.hw3;

class Employee {
    private String fio;
    private int age;
    private String post;
    private String phone;
    private int salary;


    public Employee(String fio, int age, String post, String phone, int salary) {
        this.fio = fio;
        this.age = age;
        this.post = post;
        this.phone = phone;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s %s %d", fio, age, post, phone, salary);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
