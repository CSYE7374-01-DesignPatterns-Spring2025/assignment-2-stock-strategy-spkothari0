package edu.neu.csye7374;

public class TechStockFactory  implements AbstarctFactory {
    @Override
    public StockAPI getObject() {
    	
        return new TechStock("IBM",150,"IBM Security");
    }


}
