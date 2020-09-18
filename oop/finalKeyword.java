package oop;
//Java program to demonstrate different 
// ways of initializing a final variable 

/* 
    'final' is a non-access modifier applicable only to a variable, a method or a class
    Uses:
    final variable -> to create constant variables
    final Methods -> prevent method overloading
    final classes -> prevent inheritance
*/

public class finalKeyword { 
    // there are 3 methods to initialize a final keyword

	// a final variable 
	// Method 1 - direct initialize 
	final int THRESHOLD = 5; 
	
	// a blank final variable 
	final int CAPACITY; 
	
	// another blank final variable 
	final int MINIMUM; 
	
	// a final static variable PI 
	// direct initialize 
	static final double PI = 3.141592653589793; 
	
	// a blank final static variable 
	static final double EULERCONSTANT; 
	
	// Method 2 - instance initializer block for 
	// initializing CAPACITY 
	{ 
		CAPACITY = 25; 
	} 
	
	//  Method 2 (for static) - static initializer block for 
	// initializing EULERCONSTANT 
	static{ 
		EULERCONSTANT = 2.3; 
	} 
	
	// Method 3 - constructor for initializing MINIMUM 
	// Note that if there are more than one 
	// constructor, you must initialize MINIMUM 
	// in them also 
	public finalKeyword() 
	{ 
		MINIMUM = -1; 
	} 
		
} 
