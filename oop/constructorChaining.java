package oop;

class A1{
    A1(){
        System.out.println("This is upper class");
    }
}

class B1 extends A1{
    B1(){
        System.out.println("This is non parametrized constructor of class B1"); 
    }
    B1(int a){
        this();
        System.out.println("This is parametrized(int) constructor of class B1");
    }
    B1(String a){
        this(9);
        System.out.println("This is parametrized(String) constructor of class B1");
    }
}
public class constructorChaining {
    public static void main(String[] args){
        B1 obj = new B1();
        /*
        OUTPUT:
         This is upper class
         This is non parametrized constructor of class B1
         */
        // this happening as Java by default adds a statement 'super();' at the starting of the constructor
        // which calls the constructor of the upper class and after that the called constructor is invoked.
        // we can have only one of the super() or this() statement in a constructor

        System.out.println("---------------------");
        B1 obj2 = new B1(1);
        /*
        OUTPUT:
        This is upper class
        This is non parametrized constructor of class B1
        This is parametrized(int) constructor of class B1
        */
        // here fist the parametrized constructor of B1 is called which then called the non parametrized constructor of B1
        // then the non parametrized constructor of B1 called the constructor of the super class A1 and we got the first line of output
        // then control returned to the non parametrized constructor of B1 and we get the second line of output
        // after that control returned to the parametrized constructor and we got our final line of output

        System.out.println("---------------------");
        B1 obj3 = new B1("hey");
        /*
        OUTPUT:
        This is upper class
        This is non parametrized constructor of class B1
        This is parametrized(int) constructor of class B1
        This is parametrized(String) constructor of class B1 
        */

        // this(9) called the constructor with int param.
        // rest logic is same
        // this is how constructors are chained in Java
    }
}
