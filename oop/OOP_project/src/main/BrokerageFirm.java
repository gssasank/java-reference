package main;

import java.util.ArrayList;

public class BrokerageFirm {
    // List of all the costumers in our firm
    private ArrayList<Trader> costumer = new ArrayList<>();
    // method to add client to the firm
    public void addClient(Trader user){
        System.out.println("Added user: " + user.getName() + " with a new instantiation of class Trader");
        costumer.add(user);
    }
    // method to delete client from the firm
    public void deleteClient(String name){
        costumer.removeIf(user -> user.getName().equals(name));
    }
    // delete stock for users if a stock is de-listed
    public void deleteUserStock(String stockName){
        for(Trader t: costumer){
            t.getHolding().remove(stockName);
        }
    }
    // get the reference of user by his/her name - assuming that name does not repeat
    public Trader getUser(String name){
        for(Trader t: costumer){
            if(t.getName().equals(name))
                return t;
        }
        return null;
    }
}