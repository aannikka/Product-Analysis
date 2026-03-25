package app;

import repositories.ProductRepository;
import services.ProductService;
import models.Product;

import java.util.List;
import java.util.Map;

import static utils.Print.*;

public class Main {
    public static void main(String[] args) {

        ProductRepository repository = new ProductRepository();
        ProductService productService = new ProductService(repository);

        Map<String, List<Product>> productsGroupedByCategory = productService.groupByCategory();
        Map<String, Double> averagePriceByCategory = productService.findAveragePriceByCategory();
        String categoryWithBiggestAveragePrice = productService.findCategoryByBiggestAverage();

        printProductsGroupedByCategory(productsGroupedByCategory);
        printAveragePrices(averagePriceByCategory);
        printCategoryBiggestAveragePrice(categoryWithBiggestAveragePrice);
    }
}
