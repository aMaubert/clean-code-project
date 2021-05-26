package infrastructure.db;

import domain.Product;

import java.util.Optional;

public interface IFetchProductById {
    Optional<Product> fetchProductById(int productId);
}
