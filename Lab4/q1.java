package Lab4;

import Lab3.StackOfIntegers;
import java.util.Scanner;

public class q1{
    public static void main(String[] args){
        int num;
        System.out.println("Enter Integer");
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        StackOfIntegers ans = new StackOfIntegers();
        ans = primeFactors.prime_factor(num);
        int i = ans.getSize();

        while(i != 0){
            System.out.println(ans.pop());
            i--;
        }
        scan.close();
    }
}