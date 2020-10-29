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
    public void addStock(Stock stock){
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
        // blank string to store results
        StringBuilder s1 = new StringBuilder();
        for(Stock s: stocks){
            String sector = s.getSector();
            if (sector.equals(query)){
                s1.append(s.getScrip()).append(", ");
            }
        }
        System.out.println(query + " Stocks in " + stockExchangeName + ": " + s1.toString());
    }
    // method to delete a stock from the market
    public void stockDeList(String stockName){
        stocks.removeIf(stock -> stock.getScrip().equals(stockName));
    }
}