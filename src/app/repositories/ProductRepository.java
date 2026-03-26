package app.repositories;

import app.models.Product;
import java.util.List;

public class ProductRepository {
    private List<Product> products = List.of(
            new Product("Phone", "Electronics", 15000),
            new Product("Laptop", "Electronics", 20000),
            new Product("Plushy Bear", "Toys", 800),
            new Product("Tablet", "Electronics", 7000),
            new Product("Doll House", "Toys", 1200)
    );

    public List<Product> getProducts() {
        return products;
    }
}
