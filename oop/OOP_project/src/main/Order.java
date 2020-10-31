package main;

public class Order {
    private Trader trader;
    private String type;
    private String scrip;
    private StockData stockData;
    private double qty;
    private double rate;
    // constructor
    public Order(String[] params,Trader t,StockData s){
        // sample params: {"user","Jaydeep","type","buy","scrip","INFY","qty","10","rate","790"}
        // Trader is 't'
        this.trader = t;
        // fourth element is type of trade i.e. buy/sell
        this.type = params[3];
        // sixth element is scrip
        this.scrip = params[5];
        // Stock data is in 's'
        this.stockData = s;
        // eighth element is quantity
        this.qty = Double.parseDouble(params[7]);
        // last element is price
        this.rate = Double.parseDouble(params[9]);
    }

    // getters
    public Trader getTrader() {
        return trader;
    }
    public StockData getStockData(){
        return stockData;
    }
    public String getScrip() {
        return scrip;
    }

    public String getType() {
        return type;
    }
    public double getRate() {
        return rate;
    }
    public double getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "User: " + trader.getName() + ", Type: " + type + ", Scrip: " + scrip + ", QTY: " + qty + ", Rate:" + rate;
    }
}
