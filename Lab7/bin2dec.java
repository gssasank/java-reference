import java.util.Scanner;

public class bin2dec{
    public static String convertDec(String bin){
        try{
            return Integer.toString(Integer.parseInt(bin,2));
        }
        catch(IllegalArgumentException ex){
            return "String not Valid";
        }
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String bin = scan.nextLine();
        String dec = convertDec(bin);
        System.out.println(dec);
        scan.close();
    }
}
