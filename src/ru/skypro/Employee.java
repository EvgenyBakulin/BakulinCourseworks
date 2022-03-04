package ru.skypro;

import java.util.Objects;

public class Employee {
    private static int forID = 1;

    private int ID;
    private String surName;
    private String name;
    private String middleName;
    private int department;
    private int salary;

    public Employee() {

    }

    public Employee(String surName, String name, String middleName, int department, int salary) {
        this.surName = surName;
        this.name = name;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
        this.ID = forID++;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID && department == employee.department && salary == employee.salary && surName.equals(employee.surName) && name.equals(employee.name) && middleName.equals(employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, surName, name, middleName, department, salary);
    }

    @Override
    public String toString() {
        return ID + "\t"+surName+" "+name+" "+middleName+" "+department+" отдел"+"\t"+salary+" руб";
    }
    /*Несколько методов разной печати, для разных заданий*/
    public void printShortData() {
        System.out.println(ID + " "+surName+" "+name+" "+middleName+" "+salary+" рублей");
    }

    public void printFio() {
        System.out.println(surName+" "+name+" "+middleName);
    }

    public boolean isEmployee(String surName, String name, String middleName) {
        return (this.surName.equalsIgnoreCase(surName)&&this.name.equalsIgnoreCase(name)
                &&this.middleName.equalsIgnoreCase(middleName));
    }
}
