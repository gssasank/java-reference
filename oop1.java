public class oop1{
    public static void main(String[] args)
    {
        // Creating objects
        Cat tom = new Cat();
        Cat mike = new Cat();

        // Defining tom
        tom.name="Tom";
        tom.age = 3;
        tom.breed = "Russian blue";
        tom.color = "Gray";
        tom.sleep();

        // defining mike
        mike.name = "Mike";
        mike.age = 4;
        mike.breed = "Maine Coon";
        mike.color = "Brown";
        mike.play();

    }
}

class Cat{
    // Istance variable : states of cat
    String name;
    int age;
    String color;
    String breed;
    
    // Instance methods : behaviour of Cat
    void sleep()
    {
        System.out.println("Sleeping");
    }

    void play()
    {
        System.out.println("Playing");
    }
    void feed()
    {
        System.out.println("Eating");
    }
}

