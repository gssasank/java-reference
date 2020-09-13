import java.util.Scanner;

public class p3 {
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your weight (in kg): ");
        Double weight = scan.nextDouble();
        System.out.print("Enter your height (in m): ");
        Double height = scan.nextDouble();

        Double bmi = weight / (height*height);
        System.out.print("Your BMI is: " + bmi +"\nInterpretation = ");
        if (bmi < 18.5)
            System.out.println("Underweight");
        else if (bmi >= 18.5 && bmi < 25.0)
            System.out.println("Normal");
        else if (bmi >= 25.0 && bmi < 30.0)
            System.out.println("Overweight");
        else 
            System.out.println("Obese");
        scan.close();
    }
}