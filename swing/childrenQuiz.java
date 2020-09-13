import javax.swing.*;
import java.util.Random;

public class childrenQuiz {
    public static void main(String[] args) 
    {
        String result = "",reply="";
        Random rand = new Random();
        int choice = 0,no1,no2,ans;
        while(choice == JOptionPane.YES_OPTION)
        {
            int questionDriver = rand.nextInt(1000);
            questionDriver = questionDriver % 3;
            no1 = rand.nextInt(20);
            no2 = rand.nextInt(20);
            switch(questionDriver)
            {
                case 0:
                    reply = JOptionPane.showInputDialog(null, "What is "+ no1 + "+" + no2, "Quiz", JOptionPane.QUESTION_MESSAGE);
                    ans = Integer.parseInt(reply);
                    if (ans == no1 + no2)
                        result+="Question: " + no1 + "+" + no2 + " | Your answer: " + ans + " | CORRECT\n";
                    else
                        result+="Question: " + no1 + "+" + no2 + " | Your answer: " + ans + " | INCORRECT\n";
                    break;

                case 1:
                    reply = JOptionPane.showInputDialog(null, "What is "+ no1 + "-" + no2, "Quiz", JOptionPane.QUESTION_MESSAGE);
                    ans = Integer.parseInt(reply);
                    if (ans == no1 - no2)
                        result+="Question: " + no1 + "-" + no2 + " | Your answer: " + ans + " | CORRECT\n";
                    else
                        result+="Question: " + no1 + "-" + no2 + " | Your answer: " + ans + " | INCORRECT\n";
                        break;
                 
                case 2:
                    reply = JOptionPane.showInputDialog(null, "What is "+ no1 + "x" + no2, "Quiz", JOptionPane.QUESTION_MESSAGE);
                    ans = Integer.parseInt(reply);
                    if (ans == no1 * no2)
                        result+="Question: " + no1 + "x" + no2 + " | Your answer: " + ans + " | CORRECT\n";
                    else
                        result+="Question: " + no1 + "x" + no2 + " | Your answer: " + ans + " | INCORRECT\n";
                        break; 
            }
            choice = JOptionPane.showConfirmDialog(null, "Do you want to attempt more questions?","Continue",JOptionPane.YES_NO_OPTION);
        }
        JOptionPane.showMessageDialog(null, result, "RESULT", JOptionPane.INFORMATION_MESSAGE);
    }   
}