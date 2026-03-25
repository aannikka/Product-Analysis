package services;

import models.Product;

import java.util.*;
import java.util.stream.Collectors;


public class ProductService {

   //group products by category
   public Map<String, List<Product>> groupByCategory(List<Product> products) {
      return products.stream()
              .collect(Collectors.groupingBy(
                      Product::getCategory)
              );
   }

   //find average price in each category
   public Map<String, Double> findAveragePriceByCategory(List<Product> products) {
       return products.stream()
               .collect(Collectors.groupingBy(
                       Product::getCategory,
                       Collectors.averagingDouble(Product::getPrice)
               ));
   }

   //find category with the biggest average price
    public String findCategoryByBiggestAverage(List<Product> products) {
       return findAveragePriceByCategory(products)
               .entrySet()
               .stream()
               .max(Map.Entry.comparingByValue())
               .map(Map.Entry::getKey)
               .orElse("No category");
    }
}
