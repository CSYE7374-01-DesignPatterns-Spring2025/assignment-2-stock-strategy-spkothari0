package edu.neu.csye7374;
import java.util.List;
import java.util.Stack;

public class StockAPI implements Tradable{

    private String name;
    private double price;
    private String description;

    private List<Double> previousPrices = new Stack<>();

    protected int bidCount = 0;

    public StockAPI(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.previousPrices.add(price);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Double> getPreviousPrices() {
        return previousPrices;
    }

    public void setPreviousPrices(List<Double> previousPrices) {
        this.previousPrices = previousPrices;
    }

    @Override
    public String toString() {
        return "StockAPI{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description +
    "}";
    }

    @Override
    public void setBid(String bid) {
        double bidId = Double.parseDouble(bid);
        this.price = bidId;
        this.previousPrices.add(bidId);

    }

    @Override
    public String getMetric() {
        int performance = 0;
        double previousPrice = 0;
        for(double price : getPreviousPrices().subList(getPreviousPrices().size()-6, getPreviousPrices().size())){
            if(price > previousPrice){
                performance++;
            } else {
                performance--;
            }
            previousPrice = price;
        }
        if(previousPrice > 0){
            return "Stock is Increasing";
        }
        else if(previousPrice < 0){
            return "Stock is Decreasing";
        }
        else
            return "No Change in Stock";
    }
}
