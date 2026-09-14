import java.util.Scanner;

/**
 * AviationStaff.java
 * Object/Child Class
 *
 * Represents an individual aviation staff member (e.g. Pilot, Co-pilot,
 * Ground Crew) managed by an Employee (manager). This class is used
 * inside an ArrayList<AviationStaff> that lives inside the Employee class
 * (composition / "has-many" relationship, NOT inheritance).
 */
public class AviationStaff {

    // ================= Properties =================
    String staffName;
    String designation;
    String workSchedule;
    boolean isClockedIn;
    double salary;

    // ================= Constructor =================
    public AviationStaff(String staffName, String designation, String workSchedule, double salary) {
        this.staffName = staffName;
        this.designation = designation;
        this.workSchedule = workSchedule;
        this.salary = salary;
        this.isClockedIn = false; // default: not yet on duty
    }

    // ================= Methods =================

    /**
     * Displays the complete details of the aviation staff member.
     */
    public void displayInfo() {
        System.out.println("Staff Name     : " + staffName);
        System.out.println("Designation    : " + designation);
        System.out.println("Work Schedule  : " + workSchedule);
        System.out.println("Clocked In?    : " + (isClockedIn ? "Yes (On Duty)" : "No (Off Duty)"));
        System.out.println("Salary         : PHP " + String.format("%.2f", salary));
    }

    /**
     * Clocks the staff member in for duty, updating their attendance
     * status to on-duty if they have not already clocked in.
     */
    public void timeIn() {
        if (!isClockedIn) {
            isClockedIn = true;
            System.out.println(staffName + " has clocked IN for duty.");
        } else {
            System.out.println(staffName + " is already clocked in.");
        }
    }

    /**
     * Clocks the staff member out after their shift or flight has
     * concluded, updating their status to off-duty.
     */
    public void timeOut() {
        if (isClockedIn) {
            isClockedIn = false;
            System.out.println(staffName + " has clocked OUT.");
        } else {
            System.out.println(staffName + " is not currently clocked in.");
        }
    }

    /**
     * Updates the staff member's aviation designation
     * (e.g. promotion from Co-pilot to Pilot) and confirms the change.
     */
    public void updateDesignation(Scanner scanner) {
        System.out.println("Current designation: " + designation);
        System.out.println("Enter new designation:");
        String newDesignation = scanner.nextLine();

        designation = newDesignation;
        System.out.println("Designation updated successfully!");
    }

    /**
     * Calculates the total overtime compensation based on the staff
     * member's monthly salary and the number of extra duty hours worked.
     *
     * Formula: (monthly salary / 160 standard hours) * 1.25 (OT rate) * extra hours
     */
    public void computeOvertime(Scanner scanner) {
        System.out.println("Enter extra duty/flight hours worked:");
        double extraHours = scanner.nextDouble();
        scanner.nextLine();

        double hourlyRate = salary / 160.0; // assume 160 standard working hours/month
        double overtimeRate = hourlyRate * 1.25; // 25% overtime premium
        double totalOvertime = overtimeRate * extraHours;

        System.out.println("Hourly Rate       : PHP " + String.format("%.2f", hourlyRate));
        System.out.println("Overtime Rate     : PHP " + String.format("%.2f", overtimeRate) + " /hr");
        System.out.println("Extra Hours Worked: " + extraHours);
        System.out.println("Total Overtime Pay: PHP " + String.format("%.2f", totalOvertime));
    }
}
