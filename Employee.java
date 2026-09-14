import java.util.ArrayList;
import java.util.Scanner;

/**
 * Employee.java
 * Main Class
 *
 * Represents an Aviation Operations manager/employee. This class "has"
 * (manages) a list of AviationStaff members - a composition / "has-many"
 * relationship, NOT inheritance. One Employee can oversee many
 * AviationStaff (1 -------- 0..*).
 */
public class Employee {

    // ================= Properties =================
    String employeeName;
    int employeeId;
    String department;
    String position;
    double salary;

    // Composition: Employee "has" a list of AviationStaff
    ArrayList<AviationStaff> staffList;

    // ================= Constructor =================
    public Employee(String employeeName, int employeeId, String department, String position, double salary) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.staffList = new ArrayList<>();
    }

    // ================= Methods =================

    /**
     * Displays the personal and employment details of the employee
     * (ID, Name, Department, Position, Salary).
     */
    public void displayInfo() {
        System.out.println("========================================");
        System.out.println("        EMPLOYEE / MANAGER INFO");
        System.out.println("========================================");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + employeeName);
        System.out.println("Department  : " + department);
        System.out.println("Position    : " + position);
        System.out.println("Salary      : PHP " + String.format("%.2f", salary));
        System.out.println("========================================");
    }

    /**
     * Displays the formatted list of all registered aviation staff
     * members under this manager.
     */
    public void displayStaff() {
        if (staffList.isEmpty()) {
            System.out.println("No aviation staff registered yet.");
        } else {
            for (int i = 0; i < staffList.size(); i++) {
                System.out.println("\n[" + (i + 1) + "]");
                staffList.get(i).displayInfo();
            }
        }
    }

    /**
     * Prompts the user for details to register a new aviation staff
     * member and adds them to the staff list.
     */
    public void addStaff(Scanner scanner) {
        System.out.println("Enter staff name:");
        String staffName = scanner.nextLine();

        System.out.println("Enter designation (e.g. Pilot, Co-pilot, Ground Crew):");
        String designation = scanner.nextLine();

        System.out.println("Enter work schedule (e.g. Morning Shift 6AM-2PM):");
        String workSchedule = scanner.nextLine();

        System.out.println("Enter monthly salary:");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        staffList.add(new AviationStaff(staffName, designation, workSchedule, salary));
        System.out.println("Staff Added Successfully!");
    }

    /**
     * Modifies an existing aviation staff member's record
     * (name, designation, schedule, tenure, and salary).
     */
    public void editStaff(Scanner scanner) {
        if (staffList.isEmpty()) {
            System.out.println("No Staff available to edit");
            return;
        }

        displayStaff();

        System.out.println("Enter the staff number you want to edit");
        int editIndex = scanner.nextInt();
        scanner.nextLine();
        editIndex = editIndex - 1; // convert to 0-based index

        if (editIndex >= 0 && editIndex < staffList.size()) {
            AviationStaff targetStaff = staffList.get(editIndex);

            System.out.println("Enter new staff name");
            String staffName = scanner.nextLine();

            System.out.println("Enter new work schedule");
            String workSchedule = scanner.nextLine();

            System.out.println("Enter new salary");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            targetStaff.staffName = staffName;
            targetStaff.workSchedule = workSchedule;
            targetStaff.salary = salary;
            System.out.println("Staff updated Successfully");
        } else {
            System.out.println("Invalid Staff Number selected");
        }
    }

    /**
     * Opens an interactive action sub-menu for a selected staff member
     * to manage duty clock-ins and overtime calculations.
     */
    public void staffActions(Scanner scanner) {
        if (staffList.isEmpty()) {
            System.out.println("No staff available.");
            return;
        }

        displayStaff();
        System.out.println("Select a staff number to manage:");
        int index = scanner.nextInt();
        scanner.nextLine();
        index = index - 1;

        if (index < 0 || index >= staffList.size()) {
            System.out.println("Invalid staff number selected.");
            return;
        }

        AviationStaff staff = staffList.get(index);
        int choice;

        do {
            System.out.println("--- Actions for " + staff.staffName + " ---");
            System.out.println("1. Time In");
            System.out.println("2. Time Out");
            System.out.println("3. Update Designation");
            System.out.println("4. Compute Overtime");
            System.out.println("5. Back to Main Menu");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    staff.timeIn();
                    break;
                case 2:
                    staff.timeOut();
                    break;
                case 3:
                    staff.updateDesignation(scanner);
                    break;
                case 4:
                    staff.computeOvertime(scanner);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    /**
     * Main interactive menu loop for the Aviation Staff Management System.
     */
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Aviation Staff Management Menu");
            System.out.println("1. View Manager Info");
            System.out.println("2. View All Aviation Staff");
            System.out.println("3. Add New Aviation Staff");
            System.out.println("4. Edit Aviation Staff");
            System.out.println("5. Staff Actions (Time In/Out, Overtime)");
            System.out.println("6. Exit");

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
                    System.out.println("Invalid choice. Please select 1-6.");
            }
        } while (choice != 6);
    }
}
