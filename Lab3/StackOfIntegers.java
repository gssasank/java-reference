package Lab3;

public class StackOfIntegers {
    private int[] stack;
    private int size; 

    public StackOfIntegers(){
        this.stack = new int[16];
        this.size = 0;
    }
    public StackOfIntegers(int capacity){
        this.stack = new int[capacity];
        this.size = 0;
    }

    public boolean empty(){
        return this.size>0 ? false:true;
    }
    public int peek(){
        return this.stack[size-1];
    }
    public void push(int value){
        this.stack[size++] = value;
    }
    public int pop(){
        return stack[--size]; 
    }
    public int getSize(){
        return this.size;
    }
}
