package Lab4;
import java.util.Scanner;
import java.util.Random;

public class q2{
    public static void main(String[] args){
        String[] words = {"computer","university","engineering","noida","science","research","machine"};
        Scanner scan = new Scanner(System.in);

        char choice = 'y';
        while(choice == 'y'){
            Random rand = new Random();
            // doubt- if we create the scanner object here (inside the while loop) and close it at the end of while loop then it will
            // throw exception after we have guessed the first word i.e. after completion of first loop.
            // but if we dont close the scanner at the end it wont throw exception.
            // also if we start the scanner before the first while loop and close it inside the while loop, it will throw exception  
            String question = words[rand.nextInt(words.length)];
            int missed = 0;
            String ans = "";
            for(int i = 0; i < question.length();i++)
                ans+="*";
            while(!ans.equals(question)){
                System.out.print("Enter a letter in word "+ans+" > ");
                char ch = scan.next().charAt(0); //breaking here after pressing 'y' after a loop
                if(ans.contains(""+ch)){
                    System.out.println(ch+" is already in the word");
                }
                else if (question.contains(""+ch)){
                    for(int i=0;i<question.length();i++){
                        if (question.charAt(i) == ch){
                            ans = ans.substring(0,i)+ch+ans.substring(i+1,ans.length());
                        }
                    }
                }
                else{
                    System.out.println(ch+" is not in the word");
                    missed++;
                }
            }
            System.out.println("The word is "+question+". You missed "+missed+" times");
            System.out.print("\nDo you want to continue?(y/n): ");
            choice = scan.next().charAt(0);
        }
        scan.close();
    }
}