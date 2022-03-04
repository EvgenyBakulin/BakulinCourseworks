package ru.skypro;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeList = new EmployeeBook(10);
        /*Список я намеренно заполнил не весь, чтобы часть позиций осталась нулями*/
        Employee em1 = new Employee("Петров", "Иван", "Петрович", 2, 35000);
        Employee em2 = new Employee("Иванов", "Петр", "Сергеевич", 1, 45000);
        Employee em3 = new Employee("Синицын", "Сергей", "Васильевич", 1, 30000);
        Employee em4 = new Employee("Васильев", "Марк", "Михайлович", 5, 42000);
        Employee em5 = new Employee("Сидоров", "Игорь", "Иванович", 5, 33000);
        Employee em6 = new Employee("Николаев", "Иван", "Романович", 2, 38000);
        Employee em7 = new Employee("Сергеев", "Семён", "Иванович", 3, 55000);
        Employee em8 = new Employee("Мамин", "Сергей", "Петрович", 4, 39000);
        /*Реализация методов последнего, сложного задания*/
        System.out.println("Сложное задание");
        employeeList.addEmployee(em1);
        employeeList.addEmployee(em2);
        employeeList.addEmployee(em3);
        employeeList.addEmployee(em4);
        employeeList.addEmployee(em5);
        employeeList.addEmployee(em6);
        employeeList.addEmployee(em7);
        employeeList.addEmployee(em8);
        System.out.println(employeeList);
        System.out.println("Удаляем сотрудника:");
        employeeList.deleteEmployee("Николаев Иван Романович");
        System.out.println(employeeList);
        System.out.println("На его место приходит новый");
        Employee newEmployee = new Employee("Кукушкин", "Савелий", "Петрович", 1, 50000);
        employeeList.addEmployee(newEmployee);
        System.out.println(employeeList);
        System.out.println("Изменяем данные сотрудника (департамент)");
        employeeList.changeEmployeeDepartment("Синицын Сергей Васильевич", 100);
        //System.out.println(employeeList);
        System.out.println("Изменяем данные сотрудника (зарплата), но такого сотрудника нет");
        employeeList.changeEmployeeSalary("Иванов Иван Иванович", 20000);
        System.out.println(employeeList);
        employeeList.printEmployeesToDepartment();
        /*Простое задание, методы реализованы в классе*/
        System.out.println("Методы простого задания в классе");
        System.out.println("Минимальная зарплата у сотрудника \n"+employeeList.minSalaryEmployee());
        System.out.println("Максимальная зарплата у сотрудника \n"+employeeList.maxSalaryEmployee());
        System.out.println("Средняя зарплата = "+employeeList.averageSalary()+" рублей");
        /*Усложнённое задание*/
        System.out.println("Реализация методов усложнённого задания");
        System.out.println("Индексируем зарплату");
        employeeList.indexSalary(20);
        System.out.println(employeeList);
        int dep1 = 1;
        int dep5 = 5;
        System.out.println("Распечатаем сотрудников 1 отдела:");
        employeeList.printEmployeesInDepartment(dep1);
        System.out.print("Минимальная зарплата у ");
        employeeList.minSalaryInDepartment(dep1).printShortData();
        System.out.print("Максимальная зарплата у ");
        employeeList.maxSalaryInDepartment(dep1).printShortData();
        System.out.println("Распечатаем сотрудников 1 отдела:");
        employeeList.printEmployeesInDepartment(dep5);
        System.out.println("Проиндексируем им зарплату");
        employeeList.indexSalaryInDepartment(dep5, 10);
        employeeList.printEmployeesInDepartment(dep5);
        System.out.println("Средняя зарплата в 5 отделе - "+employeeList.averageSalaryInDepartment(dep5)+" рублей");
        System.out.println("Зарплата менее 50000:");
        employeeList.salaryLessThanSum(50000);
        System.out.println("Зарплата более 50000:");
        employeeList.salaryMoreThanSum(50000);

    }
}

        /*printList(employeeList);
        printAllFIO(employeeList);
        System.out.println("Общая зарплата - " + commonSalary(employeeList)+" рублей");
        System.out.println("Работник с минимальной зарплатой:\n" + minSalaryEmployee(employeeList));
        System.out.println("Работник с минимальной зарплатой:\n" + maxSalaryEmployee(employeeList));
        System.out.println("Средняя зарплата - " + averageSalary(employeeList)+" рублей");

    }*/


   /* public static int commonSalary(Employee[] arr) {
        ifEmpty(arr);
        int sum = 0;
        for (Employee i : arr) {
            if (i != null) {
                sum += i.getSalary();
            }
        }
        return sum;
    }

    public static Employee minSalaryEmployee(Employee[] arr) {
        ifEmpty(arr);
        int temp = arr[0].getSalary();
        if (arr[0] == null) {
            for (Employee i : arr) {
                if (i != null) {
                    temp = i.getSalary();
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {

                if (arr[i]!=null&&arr[i].getSalary() < temp) {
                    temp = arr[i].getSalary();
                    counter = i;
                }

        }
        return arr[counter];
    }


    public static Employee maxSalaryEmployee(Employee[] arr) {
        ifEmpty(arr);
        int temp = arr[0].getSalary();
        if (arr[0] == null) {
            for (Employee i : arr) {
                if (i != null) {
                    temp = i.getSalary();
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=null&&arr[i].getSalary() > temp) {
                temp = arr[i].getSalary();
                counter = i;
            }
        }
        return arr[counter];
    }

    public static double averageSalary(Employee[] arr) {
        ifEmpty(arr);
        int counter = 0;
        for (Employee i : arr) {
            if (i != null) {
                counter++;
            }
        }
        return commonSalary(arr) / (double) counter;

    }

    public static void printAllFIO(Employee[] arr) {
        ifEmpty(arr);
        for (Employee i : arr) {
            if (i != null) {
                System.out.println(i.getSurName() + " " + i.getName() + " " + i.getMiddleName());
            }
        }
    }
}*/
