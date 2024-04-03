package exercise;

// BEGIN
//import Point;
class Segment {
    private Point beginPoint;
    private Point endPoint;
    Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
    public Point getMidPoint() {
        Point begin = this.getBeginPoint();
        Point end = this.getEndPoint();
        Point c = new Point((begin.getX()+end.getX())/2, (begin.getY()+end.getY())/2);
        return c;
    }
}
// END
