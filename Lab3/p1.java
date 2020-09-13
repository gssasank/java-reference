package Lab3;
public class p1 {
    public static void main(String[] args)
    {
        StackOfIntegers s1 = new StackOfIntegers();
        StackOfIntegers s2 = new StackOfIntegers(6);
        
        s1.push(5);
        s1.push(1);
        s1.push(8);

        System.out.println("Is s1 empty? "+s1.empty()+" | Is s2 empty? "+s2.empty());

        s2.push(6);
        s2.push(9);

        System.out.println("Size of s1: "+s1.getSize()+" | Size of s2: "+s2.getSize());
        System.out.println("Peek s1: "+s1.peek()+" | Peek s2: "+s2.peek());
        System.out.println("Pop s1: "+s1.pop()+" | Pop s2: "+s2.pop());

        s1.push(7);
        s2.push(7);
    }
}