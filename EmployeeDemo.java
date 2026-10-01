import java.util.Scanner;

class Employee {
    String name;
    int employeeId;
    double basicSalary;

    Employee(String name, int employeeId, double basicSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
        System.out.println();
    }
}

class Professor extends Employee {
    Professor(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + 20000;
    }
}

class LabAssistant extends Employee {
    LabAssistant(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + 10000;
    }
}

class AdministrativeStaff extends Employee {
    AdministrativeStaff(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + 5000;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new Professor("Arun", 101, 50000);
        Employee e2 = new LabAssistant("Priya", 102, 30000);
        Employee e3 = new AdministrativeStaff("Ravi", 103, 25000);

        e1.display();
        e2.display();
        e3.display();
    }
}
