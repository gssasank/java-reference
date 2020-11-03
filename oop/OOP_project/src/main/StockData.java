package main;

public class StockData {
    private final String sector;
    private final double openPrice;
    private final double highPrice;
    private final double lowPrice;
    private final double closePrice;
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
        StringBuilder str = new StringBuilder();
        str.append(openPrice).append(",").append(highPrice).append(",").append(lowPrice).append(",").append(closePrice);
        return str.toString();
    }

    @Override
    public String toString(){
        return "Sector: " + sector + ", O: " + openPrice + ", H: " + highPrice + ", L: " + lowPrice + ", C: " + closePrice;
    }
}