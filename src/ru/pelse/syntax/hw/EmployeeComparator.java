package ru.pelse.syntax.hw;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int countFirst = 0;
        int countSecond = 0;
        if (o1.getName().compareTo(o2.getName()) > 0) {
            countFirst++;
        } else {
            countSecond++;
        }
        if (o1.getCompany().compareTo(o2.getCompany()) > 0) {
            countFirst++;
        } else {
            countSecond++;
        }
        if (o1.getAge() > o2.getAge()) {
            countFirst++;
        } else {
            countSecond++;
        }
        if (o1.getSalary() > o2.getSalary()) {
            countFirst++;
        } else {
            countSecond++;
        }
        return Integer.compare(countFirst, countSecond);
    }
}

class EmployeeNameAndSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getName().compareTo(o2.getName()) == 0) {
            return Integer.compare(o1.getAge(), o2.getAge());
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
