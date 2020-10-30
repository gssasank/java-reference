package main;

public class Order {
    private String name;
    private String type;
    private String scrip;
    private double qty;
    private double rate;
    // constructor
    public Order(String[] params){
        // sample params: {"user","Jaydeep","type","buy","scrip","INFY","qty","10","rate","790"}
        // second elemet is name
        this.name = params[1];
        // fourth element is type
        this.type = params[3];
        // sixth element is scrip
        this.scrip = params[5];
        // eighth element is quantity
        this.qty = Double.parseDouble(params[7]);
        // last element is price
        this.rate = Double.parseDouble(params[9]);
    }

    // getters
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "User: " + name + ", Type: " + type + ", Scrip: " + scrip + ", QTY: " + qty + ", Rate:" + rate;
    }
}
