package main;

public class StockData {
    private final String sector;
    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double closePrice;
    private double firstTransaction;
    private double lowestTransaction;
    private double highestTransaction;
    private final double upperCircuit;
    private final double lowerCircuit;

    // Constructor
    public StockData(String[] params){
        // sample params: {"scrip","M&M","sector","auto","O","610","H","610","L","610","C","610"}

        // fourth element is the sector of the stock
        this.sector = params[3];
        // sixth element is the open price of the stock
        this.openPrice = Double.parseDouble(params[5]);
        // eighth element is the high price
        this.highPrice = Double.parseDouble(params[7]);
        // tenth element is the low price
        this.lowPrice = Double.parseDouble(params[9]);
        // last element is the close price 
        this.closePrice = Double.parseDouble(params[11]);
        // calculating upper circuit
        this.upperCircuit = this.closePrice + (this.closePrice/10.0);
        this.lowerCircuit = this.closePrice - (this.closePrice/10.0);
        // setting firstTransaction price to some arbitrary value to easily track the changes
        this.firstTransaction = Double.MIN_VALUE;
        // similarly for lowest and highest prices
        this.highestTransaction = Double.MIN_VALUE;
        this.lowestTransaction = Double.MAX_VALUE;
    }

    // Getters
    public String getSector() {
        return sector;
    }
    public double getUpperCircuit() {
        return upperCircuit;
    }
    public double getLowerCircuit() {
        return lowerCircuit;
    }
    public String getOHLC(){
        return openPrice + "," + highPrice + "," + lowPrice + "," + closePrice;
    }

    // update OHLC
    public void updateOHLC(double rate){
        // update O
        if ( firstTransaction == Double.MIN_VALUE){
            // update first transaction (to prevent future changes)
            firstTransaction = rate;
            // update open price
            openPrice = firstTransaction;
        }
        // update H
        if( rate > highestTransaction ){
            highestTransaction = rate;
            highPrice = highestTransaction;
        }
        // update L
        if ( rate < lowestTransaction) {
            lowestTransaction = rate;
            lowPrice = lowestTransaction;
        }
    }

    @Override
    public String toString(){
        return "Sector: " + sector + ", O: " + openPrice + ", H: " + highPrice + ", L: " + lowPrice + ", C: " + closePrice;
    }
}