package uz.muu;

import uz.muu.exceptions.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import uz.muu.exceptions.NoSuchDriver;

public class Main {
    public static void main(String[] args) throws NoSuchAutoService {
        CarRepairing cr = new CarRepairing();
        AutoService autoService1 = cr.createAutoService(1, "Avtoritet", new Coordinate(100, 250));
        AutoService autoService2 = cr.createAutoService(2, "Carbox", new Coordinate(-50, -150));
        AutoService autoService3 = cr.createAutoService(3, "Imagine", new Coordinate(-100, 150));
        AutoService autoService4 = cr.createAutoService(4, "Shina.uz", new Coordinate(20, 70));
        AutoService autoService5 = cr.createAutoService(5, "DA Service", new Coordinate(0, 0));
        AutoService autoService6 = cr.createAutoService(6, "AvtoUsta", new Coordinate(150, 350));
        AutoService autoService7 = cr.createAutoService(7, "FazJet", new Coordinate(100, -150));
        AutoService autoService8 = cr.createAutoService(8, "TuningHouse", new Coordinate(-150, -350));
        AutoService autoService9 = cr.createAutoService(9, "Koleso", new Coordinate(350, 550));
        AutoService autoService10 = cr.createAutoService(10, "Sprint", new Coordinate(-350, -450));

        Collection<AutoService> autoServices = cr.getAutoServices();
        try {
            AutoService autoService = cr.getAutoService(7);
        } catch (NoSuchAutoService e) {
            e.printStackTrace();
        }

        class main {
            public void main(String[] args) throws Exception {
                CarRepairing carRepairing = new CarRepairing();

                // Create some sample drivers
                carRepairing.addDriver(1, "John Doe", "Toyota Camry");
                carRepairing.addDriver(2, "Jane Smith", "Honda Civic");

                // Create some sample auto services with coordinates (replace with actual values)
                carRepairing.createAutoService(101, "Fix-It Auto", new Coordinate(10, 20));
                carRepairing.createAutoService(102, "Reliable Repairs", new Coordinate(5, 30));

                // Your code to use carRepairing object (e.g., booking a service)
            }
        }

        try {
            cr.addDriver(1, "Michael Schumacher", "Ferrari");
            cr.addDriver(2, "Max Verstappen", "Honda");
            cr.addDriver(3, "Lewis Hamilton", "Mercedes Benz");
        } catch (DriverAlreadyExist e){
            e.printStackTrace();
        }

        Driver driver=null, driver2=null;
        try {
            driver = cr.getDriver(1);
            driver2 = cr.getDriver(5);
        } catch (NoSuchDriver e){
            System.err.println("Driver NOT found.");
        }

        Collection<Driver> driversList = cr.getDrivers();

        cr.createService(1, "oil change", 50000);
        cr.createService(2, "body repair", 700000);
        cr.createService(3, "diagnostics", 150000);
        cr.createService(4, "battery replacement", 1000000);

        try{
            Service s1 = cr.getService(1);
            Service s2 = cr.getService(2);
        } catch (NoSuchService e){
            System.err.println("Service not fount with that ID");
        }

        List<Service> serviceList = new LinkedList<>();
        try {
            serviceList.add(cr.getService(1));
            serviceList.add(cr.getService(2));
            serviceList.add(cr.getService(3));
        } catch (NoSuchService noSuchService) {
            noSuchService.printStackTrace();
        }

        // Assuming you have created the driver before trying to book a service for them
        // Get the driver
        Driver d = null;
        try {
            d = cr.getDriver(1);
        } catch (NoSuchDriver e){
            System.err.println("Driver NOT found.");
            // Handle the case where the driver is not found
        }

        // Check if the driver is not null (i.e., if the driver was found)
        if (d != null) {
            // Proceed with booking a service
            List<AutoService> autoServiceList = cr.availableAutoServices(1, new Coordinate(0, 0), serviceList);

            // Check if the autoServiceList is not empty
            if (!autoServiceList.isEmpty()) {
                // Book the first auto service (assuming there is at least one available)
                AutoService autoService = autoServiceList.get(0);
                cr.bookAutoService(1, autoService.getID(), serviceList);
            } else {
                // Handle the case where no auto services are available
                System.err.println("No auto services available.");
            }
        }
        List<AutoService> autoServiceList = cr.availableAutoServices(1, new Coordinate(0, 0), serviceList);
        cr.bookAutoService(1, autoServiceList.get(0).getID(), serviceList);

        double length = cr.findDistanceBetweenTwoCoordinates(new Coordinate(2, 1), new Coordinate(4, 3));

        try {
            System.out.println("Driver " + cr.getDriver(1).getDriverFullName() + "has booked: " + cr.getNumberOfBookingsByDrivers(1) + " times.");
        } catch (NoSuchDriver noSuchDriver) {
            noSuchDriver.printStackTrace();
        }

        try {
            AutoService autoService = cr.getAutoService(2);
            double totalProfit = autoService.getTotalProfit();
            System.out.println("Total profit for AutoService with ID 2: " + totalProfit);
        } catch (NoSuchAutoService e) {
            System.out.println("AutoService with ID 2 not found.");
        }
        double totalProfit = cr.getAutoServiceTotalProfit(2);
    }
}
