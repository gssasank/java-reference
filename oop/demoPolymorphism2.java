package oop;

// Runtime polymorphism by Method overriding
class BaseA{
    void info(){
        System.out.println("In BaseA class");
    }
}

class ChildA extends BaseA{
    void info(){
        System.out.println("In ChildA class");
    }
    void info2(){
        System.out.println("In ChildA info2");
    }
}

class ChildB extends BaseA{
/*  It is a best practice to use @Override annotation because with that can take advantage 
    of the compiler checking to make sure you actually are overriding a method when you think you are. 
    This way, if you make a common mistake of misspelling a method name or not correctly matching the parameters, 
    you will be warned that you method does not actually override as you think it does. 
    Secondly, it makes your code easier to understand because it is more obvious when methods are overwritten. */
    @Override
    void info(){
        System.out.println("In ChildB class");
    }
}
class ChildUnknown extends BaseA{

}

public class demoPolymorphism2 {
    public static void main(String[] args){
        BaseA a1; // reference variable 
        // parent class can hold the reference of its child class but we can only access the overwriden methods of chil through refernce of its parent class
        // https://www.geeksforgeeks.org/parent-and-child-classes-having-same-data-member-in-java/
        a1 = new ChildA();
        a1.info();
        // a1.info2(); // we cant run this as info2 is not overridden
        
        a1 = new ChildB();
        a1.info();

        a1 = new ChildUnknown();
        a1.info();
    }
}
