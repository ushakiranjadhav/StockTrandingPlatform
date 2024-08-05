package TrandingPlatform;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
	private Map<String, Integer> stocks = new HashMap<>();
    private double balance;

    public Portfolio(double initialBalance) {
        this.balance = initialBalance;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (balance >= cost) {
            balance -= cost;
            stocks.put(stock.getTicker(), stocks.getOrDefault(stock.getTicker(), 0) + quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.getTicker());
        } else {
            System.out.println("Insufficient balance to buy " + quantity + " shares of " + stock.getTicker());
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int ownedQuantity = stocks.getOrDefault(stock.getTicker(), 0);
        if (ownedQuantity >= quantity) {
            double revenue = stock.getPrice() * quantity;
            balance += revenue;
            stocks.put(stock.getTicker(), ownedQuantity - quantity);
            System.out.println("Sold " + quantity + " shares of " + stock.getTicker());
        } else {
            System.out.println("Not enough shares to sell " + quantity + " shares of " + stock.getTicker());
        }
    }

    public void printPortfolio() {
        System.out.println("Portfolio:");
        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {
            System.out.println("Stock: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
        System.out.println("Balance: $" + balance);
    }

    public double getBalance() {
        return balance;
    }
	

}
