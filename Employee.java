import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    // Fields – default access (no private), just like your whiteboard
    String employeeName;
    int employeeId;
    String department;
    String position;
    double salary;
    ArrayList<AviationStaff> staffList; // list of aviation staff under this employee

    // Constructor
    public Employee(String employeeName, int employeeId, String department, String position, double salary) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.staffList = new ArrayList<>(); // initialize the list
    }

    // Method #1: displayInfo()
    public void displayInfo() {
        System.out.println("===== Employee Details =====");
        System.out.println("ID         : " + employeeId);
        System.out.println("Name       : " + employeeName);
        System.out.println("Department : " + department);
        System.out.println("Position   : " + position);
        System.out.println("Salary     : PHP " + salary);
    }

    // Method #2: displayStaff()
    public void displayStaff() {
        if (staffList.isEmpty()) {
            System.out.println("No staff assigned to this manager.");
            return;
        }
        System.out.println("===== Staff List =====");
        for (int i = 0; i < staffList.size(); i++) {
            System.out.println("\n--- Staff #" + (i + 1) + " ---");
            staffList.get(i).displayInfo(); // polymorphic call
        }
    }

    // Method #3: addStaff()
    public void addStaff(Scanner scanner) {
        System.out.println("--- Add New Staff ---");
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter designation (e.g., Pilot, Co-pilot, Cabin Crew): ");
        String designation = scanner.nextLine();
        System.out.print("Enter work schedule (e.g., Morning, Night): ");
        String schedule = scanner.nextLine();
        System.out.print("Enter tenure (years): ");
        int tenure = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter monthly salary: ");
        double staffSalary = scanner.nextDouble();
        scanner.nextLine();

        // Create a new AviationStaff object (child class)
        AviationStaff newStaff = new AviationStaff(name, id, department, "Aviation Staff", staffSalary,
                designation, schedule, tenure);
        staffList.add(newStaff);
        System.out.println("Staff added successfully!\n");

    }

    // Method #4: editStaff()
    public void editStaff(Scanner scanner) {
        if (staffList.isEmpty()) {
            System.out.println("No staff available to edit.");
            return;
        }

        displayStaff();
        System.out.print("Enter the number of the staff to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 1 && index <= staffList.size()) {
            AviationStaff target = staffList.get(index - 1);
            System.out.print("Enter new staff name (current: " + target.employeeName + "): ");
            target.employeeName = scanner.nextLine();
            System.out.print("Enter new designation (current: " + target.designation + "): ");
            target.designation = scanner.nextLine();
            System.out.print("Enter new work schedule (current: " + target.workSchedule + "): ");
            target.workSchedule = scanner.nextLine();
            System.out.print("Enter new tenure (current: " + target.tenure + "): ");
            target.tenure = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new salary (current: " + target.salary + "): ");
            target.salary = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Staff updated successfully!\n");
        } else {
            System.out.println("Invalid number selected.");
        }
    }

    // Method #5: staffActions()
    public void staffActions(Scanner scanner) {
        if (staffList.isEmpty()) {
            System.out.println("No staff available to manage.");
            return;
        }

        displayStaff();
        System.out.print("Enter the number of the staff to manage: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 1 && index <= staffList.size()) {
            AviationStaff target = staffList.get(index - 1);
            System.out.println("\n--- Actions for " + target.employeeName + " ---");
            System.out.println("1. Time In (Clock In)");
            System.out.println("2. Time Out (Clock Out)");
            System.out.println("3. Compute Overtime Pay");
            System.out.print("Enter action choice: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    target.timeIn();
                    break;
                case 2:
                    target.timeOut();
                    break;
                case 3:
                    System.out.print("Enter overtime hours worked: ");
                    int hours = scanner.nextInt();
                    scanner.nextLine();
                    target.computeOvertime(hours);
                    break;
                default:
                    System.out.println("Invalid action choice.");
            }
        } else {
            System.out.println("Invalid number selected.");
        }
    }

    // Method #6: startMenu() – the main driver
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT MENU =====");
            System.out.println("1. Display my info");
            System.out.println("2. Display all staff");
            System.out.println("3. Add new staff");
            System.out.println("4. Edit a staff");
            System.out.println("5. Staff actions (Time in/out, Overtime)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayInfo();
                    break;
                case 2:
                    displayStaff();
                    break;
                case 3:
                    addStaff(scanner);
                    break;
                case 4:
                    editStaff(scanner);
                    break;
                case 5:
                    staffActions(scanner);
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}