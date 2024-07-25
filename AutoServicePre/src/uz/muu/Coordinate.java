package uz.muu;

public class Coordinate {

    private double xAxes, yAxes;

    public double getxAxes() {
        return xAxes;
    }

    public void setxAxes(double xAxes) {
        this.xAxes = xAxes;
    }

    public double getyAxes() {
        return yAxes;
    }

    public void setyAxes(double yAxes) {
        this.yAxes = yAxes;
    }

    public Coordinate(int xAxes, int yAxes) {
        this.xAxes = xAxes;
        this.yAxes = yAxes;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "xAxes=" + xAxes +
                ", yAxes=" + yAxes +
                '}';
    }
}
