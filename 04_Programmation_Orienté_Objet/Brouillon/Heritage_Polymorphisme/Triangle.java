public class Triangle implements AvecSurface {
    protected Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double surface(){
        double a = p1.distance(p2);
        double b = p1.distance(p3);
        double c = p2.distance(p3);
        double dp = (a+b+c)/2;
        return Math.sqrt(dp*(dp -a)*(dp-b)*(dp-c));
    }
}
