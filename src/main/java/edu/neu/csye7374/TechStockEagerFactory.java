package edu.neu.csye7374;

public class TechStockEagerFactory implements AbstarctFactory {
    public static final TechStockEagerFactory INSTANCE = new TechStockEagerFactory();
    private TechStockEagerFactory() {}

    public static synchronized TechStockEagerFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public StockAPI getObject() {
        return new TechStock("IBM", 150,"IBM Stock");
    }
}
