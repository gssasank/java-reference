package oop;
import java.util.ArrayList;
import java.util.Collections;
/* 
    Java Comparable interface is used to order the objects of the user-defined class.
    This interface is found in java.lang package and contains only one method named compareTo(Object).
    It provides a single sorting sequence only, i.e., you can sort the elements on the basis of
    single data member only.

    Comparable Interface looks like this, where T is name of the Class and 'o' is other object of same class
    public interface Comparable<T> 
    {
        public int compareTo(T o);
    }
    As Comparable is an interface then we need to implement the method compareTo(T o) in our class.
    compareTo method returns-
        +ve int if current object is greater than other object
        -ve int if current object is smaller than other object
        0 if both are equal

    we can sort elements of
        String objects
        Wrapper class objects
        User-defined class objects
 */

class Dept implements Comparable<Dept>{
    private String name;
    private int year;
    public Dept(String name, int year){
        this.name = name;
        this.year = year;
    }
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }

    @Override
    public String toString(){
        return "Department Name = " + name + ", Year = "+year;
    }
    @Override
    public int compareTo(Dept other){
        if (year > other.getYear())
            return 1;
        else if (year < other.getYear())
            return -1;
        return 0;
    // we can also reduce these statements to
    // return this.year - other.getYear();
    // but for explanation I've used the extended form
    }
}
public class comparableInterface {
    public static void main(String[] args){
        Dept cse = new Dept("CSE",2017);
        Dept ece = new Dept("ECE",2019);
        System.out.println(cse.compareTo(ece));
        System.out.println(ece.compareTo(cse));
        System.out.println(ece.compareTo(ece));

        // We can also use a list to store elements and then sort them using Collections class
        ArrayList<Dept> list = new ArrayList<>();
        list.add(new Dept("EEE",2018));
        list.add(new Dept("ECE",2019));
        list.add(new Dept("CSE",2017));
        list.add(new Dept("BMS",2020));
        list.add(new Dept("MEC",2016));

        System.out.println("before sorting");
        for(Dept x : list){
            System.out.println(x);
        }
        // sorting using Collections.sort() - used to sort a list of objects.
        // to Collection.sort() it is important to have a sorting logic
        // in this case the sorting logic is provided by compareTo() method
        // we can also interchange 1 and -1 in compareTo(), to sort in reverse order
        Collections.sort(list);

        System.out.println("After sorting");
        for(Dept x : list){
            System.out.println(x);
        }
    }
}
