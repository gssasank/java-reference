package oop;

public class demoConstructor {
    // Instance variables
    private String name;
    private int rollno;
    private String branch;
    private boolean isStudent;

    /* 
    * A Constructor initialize the object when it is created.
    * It has same name as the class and syntactically similar to a method.
    * Constructor has no explicit return type.
    * We use constructors to give initial values to the instance variables defined by a class 
    * If we dont make a constructor the default constructor will be called i.e. 
        demoConstructor(){

        }
        this will set all the variables to their default values i.e 0 for int, null for strings, false for boolean
    */
    // Constructor1
    demoConstructor(){
        name = "Aman Yadav";
        rollno = 7;
        branch = "CSE";
        isStudent = true;
    }

    // parametrized constructor: constructor overloading
    // Constructor2
    demoConstructor(String name, int rn, String branch){
        // if we are using variables name of the method same as the instance variables of the class,
        // then we use 'this' keyword to refer to the current object
        this.name = name;
        // if the name of variable is not same as the instance variables then we don't need 'this' keyword
        rollno = rn;
        this.branch = branch;
        isStudent = true;
    }
    // Constructor3
    demoConstructor(String name){
        this.name = name;
        // if we don't provide any value then the default values will be used else we can assign custom values as given below
        // this.rollno = 10;
        // this.branch = "EEE";
        // this.isStudent = false;
    }

    // Instance methods: getter functions
    String getName() {
        return name;
    }
    int getRollno() {
        return rollno;
    }
    String getBranch() {
        return branch;
    }
    Boolean getIsStudent(){
        return isStudent;
    }

    // Main method: Driver function
    public static void main(String[] args){
        // calling constructor1
        demoConstructor s1 = new demoConstructor();
        System.out.println(s1.getName());
        System.out.println(s1.getRollno());
        System.out.println(s1.getBranch());
        System.out.println(s1.getIsStudent());
        
        // calling constructor2
        demoConstructor s2 = new demoConstructor("Manav",13,"BCA");
        System.out.println(s2.getName());
        System.out.println(s2.getRollno());
        System.out.println(s2.getBranch());
        System.out.println(s2.getIsStudent());

        // calling constructor3
        demoConstructor s3 = new demoConstructor("Saurabh");
        System.out.println(s3.getName());
        System.out.println(s3.getRollno());
        System.out.println(s3.getBranch());
        System.out.println(s3.getIsStudent());
    }
}
