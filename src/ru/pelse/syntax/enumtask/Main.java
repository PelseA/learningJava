package ru.pelse.syntax.enumtask;

import ru.pelse.syntax.enumtask.employee.EmployeeListHandler;

public class Main {
    public static void main(String[] args) {
        EmployeeListHandler listHandler = new EmployeeListHandler(5);
        listHandler.createEmployee();
    }

}
