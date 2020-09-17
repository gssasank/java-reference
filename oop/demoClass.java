package oop;
// Access modifier of this class is public
public class demoClass{
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
    // We generally don't initialize the instance variables here instead we use constructor to do that.
    String name;
    int age;
    String color;
    String breed;
    static int no_of_cats; // class variable

    // Instance methods : behaviour of Cat
    void sleep()
    {
        String sleeping = "Sleeping"; // local variable
        System.out.println(sleeping);
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

