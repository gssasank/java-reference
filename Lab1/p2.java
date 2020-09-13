import java.util.Scanner;

public class p2 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter first equation (ax + by = e): ");
        System.out.print("Enter the value of a: ");
        Double a = scan.nextDouble();
        System.out.print("Enter the value of b: ");
        Double b = scan.nextDouble();
        System.out.print("Enter the value of e: ");
        Double e = scan.nextDouble();

        System.out.println("Enter second equation (cx + dy = f): ");
        System.out.print("Enter the value of c: ");
        Double c = scan.nextDouble();
        System.out.print("Enter the value of d: ");
        Double d = scan.nextDouble();
        System.out.print("Enter the value of f: ");
        Double f = scan.nextDouble();

        Double x = (e*d - b*f)/(a*d - b*c);
        Double y = (a*f - e*c)/(a*d - b*c);

        System.out.println("x = " + x + "\ny = " + y);

        scan.close();
    }
    
}