package kurs1LowLevel;

import java.util.Arrays;

public class EmployeeBook {
    Employee[] employees;

    public EmployeeBook(Employee[] employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        String result = "";
        for (Employee emp : employees)
            result += "Ф.И.О.: " + emp.getFullName() + " Отдел: " + emp.getDepartment() + " Зарплата: " + emp.getSalary() + "\n";
        return result;
    }

    public int salarySumm() {
        int summ = 0;
        for (Employee emp : employees) summ += emp.getSalary();
        return summ;
    }

    public Employee minSalaryEmployee() {
        int min = 0;
        for (int i = 0; i < employees.length; i++)
            if (employees[i].getSalary() < employees[min].getSalary()) min = i;
        return employees[min];
    }

    public Employee maxSalaryEmployee() {
        int max = 0;
        for (int i = 0; i < employees.length; i++)
            if (employees[i].getSalary() > employees[max].getSalary()) max = i;
        return employees[max];
    }

    public float averageSalary() {
        return (float) salarySumm() / employees.length;
    }

    public String getFullName() {
        String result = "";
        for (Employee emp : employees)
            result += emp.getFullName() + "\n";
        return result;
    }
}