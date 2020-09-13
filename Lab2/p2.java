public class p2 {
    public static void main(String[] args)
    {
        boolean[] arr = new boolean[1001];
        arr[0] = arr[1] = true;
        arr[2] = false;
        for (int i = 2;i<1001/2;i++)
        {
            if(!arr[i])
            {
                for (int j = i*2;j<1001;j+=i)
                arr[j] = true;
            }
        }
        int i = 0;
        for (boolean b:arr)
        {
            if (!b)
                System.out.printf("%d ",i);
            i++;
        }
    }    
}