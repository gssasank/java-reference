package main;

import java.util.ArrayList;

public class BrokerageFirm {
    // List of all the costumers in our FIrm
    private ArrayList<Trader> costumer = new ArrayList<>();
    // method to add client to the firm
    public void addClient(Trader user){
        costumer.add(user);
    }
    // method to delete client from the firm
    public void deleteClient(String name){
        costumer.removeIf(user -> user.getName().equals(name));
    }
}
