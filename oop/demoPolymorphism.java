package oop;

/* 
    Polymorphism is a concept by which can perform a single action in different ways.
    Polymorphism means many forms.

    There are 2 types of polymorphism in Java:
    * Static Polymorphism aka Complie time polymorphism - 
        This type of polymorphism is achieved by function/method overloading or operator overloading (only '+' operator is supported).
        Method Overloading: When there are multiple functions with same name but different parameters then these functions are said to be overloaded.
        
    * Dynamic Polymorphism aka runtime polymorphism -
        This type of polymorphism is achieved by Method Overriding i.e. when a sub class class has a definition for one of the 
        member functions of the parent class. That parent class function is said to be overridden.
 */

class Addition{
    // Compile time polymorphism by method overloading

    // Method: add()
    void add(int a, int b){
        System.out.println(a+b);
    }

    // increasing parameters
    void add(int a, int b, int c){
        System.out.println(a+b+c);
    }

    // changing data types
    void add(double a, int b){
        System.out.println(a+b);
    }

    // reversing data types
    void add(int a,double b){
        System.out.println(a+b);
    }
}

public class demoPolymorphism {
    public static void main(String[] args){
        Addition a1 = new Addition();
        a1.add(62,7);
        a1.add(2,3,4);
        a1.add(10.2,5);
        a1.add(4,5);
    }
    
}
