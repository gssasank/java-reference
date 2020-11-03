package main;

import java.util.Hashtable;

public class StockExchange{
    private final String stockExchangeName;
    // Hash-table to store stocks
    Hashtable<String,StockData> stocks = new Hashtable<>();
    // Constructor
    public StockExchange(String stockExchangeName){
        this.stockExchangeName = stockExchangeName;
    }

    // Class Methods
    // add stock in the list of stocks
    public void addStock(String[] params){
        // sample params: {"scrip","M&M","sector","auto","O","610","H","610","L","610","C","610"}
        // params[1] is the name of the stock
        System.out.println("Added Scrip: " + params[1] + " with a new instantiation of StockData class");
        stocks.put(params[1],new StockData(params));
    }
    // query the price of a stock
    public void queryPrice(String stockName){
        StockData tmp = stocks.get(stockName);
        if (tmp != null){
            System.out.println("Scrip: " + stockName + ", " + tmp);
        }
    }
    // query stock by sector name
    public void querySector(String query){
        // blank string to store results
        StringBuilder s1 = new StringBuilder();
        for(String stockName: stocks.keySet()){
            StockData stock = stocks.get(stockName);
            String sector = stock.getSector();
            if (sector.equals(query)){
                s1.append(stockName).append(" - OHLC <").append(stock.getOHLC()).append(">").append(", ");
            }
        }
        System.out.println(query + " Stocks in " + stockExchangeName + ": " + s1.toString());
    }
    // delete a stock from the market
    public void stockDeList(String stockName){
        stocks.remove(stockName);
    }
    // method to return the reference of stock by its ticket
    public StockData getStock(String scrip){
        return stocks.get(scrip);
    }
    // list all stocks
    public void showScrips(){
        for (String stockName: stocks.keySet()){
            System.out.println("Scrip: " + stockName + ", " + stocks.get(stockName));
        }
    }
}