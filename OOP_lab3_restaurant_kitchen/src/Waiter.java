public class Waiter {
    private int waiterId;
    private String waiterFullname;
    private double salary;

    public Waiter(int waiterId, String waiterFullname) {
        this.waiterId = waiterId;
        this.waiterFullname = waiterFullname;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public String getWaiterFullname() {
        return waiterFullname;
    }

    public void setWaiterFullname(String waiterFullname) {
        this.waiterFullname = waiterFullname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "waiterId=" + waiterId +
                ", waiterFullname='" + waiterFullname + '\'' +
                ", salary=" + salary +
                '}';
    }
}