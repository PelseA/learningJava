package ru.pelse.syntax.enumtask.employee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeListHandler {
    private Map<Position, User[]> employees;
    private Scanner sc;

    //listSize - количество мест для каждой должности (одинаково для всех)
    public EmployeeListHandler(int listSize) {
        Map<Position, User[]> employees = new HashMap<>();
        this.employees = prepareListEmployees(listSize, employees);
        this.sc = new Scanner(System.in);
    }

    private Map<Position, User[]> prepareListEmployees(int listSize, Map<Position, User[]> employees) {
        for (Position pos : Position.values()) {
            employees.put(pos, new User[listSize]);
        }
        return employees;
    }

    public void createEmployee() {
        System.out.println("Enter full name (to cancel, press 1)");
        String fullName = sc.nextLine();
        if(fullName.equals("1")) {
            System.out.println(toString());
            return;
        }
        System.out.println("Enter the first letter of the position");
        String position = sc.nextLine().trim().toUpperCase();

        User employee = new User(fullName, findPosition(position));
        addUserToList(employee);
        createEmployee();
    }

    public void addUserToList(User employee) {
        Position position = employee.getPosition();
        employees.get(position);
        for(int i = 0; i < employees.get(position).length; i++) {
            if(employees.get(position)[i] == null) {
                employees.get(position)[i] = employee;
                break;
            }
        }
    }

    protected Position findPosition(String firstLetter) {
        for (Position pos : Position.values()) {
            String position = pos.name();
            char first = position.charAt(0);
            if (firstLetter.equals(Character.toString(first))) {
                return pos;
            }
        }
        return Position.INTERN;
    }

    public Map<Position, User[]> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "EmployeeListHandler{ " +
                Arrays.toString(displayEmployees(employees)) +
                '}';
    }

    private String[] displayEmployees(Map<Position, User[]> employees) {
        String[] list = new String[Position.values().length];

        for (Position key : employees.keySet() ) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    list[i] = key.toString().concat(Arrays.toString(employees.get(key)));
                    break;
                }
            }
        }
        return list;
    }

}
