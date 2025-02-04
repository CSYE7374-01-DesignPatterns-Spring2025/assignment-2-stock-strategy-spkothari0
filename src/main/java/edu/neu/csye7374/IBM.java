package edu.neu.csye7374;

public class IBM extends StockAPI {

    public IBM() {
        super("IBM", 131.15, "IBM Common Stock");
    }

    @Override
    public void setBid(String bid) {
        double bidVal = Double.parseDouble(bid);
        setPrice(getPrice() + (bidVal * 0.2));
        applyPricingStrategy(); // Applying pricing strategy when bid is set
//        System.out.println("Bid " + bidCount + " : " + bidVal);
        bidCount++;
    }

    @Override
    public String getMetric() {
        int performanceMetric = (int) (getPrice() / 10);
        return "Performance Metric: " + performanceMetric;
    }
}
