package infrastructure.console;

import domain.Price;
import domain.Product;

public interface PrintProduct {
    void displayProduct(Product product, double price);
}
