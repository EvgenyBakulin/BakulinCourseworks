package ru.skypro;

public class Main {

    public static void main(String[] args) {
        Employee[] employeeList = new Employee[10];
        /*Список я намеренно заполнил не весь, чтобы часть позиций осталась нулями*/
        employeeList[0] = new Employee("Петров", "Иван", "Петрович", 2, 35000);
        employeeList[1] = new Employee("Иванов", "Петр", "Сеогеевич", 1, 45000);
        employeeList[2] = new Employee("Синицын", "Сергей", "Васильевич", 1, 30000);
        employeeList[3] = new Employee("Васильев", "Марк", "Михайлович", 5, 42000);
        employeeList[4] = new Employee("Сидоров", "Игорь", "Иванович", 5, 33000);
        employeeList[5] = new Employee("Николаев", "Иван", "Романович", 2, 38000);
        employeeList[6] = new Employee("Сергеев", "Семён", "Иванович", 3, 55000);
        employeeList[7] = new Employee("Мамин", "Сергей", "Петрович", 4, 39000);
        printList(employeeList);
        printAllFIO(employeeList);
        System.out.println("Общая зарплата - " + commonSalary(employeeList)+" рублей");
        System.out.println("Работник с минимальной зарплатой:\n" + minSalaryEmployee(employeeList));
        System.out.println("Работник с минимальной зарплатой:\n" + maxSalaryEmployee(employeeList));
        System.out.println("Средняя зарплата - " + averageSalary(employeeList)+" рублей");

    }
    /*Метод, выбрасывающий исключение, если список пуст*/
    public static void ifEmpty(Employee[] arr) {
        int counter = 0;
        for (Employee i : arr) {
           if(i==null) {
               counter++;
           }
        }
        if (counter == arr.length) {
            throw new RuntimeException("Список пуст!");
        }
    }

    public static void printList(Employee[] arr) {
        ifEmpty(arr);
        for (Employee i : arr) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }

    public static int commonSalary(Employee[] arr) {
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
}
