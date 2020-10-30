package main;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class StockExchange{
    private final String stockExchangeName;
    // list to store stocks
//    private List<StockData> stockData = new ArrayList<>();
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
//    // get details of all the stocks in a specific Stock Exchange
//    public void getDetails(){
//        System.out.print("Stock Exchange: " + stockExchangeName + ", Stock: ");
//        for (StockData s: stockData){
//            System.out.println(s.getScrip()+", "+s.getSector());
//        }
//    }
//    // method to query the price of a stock
//    public void queryPrice(String stockName){
//        for(StockData s: stockData){
//            if (s.getScrip().equals(stockName)){
//                System.out.println(s);
//            }
//        }
//    }
//    // method to query stock by sector name
//    public void querySector(String query){
//        // blank string to store results
//        StringBuilder s1 = new StringBuilder();
//        for(StockData s: stockData){
//            String sector = s.getSector();
//            if (sector.equals(query)){
//                s1.append(s.getScrip()).append(", ");
//            }
//        }
//        System.out.println(query + " Stocks in " + stockExchangeName + ": " + s1.toString());
//    }
//    // method to delete a stock from the market
//    public void stockDeList(String stockName){
//        stockData.removeIf(stockData -> stockData.getScrip().equals(stockName));
//    }
}