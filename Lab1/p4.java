import java.util.Scanner;

public class p4 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter monthly interst: ");
        Double monthly = scan.nextDouble();
        monthly /= 100;

        System.out.print("Enter number of years: ");
        Double years = scan.nextDouble();

        System.out.print("Enter loan amount: ");
        Double loan = scan.nextDouble();

        Double monthlyPayment = loan * (monthly / (1.0 - (1.0/(Math.pow(1.0 + monthly , years*12.0)))));

        System.out.println("Monthly Payment: " + monthlyPayment);

        scan.close();
    }    
}