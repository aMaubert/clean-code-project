package infrastructure.console;

import domain.Price;
import domain.Product;

public class Printer implements PrintProduct, ExitError {

    @Override
    public void displayProduct(Product product, double price) {
        System.out.println("Name : " + product.getName());
        System.out.println("Description : " + product.getDescription());
        System.out.println("Category : " + product.getCategory());
        System.out.println("Price : " + price);
        System.out.println("Details :");
        System.out.println("-------------------");
        for (String key : product.getDetails().keySet()) {
            System.out.println( key + " => " + product.getDetails().get(key));
        }
        System.out.println("-------------------");
    }

    public void errorAndExit(String error) {
        throw new RuntimeException(error);
    }

}
