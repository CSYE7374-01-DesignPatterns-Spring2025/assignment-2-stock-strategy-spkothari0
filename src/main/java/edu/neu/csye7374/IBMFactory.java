package edu.neu.csye7374;

public class IBMFactory implements AbstarctFactory {
    @Override
    public StockAPI getObject() {
        return new IBM();
    }
}
