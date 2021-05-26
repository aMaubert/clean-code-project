package infrastructure.db;

import domain.Price;

import java.util.Optional;

public interface FetchPrice {
    Optional<Price> byProductId(int productId);
}
