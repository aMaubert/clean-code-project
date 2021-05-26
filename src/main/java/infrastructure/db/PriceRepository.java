package infrastructure.db;

import domain.Price;

import java.util.Optional;

public class PriceRepository extends Repository<Price> implements FetchPrice {

    public PriceRepository(IDatabase connection) {
        super(connection);
    }


    @Override
    public Optional<Price> byProductId(int productId) {
        return this.fetchAll().stream()
                            .filter(price -> price.getProductId() == productId )
                            .findFirst();
    }
}
