package main;

import java.util.Hashtable;

public class StockExchange{
    private final String stockExchangeName;
    // list to store stocks
    Hashtable<String,StockData> stocks = new Hashtable<>();
    // Constructor
    public StockExchange(String stockExchangeName){
        this.stockExchangeName = stockExchangeName;
    }

    // Class Methods
    // add stock in the list of stocks
    public void addStock(String scrip, StockData stockdata){
        stocks.put(scrip,stockdata);
    }
    // method to query the price of a stock
    public void queryPrice(String stockName){
        StockData tmp = stocks.get(stockName);
        if (tmp != null){
            System.out.println("Scrip: " + stockName + ", " + tmp);
        }
    }
    // method to query stock by sector name
    public void querySector(String query){
        // blank string to store results
        StringBuilder s1 = new StringBuilder();
        for(String stockName: stocks.keySet()){
            StockData stock = stocks.get(stockName);
            String sector = stock.getSector();
            if (sector.equals(query)){
                s1.append(stockName).append(", ");
            }
        }
        System.out.println(query + " Stocks in " + stockExchangeName + ": " + s1.toString());
    }
    // method to delete a stock from the market
    public void stockDeList(String stockName){
        stocks.remove(stockName);
    }
}