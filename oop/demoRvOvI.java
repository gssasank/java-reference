package oop;

public class demoRvOvI{
    public static void main(String[] args){
        // we will be using demoConstructor class in this program.
        // we can access the methods of demoConstructor directly as the class is public,
        // also this class and demoConstructor class is in same package i.e oop
        
        /*
        A blueprint for a house design is like a class description. 
        All the houses built from that blueprint are objects of that class. 
        A given house is an instance of that class. 
        A reference is a pointer to a specific instance 
        */


        /* 
        * Creating reference of demoConstructor
        * The reference variables contains the address of the memory location in the heap
        * In this case s1 is not pointing to any memory location as we have not created 
          an object of class demoConstructor i.e. no memory is assigned to s1
        */
        demoConstructor s1; 

        // * to create an object we use 'new' operator
        //  'new' is used to create a new instance or a copy of the book demoConstructor
        // * here s2 is an instance of object demoConstructor
        // * Here 'new demoConstructor()' is assigning variables of demoConstructor in the memory 
        //   and will return the address of that chunk of memory.
        // * The address returned by by new operator will be stored in s2 
        demoConstructor s2 = new demoConstructor();  
        System.out.println(s2.getName());
    }
}