package kurs1LowLevel;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        EmployeeBook employeeBook = new EmployeeBook(employees);
        fillMass(employees);

        //Задачи базовой сложности
        System.out.println("Список всех сотрудников: \n" + employeeBook.toString());
        System.out.print("Суммарная зарплата за месяц: " + employeeBook.salarySumm() + "\n\n");
        System.out.print("Сотрудник с минимальной зарплатой: " + employeeBook.minSalaryEmployee().toString() + "\n\n");
        System.out.print("Сотрудник с максимальной зарплатой: " + employeeBook.maxSalaryEmployee().toString() + "\n\n");
        System.out.printf("Средняя зарплата всех сотрудников: %.2f\n\n", employeeBook.averageSalary());
        System.out.println("Ф.И.О. всех сотрудников: \n" + employeeBook.getFullName());

        //Задачи повышенной сложности
        employeeBook.indexingOfSalary(-45);
        System.out.println("Список всех сотрудников: \n" + employeeBook.toString() + "\n\n");
        System.out.println("Обработка сотрудников 1-го отдела: ");
        employeeBook.departmentMethods(1);
        employeeBook.salaryAnalyzer(1000);
    }

    public static void fillMass(Employee[] employees) {
        Random x = new Random();
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee("Name" + i, x.nextInt(5) + 1, 1000 + i * 10);
        }
    }
}
