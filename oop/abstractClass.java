package oop;
/* 
    Abstraction is a process of hiding the implementation details and showing only functionality to the user.
    Abstraction lets you focus on what the object does instead of how it does it.
    Technically abstract means something incomplete or to be completed later.

    * abstract is a non-access modifier in java applicable for classes, methods but not variables.
    * It is used to implement Abstraction.
    * A class which is declared with the 'abstract' keyword is known as an abstract class in Java. 
    * abstract and final or static can never be together.

    Rules for java Abstract classes:
    1) If a class has atleast one abstract method, then the class must be delared abstract.
    2) Abstract classes can have abstract and non-abstract methods (method with the body).
       An abstract method doesn’t have implementation (no method body and ends up with a semi colon).
       It shouldn’t be marked as private.
    3) Abstract classes cannot be instantiated i.e. we can't create the objects of the class.
    4) It can have constructors, static and final 'methods'.
    5) To use an abstract class, you have to inherit it from another class.
    6) If you inherit an abstract class, you have to provide implementations to all the abstract methods in it.
    7) The first concrete sub class of an abstract class must provide implementation to all abstract methods.
       If this doesn't happen, then the sub class also should be marked as abstract.
*/
//-----------------------------------------------------------------------
abstract class DemoAbstract{
    private String var1;
    private int var2;
    // In Java, we can have an abstract class without any abstract method. 
    // This allows us to create classes that cannot be instantiated, but can only be inherited. 
    void m1(){
        System.out.println("Non-Abstract/Concrete Method m1 of an abstract class");
    }

    // constructor
    public DemoAbstract(){
      System.out.println("DemoAbstract Constructor1");
    }
    public DemoAbstract(String var1, int var2){
      System.out.println("DemoAbstract Constructor2");
      this.var1 = var1;
      this.var2 = var2;
    }

    // getters
    public String getVar1() {
      return var1;
    }
    public int getVar2() {
      return var2;
    }

    // setters
    public void setVar1(String var1) {
      this.var1 = var1;
    }
    public void setVar2(int var2) {
      this.var2 = var2;
    }

    // abstract methods
    public abstract void info();
}
//-----------------------------------------------------------------------
class SubAbs extends DemoAbstract{
  private int var3;

  public SubAbs(){
    System.out.println("SubAbs Constructor1");
  }
  public SubAbs(String var1, int var2, int var3){
    super(var1,var2);
    this.var3 = var3;
    System.out.println("SubAbs Constructor2");
  }

  public void setVar3(int var3){
    this.var3 = var3;
  }

  public int getVar3() {
    return var3;
  }

  // if i dont provide the implementation of the abstract methods then the program will throw compilation error
  @Override
  public void info(){
    System.out.println("This is Abstract method definition");
  }
}
//-----------------------------------------------------------------------
public class abstractClass {
    public static void main(String[] args){
        // Cannot instantiate the type demoAbstract
        // DemoAbstract obj1 = new DemoAbstract(); // compile time error
        SubAbs obj1 = new SubAbs();
        obj1.m1();

        SubAbs obj2 = new SubAbs("abc",2,4);
        System.out.println( obj1.getVar1() +" "+ obj1.getVar2() +" "+ obj1.getVar3());
        System.out.println( obj2.getVar1() +" "+ obj2.getVar2() +" "+ obj2.getVar3());
        obj2.info();
    }
}

//-----------------------------OUTPUT------------------------------------
// DemoAbstract Constructor1
// SubAbs Constructor1
// Non-Abstract/Concrete Method m1 of an abstract class
// DemoAbstract Constructor2
// SubAbs Constructor2
// null 0 0
// abc 2 4
// This is Abstract method definition
//-----------------------------------------------------------------------

/* 
Is it possible to create abstract and final class in Java?
  No, When a class is declared final,it cannot be extended or subclassed.
  If any attempt is made to do so will result in compilation error .
  An abstract class can never be instantiated.Its main mission is to be sub-classesd.
  If even a single method is abstract, the whole class must be declared abstract.
  However you can have non-abstract methods in abstract class.
  You cannot create an object out of abstract classes, which will result in compilation error,
  thus its duty of subclass to give definition of superclass's method else subclass would all became abstract,
  not following such result in complication error.
  So now if one declare the class both final and abstract then both will contradict,
  thus one can't declare a class both final and abstract .

Is it possible to have an abstract method in a final class?
  No we cant have a abstract method in final class as final class not be sub classed.

Is it possible to inherit from multiple abstract classes in Java?
  No, Java Doesn't support multiple inheritance,
  but you can achieve this by interface. 
*/