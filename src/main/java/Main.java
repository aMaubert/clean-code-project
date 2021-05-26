
import infrastructure.console.Printer;
import infrastructure.db.*;
import use_cases.DisplayProduct;

public class Main {

    public static void main(String[] args) {

        //Injection de dependances
        IDatabase database = new IDatabase() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        ProductCatalogRepository productCatalogRepository = new ProductCatalogRepository(database);
        SellHistoryRepository sellHistoryRepository = new SellHistoryRepository(database);
        PriceRepository priceRepository = new PriceRepository(database);
        Printer printer = new Printer();


        DisplayProduct displayProduct = new DisplayProduct(productCatalogRepository, printer, printer, sellHistoryRepository, priceRepository);
        displayProduct.display(args);

    }


}
