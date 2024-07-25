package uz.muu;
import uz.muu.exceptions.*;
import java.util.*;
import java.util.stream.Collectors;

public class CarRepairing {
	List<AutoService> autoServiceList = new LinkedList<>();
	List<Driver> driverList = new LinkedList<>();
	List<Service> serviceList = new LinkedList<>();

	public AutoService createAutoService(int ID, String name, Coordinate coordinate) {
		AutoService autoService = new AutoService(ID, name, new Coordinate((int) coordinate.getxAxes(), (int) coordinate.getyAxes()));
		autoServiceList.add(autoService);
		return autoService;
	}

	public Collection<AutoService> getAutoServices() {
		return autoServiceList;
	}

	public Driver addDriver(int ID, String fullName, String carModel) throws DriverAlreadyExist {
		for (Driver d : driverList) {
			if (ID == d.getDriverId()) {
				throw new DriverAlreadyExist();
			}
		}
		Driver driver = new Driver(ID, fullName, carModel);
		driverList.add(driver);
		return driver;
	}

	public Collection<Driver> getDrivers() {
		return driverList;
	}

	public Driver getDriver(int ID) throws NoSuchDriver {
		for (Driver d : driverList) {
			if (ID == d.getDriverId()) {
				return d;
			}
		}
		throw new NoSuchDriver("Driver not found with ID: " + ID);
	}


	public Service createService(int ID, String serviceName, double cost) {
		Service service = new Service(ID, serviceName, cost);
		serviceList.add(service);
		return service;
	}

	public Service getService(int ID) throws NoSuchService {
		for (Service s : serviceList) {
			if (ID == s.getServiceID()) {
				return s;
			}
		}
		throw new NoSuchService();
	}
//
//	// R4 - Booking
//	public List<AutoService> availableAutoServices(int driverID, Coordinate currentCoordinate, List<Service> serviceList) {
//		List<AutoService> nearbyAutoServices = new ArrayList<>();
//		final double MAX_DISTANCE = 100.0; // Example value, adjust according to your requirement
//
//		for (AutoService autoService : autoServiceList) {
//			double distance = findDistanceBetweenTwoCoordinates(currentCoordinate, autoService.getCoordinate());
//
//			// Check if AutoService can provide all requested services
//			boolean canProvideServices = true;
//			for (Service service : serviceList) {
//				if (!autoService.canProvideService(service.getServiceID())) {
//					canProvideServices = false;
//					break;
//				}
//			}
//
//			// Add AutoService if it's nearby and can provide services
//			if (canProvideServices && distance <= MAX_DISTANCE) {
//				nearbyAutoServices.add(autoService);
//			}
//		}
//
//		// Sort nearby AutoServices by distance in ascending order
//		Collections.sort(nearbyAutoServices, new Comparator<AutoService>() {
//			@Override
//			public int compare(AutoService autoService1, AutoService autoService2) {
//				return Double.compare(findDistanceBetweenTwoCoordinates(currentCoordinate, autoService1.getCoordinate()),
//						findDistanceBetweenTwoCoordinates(currentCoordinate, autoService2.getCoordinate()));
//			}
//		});
//
//		// Return only the top 3 closest AutoServices (if available)
//		return nearbyAutoServices.subList(0, Math.min(3, nearbyAutoServices.size()));
//	}
//
//	public boolean bookAutoService(int driverID, int autoServiceID, List<Service> serviceList) {
//		for (Driver driver : driverList) {
//			if (driver.getDriverId() == driverID) {
//				for (AutoService autoService : autoServiceList) {
//					if (autoServiceID == autoService.getID()) {
//						// Check if all services are available at the chosen AutoService
//						boolean allServicesAvailable = true;
//						for (Service service : serviceList) {
//							if (!autoService.canProvideService(service.getServiceID())) {
//								allServicesAvailable = false;
//								break;
//							}
//						}
//						if (allServicesAvailable) {
//							// Booking confirmed, update AutoService records
//							autoService.addBookedService(driverID, serviceList);
//							return true;
//						}
//					}
//				}
//			}
//		}
//		return false;
//	}
//
//	// R5 - Statistics
//	public int getNumberOfBookingsByDrivers(int driverID) throws NoSuchDriver {
//		int bookingCount = 0;
//		for (AutoService autoService : autoServiceList) {
//			bookingCount += autoService.getNumberOfBookingsByDriver(driverID);
//		}
//		return bookingCount;
//	}
//
//	public double getAutoServiceTotalProfit(int autoServiceID) throws NoSuchAutoService {
//		double totalProfit = 0.0;
//		for (AutoService autoService : autoServiceList) {
//			if (autoService.getID() == autoServiceID) {
//				totalProfit = autoService.getTotalProfit();
//				break; // Early exit after finding the matching AutoService
//			}
//		}
//		return totalProfit;
//	}
//
//	public double findDistanceBetweenTwoCoordinates(Coordinate startingCoordinate, Coordinate destinationCoordinate) {
//		double xMin = Math.min(Math.abs(startingCoordinate.getxAxes()), Math.abs(destinationCoordinate.getxAxes()));
//		double xMax = Math.max(Math.abs(startingCoordinate.getxAxes()), Math.abs(destinationCoordinate.getyAxes()));
//		double yMin = Math.min(Math.abs(startingCoordinate.getyAxes()), Math.abs(destinationCoordinate.getyAxes()));
//		double yMax = Math.max(Math.abs(startingCoordinate.getyAxes()), Math.abs(destinationCoordinate.getyAxes()));
//		double xLength = xMax - xMin;
//		double yLength = yMax - yMin;
//		double length = Math.sqrt(xLength * xLength + yLength * yLength);
//		return length;
//	}


