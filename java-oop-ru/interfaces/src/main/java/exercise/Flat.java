package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;
    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;

    }
    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }
    @Override
    public int compareTo(Home another) {
        if (another.getArea() == this.getArea()) {
            return 0;
        } else if (another.getArea() < this.getArea()){
            return 1;
        }
        return -1;
    }
    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
