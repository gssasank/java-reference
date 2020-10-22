public class outofmem{
    public static void main(String args[]){
        try{
            double[] arr = new double[1000000000];
        }
        catch(OutOfMemoryError ex){
            System.out.println("out of memory exception");        
        }
    }    
}