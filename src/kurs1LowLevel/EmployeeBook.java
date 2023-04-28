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

    public String toString(int departmentID) {
        String result = "";
        for (Employee emp : employees)
            if (emp.getDepartment() == departmentID)
                result += "Ф.И.О.: " + emp.getFullName() + " Зарплата: " + emp.getSalary() + "\n";
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

    public void indexingOfSalary(int percent) {
        if (percent < 0) {
            percent = Math.abs(percent);
            for (Employee emp : employees)
                //тут может быть не точность в расчетах т.к. нужно приводить к типу float, но т.к. по
                // требованиям зарплата должна быть int, я не делал приведение типов
                emp.setSalary(emp.getSalary() - (emp.getSalary() / 100 * percent));
        } else {
            percent = Math.abs(percent);
            for (Employee emp : employees)
                emp.setSalary(emp.getSalary() + (emp.getSalary() / 100 * percent));
        }
    }

    public void indexingOfSalary(int percent, int departmentID) {
        if (percent < 0) {
            percent = Math.abs(percent);
            for (Employee emp : employees)
                //тут может быть не точность в расчетах т.к. нужно приводить к типу float, но т.к. по
                // требованиям зарплата должна быть int, я не делал приведение типов
                if (emp.getDepartment() == departmentID)
                    emp.setSalary(emp.getSalary() - (emp.getSalary() / 100 * percent));
        } else {
            percent = Math.abs(percent);
            for (Employee emp : employees)
                if (emp.getDepartment() == departmentID)
                    emp.setSalary(emp.getSalary() + (emp.getSalary() / 100 * percent));
        }
    }

    public void departmentMethods(int departmentID) {
        int count = 0;
        int index = 0;
        for (Employee emp : employees) if (emp.getDepartment() == departmentID) count++;
        Employee[] bufEmpMass = new Employee[count];
        for (Employee employee : employees)
            if (employee.getDepartment() == departmentID) {
                bufEmpMass[index] = employee;
                index++;
            }
        EmployeeBook bufEmpBook = new EmployeeBook(bufEmpMass);
        System.out.print("Сотрудник с минимальной зарплатой: " + bufEmpBook.minSalaryEmployee().toString() + "\n");
        System.out.print("Сотрудник с максимальной зарплатой: " + bufEmpBook.maxSalaryEmployee().toString() + "\n");
        System.out.print("Суммарная зарплата за месяц: " + bufEmpBook.salarySumm() + "\n");
        System.out.printf("Средняя зарплата всех сотрудников отдела: %.2f\n", bufEmpBook.averageSalary());
        indexingOfSalary(350, 1);
        System.out.println("Список всех сотрудников: \n" + this.toString());
        System.out.println("Список всех сотрудников отдела 1: \n" + this.toString(1));
    }

    public void salaryAnalyzer(int number) {
        System.out.println("Cотрудники с зарплатой меньше числа:");
        for (Employee emp : employees)
            if (emp.getSalary() < number)
                System.out.println("ID: " + emp.getId() + " Ф.И.О.: " + emp.getFullName() + " Зарплата: " + emp.getSalary());
        System.out.println("Cотрудники с зарплатой больше (или равно) числа:");
        for (Employee emp : employees)
            if (emp.getSalary() >= number)
                System.out.println("ID: " + emp.getId() + " Ф.И.О.: " + emp.getFullName() + " Зарплата: " + emp.getSalary());
    }
}