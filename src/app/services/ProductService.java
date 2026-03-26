package app.services;

import app.models.Product;
import app.repositories.ProductRepository;

import java.util.*;
import java.util.stream.Collectors;


public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

   //group products by category
   public Map<String, List<Product>> groupByCategory() {
      return repository.getProducts().stream()
              .collect(Collectors.groupingBy(
                      Product::getCategory)
              );
   }

   //find average price in each category
   public Map<String, Double> findAveragePriceByCategory() {
       return repository.getProducts().stream()
               .collect(Collectors.groupingBy(
                       Product::getCategory,
                       Collectors.averagingDouble(Product::getPrice)
               ));
   }

   //find category with the biggest average price
    public Optional<String> findCategoryByBiggestAverage() {
       return findAveragePriceByCategory()
               .entrySet()
               .stream()
               .max(Map.Entry.comparingByValue())
               .map(Map.Entry::getKey);
    }
}