	// R4 - Booking (assuming necessary methods exist for driver/service validity checks)
	public List<AutoService> availableAutoServices(int driverID, Coordinate currentCoordinate, List<Service> serviceList) {
		final double MAX_DISTANCE = 100.0; // Adjust according to your requirements

		return autoServiceList.stream()
				.filter(autoService -> autoService.canProvideServices(serviceList)) // Filter by service availability
				.filter(autoService -> findDistanceBetweenTwoCoordinates(currentCoordinate, autoService.getCoordinate()) <= MAX_DISTANCE) // Filter by proximity
				.sorted((autoService1, autoService2) -> Double.compare(
						findDistanceBetweenTwoCoordinates(currentCoordinate, autoService1.getCoordinate()),
						findDistanceBetweenTwoCoordinates(currentCoordinate, autoService2.getCoordinate())))
				.limit(3) // Return only the top 3 closest AutoServices
				.collect(Collectors.toList());
	}

	public boolean bookAutoService(int driverID, int autoServiceID, List<Service> serviceList) {
		for (AutoService autoService : autoServiceList) {
			if (autoService.getID() == autoServiceID) {
				if (autoService.canProvideServices(serviceList)) { // Ensure AutoService can provide all services
					autoService.addBookedService(driverID, serviceList);
					return true;
				} else {
					// Handle situation where AutoService cannot provide all services (optional)
					System.out.println("Error: AutoService cannot provide all requested services.");
					return false;
				}
			}
		}
		return false; // AutoService not found or booking failed
	}

	public double findDistanceBetweenTwoCoordinates(Coordinate startingCoordinate, Coordinate destinationCoordinate) {
		double xMin = Math.min(Math.abs(startingCoordinate.getxAxes()), Math.abs(destinationCoordinate.getxAxes()));
		double xMax = Math.max(Math.abs(startingCoordinate.getxAxes()), Math.abs(destinationCoordinate.getyAxes()));
		double yMin = Math.min(Math.abs(startingCoordinate.getyAxes()), Math.abs(destinationCoordinate.getyAxes()));
		double yMax = Math.max(Math.abs(startingCoordinate.getyAxes()), Math.abs(destinationCoordinate.getyAxes()));
		double xLength = xMax - xMin;
		double yLength = yMax - yMin;
		double length = Math.sqrt(xLength * xLength + yLength * yLength);
		return length;
	}

	// R5 - Statistics

	public int getNumberOfBookingsByDrivers(int driverID) throws NoSuchDriver {
		int bookingCount = 0;
		for (AutoService autoService : autoServiceList) {
			bookingCount += autoService.getNumberOfBookingsByDriver(driverID);
		}
		return bookingCount;
	}

//	public double getAutoServiceTotalProfit(int autoServiceID) throws NoSuchAutoService {
//		double totalProfit = 0.0;
//		for (AutoService autoService : autoServiceList) {
//			if (autoService.getID() == autoServiceID) {
//				totalProfit = autoService.getTotalProfit();
//				break; // Early exit after finding the matching AutoService
//			}
//		}
//		return totalProfit;
//	}
	public double getAutoServiceTotalProfit(int autoServiceID) throws NoSuchAutoService {
		for (AutoService autoService : autoServiceList) {
			if (autoService.getID() == autoServiceID) {
				return autoService.getTotalProfit();
			}
		}
//		throw new NoSuchAutoService("AutoService with ID " + autoServiceID + " not found.");
		throw new NoSuchAutoService();
	}


	public AutoService getAutoService(int ID) throws NoSuchAutoService{
		for (AutoService autoService : autoServiceList){
			if (autoService.getID() == ID){
				return autoService;
			}
		}
		throw new NoSuchAutoService();
	}
}
