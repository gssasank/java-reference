import java.util.Random;

abstract class Compartment{
    public abstract void notice();
}

class FirstClass extends Compartment{
    @Override
    public void notice(){
        System.out.println("This is First Class Compartment");
    }
}

class Ladies extends Compartment{
    @Override
    public void notice(){
        System.out.println("This is Ladies Compartment");
    }
}

class General extends Compartment{
    @Override
    public void notice(){
        System.out.println("This is General Compartment");
    }
}

class Luggage extends Compartment{
    @Override
    public void notice(){
        System.out.println("This is Luggage Compartment");
    }
}
public class TestCompartment{
    public static void main(String args[]){
        Compartment[] c1 = new Compartment[10];
        Random rand = new Random();
        for (int i=0;i<10;i++){
            int choice = rand.nextInt(4);
            System.out.print(i+": ");

            if (choice == 0){
                c1[i] = new FirstClass();
                c1[i].notice();
            }
 
            if (choice == 1){
                c1[i] = new Ladies();
                c1[i].notice();
            }
 
            if (choice == 2){
                c1[i] = new General();
                c1[i].notice();
            }
 
            if (choice == 3){
                c1[i] = new Luggage();
                c1[i].notice();
            } 
        } 
    }
}
