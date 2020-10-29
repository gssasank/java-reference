package main;

import java.util.ArrayList;
import java.util.List;

public class StockExchange{
    private final String stockExchangeName;
    // list to store stocks
    private List<Stock> stocks = new ArrayList<>();

    // Constructor
    public StockExchange(String stockExchangeName){
        this.stockExchangeName = stockExchangeName;
    }

    // Class Methods
    // add stock in the list of stocks
    public void setStock(Stock stock){
        this.stocks.add(stock);
    }
    // get details of all the stocks in a specific Stock Exchange
    public void getDetails(){
        System.out.print("Stock Exchange: " + stockExchangeName + ", Stock: ");
        for (Stock s: stocks){
            System.out.println(s.getScrip()+", "+s.getSector());
        }
    }
    // method to query stock by sector name
    public void querySector(String query){
        System.out.print("\n" + query + " Stocks in " + stockExchangeName + ": ");
        for(Stock s: stocks){
            String sector = s.getSector();
            if (sector.equals(query)){
                System.out.print(s.getScrip()+", ");
            }
        }
    }
}