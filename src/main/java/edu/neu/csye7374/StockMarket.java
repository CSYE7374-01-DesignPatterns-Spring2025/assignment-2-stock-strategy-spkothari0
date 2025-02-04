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
        System.out.println("Traded: " + stock.toString());
    }

    public static void demo(){
    	System.out.println("Demo method");
    	
        StockMarket stockMarket = getInstance();
        
        IBMLazySingletonFactory ibmLazySingletonFactory = IBMLazySingletonFactory.getInstance();

        StockAPI ibmLazy = ibmLazySingletonFactory.getObject();

        System.out.println("IBM Lazy");
     
        String[] bids = {"132.89", "130.98", "135.00", "134.02", "136.00", "139.02"};
        for (String bid : bids) {
            stockMarket.tradeStock(ibmLazy, bid);
        }
        System.out.println(ibmLazy.getMetric());
        System.out.println();
        
        System.out.println("Tech Stock Eager");


        TechStockEagerFactory techStockEagerFactory = TechStockEagerFactory.getInstance();

        StockAPI techStockEager = techStockEagerFactory.getObject();

        techStockEager.setDescription("TechStock Eager");
     
        bids = new String[]{"120", "125", "135", "115", "90", "84"};
        for (String bid : bids) {
            stockMarket.tradeStock(techStockEager, bid);
        }
        System.out.println(techStockEager.getMetric());
        System.out.println();
        
        System.out.println("IBM factory");

        IBMFactory ibmFactory = new IBMFactory();
        StockAPI ibm = ibmFactory.getObject();

        bids = new String[]{"132.89", "130.98", "135.00", "134.02", "136.00", "139.02"};
        for (String bid : bids) {
            stockMarket.tradeStock(ibm, bid);
        }
        System.out.println(ibm.getMetric());
        System.out.println();

        System.out.println("Tech Stock factory");

        TechStockFactory techStockFactory = new TechStockFactory();
        StockAPI techStock = ibmFactory.getObject();

        bids = new String[]{"132", "130", "135", "134", "136", "139"};
        for (String bid : bids) {
            stockMarket.tradeStock(techStock, bid);
        }
        System.out.println(techStock.getMetric());
        System.out.println();
        
    }
}
