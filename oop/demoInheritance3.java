package oop;

// Hierarchical Inheritance
class Person{
    private String name;
    private int age;

    void setName(String name){
        this.name = name;
    }
    void setAge(int age){
        this.age = age;
    }
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }
}

class Student extends Person{
    private double cgpa;
    void setCgpa(double cgpa){
        this.cgpa = cgpa;
    }
    double getCgpa(){
        return cgpa;
    }
}

class Teacher extends Person{
    private double salary;
    void setSalary(double salary){
        this.salary = salary;
    }
    double getSalary(){
        return salary;
    }
}

public class demoInheritance3 {
    public static void main(String[] args){
        Student s1 = new Student();
        s1.setName("Aman Yadav");
        s1.setAge(20);
        s1.setCgpa(9.8);

        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        System.out.println(s1.getCgpa());

        Teacher t1 = new Teacher();
        t1.setName("Some name");
        t1.setAge(50);
        t1.setSalary(50000.00);

        System.out.println(t1.getName());
        System.out.println(t1.getAge());
        System.out.println(t1.getSalary());
    }
    
}
