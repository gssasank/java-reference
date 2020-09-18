package oop;

/*
 * 'this' keyword is a reference variable that refers to the current object. It can be used to refer current class instance variable.
 *  'super' is used to call the constructor, methods and properties of the parent class.
    we can use 'super' in the subclass to invoke methods from the parent class that we have overridden in the subclass.
 */

 // here is an example of 'super' keyword.
 // example of 'this' keyword is already discussed in the file demoConstructor.java
class Parent{
    String info = "this is a parent class";
}

class  Child extends Parent{
    String info = "this is a child class";

    void display(){
        System.out.println(info);
    }
    void display1(){
        System.out.println(super.info);
    }
}

public class thisVSsuper {
    public static void main(String[] args){
        Child c1 = new Child();
        c1.display();
        c1.display1();
    }    
}
