// Note: At the time of writing this code the name of the directory was Java 
package Java;
// since we have created our own package i.e. the name of the directory so if we want to run this code we will need to run
// the code from its parent directory after compiling, by executing java Java.TakingInput, or if we want to run the code from current directory
// we will need to set the class path to parent directory i.e. java -classpath ../ Java.TakingInput or java -cp ../ Java.TakingInput
// We can ignore this if we dont make our own packages and dont include package line i.e. line1 in our code then we can run it by java TakingInput
import java.util.Scanner;

public class TakingInput {
    public static void main(String[] args) // here static means we can call this function with its name directly
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        System.out.println("Welcome " + name);

        System.out.print("Enter your age: ");
        int age = scan.nextInt();
        System.out.println("Your age is: " + age);

        scan.close();
    }
}