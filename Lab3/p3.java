package Lab3;
import java.time.LocalDateTime;


public class p3 {
    public static void main(String[] args){
        Time t1 = new Time();
        System.out.println("Time(t1) = "+t1.getTimeHour()+":"+t1.getTimeMinute()+":"+t1.getTimeSecond());

        Time t2 = new Time("15:07:10");
        System.out.println("Time(t2) = "+t2.getTimeHour()+":"+t2.getTimeMinute()+":"+t2.getTimeSecond());

        Time t3 = new Time(555550000);
        System.out.println("Time(t3) = "+t3.getTimeHour()+":"+t3.getTimeMinute()+":"+t3.getTimeSecond());

        t1.setTime(555550000);
        System.out.println("Time(t1) = "+t1.getTimeHour()+":"+t1.getTimeMinute()+":"+t1.getTimeSecond());
    }
}

class Time{
    private int hour;
    private int min;
    private int sec;

    public Time(){
        hour = LocalDateTime.now().getHour();
        min = LocalDateTime.now().getMinute();
        sec = LocalDateTime.now().getSecond();
    }
    public Time(long elapsedTime){
        int[] time = new int[3];
        time = tsToTime(elapsedTime);
        hour = time[0];
        min = time[1];
        sec = time[2];
    }

    int[] tsToTime(long elapsedTime){
        int[] res = new int[3];
        double days = elapsedTime / (1000*60*60*24.0); // milliseconds to days
        
        double temp = days - (int)days; // removed completed days
        double h = temp*24; // days to hours
        res[0] = (int)h; // added completed hours to result

        temp = h - (int)h; //removed completed hours
        double m = temp*60; // hours to minutes
        res[1]= (int)m; // added completed minutes to result

        temp = m - (int)m; //removed completed minutes
        double s = temp*60; // minutes to seconds
        res[2] = (int)s; // added completed seconds to result
        
        return res;
    }

    public Time(String time){
        String[] time1 = time.split(":");
        hour = Integer.parseInt(time1[0]);
        min = Integer.parseInt(time1[1]);
        sec = Integer.parseInt(time1[2]);
    }

    public int getTimeHour(){
        return hour;
    }
    public int getTimeMinute(){
        return min;
    }
    public int getTimeSecond(){
        return sec;
    }

    public void setTime(long elapsedTime){
        int[] time = new int[3];
        time = tsToTime(elapsedTime);
        hour = time[0];
        min = time[1];
        sec = time[2];
    }
}