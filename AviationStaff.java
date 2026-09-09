public class AviationStaff extends Employee {
    // Additional fields (child-specific)
    String designation;
    String workSchedule;
    int tenure;
    boolean isClockedIn; // for time-in/time-out

    // Constructor – calls parent constructor via super()
    public AviationStaff(String name, int id, String dept, String pos, double sal,
            String designation, String workSchedule, int tenure) {
        super(name, id, dept, pos, sal); // set inherited fields
        this.designation = designation;
        this.workSchedule = workSchedule;
        this.tenure = tenure;
        this.isClockedIn = false; // default: not clocked in
    }

    // Override displayInfo() – add staff-specific details
    @Override
    public void displayInfo() {
        super.displayInfo(); // prints parent fields
        System.out.println("Designation   : " + designation);
        System.out.println("Work Schedule : " + workSchedule);
        System.out.println("Tenure        : " + tenure + " years");
        System.out.println("Clocked In    : " + (isClockedIn ? "Yes" : "No"));
    }

    // Method #2: timeIn()
    public void timeIn() {
        if (isClockedIn) {
            System.out.println("Already clocked in.");
        } else {
            isClockedIn = true;
            System.out.println("Clocked in successfully!");
        }
    }

    // Method #3: timeOut()
    public void timeOut() {
        if (!isClockedIn) {
            System.out.println("Not clocked in yet.");
        } else {
            isClockedIn = false;
            System.out.println("Clocked out successfully!");
        }
    }

    // Method #4: updateDesignation()
    public void updateDesignation(String newDesignation) {
        this.designation = newDesignation;
        System.out.println("Designation updated to: " + newDesignation);
    }

    // Method #5: computeOvertime()
    public double computeOvertime(int extraHours) {
        // Assuming 30 days/month, 8 hours/day
        double hourlyRate = salary / (30 * 8);
        double overtimePay = extraHours * hourlyRate * 1.25; // 25% extra
        System.out.println("Overtime pay for " + extraHours + " hours: PHP " + overtimePay);
        return overtimePay;
    }
}