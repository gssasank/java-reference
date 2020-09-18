package oop;

// Multilevel inheritance
class Products{
    private String name;
    private double price;

    void setName(String name){
        this.name = name;
    }
    void setPrice(double price){
        this.price = price;
    }

    String getName() {
        return name;
    }
    double getPrice(){
        return price;
    }
}

class Laptops extends Products{
    private String brand;

    void setBrand(String brand){
        this.brand = brand;
    }
    String getBrand(){
        return brand;
    }
}

class GamingLaptop extends Laptops{
    private String processor;

    void setProcessor(String processor){
        this.processor = processor;
    }
    String getProcessor(){
        return processor;
    }
}
public class demoInheritance2 {
    public static void main(String[] args){
        GamingLaptop l1 = new GamingLaptop();
        l1.setName("Legion Y540");
        l1.setPrice(70000);
        l1.setBrand("Lenovo");
        l1.setProcessor("i5 9th gen");

        System.out.println(l1.getBrand());
        System.out.println(l1.getName());
        System.out.println(l1.getPrice());
        System.out.println(l1.getProcessor());
    }
}
