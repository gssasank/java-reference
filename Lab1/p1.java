import java.util.Scanner;
public class p1 {
    public static void main(String[] args)
    {
        System.out.print("Enter a number: ");
        int a;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        System.out.println("a  a^2  a^3");
        for(int i = 0;i<=a;i++)
            System.out.println(i + "  " + i*i + "  " + i*i*i);
        scan.close();
    }
}