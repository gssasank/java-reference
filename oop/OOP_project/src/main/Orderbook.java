package main;

import java.util.ArrayList;

public class Orderbook {
    private ArrayList<Order> buyOrders = new ArrayList<>();
    private ArrayList<Order> sellOrders = new ArrayList<>();
    // TODO sort orders
    // TODO throw exception on upper circuit and lower circuit

    // add order to order book
    public void addOrder(Order o){
        if (o.getType().equals("buy")){
            buyOrders.add(o);
        }
        else{
            sellOrders.add(o);
        }
    }
    // search orders of a specific person TODO (yet to be tested)
    public void queryOrders(String userName){
        System.out.println("Buy Orders:");
        for(Order o: buyOrders){
            if(o.getName().equals(userName))
                System.out.println(o);
        }
        System.out.println("Sell Orders:");
        for (Order o: sellOrders)
            if(o.getName().equals(userName))
                System.out.println(o);
    }
}
