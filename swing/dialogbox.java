import javax.swing.JOptionPane;

public class dialogbox {
    public static void main(String[] args)
    {
        String s1 = JOptionPane.showInputDialog(null, "Enter your age","An Integer Requested",JOptionPane.QUESTION_MESSAGE);
        int x = Integer.parseInt(s1);
        JOptionPane.showMessageDialog(null, "Your age is "+x,"Result",JOptionPane.INFORMATION_MESSAGE);
    }
}