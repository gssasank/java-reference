import java.util.Random;

public class p3 {
    public static void main(String[] args)
    {
        char[] arr = new char[40];
        int low = 'a',high = 'z';
        Random rand = new Random();
        for(int i=0;i<40;i++)
        {
            arr[i] = (char)(rand.nextInt(high-low+1)+low);
        }
        System.out.println("Lowercase letters are: ");
        for (char c:arr)
            System.out.printf("%c ",c);
        
        int[] count = new int[26];
        for(int i = 0 ;i <40;i++)
        {
            count[arr[i]-'a']++;
        }
        System.out.println("\nThe occurence of each letters are:");
        for (int i=0;i<26;i++)
        {
            System.out.printf("%d %c ",count[i],i+'a');
        }
    }    
}