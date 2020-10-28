package main;

public class Stock{
    private String scrip;
    private String sector;
    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double closePrice;

    // Constructor
    public Stock(String scrip, String sector, double openPrice, double highPrice, double lowPrice, double closePrice) {
        this.scrip = scrip;
        this.sector = sector;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
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