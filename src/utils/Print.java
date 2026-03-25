package utils;

import models.Product;

import java.util.List;
import java.util.Map;

public class Print {

    public static void printProductsGroupedByCategory(Map<String, List<Product>> groupedByCategory) {
        System.out.println("\nProducts grouped by category:");
        groupedByCategory.forEach((category, products) -> {
            System.out.println("---" + category + "---");
            products.forEach(product ->
                System.out.printf("<> %-15s | %.2f%n", product.getName(), product.getPrice())
            );
        });
    }

    public static void printAveragePrices (Map<String, Double> averagePrices) {
        System.out.println("\nAverage price in categories:");
        averagePrices.forEach((category, averagePrice) ->
                System.out.printf("<> %-15s | %.2f%n", category, averagePrice));
    }

    public static void printCategoryBiggestAveragePrice(String category) {
        System.out.println("\nCategory with the biggest average price: " +  category);
    }
}
