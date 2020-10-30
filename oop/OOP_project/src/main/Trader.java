package main;

import java.util.Hashtable;

public class Trader{
    private int costumerID = 0;
    private final String name;
    private double funds;
    private Hashtable<String, Double> holding = new Hashtable<String, Double>();
    private static int counter = 0;
    // Constructor
    public Trader(String[] params){
        // sample params: {"user","Mimi","funds","1000","INFY","10","TCS","5","SBI","20"}
        this.costumerID = counter++;
        // second element in params array is the name
        this.name = params[1];
        // fourth element in params array is the funds
        this.funds = Double.parseDouble(params[3]);
        // rest of the elements are holdings of the person
        // in case of, 'None' holdings params are like: {"user","Jaydeep","funds","15000","holding","None"}
        // add to holdings if they exist
        if ( ! params[5].equals("None")){
            for (int i = 4; i < params.length; i+=2) {
                holding.put(params[i],Double.parseDouble(params[i+1]));
            }
        }
    }
    // getters
    public String getName() {
        return name;
    }
    public Hashtable<String, Double> getHolding() {
        return holding;
    }
}