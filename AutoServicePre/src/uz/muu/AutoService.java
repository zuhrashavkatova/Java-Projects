//package uz.muu;
//import java.util.Map;
//
//import java.util.*;
//
//public class AutoService {
//    private int ID;
//    private String name;
//    private Coordinate coordinate;
//    private List<Integer> servicesOffered; // List of service IDs offered by the AutoService
////    private Map<Integer, List<Integer>> bookedServices; // Map of driver ID to list of booked service IDs
//    // Map to store service IDs and corresponding availability flags
//    private Map<Integer, Boolean> availableServices = new HashMap<>();
//    // Map to store bookings by driver ID
//    private Map<Integer, List<Service>> bookedServices = new HashMap<>();
//
//    public AutoService(int ID, String name, Coordinate coordinate) {
//        this.ID = ID;
//        this.name = name;
//        this.coordinate = new Coordinate((int) coordinate.getxAxes(), (int) coordinate.getyAxes());
//        servicesOffered = new LinkedList<>();
////        bookedServices = new HashMap<Integer, List<Integer>>();
//    }
//
//    public int getID() {
//        return ID;
//    }
//
//    public void setID(int ID) {
//        this.ID = ID;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Coordinate getCoordinate() {
//        return coordinate;
//    }
//
//    public void setCoordinate(Coordinate coordinate) {
//        this.coordinate = coordinate;
//    }
//
//    public void addOfferedService(int serviceID) {
//        servicesOffered.add(serviceID);
//    }
//
//    public List<Integer> getServicesOffered() {
//        return servicesOffered;
//    }
//
//    public boolean canProvideService(int serviceID) {
//        return servicesOffered.contains(serviceID);
//    }
//
//    public void addBookedService(int driverID, List<Service> serviceList) {
//        List<Integer> bookedServiceIDs = bookedServices.getOrDefault(driverID, new LinkedList<Integer>());
//        for (Service service : serviceList) {
//            bookedServiceIDs.add(service.getServiceID());
//        }
//        bookedServices.put(driverID, bookedServiceIDs);
//    }
//
//    public int getNumberOfBookingsByDriver(int driverID) throws NoSuchDriver {
//        if (!bookedServices.containsKey(driverID)) {
//            throw new NoSuchDriver("Driver with ID " + driverID + " not found.");
//        }
//        return bookedServices.get(driverID).size();
//    }
//    public double getTotalProfit() {
//        double totalProfit = 0.0;
//
//        // Iterate through all booked services
//        for (Map.Entry<Integer, List<Service>> entry : bookedServices.entrySet()) {
//            List<Service> bookedServicesList = entry.getValue();
//
//            // Stream the booked services and sum their costs
//            totalProfit += bookedServicesList.stream()
//                    .mapToDouble(Service::getServiceCost) // Extract service cost using method reference
//                    .sum();
//        }
//
//        return totalProfit;
//    }
//
//
//    public boolean canProvideServices(List<Service> requestedServices) {
//        // Check if all requested services are available
//        for (Service service : requestedServices) {
//            int serviceID = service.getServiceID(); // Assuming Service has getServiceID()
//            if (!availableServices.containsKey(serviceID) || !availableServices.get(serviceID)) {
//                return false; // Service not available
//            }
//        }
//        return true; // All requested services are available
//    }
//
//    // Add additional methods for managing service availability (optional)
//    public void addAvailableService(int serviceID) {
//        availableServices.put(serviceID, true);
//    }
//
//    public void removeAvailableService(int serviceID) {
//        availableServices.remove(serviceID);
//    }
//
//    public void setServiceAvailability(int serviceID, boolean available) {
//        availableServices.put(serviceID, available);
//    }
//
//    // Methods for managing booked services (assuming Service class is defined)
//    public void addBookedService(int driverID, List<Service> bookedServices) {
//        this.bookedServices.put(driverID, bookedServices);
//    }
//
//    public int getNumberOfBookingsByDriver(int driverID) throws NoSuchDriver {
//        if (!bookedServices.containsKey(driverID)) {
//            throw new NoSuchDriver("Driver with ID " + driverID + " not found.");
//        }
//        return bookedServices.get(driverID).size();
//    }
//
//    public double getTotalProfitByService(int serviceID) {
//        // Implement logic to calculate total profit earned from serviceID
//        // This might involve accessing service cost information and number of times the service was booked
//        return 0.0; // Placeholder value, replace with actual calculation
//    }
//
//    @Override
//    public String toString() {
//        return "AutoService{" +
//                "ID=" + ID +
//                ", name='" + name + '\'' +
//                ", coordinate=" + coordinate +
//                ", servicesOffered=" + servicesOffered +
//                ", bookedServices=" + bookedServices +
//                '}';
//    }
//}


package uz.muu;

import uz.muu.exceptions.NoSuchDriver;

import java.util.*;

public class AutoService {
    private int ID;
    private String name;
    private Coordinate coordinate;
    private List<Integer> servicesOffered;
    private Map<Integer, List<Service>> bookedServices = new HashMap<>();

    public AutoService(int ID, String name, Coordinate coordinate) {
        this.ID = ID;
        this.name = name;
        this.coordinate = new Coordinate((int) coordinate.getxAxes(), (int) coordinate.getyAxes());
        servicesOffered = new LinkedList<>();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void addOfferedService(int serviceID) {
        servicesOffered.add(serviceID);
    }

    public List<Integer> getServicesOffered() {
        return servicesOffered;
    }

    public boolean canProvideService(int serviceID) {
        return servicesOffered.contains(serviceID);
    }

    public void addBookedService(int driverID, List<Service> serviceList) {
        bookedServices.put(driverID, serviceList);
    }

    public int getNumberOfBookingsByDriver(int driverID) throws NoSuchDriver {
        if (!bookedServices.containsKey(driverID)) {
            throw new NoSuchDriver("Driver with ID " + driverID + " not found.");
        }
        return bookedServices.get(driverID).size();
    }

    public double getTotalProfit() {
        double totalProfit = 0.0;
        for (List<Service> services : bookedServices.values()) {
            for (Service service : services) {
                totalProfit += service.getServiceCost();
            }
        }
        return totalProfit;
    }

    public boolean canProvideServices(List<Service> requestedServices) {
        for (Service service : requestedServices) {
            if (!servicesOffered.contains(service.getServiceID())) {
                return false;
            }
        }
        return true;
    }

    public void addAvailableService(int serviceID) {
        servicesOffered.add(serviceID);
    }

    public void removeAvailableService(int serviceID) {
        servicesOffered.remove(serviceID);
    }

    public void setServiceAvailability(int serviceID, boolean available) {
        if (available) {
            servicesOffered.add(serviceID);
        } else {
            servicesOffered.remove(serviceID);
        }
    }
}
