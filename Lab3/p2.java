package Lab3;

public class p2 {
    public static void main(String[] args){
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println("Area is " + c1.getArea());
        System.out.println("Perimeter is " + c1.getPerimeter());
        System.out.println(c1.contains(3, 3));
        System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));   
        System.out.println(c1.contains(new Circle2D(2, 2, 2)));    
    }
}

class Circle2D{
    private double x;
    private double y;
    private double r;

    public double[] getCenter(){
        double[] center = new double[2];
        center[0] = x;
        center[1] = y;
        return center;
    }
    public double getRadius(){
        return r;
    }

    public Circle2D(){
        x = 0;
        y = 0;
        r = 1;
    }
    public Circle2D(double x,double y,double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getArea(){
        return r*r*3.141592;
    }
    public double getPerimeter(){
        return 2*3.141592*r;
    }
    double calcDist(double a,double b){
        double r1 = Math.pow(Math.pow(x-a,2)+Math.pow(y-b,2),0.5);
        return r1;
    }
    public boolean contains(double a,double b){
        double r1 = calcDist(a, b);
        return r1>r?false:true;
    }
    public boolean contains(Circle2D circle){
        double[] c1 = circle.getCenter();
        double d1 = calcDist(c1[0], c1[1]);
        double r1 = circle.getRadius();
        return d1+r1 < r?true:false;
    }
    public boolean overlaps(Circle2D circle){
        double[] c1 = circle.getCenter();
        double d1 = calcDist(c1[0], c1[1]);
        double r1 = circle.getRadius();
        double small_rad = r>r1?r1:r;
        double big_rad = r1>r?r1:r;
        return d1+small_rad > big_rad?true:false;
    }
}