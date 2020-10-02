package oop;

/* 
    An interface is a reference type in java. we can call it a blue print of a class.
    It is similar to a class, no constructors are allowed here and is 100% abstract.

    * To declare an interface, 'interface' keyword is used.
    * To implement interface use 'implements' keyword
    * If a class implements an interface and does not provide 
      method bodies for all functions specified in the interface,
      then the class must be declared abstract. 
    * interface variables are public, final and static by default, because interfaces can't be instantiated
      and final ensures that the value in an interface is true constant and cannot be re-assigned
    * interface methods are public and abstract by default, so we don't need to specify that inside an interface
    * So when a class implements an interface’s method without specifying the access level of that method,
      the compiler will throw an error stating “Cannot reduce the visibility of the inherited method from interface”.
      So that implemented method’s access level must be set to public.
    * An interface and a class both can extend multiple interfaces. Interface can extend another interface only

	* although we can't define implementation from java 8 we can add default and static implementation 
	  for interface methods, for more details- https://www.geeksforgeeks.org/interfaces-in-java/

    Why do we use abstraction?
        * To achieve total abstraction
        * using interfaces we can achieve multiple inheritance
		* we can also achieve loose coupling
		* To force sub classes to implement abstract methods.
    	* To stop having actual objects of that class.
    	* To keep having a class reference.
 */
//-----------------------------------------------------------------------

interface Player{
    // this variable is public static final
    int playerHealth = 100;

    void move();
    void turnLeft();
    void turnRight();
}

class RedPlayer implements Player{
    @Override
    // try removing 'public' here, you will error stated in line 16
    public void move(){
        System.out.println("RedPlayer Moving");
    }
    @Override
    public void turnLeft(){
        System.out.println("RedPlayer Turning Left");
    }
    @Override
    public void turnRight(){
        System.out.println("RedPlayer Turning Right");
    }
}

// extending interfaces
interface SideKick extends Player{
	// try commenting this int variable as it's already present in Player interface
	// doubt how are we able to do this?
	// ans - https://www.geeksforgeeks.org/inheritance-of-interface-in-java-with-examples/
	int playerHealth = 300;

	void specialAbility();
}

class PlayerSidekick implements SideKick{
    // try this
	// int playerHealth = 200; 
	@Override
	public void move(){
        System.out.println("Sidekick Moving");
    }
    @Override
    public void turnLeft(){
        System.out.println("Sidekick Turning Left");
    }
    @Override
    public void turnRight(){
        System.out.println("Sidekick Turning Right");
	}
	@Override
	public void specialAbility(){
		System.out.println("Sidekick can Heal");
	}
}

interface Villain{
	int skills = 5;
	void powers();
}

interface Stage{
  void environment();
  void difficulty();
}

// class extending multiple interfaces
class Game implements Villain, Stage{
	@Override
	public void powers(){
		System.out.println("Villain can fly");
	}
	
	@Override
	public void difficulty(){
		System.out.println("Difficulty is medium");
	}

	@Override
	public void environment(){
		System.out.println("Environment is Urban");
	}
}
//-----------------------------------------------------------------------

public class demoInterface {
    public static void main(String[] args){
        RedPlayer rp1 = new RedPlayer();
        rp1.move();
        rp1.turnLeft();
        rp1.turnRight();
		System.out.println("Red player health = " + RedPlayer.playerHealth);

		PlayerSidekick ps1 = new PlayerSidekick();
		ps1.move();
		ps1.turnLeft();
		ps1.turnRight();
		ps1.specialAbility();
		System.out.println("Side kick Health = " + PlayerSidekick.playerHealth);

		
		Game g1 = new Game();
		g1.difficulty();
		g1.environment();
		g1.powers();
		System.out.println("Computer player skills level = " + Game.skills);
    }
}

//----------------------------------OUTPUT-------------------------------
// RedPlayer Moving
// RedPlayer Turning Left
// RedPlayer Turning Right
// Red player health = 100

// Sidekick Moving
// Sidekick Turning Left
// Sidekick Turning Right
// Sidekick can Heal
// Side kick Health = 300

// Difficulty is medium
// Environment is Urban
// Villain can fly
// Computer player skills level = 5
//-----------------------------------------------------------------------

