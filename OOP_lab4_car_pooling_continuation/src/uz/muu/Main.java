package uz.muu;

import uz.muu.exceptions.*;


public class Main {

    public static void main(String[] args) {
        CarPooling cp = new CarPooling();
        cp.createDriver("Bobur Boburov");
        cp.createDriver("Anvar Anvarov");

        Driver driver = null, driver2 = null;
        try {
            driver = cp.getDriver("Anvar Anvarov");
            driver2 = cp.getDriver("Anvar Boxodirov");
        } catch (NoSuchDriver e) {
            System.err.println("Driver NOT found.");
        }

        try {
            cp.setDriverWorkingHours("Anvar Anvarov", "13:00", "18:00");
        } catch (NoSuchDriver e) {
            System.err.println("Driver NOT found.");
        }

        Collection<Driver> driversList = cp.getDrivers();

        try {
            cp.addEmployee(123, "Doniyorov Doniyor", "CEO");
            cp.addEmployee(234, "Lazizov Laziz", "CTO");
            cp.addEmployee(234, "Rustamov Rustam", "Manager");
        } catch (EmployeeAlreadyExist e) {
            System.err.println("Employee already exist");
        }

        try {
            Employee employee = cp.getEmployee(234);
            Employee employee2 = cp.getEmployee(235);
        } catch (NoSuchEmployee e) {
            System.err.println("Employee not fount with that ID");
        }

        try {
            Driver availableDriver = cp.bookDriver(123, "14:00", 1);
        } catch (NoDriverAvailableForBooking e) {
            System.err.println("No driver available for booking");
        } catch (BookingDriverNotAllowed e) {
            System.err.println("Booking driver not allowed for current employees position");
        }

        try {
            Driver availableDriver = cp.availableDriver("14:00", 1);
        } catch (NoDriverAvailableForBooking e) {
            System.err.println("No driver available for booking");
        }

        Collection<TimeSlot> timeSlot = cp.getDriverTimetable("Anvar Anvarov");

        String employeeName = "Anvar Anvarov";
        System.out.println("User " + employeeName + "has booked: " + cp.getNumberOfBookingsByEmployee(employeeName) + " times.");

        System.out.println("Employee with position CEO has booked: " + cp.getNumberOfBookingsByEmployeePosition("CEO") + " times.");

        cp.printAllBookings();

    }
}
