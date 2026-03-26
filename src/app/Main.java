package app;

import app.repositories.ProductRepository;
import app.services.ProductService;
import app.models.Product;
import app.utils.Print;

import java.util.List;
import java.util.Map;

import static app.utils.Print.*;

public class Main {
    public static void main(String[] args) {

        ProductRepository repository = new ProductRepository();
        ProductService productService = new ProductService(repository);

        Map<String, List<Product>> productsGroupedByCategory = productService.groupByCategory();
        Map<String, Double> averagePriceByCategory = productService.findAveragePriceByCategory();

        printProductsGroupedByCategory(productsGroupedByCategory);
        printAveragePrices(averagePriceByCategory);

        productService.findCategoryByBiggestAverage()
                .ifPresentOrElse(
                        Print::printCategoryBiggestAveragePrice,
                        () -> System.out.println("\nNo category found")
                );
    }
}
