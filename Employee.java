import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String designation;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

public class EmployeeManagementSystem {
    private List<Employee> employees;
    private int nextId;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        nextId = 1;
    }

    public void createEmployee(String name, String designation) {
        Employee employee = new Employee(nextId, name, designation);
        employees.add(employee);
        System.out.println("Employee created successfully!");
        nextId++;
    }

    public void readEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Designation: " + employee.getDesignation());
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void updateEmployee(int id, String designation) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setDesignation(designation);
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void deleteEmployee(int id) {
        Employee foundEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                foundEmployee = employee;
                break;
            }
        }

        if (foundEmployee != null) {
            employees.remove(foundEmployee);
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    public void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.println("Employee List:");
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Designation: " + employee.getDesignation());
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Create Employee");
            System.out.println("2. Read Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee designation: ");
                    String designation = scanner.nextLine();
                    system.createEmployee(name, designation);
                    break;
                case 2:
                    System.out.print("Enter employee ID: ");
                    int id;

                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for employee ID! Please enter a number.");
                        continue;
                    }

                    system.readEmployee(id);
                    break;
                case 3:
                    System.out.print("Enter employee ID: ");

                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for employee ID! Please enter a number.");
                        continue;
                    }

                    System.out.print("Enter new employee designation: ");
                    designation = scanner.nextLine();
                    system.updateEmployee(id, designation);
                    break;
                case 4:
                    System.out.print("Enter employee ID: ");

                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for employee ID! Please enter a number.");
                        continue;
                    }

                    system.deleteEmployee(id);
                    break;
                case 5:
                    system.viewAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }
}

