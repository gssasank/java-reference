import java.util.Scanner;

public class p4 {
    public static void main(String[] args)
    {
        char[] key = {'D', 'B', 'D', 'C', 'C', 'D', 'A' ,'E', 'A', 'D'};
        Scanner scan = new Scanner(System.in);
        int[] result = new int[8] ;
        System.out.println("Enter Student's Answer: ");
        for(int i =0;i<8;i++)
        {
            for(int j=0;j<10;j++)
            {
                char c;
                c = scan.next().charAt(0);
                if (key[j] == c)
                    result[i]++;
            }
        }
        System.out.println("Results: ");
        for (int i: result)
        {
            System.out.printf("%d ",i);
        }
    }    
}

// A B A C C D E E A D
// D B A B C A E E A D
// E D D A C B E E A D
// C B A E D C E E A D
// A B D C C D E E A D
// B B E C C D E E A D
// B B A C C D E E A D
// E B E C C D E E A D