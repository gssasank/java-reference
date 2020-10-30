package main;

import java.util.ArrayList;
import java.util.Comparator;

public class OrderBook {
    private ArrayList<Order> buyOrders = new ArrayList<>();
    private ArrayList<Order> sellOrders = new ArrayList<>();
    // TODO sort orders
    // TODO throw exception on upper circuit and lower circuit

    // add order to order book
    public void addOrder(Order o){
        if (o.getType().equals("buy")){
            buyOrders.add(o);
            // sort buy orders in descending order
            Comparator<Order> sortBuy = new Comparator<>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if (o1.getRate() > o2.getRate())
                        return -1;
                    else if (o1.getRate() < o2.getRate())
                        return 1;
                    return 0;
                }
            };
            buyOrders.sort(sortBuy);
        }
        else{
            sellOrders.add(o);
            // sorting sell orders in ascending order
            Comparator<Order> sortSell = new Comparator<>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if (o1.getRate() > o2.getRate())
                        return 1;
                    else if (o1.getRate() < o2.getRate())
                        return -1;
                    return 0;
                }
            };
            sellOrders.sort(sortSell);
        }
    }
    // search for open orders of a specific person
    public void queryOrders(String userName){
        System.out.println("Buy Orders:");
        for(Order o: buyOrders){
            if(o.getName().equals(userName))
                System.out.println(o);
        }
        System.out.println("Sell Orders:");
        for (Order o: sellOrders){
            if(o.getName().equals(userName))
                System.out.println(o);
        }
    }
    // see order book
    public void showOrderBook() {
        System.out.println("Buy Orders:");
        for(Order o: buyOrders){
            System.out.println(o);
        }
        System.out.println("Sell Orders:");
        for (Order o: sellOrders){
            System.out.println(o);
        }
    }
}
