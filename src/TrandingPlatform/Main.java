package TrandingPlatform;
import java.util.Scanner;
public class Main {

		public static void main(String[] args) {
	        Market market = new Market();
	        Portfolio portfolio = new Portfolio(10000.0);
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Choose an option: ");
	            System.out.println("1. View market data");
	            System.out.println("2. Buy stock");
	            System.out.println("3. Sell stock");
	            System.out.println("4. View portfolio");
	            System.out.println("5. Exit");
	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    market.printMarketData();
	                    break;
	                case "2":
	                    System.out.println("Enter ticker symbol: ");
	                    String buyTicker = scanner.nextLine();
	                    System.out.println("Enter quantity: ");
	                    int buyQuantity = Integer.parseInt(scanner.nextLine());
	                    Stock buyStock = market.getStock(buyTicker);
	                    if (buyStock != null) {
	                        portfolio.buyStock(buyStock, buyQuantity);
	                    } else {
	                        System.out.println("Invalid ticker symbol.");
	                    }
	                    break;
	                case "3":
	                    System.out.println("Enter ticker symbol: ");
	                    String sellTicker = scanner.nextLine();
	                    System.out.println("Enter quantity: ");
	                    int sellQuantity = Integer.parseInt(scanner.nextLine());
	                    Stock sellStock = market.getStock(sellTicker);
	                    if (sellStock != null) {
	                        portfolio.sellStock(sellStock, sellQuantity);
	                    } else {
	                        System.out.println("Invalid ticker symbol.");
	                    }
	                    break;
	                case "4":
	                    portfolio.printPortfolio();
	                    break;
	                case "5":
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        }
	    

	}

}
