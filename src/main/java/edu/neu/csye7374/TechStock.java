package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class TechStock extends StockAPI {
    List<Integer> bidList = new ArrayList<>();
    public TechStock() {
        super("Tech Stock", 130, "Tech Stock is available");
    }

    @Override
    public void setBid(String bid) {
        int bidValue= Integer.parseInt(bid);
        bidList.add(bidValue);
        setPrice(bidValue);
        applyPricingStrategy(); // Applying pricing strategy when bid is set
//        System.out.println("The price for " + this.getName() + " is now " + bidValue);
    }

    @Override
    public String getMetric() {
        double bidAvgValue = getPreviousPrices().stream()
                .mapToInt(Double::intValue)
               .average()
                .orElse(0.0);
        return String.format("The Metric for " + this.getName() + ": Average Bid for the past " + bidList.size() + " bid values is: %.2f", bidAvgValue);
    }

    @Override
    public String toString() {
        return "TechStock { " + this.getName() + " - " + this.getDescription()
                + " - Current Price: " + this.getPrice() +" }";
    }
}
