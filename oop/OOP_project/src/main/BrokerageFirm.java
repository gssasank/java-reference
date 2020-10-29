package main;

import java.util.ArrayList;

public class BrokerageFirm {
    // List of all the costumers in our FIrm
    private ArrayList<Trader> costumer = new ArrayList<>();
    public void addCostumer(Trader user){
        costumer.add(user);
    }
}
