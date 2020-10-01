package oop;

/*
    * Static keyword:
      If a field is declared static, there exists exactly one incarnation of the field, 
      no matter how many instances (possibly zero) of the class may eventually be created. 
      When a member is declared static, it can be accessed before any objects of its class are created, and without reference to any object
      A static field, sometimes called a class variable, is incarnated when the class is initialized.
        (1) Mainly used for memory management.
        (2) It can be used with variables, methods, blocks and 'nested classes'.
            Top level class cannot be static. We can create static variables at class level only.
            static block and static variables are executed in order they are present in a program.
            Static methods can only directly call other static methods and can only directly access static data.
            Static methods cannot refer to 'this' or 'super' in any way.
        (3) It is a keyword which is used to share the same variable or method of a given class.
        (4) We can create static variables at class-level only

    * Advantages
        (1) Allocate memory only once in a class area at the time of class loading
        (2) Make our program memory efficient 
        
        more info: https://www.geeksforgeeks.org/static-keyword-java/
*/

public class staticKeyword{
    public static void main(String[] args){
        // calling info() without creating any objectof class DemoStaticKeywordClass
        DemoStaticKeywordClass.info();

        // accessing of class DemoStaticKeywordClass directly
        System.out.println(DemoStaticKeywordClass.a);

        // A static nested class may be instantiated without instantiating its outer class.
        DemoStaticKeywordClass.NestedStaticClass obj1 = new DemoStaticKeywordClass.NestedStaticClass();
        obj1.m3();

        // In order to create instance of inner class we need an Outer class instance. 
        // Let us create Outer class instance for creating non-static nested class.
        // DemoStaticKeywordClass.NestedNonStaticClass obj2 = new DemoStaticKeywordClass.NestedNonStaticClass();
        // compliation error: an enclosing instance that contains DemoStaticKeywordClass.NestedNonStaticClass is required
        DemoStaticKeywordClass obj2 = new DemoStaticKeywordClass();
        DemoStaticKeywordClass.NestedNonStaticClass objInner = obj2.new NestedNonStaticClass();
        objInner.m4();
    }
}


class DemoStaticKeywordClass{
    int b=80;

    // static variable
    static int a=20;
    // initialization of static variable
    // to initialize a static variable we use static blocks
    static{
        System.out.println("Static block initialized");
        a=10;
    }

    // static method
    static void info(){
        // Cannot make a static reference to the non-static field b 
        //b = 90; // compilation error 
        // Cannot make a static reference to the non-static method m2() from the type DemoStaticKeywordClass
        // m2(); // compilation error
        System.out.println("I am in static method of demoStaticKeywordClass");
    }

    // non-static method
    void m2(){
        System.out.println("I am in non static method");
    }
    static{
        System.out.println("Second Static block initialized");
        a=30;
    }

    // static nested class
    public static class NestedStaticClass{
        // Only static members of Outer class are directly accessible in nested static class 
        void m3(){
            System.out.println(a); // can access 'a' as 'a' is a static

            // Cannot make a static reference to the non-static field b
            // System.out.println(b); // complilation error
        }
    }

    // Non-static nested inner class
    public class NestedNonStaticClass{
        // Both static and non-static members of Outer class are accessible in  this Inner class 
        
        // An instance of an inner class cannot be created without an instance of the outer class. 
        // Therefore, an inner class instance can access all of the members of its outer class, 
        // without using a reference to the outer class instance. 
        // For this reason inner classes can help make programs simple and concise.
        void m4(){
            System.out.println(a);
            System.out.println(b);
        }
    }
}