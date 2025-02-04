package edu.neu.csye7374;

public class IBM extends StockAPI {
    private double bidVal;

    public IBM() {
        super("IBM", 131.15, "IBM Common Stock");
    }

    @Override
    public void setBid(String bid) {
        bidVal = Double.parseDouble(bid);
        setPrice(getPrice() + (bidVal * 0.2));
        System.out.println("Bid " + bidCount + " : " + bidVal);
        bidCount++;
    }

    @Override
    public String getMetric() {
        
        int performanceMetric = (int) (getPrice() / 10);
        return "Performance Metric: " + performanceMetric;
    }
}
