package TrandingPlatform;
import java.util.HashMap;
import java.util.Map;
public class Market {
	 private Map<String, Stock> stocks = new HashMap<>();

	    public Market() {
	        stocks.put("AAPL", new Stock("AAPL", 150.0));
	        stocks.put("GOOGL", new Stock("GOOGL", 2800.0));
	        stocks.put("AMZN", new Stock("AMZN", 3400.0));
	    }

	    public Stock getStock(String ticker) {
	        return stocks.get(ticker);
	    }

	    public void updateStockPrice(String ticker, double newPrice) {
	        Stock stock = stocks.get(ticker);
	        if (stock != null) {
	            stock.setPrice(newPrice);
	        }
	    }

	    public void printMarketData() {
	        System.out.println("Market Data:");
	        for (Stock stock : stocks.values()) {
	            System.out.println("Ticker: " + stock.getTicker() + ", Price: $" + stock.getPrice());
	        }
	    }
	

}
