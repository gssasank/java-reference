package oop;

// Encapsulation refers to the bundling of data with the methods that operate on that data, 
// or the restricting of direct access to some of an object's components.
// Encapsulation can be achieved by: 
// (1) By Making member variables private; (2) By creating getters and setters methods public
// Benefits of encapsulation:
// (1) The fields of class can be made read-only or write-only; (2) A class can have total control over what is stored in its fields

class Anime{
    // Use constructor if you think initialization is mandatory before you can use the object. 
    // Use setter method when initialization of variable is non-mandatory to use the object.
    private String name;
    private float rating;
    // Original Language of anime is same for all anime so we can make it static for better memory management
    public static String language;
    
    // Setter methods: write only
    public void setName(String name){
        this.name = name;
    }
    public void setRating(float r){
        rating = r;
    }

    // getter methods: read only
    public String getName(){
        return name;
    }
    public float getRating(){
        return rating;
    }

    // we don't initialize static variables in constructors instead we use static blocks, we can have multiple static blocks
    static{
        language = "Japanese";
    }
    // static methods
    public static void greeting(){
        System.out.println("Konnichiwa");
    }
    // nested static classes
    static class manga {
        // some code
    }
}
public class demoEncapsulation {
    // we make our main function static so that the JVM can call it with creating its instance
    public static void main(String[] args){
        Anime a1 = new Anime();
        a1.setName("Attack on Titan"); 
        a1.setRating(9.8f); // in Java a decimal no is considered as double unless specified
        System.out.println(a1.getName());
        System.out.println(a1.getRating());
        a1.greeting(); 
        // Using the above statement will give us some sort of warning like
        // The static method greeting() from the type Anime should be accessed in a static way
        // so best coding practice is to call the static methods by class name i.e.
        Anime.greeting();
        System.out.println(Anime.language);
    }
}
