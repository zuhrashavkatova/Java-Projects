//package uz.muu;
//
//public class Service {
//    private int serviceID;
//    private String serviceName;
//    private double serviceCost;
//
//    public Service(int serviceID, String serviceName, double serviceCost) {
//        this.serviceID = serviceID;
//        this.serviceName = serviceName;
//        this.serviceCost = serviceCost;
//    }
//
//    public int getServiceID() {
//        return serviceID;
//    }
//
//    public void setServiceID(int serviceID) {
//        this.serviceID = serviceID;
//    }
//
//    public String getServiceName() {
//        return serviceName;
//    }
//
//    public void setServiceName(String serviceName) {
//        this.serviceName = serviceName;
//    }
//
//    public static double getServiceCost() {
//        return serviceCost;
//    }
//
//    public void setServiceCost(double serviceCost) {
//        this.serviceCost = serviceCost;
//    }
//
////    public double getServiceCost() { // Remove the static modifier
////        return serviceCost;
////    }
//
//    @Override
//    public String toString() {
//        return "Service{" +
//                "serviceID=" + serviceID +
//                ", serviceName='" + serviceName + '\'' +
//                ", serviceCost=" + serviceCost +
//                '}';
//    }
//
//    public double getServiceCost(Integer serviceCost) {
//        this.serviceCost = serviceCost;
//    }
//}

package uz.muu;

public class Service {
    private int serviceID;
    private String serviceName;
    private double serviceCost;

    public Service(int serviceID, String serviceName, double serviceCost) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceID=" + serviceID +
                ", serviceName='" + serviceName + '\'' +
                ", serviceCost=" + serviceCost +
                '}';
    }
}
