package edu.neu.csye7374;

public class IBMLazySingletonFactory implements AbstarctFactory {

    private static IBMLazySingletonFactory ibmLazySingletonFactory;

    private IBMLazySingletonFactory() {
    	
    }

    public static synchronized IBMLazySingletonFactory getInstance() {
        if(ibmLazySingletonFactory == null){
        	ibmLazySingletonFactory = new IBMLazySingletonFactory();
        }
        return ibmLazySingletonFactory;
    }

    @Override
    public StockAPI getObject() {
        return new IBM();
    }

}
