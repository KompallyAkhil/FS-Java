// You are building an E-Commerce Product Insights Engine for a marketplace like 
// Amazon or Flipkart. The platform stores information about various products, 
// their pricing history, and user ratings.

// Your job is to:

//     1. Accept data for multiple products.
    
//     2. Each product has:
//         🎯 Multiple price entries (date + price)
//         🎯 Multiple ratings (user + stars out of 5)
        
//     3. Calculate:
//         🎯 Average price of the product
//         🎯 Price volatility score: Standard deviation of prices
//         🎯 Average rating

//     4. Classify products into Insight Tiers:
//         🟢 Stable & Loved: Volatility < 100 and Rating ≥ 4.0
//         🟡 Unstable but Popular: Volatility ≥ 100 and Rating ≥ 4.0
//         🔴 Unstable & Poorly Rated: Volatility ≥ 100 and Rating < 4.0
//         ⚪ Stable but Low-Rated: Volatility < 100 and Rating < 4.0
        
// Sample Input:
// -------------
// 2               
// EchoDot         
// 3               
// 2024-06-01 3499 
// 2024-06-10 3299
// 2024-06-15 3599
// 2               
// Alice 5        
// Bob 4
// OldTV           
// 4              
// 2024-05-01 9999 
// 2024-05-10 10999
// 2024-05-15 11999
// 2024-05-20 8999
// 3             
// Charlie 2      
// Diana 3
// Eve 1

// Sample Output:
// --------------
// Product: EchoDot, AvgPrice: 3465.7, Volatility: 124.7, AvgRating: 4.5, Tier: Unstable but Popular
// Product: OldTV, AvgPrice: 10499.0, Volatility: 1118.0, AvgRating: 2.0, Tier: Unstable & Poorly Rated

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaDesign2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int m = Integer.parseInt(sc.nextLine().trim());

            List<PriceEntry> prices = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                String[] parts = sc.nextLine().split(" ");
                prices.add(new PriceEntry(parts[0], Double.parseDouble(parts[1])));
            }

            int k = Integer.parseInt(sc.nextLine().trim());
            List<Rating> ratings = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                String[] parts = sc.nextLine().split(" ");
                ratings.add(new Rating(parts[0], Integer.parseInt(parts[1])));
            }

            products.add(new Product(name, prices, ratings));
        }

        InsightEngine engine = new InsightEngineImpl();
        System.out.println("=== Product Insights Summary ===");
        for (Product p : products) {
            ProductInsight insight = engine.analyze(p);
            System.out.println(insight);
        }
    }
}


// TODO: Complete this POJO
class PriceEntry {
    // String date; double amount
    String date;
    double amount;
    PriceEntry(String date, double amount){
        this.date = date;
        this.amount = amount;
    }
    
}

// TODO: Complete this POJO
class Rating {
    // String userName; int stars
    String userName;
    int stars;
    Rating(String userName , int stars){
        this.userName = userName;
        this.stars = stars;
    }
}

// TODO: Complete this POJO
class Product {
    // String name; List<PriceEntry>; List<Rating>
    String name;
    List<PriceEntry> prices;
    List<Rating> rating;
    Product(String name , List<PriceEntry> prices , List<Rating> rating){
        this.name = name;
        this.prices = prices;
        this.rating = rating;
    }
    
}

// TODO: Complete this POJO
class ProductInsight {
    // Product; double avgPrice; double volatility; double avgRating; String insightTier
    // Override toString() for output
    Product product;
    double avgPrice;
    double volatility;
    double avgRating;
    String insightTier;
    ProductInsight(Product product , double avgPrice , double volatility , double avgRating , String insightTier){
        this.product = product;
        this.avgPrice = avgPrice;
        this.volatility = volatility;
        this.avgRating = avgRating;
        this.insightTier = insightTier;
    }
    // Product: EchoDot, AvgPrice: 3465.7, Volatility: 124.7, AvgRating: 4.5, Tier: Unstable but Popular
    @Override
    public String toString() {
        return "Product: " + product.name + ", AvgPrice: " + String.format("%.1f", avgPrice) + ", Volatility: " + String.format("%.1f", volatility) + ", AvgRating: " + String.format("%.1f", avgRating) + ", Tier: " + insightTier;
        }
    }

interface InsightEngine {
    ProductInsight analyze(Product p);
}

// TODO: Implement InsightEngineImpl using Math.pow and Math.sqrt for std deviation
class InsightEngineImpl implements InsightEngine {
    public ProductInsight analyze(Product p) {
        // Logic:
        // - Calculate avgPrice
        double sumPrice = 0;
        for(PriceEntry pe : p.prices){
            sumPrice += pe.amount;
        }
        double avgPrice = sumPrice / p.prices.size();
        // - Calculate standard deviation
        double variance = 0;
        for (PriceEntry pe : p.prices) {
            variance += Math.pow(pe.amount - avgPrice, 2);
        }
        double stdDev = Math.sqrt(variance / p.prices.size());
        // - Calculate avgRating
        double sumRating = 0;
        for(Rating r : p.rating){
            sumRating += r.stars;
        }
        double avgRating = sumRating / p.rating.size();
        // - Tier assignment
        String tier;
        if (stdDev < 100 && avgRating >= 4.0) {
            tier = "Stable & Loved";
        } else if (stdDev >= 100 && avgRating >= 4.0) {
            tier = "Unstable but Popular";
        } else if (stdDev >= 100 && avgRating < 4.0) {
            tier = "Unstable & Poorly Rated";
        } else {
            tier = "Stable but Low-Rated";
        }
        return new ProductInsight(p,avgPrice,stdDev,avgRating,tier); // TODO
    }
}


