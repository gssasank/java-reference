package main;

import java.util.Hashtable;

public class Trader{
    private int costumerID;
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
    public double getFunds() {
        return funds;
    }
    public Hashtable<String, Double> getHolding() {
        return holding;
    }

    // Method to update holdings
    public void updateHoldings(String stockName, Double qty){
        Double prevQty = holding.get(stockName);
        if (qty > 0 && prevQty == null){
            // in case of increase in holdings it may be possible that the person is buying stock for the first time
            prevQty = 0.0;
        }
        double newQty = prevQty + qty;
        // if there are no holdings
        if (newQty == 0.0){
            holding.remove(stockName);
        }
        else{
            holding.put(stockName, newQty);
        }
    }
    // method to update funds
    public void updateFunds(Double amount){
        funds += amount;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("User: ").append(name).append(", funds: ").append(funds).append(", holding: {");
        for (String stockName: holding.keySet()){
            str.append(stockName).append(":").append(holding.get(stockName)).append(", ");
        }
        str.append("}");
        return str.toString();
    }
}