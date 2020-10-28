package main;

public class Stock{
    private final String scrip;
    private final String sector;
    private final double openPrice;
    private final double highPrice;
    private final double lowPrice;
    private final double closePrice;

    // Constructor
    public Stock(String[] params){
        // first element in params array is ticket name
        this.scrip = params[0];
        // second element is the sector of the stock
        this.sector = params[1];
        // third element is the open price of the stock
        this.openPrice = Double.parseDouble(params[2]);
        // fourth element is the high price
        this.highPrice = Double.parseDouble(params[3]);
        // fifth element is the low price
        this.lowPrice = Double.parseDouble(params[4]);
        // last element is the close price 
        this.closePrice = Double.parseDouble(params[5]);
//        System.out.println("Created Stock: "+scrip);
    }

    // Getters
    public String getScrip() {
        return scrip;
    }
    public String getSector() {
        return sector;
    }
    public double getOpenPrice() {
        return openPrice;
    }
    public double getHighPrice() {
        return highPrice;
    }
    public double getLowPrice() {
        return lowPrice;
    }
    public double getClosePrice() {
        return closePrice;
    }

    @Override
    public String toString(){
        return "Scrip: " + scrip + ", Sector: " + sector + ", OpenPrice: " + openPrice + ", HighPrice: " + highPrice + ", LowPrice: " + lowPrice + ", ClosePrice: " + closePrice;
    }
}