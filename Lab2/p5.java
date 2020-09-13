import java.util.Scanner;

public class p5 {
    public static void main(String[] args)
    {
        double[][] points = new double[8][2];
        Scanner scan = new Scanner(System.in);
        double[] min_pair = new double[5];
        double min_dist = 10000.0;
        System.out.println("Enter the points: ");
        for (int i = 0; i <8; i++)
            for (int j = 0; j <2; j++)
                points[i][j] = scan.nextDouble();
        
        for (int i=0; i<7; i++)
        {
            for (int j=i+1; j<8; j++)
            {
                double dis = Math.pow((Math.pow(points[i][0] - points[j][0],2.0) + Math.pow(points[i][1] - points[j][1],2.0)),0.5);
                System.out.printf("Distance between point: (%.2f,%.2f) & (%.2f,%.2f) = %.2f units\n",points[i][0],points[i][1],points[j][0],points[j][1],dis);
                if (dis < min_dist)
                {
                    min_dist = dis;
                    min_pair[0] = points[i][0];
                    min_pair[1] = points[i][1];
                    min_pair[2] = points[j][0];
                    min_pair[3] = points[j][1];
                    min_pair[4] = dis;
                }
            }
        }
        System.out.printf("Minimum distance is between the points (%.2f,%.2f) & (%.2f,%.2f) i.e %.2f units",min_pair[0],min_pair[1],min_pair[2],min_pair[3],min_pair[4]);
    }
}

// -1 3
// -1 -1
// 1 1
// 2 0.5
// 2 -1
// 3 3
// 4 2
// 4 -0.5