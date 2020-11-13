package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class OrderBook {
    private ArrayList<Order> buyOrders = new ArrayList<>();
    private ArrayList<Order> sellOrders = new ArrayList<>();
    private ArrayList<Order> shortSellOrders = new ArrayList<>();

    // add order to order book
    public void addOrder(Order o) throws InValidInputException {
        // check upper circuit and lower circuit
        if (o.getRate() < o.getStockData().getLowerCircuit() || o.getRate() > o.getStockData().getUpperCircuit())
            throw new InValidInputException(o);
        else {
            if (o.getType().equals("buy")){
                // check funds of the trader before buying
                // funds must be more than the amount of order
                if (o.getTrader().getFunds() < o.getRate() * o.getQty()){
                    System.out.println("Order rejected for " + o + ", reason: Insufficient funds. Order amount:" + o.getRate()*o.getQty() + " Funds:" + o.getTrader().getFunds());
                    return;
                }
                System.out.println("Order placed for " + o);
                buyOrders.add(o);
                // sort buy orders in descending order of bid price
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
                // check for holdings before selling
                // if holdings are not present or less than the ordered quantity, then it's the case of short selling
                if (o.getTrader().getHolding().get(o.getScrip()) == null || o.getTrader().getHolding().get(o.getScrip()) < o.getQty()){
                    shortSellOrders.add(o);
                }
                System.out.println("Order placed for " + o);
                sellOrders.add(o);
                // sorting sell orders in ascending order of ask price
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
    }
    // search for open orders of a specific person
    public void queryOrders(String userName){
        System.out.println("-: Buy Orders :-");
        for(Order o: buyOrders){
            if(o.getTrader().getName().equals(userName))
                System.out.println(o);
        }
        System.out.println("-: Sell Orders :-");
        for (Order o: sellOrders){
            if(o.getTrader().getName().equals(userName))
                System.out.println(o);
        }
    }
    // see order book
    public void showOrderBook() {
        System.out.println("-: Buy Orders :-");
        for(Order o: buyOrders){
            System.out.println(o);
        }
        System.out.println("-: Sell Orders :-");
        for (Order o: sellOrders){
            System.out.println(o);
        }
    }
    // check for pending short sell orders
    public void checkShortSell(){
        for(Order o: shortSellOrders){
            if(o.getTrader().getHolding().get(o.getScrip())!= null && o.getTrader().getHolding().get(o.getScrip()) < 0){
                System.out.println("Pending Short sell order User:" + o.getTrader().getName() + " Scrip:" + o.getScrip());
            }
        }
    }
    // Execute orders
    public void executeOrders(){
        // iterating buyOrders
        // creating an iterator for array list, as we cant update array-list while iterating using forEach loop
        Iterator<Order> it1 = buyOrders.iterator();
        while (it1.hasNext()){
            Order o1 = it1.next();
            // iterating sell Orders
            Iterator<Order> it2 = sellOrders.iterator();
            while(it2.hasNext()){
                Order o2 = it2.next();
                // checking if scrip is equal
                if (o1.getScrip().equals(o2.getScrip())){
                    // ask price must be lower or equal to the bid price
                    if (o2.getRate() <= o1.getRate()){
                        // funds must be sufficient for buy order
                        if (o1.getTrader().getFunds() > o1.getQty()* o1.getRate()){
                            // if none holdings(short selling) then add zero holding for that stock
                            o2.getTrader().getHolding().putIfAbsent(o2.getScrip(), 0.0);
                            // if ask quantity is equal to buy quantity
                            if (o1.getQty() == o2.getQty()){
                                // remove stocks from seller's holdings
                                o2.getTrader().updateHoldings(o2.getScrip(),-1*o2.getQty());
                                // add stock to buyer's holdings
                                o1.getTrader().updateHoldings(o1.getScrip(),o1.getQty());
                                // deduct funds from buyer's account
                                o1.getTrader().updateFunds(-1.0*(o1.getQty() * o2.getRate()));
                                // add funds to the seller's account
                                o2.getTrader().updateFunds(o1.getQty() * o2.getRate());
                                System.out.println("Executed Transaction: " + o1.getQty() + " qty of scrip:" + o1.getScrip() + " @ " + o2.getRate() + " per share" + " sold for INR " + o1.getQty() * o2.getRate() +"; Buyer: " + o1.getTrader().getName() + ", Seller: " + o2.getTrader().getName());
                                // update OHLC
                                o1.getStockData().updateOHLC(o1.getRate());
                                // remove order from the list
                                it1.remove();
                                it2.remove();
                            }
                            // if buy quantity is less than sell quantity
                            else if (o1.getQty() < o2.getQty()){
                                // decrease stocks from seller's holdings (-ve)
                                o2.getTrader().updateHoldings(o2.getScrip(),-1*o1.getQty());
                                // add stock to buyer's holdings
                                o1.getTrader().updateHoldings(o1.getScrip(), o1.getQty());
                                // deduct funds from buyer's account
                                o1.getTrader().updateFunds(-1.0*(o1.getQty() * o2.getRate()));
                                // add funds to the seller's account
                                o2.getTrader().updateFunds(o1.getQty() * o2.getRate());
                                // update sell order
                                o2.setQty(o2.getQty() - o1.getQty());
                                System.out.println("Executed Transaction: " + o1.getQty() + " qty of scrip:" + o1.getScrip() + " @ " + o2.getRate() + " per share" + " sold for INR " + o1.getQty() * o2.getRate() +"; Buyer: " + o1.getTrader().getName() + ", Seller: " + o2.getTrader().getName());
                                // update OHLC
                                o1.getStockData().updateOHLC(o1.getRate());
                                // remove buy order from list as it's completed
                                it1.remove();
                            }
                            // if sell quantity is less than buy quantity
                            else if (o2.getQty() < o1.getQty()){
                                // decrease stocks from seller's holdings (-ve)
                                o2.getTrader().updateHoldings(o2.getScrip(),-1*o2.getQty());
                                // add stock to buyer's holdings
                                o1.getTrader().updateHoldings(o1.getScrip(), o2.getQty());
                                // deduct funds from buyer's account
                                o1.getTrader().updateFunds(-1.0*(o2.getQty() * o2.getRate()));
                                // add funds to the seller's account
                                o2.getTrader().updateFunds(o2.getQty() * o2.getRate());
                                // update buy order
                                o1.setQty(o1.getQty() - o2.getQty());
                                System.out.println("Executed Transaction: " + o2.getQty() + " qty of scrip:" + o1.getScrip() + " @ " + o2.getRate() + " per share" + " sold for INR " + o2.getQty() * o2.getRate() +"; Buyer: " + o1.getTrader().getName() + ", Seller: " + o2.getTrader().getName());
                                // update OHLC
                                o2.getStockData().updateOHLC(o2.getRate());
                                // remove sell order from list as it's completed
                                it2.remove();
                            }
                        }
                        else{
                            System.out.println("Failed Transaction: " + o1 + ", reason: In-sufficient Funds");
                        }
                    }
                }
            }
        }
    }
}
