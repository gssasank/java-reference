package main;

public class InValidInputException extends Exception{
    public InValidInputException(Order o){
        if (o.getRate() < o.getStockData().getLowerCircuit())
            System.out.print("Order Price: " + o.getRate() + " is below Lower Circuit price: " + o.getStockData().getLowerCircuit());
        else if(o.getRate() > o.getStockData().getUpperCircuit())
            System.out.print("Order Price: " + o.getRate() + " is above Upper Circuit price: " + o.getStockData().getUpperCircuit());
    }

    @Override
    public String getMessage() {
        return " Order Failed!!";
    }
}
