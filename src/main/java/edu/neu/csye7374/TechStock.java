package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class TechStock extends StockAPI {
    List<Integer> bidList = new ArrayList<>();
    public TechStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setBid(String bid) {
        int bidValue= Integer.parseInt(bid);
        bidList.add(bidValue);
        setPrice(bidValue);
        System.out.println("The price for " + this.getName() + " is now " + bidValue);
    }

    @Override
    public String getMetric() {
        double bidAvgValue = bidList.stream()
                .mapToInt(Integer::intValue)
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
