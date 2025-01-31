public class Point {
    protected double x,y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2){
        return Math.sqrt((this.x-p2.x)*(this.x-p2.x)+(this.y-p2.y)*(this.y-p2.y));
    }

}
