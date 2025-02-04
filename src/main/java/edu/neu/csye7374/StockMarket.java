package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket stockMarketInstance;

    private List<StockAPI> stocks = new ArrayList<>();


    private StockMarket(){

    }

    public void add(StockAPI stock) {stocks.add(stock);}

    public void remove(StockAPI stk) {
        boolean isRemoved = this.stocks.remove(stk);

        if(!isRemoved) {
            System.out.println("stock was not found to be traded");
        }
    }
    public static StockMarket getInstance(){
        if(stockMarketInstance == null){
            stockMarketInstance = new StockMarket();
        }
        return stockMarketInstance;
    }

    public void tradeStock(StockAPI stock, String bid) {
        stock.setBid(bid);
//        System.out.println("Traded: " + stock);
    }

    public static void demo(){
    	System.out.println("Demo method");

        StockMarket stockMarket = getInstance();

        // Pricing Strategies
        PricingStrategy bullStrategy = new BullMarketStrategy();
        PricingStrategy bearStrategy = new BearMarketStrategy();

        // IBM Lazy Singleton Factory with Bull Strategy
        IBMLazySingletonFactory ibmLazySingletonFactory = IBMLazySingletonFactory.getInstance();
        StockAPI ibmLazy = ibmLazySingletonFactory.getObject();
        ibmLazy.setPricingStrategy(bullStrategy); // Apply Bull strategy

        System.out.println("IBM Lazy with Bull Strategy");
        for(int i = 0; i < 6; i++){
            ibmLazy.applyPricingStrategy();
            System.out.println(ibmLazy);
        }
        System.out.println(ibmLazy.getMetric());
        System.out.println();

        // Tech Stock Eager Factory with Bear Strategy
        TechStockEagerFactory techStockEagerFactory = TechStockEagerFactory.getInstance();
        StockAPI techStockEager = techStockEagerFactory.getObject();
        techStockEager.setDescription("TechStock Eager");
        techStockEager.setPricingStrategy(bearStrategy); // Apply Bear strategy

        System.out.println("Tech Stock Eager with Bear Strategy");
        for (int i = 0; i < 6; i++) {
            techStockEager.applyPricingStrategy();
            System.out.println(techStockEager);
        }
        System.out.println(techStockEager.getMetric());
        System.out.println();

        // IBM Factory with Bull Strategy
        IBMFactory ibmFactory = new IBMFactory();
        StockAPI ibm = ibmFactory.getObject();
        ibm.setPricingStrategy(bullStrategy);

        System.out.println("IBM Factory with Bull Strategy");
        for (int i = 0; i < 6; i++) {
            ibm.applyPricingStrategy();
            System.out.println(ibm);
        }
        System.out.println(ibm.getMetric());
        System.out.println();

        // Tech Stock Factory with Bear Strategy
        TechStockFactory techStockFactory = new TechStockFactory();
        StockAPI techStock = techStockFactory.getObject();
        techStock.setPricingStrategy(bearStrategy);

        System.out.println("Tech Stock Factory with Bear Strategy");
        for (int i = 0; i < 6; i++) {
            techStock.applyPricingStrategy();
            System.out.println(techStock);
        }
        System.out.println(techStock.getMetric());
        System.out.println();
        
    }
}
