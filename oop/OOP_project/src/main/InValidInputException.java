package main;

public class InValidInputException extends Exception{
    public InValidInputException(Order o){
        if (o.getRate() < o.getStockData().getLowerCircuit())
            System.out.println("Order rejected for " + o + ", reason: lower circuit violation(" + o.getStockData().getLowerCircuit() +")");
        else if(o.getRate() > o.getStockData().getUpperCircuit())
            System.out.println("Order rejected for " + o + ", reason: upper circuit violation(" + o.getStockData().getUpperCircuit() +")");
    }

    @Override
    public String getMessage() {
        return " Order Failed!!";
    }
}
