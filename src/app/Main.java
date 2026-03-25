package app;

import repositories.ProductRepository;
import services.ProductService;
import models.Product;

import java.util.List;
import java.util.Map;

import static utils.Print.*;

public class Main {
    public static void main(String[] args) {

        ProductService productService = new ProductService();

        List<Product> products = ProductRepository.getAllProducts();
        Map<String, List<Product>> productsGroupedByCategory = productService.groupByCategory(products);
        Map<String, Double> averagePriceByCategory = productService.findAveragePriceByCategory(products);
        String categoryWithBiggestAveragePrice = productService.findCategoryByBiggestAverage(products);

        printProductsGroupedByCategory(productsGroupedByCategory);
        printAveragePrices(averagePriceByCategory);
        printCategoryBiggestAveragePrice(categoryWithBiggestAveragePrice);
    }
}
