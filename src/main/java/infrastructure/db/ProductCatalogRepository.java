package infrastructure.db;

import domain.Product;

import java.util.Optional;

public class ProductCatalogRepository extends Repository<Product> implements IFetchProductById  {

    public ProductCatalogRepository(IDatabase connection) {
        super(connection);
        //Initialize DATA
    }

    public Optional<Product> fetchProductById(int productId) {
        return this.fetchAll().stream()
                            .filter(product -> product.getId() == productId )
                            .findFirst();
    }
}
