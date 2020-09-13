import java.util.Scanner;

public class p1
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String str1,str2;

        System.out.print("Enter first string: ");
        str1 = scan.next().toLowerCase();

        System.out.print("Enter second string: ");
        str2 = scan.next().toLowerCase();

        int len = str1.length() < str2.length() ? str1.length():str2.length();
        System.out.print("Common prefix: ");
        for (int i = 0; i < len ; i++)
        {
            if(str1.charAt(i) == str2.charAt(i)) 
                System.out.print(str1.charAt(i));
            else
                break;
        }
    }
}