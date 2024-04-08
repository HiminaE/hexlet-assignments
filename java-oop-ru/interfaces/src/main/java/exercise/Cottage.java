package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;
    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    @Override
    public double getArea() {
        return this.area;
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
        return this.floorCount + " этажный коттедж площадью " + this.getArea() + " метров";
    }
}
// END
