/**
 * Main.java
 * Entry point of the Aviation Staff Management System.
 * Creates one Employee (manager) and starts the menu.
 */
public class Main {
    public static void main(String[] args) {
        Employee manager = new Employee("Rochelle Bayogbog", 6362, "Aviation Operations", "Senior Manager", 50000.00);
        manager.startMenu();
    }
}
