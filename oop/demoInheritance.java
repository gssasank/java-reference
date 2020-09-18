package oop;
    /*
    Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object.
    The idea behind inheritance in Java is that you can create new classes that are built upon existing classes. 
    When you inherit from an existing class, you can reuse methods and fields of the parent class.
    Moreover, you can add new methods and fields in your current class also. 

    Terms used in Inheritance-
    * Sub Class/Child Class: Subclass is a class which inherits the other class. It is also called a derived class, extended class, or child class.
    * Super Class/Parent Class: Superclass is the class from where a subclass inherits the features. It is also called a base class or a parent class.

    Important points in inheritance-
    * A class can have one and only one direct superclass/parent class.
    * A subclass inherits all the members but as constructors are not members, so they are not inherited by subclass,
      but we can invoke the constructor of the superclass with the help of subclass.
    * A subclass does not inherit the private members of its parent class.

    Syntax
    class ChildClass extends ParentClass{
        // some code
    }

    There are 3 types of inheritance in Java:
    * Single inheritance: P -> C
    * Multi level inheritance: P -> I -> C
    * Hierarchical inheritance: 
              ↗ C
            P -> C     
              ↘ C
    */   


class Animal{
    private String name;
    String color;
    Animal(){
        name = "Name of animal";
        color = "Color of animal";
    }
    Animal(String name, String color){
        this.name = name;
        this.color = color;
    }
    void printName(){
        System.out.println("Name = "+name);
    }
    void printColor(){
        System.out.println("Color = "+color);
    }
}

// Single Inheritance
class Dog extends Animal{
    Dog(){
        // this will call constructor of parent class by default
        // java automatically adds the statement given in comment below 
        // super();
        // for more info read constructorChaining.java
    }
    Dog(String name,String color){
        // we can call constructor of parent class by 'super' keyword. Read thisVSsuper.java for more info
        super(name,color);
    }
    void eat(){
        System.out.println("Dog is eating");
    }
}
public class demoInheritance {
    public static void main(String[] args){
        Dog d1 = new Dog();
        d1.printName();
        d1.printColor();
        System.out.println(d1.color);
        d1.eat();
        // System.out.println((d1.name)); // this wont work as the name is private

        System.out.println("---------------------");
        Dog d2 = new Dog("Oscar","Black");
        d2.printName();
        d2.printColor();
    }
}
