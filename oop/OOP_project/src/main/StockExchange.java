package main;

import java.util.ArrayList;
import java.util.List;

public class StockExchange{
    private List<Stock> stocks = new ArrayList<>();
    public void addStock(Stock stock){
        stocks.add(stock);
    }
}