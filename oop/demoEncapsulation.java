package oop;

// Encapsulation refers to the bundling of data with the methods that operate on that data, 
// or the restricting of direct access to some of an object's components.
// Encapsulation can be achieved by: 
//(1) By Making member variables private; (2) By creating getters and setters methods public
// Benifits of encapsulation: 
// (1) The fields of class can be made read-only or write-only; (2) A class can have total control over what is stored in its fields

class Anime{
    private String name;
    private double rating;
    // Use constructor if you think initialization is mandatory before you can use the object. 
    //Use setter method when initialization of variable is non-mandatory to use the object.
    
    // Setter methods: write only
    public void setName(String name){
        this.name = name;
    }
    public void setRating(double r){
        rating = r;
    }

    // getter methods: read only
    public String getName(){
        return name;
    }
    public double getRating(){
        return rating;
    }
}
public class demoEncapsulation {
    public static void main(String[] args){
        Anime a1 = new Anime();
        a1.setName("Attack on Titan");
        a1.setRating(9.8);
        System.out.println(a1.getName());
        System.out.println(a1.getRating());
    }
}
