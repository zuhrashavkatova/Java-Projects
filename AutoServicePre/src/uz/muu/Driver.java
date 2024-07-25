package uz.muu;

public class Driver {
	private int driverId;
	private String driverFullName;
	private String carModel;

	public Driver(int driverId, String driverFullName, String carModel) {
		this.driverId = driverId;
		this.driverFullName = driverFullName;
		this.carModel = carModel;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverFullName() {
		return driverFullName;
	}

	public void setDriverFullName(String driverFullName) {
		this.driverFullName = driverFullName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	@Override
	public String toString() {
		return "Driver{" +
				"driverId=" + driverId +
				", driverFullName='" + driverFullName + '\'' +
				", carModel='" + carModel + '\'' +
				'}';
	}
}
