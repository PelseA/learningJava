package ru.pelse.syntax.hw;

// Создать список объетов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee(String name, String company, int salary, int age) {
        setName(name);
        setCompany(company);
        setSalary(salary);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        int namesLength = names.length;
        int companiesLength = companies.length;
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(
                    names[(int)Math.floor(Math.random() * namesLength)],
                    companies[(int)Math.floor(Math.random() * companiesLength)],
                    100 + (int)Math.floor(Math.random() * 300),
                    21 + (int)Math.floor(Math.random() * 60)
            ));
        }
        Comparator<Employee> employeeComparator = new EmployeeNameComparator()
                .thenComparing(new EmployeeSalaryComparator()
                .thenComparing(new EmployeeAgeComparator()
                .thenComparing(new EmployeeCompanyComparator())));
        employees.sort(employeeComparator);
        return employees;
    }

    /*public static List<Employee> generateSortedList(int num) {
        Comparator<Employee> employeeComparator = new EmployeeNameComparator()
                .thenComparing(new EmployeeSalaryComparator()
                        .thenComparing(new EmployeeAgeComparator()
                                .thenComparing(new EmployeeCompanyComparator())));
        List<Employee> employees = employeeGenerator(num);
        employees.sort(employeeComparator);
        return employees;
    }*/


}

