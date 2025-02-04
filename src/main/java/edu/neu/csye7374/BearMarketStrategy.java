package edu.neu.csye7374;

public class BearMarketStrategy implements PricingStrategy {
    @Override
    public double calculateNewPrice(double currentPrice) {
        return currentPrice * 0.9; // Decrease by 10% for a Bear market
    }
}
