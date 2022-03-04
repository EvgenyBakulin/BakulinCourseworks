package ru.skypro;

import java.util.Arrays;

public class EmployeeBook {
    private int size;
    private Employee[] employees;

    public EmployeeBook(int size) {
        this.size = size;
        this.employees = new Employee[size];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Employee i : this.employees) {
            if (i != null) {
                sb.append(i).append("\n");
            }
        }
        return sb.toString();
    }

    /*Методы из лёгкого задания*/
    public int commonSalary() {
        throwIfEmpty();
        int sum = 0;
        for (Employee i : this.employees) {
            if (i != null) {
                sum += i.getSalary();
            }
        }
        return sum;
    }

    public Employee minSalaryEmployee() {
        throwIfEmpty();
        int temp = employees[0].getSalary();
        if (employees[0] == null) {
            for (Employee i : employees) {
                if (i != null) {
                    temp = i.getSalary();
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < temp) {
                temp = employees[i].getSalary();
                counter = i;
            }
        }
        return employees[counter];
    }

    public Employee maxSalaryEmployee() {
        throwIfEmpty();
        int temp = employees[0].getSalary();
        if (employees[0] == null) {
            for (Employee i : employees) {
                if (i != null) {
                    temp = i.getSalary();
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > temp) {
                temp = employees[i].getSalary();
                counter = i;
            }
        }
        return employees[counter];
    }

    public double averageSalary() {
        throwIfEmpty();
        int counter = 0;
        for (Employee i : employees) {
            if (i != null) {
                counter++;
            }
        }
        return commonSalary() / (double) counter;
    }

    /*Методы из усложнённого задания*/
    public void indexSalary(int percent) {
        throwIfEmpty();
        for (Employee i : employees) {
            if (i != null) {
                i.setSalary(i.getSalary() + i.getSalary() * percent / 100);
            }
        }
    }

    public void indexSalaryInDepartment(int dep, int percent) {
        throwIfEmpty();
        for (Employee i : employees) {
            if (i != null && i.getDepartment() == dep) {
                i.setSalary(i.getSalary() + i.getSalary() * percent / 100);
            }
        }
    }

    public void printEmployeesInDepartment(int dep) {
        throwIfEmpty();
        for (Employee i : employees) {
            if (i != null && i.getDepartment() == dep) {
                i.printShortData();
            }
        }
    }

    public Employee minSalaryInDepartment(int dep) {
        throwIfEmpty();
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == dep) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException("Неправильно указан отдел");
        }
        int temp = employees[index].getSalary();
        int index1 = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == dep && employees[i].getSalary() < temp) {
                temp = employees[i].getSalary();
                index1 = i;
            }
        }
        return employees[index1];
    }

    public Employee maxSalaryInDepartment(int dep) {
        throwIfEmpty();
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == dep) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException("Неправильно указан отдел");
        }
        int temp = employees[index].getSalary();
        int index1 = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == dep && employees[i].getSalary() > temp) {
                temp = employees[i].getSalary();
                index1 = i;
            }
        }
        return employees[index1];
    }

    public int commonSumInDepartment(int dep) {
        int sum = 0;
        throwIfEmpty();
        for (Employee i : employees)
            if (i != null && i.getDepartment() == dep) {
                sum += i.getSalary();
            }
        return sum;
    }

    public double averageSalaryInDepartment(int dep) {
        int counter = 0;
        double average = 0;
        for (Employee i : employees) {
            if (i != null && i.getDepartment() == dep) {
                counter++;
            }
        }
        if (counter > 0) {
            average = commonSumInDepartment(dep) / (double) counter;
        }
        return average;
    }

    public void salaryMoreThanSum(int sum) {
        throwIfEmpty();
        for (Employee i : employees) {
            if (i != null && i.getSalary() >= sum) {
                System.out.println(i);
            }
        }
    }

    public void salaryLessThanSum(int sum) {
        throwIfEmpty();
        for (Employee i : employees) {
            if (i != null && i.getSalary() < sum) {
                System.out.println(i);
            }
        }
    }

    /*Методы из сложного задания*/
    public void addEmployee(Employee employee) {
        int counter = 0;
        for (Employee i : employees) {
            if (i != null) {
                counter++;
            }
        }
        if (counter == employees.length) {
            System.out.println("Список полон");
        } else {
            for (int i = 0; i < this.size; i++) {
                if (i == this.size - 1 && this.employees[i] != null) {
                    System.out.println("Список полон");
                }
                if (this.employees[i] == null) {
                    this.employees[i] = employee;
                    break;
                }
            }
        }
    }

    public void throwIfEmpty() {
        int counter = 0;
        for (Employee i : this.employees) {
            if (i == null) {
                counter++;
            }
        }
        if (counter == this.employees.length) {
            throw new RuntimeException("Список пуст!");
        }
    }

    public void deleteEmployee(String fio) {
        throwIfEmpty();
        String surName = fio.substring(0, fio.indexOf(' '));
        String name = fio.substring(fio.indexOf(' ') + 1, fio.lastIndexOf(' '));
        String middleName = fio.substring(fio.lastIndexOf(' ') + 1);
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].isEmployee(surName, name, middleName)) {
                employees[i] = null;
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("Такого сотрудника нет");
        }
    }

    public void changeEmployeeDepartment(String fio, int dep) {
        throwIfEmpty();
        String surName = fio.substring(0, fio.indexOf(' '));
        String name = fio.substring(fio.indexOf(' ') + 1, fio.lastIndexOf(' '));
        String middleName = fio.substring(fio.lastIndexOf(' ') + 1);
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].isEmployee(surName, name, middleName)) {
                employees[i].setDepartment(dep);
                System.out.println(employees[i]);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("Такого сотрудника нет");
        }
    }

    public void changeEmployeeSalary(String fio, int salary) {
        throwIfEmpty();
        String surName = fio.substring(0, fio.indexOf(' '));
        String name = fio.substring(fio.indexOf(' ') + 1, fio.lastIndexOf(' '));
        String middleName = fio.substring(fio.lastIndexOf(' ') + 1);
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].isEmployee(surName, name, middleName)) {
                employees[i].setDepartment(salary);
                counter++;
                System.out.println(employees[i]);
            }
        }
        if (counter == 0) {
            System.out.println("Такого сотрудника нет");
        }
    }

    /*Здесь, усложняя себе задачу и имея в виду, что в номерах отделов может быть чехарда
    * я собираю их во вспомогательный массив, там сортирую и по этому массиву вывожу в консоль*/
    public void printEmployeesToDepartment() {
        throwIfEmpty();
        int arrDepSize = 0;
        for (Employee i : employees) {
            if (i != null) {
                arrDepSize++;
            }
        }
        int[] depArr = new int[arrDepSize];
        for (int i = 0, j = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                depArr[j] = employees[i].getDepartment();
                j++;
            }
        }
        Arrays.sort(depArr);

        System.out.println(depArr[0] + "-й отдел:");
        for (Employee i : employees) {
            if (i != null && i.getDepartment() == depArr[0]) {
                i.printFio();
            }
        }
        for (int k = 1; k < depArr.length; k++) {
            if (depArr[k] != depArr[k - 1]) {
                System.out.println(depArr[k] + "-й отдел:");
                for (Employee j : employees) {
                    if (j != null && j.getDepartment() == depArr[k]) {
                        j.printFio();
                    }
                }
            }

        }
    }

}
