import domain.Price;
import domain.Product;
import domain.SellHistory;
import infrastructure.console.PrintProduct;
import infrastructure.console.Printer;
import infrastructure.db.IDatabase;
import infrastructure.db.PriceRepository;
import infrastructure.db.ProductCatalogRepository;
import infrastructure.db.SellHistoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import use_cases.DisplayProduct;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class SimpleTest {

    DisplayProduct displayProduct ;

    Product productTest;
    Price priceTest;
    SellHistoryRepository sellHistoryRepository;

    Product displayedProduct;
    double displayedPrice;

    @Before
    public void setup() {
        //Injection de dependances
        IDatabase database = new IDatabase() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        ProductCatalogRepository productCatalogRepository = new ProductCatalogRepository(database);
        sellHistoryRepository = new SellHistoryRepository(database);
        PriceRepository priceRepository = new PriceRepository(database);
        Printer printer = new Printer();

        PrintProduct printProduct = (product, price) -> {
            displayedPrice = price;
            displayedProduct = product;
        };

        displayProduct = new DisplayProduct(productCatalogRepository, printProduct, printer, sellHistoryRepository, priceRepository);


        //Créer de la donnée
        productTest = new Product(1, "Produit 1", "description ", "Category 1", new HashMap<>());
        productCatalogRepository.fetchAll().add(productTest);


        SellHistory sellHistory = new SellHistory(1, productTest.getId(), new Date());
        sellHistoryRepository.fetchAll().add(sellHistory);

        priceTest = new Price(productTest.getId(), 100, new Date());
        priceRepository.fetchAll().add(priceTest);


    }

    @Test
    public void UseCase1() {
        String[] args = new String[1];
        args[0] = "1";

        displayProduct.display(args);

        assertThat(displayedProduct.getId()).isEqualTo(productTest.getId());
    }

    @Test
    public void UseCase2() {

        LocalDate sixMonthRuleDate = LocalDate.now().minus(6, ChronoUnit.MONTHS);
        Date date = Date.from(sixMonthRuleDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SellHistory sellHistory = new SellHistory(2, productTest.getId(), date);

        sellHistoryRepository.fetchAll().add(sellHistory);
        sellHistoryRepository.fetchAll().add(sellHistory);
        sellHistoryRepository.fetchAll().add(sellHistory);

        String[] args = new String[2];
        args[0] = "1"; // Id product
        args[1] = "2"; // Id user connected

        displayProduct.display(args);

        assertThat(displayedPrice).isEqualTo(priceTest.getPrice() * 0.9);//10 % discount

    }

    @Test
    public void discountOf5Percent() {

        LocalDate sixMonthRuleDate = LocalDate.now().minus(1, ChronoUnit.YEARS);
        Date date = Date.from(sixMonthRuleDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SellHistory sellHistory = new SellHistory(2, productTest.getId(), date);

        sellHistoryRepository.fetchAll().add(sellHistory);
        sellHistoryRepository.fetchAll().add(sellHistory);
        sellHistoryRepository.fetchAll().add(sellHistory);
        sellHistoryRepository.fetchAll().add(sellHistory);
        sellHistoryRepository.fetchAll().add(sellHistory);

        String[] args = new String[2];
        args[0] = "1"; // Id product
        args[1] = "2"; // Id user connected

        displayProduct.display(args);

        assertThat(displayedPrice).isEqualTo(priceTest.getPrice() * 0.95);//5 % discount

    }

    @Test
    public void discountOf15Percent() {

        LocalDate sixMonthRuleDate = LocalDate.now().minus(3, ChronoUnit.MONTHS);
        Date date = Date.from(sixMonthRuleDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SellHistory sellHistory = new SellHistory(2, productTest.getId(), date);

        sellHistoryRepository.fetchAll().add(sellHistory);
        sellHistoryRepository.fetchAll().add(sellHistory);
        sellHistoryRepository.fetchAll().add(sellHistory);

        LocalDate lastYear = LocalDate.now().minus(1, ChronoUnit.YEARS);
        Date dateLastYear = Date.from(lastYear.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SellHistory sellHistory2 = new SellHistory(2, productTest.getId(), dateLastYear);

        sellHistoryRepository.fetchAll().add(sellHistory2);
        sellHistoryRepository.fetchAll().add(sellHistory2);
        sellHistoryRepository.fetchAll().add(sellHistory2);
        sellHistoryRepository.fetchAll().add(sellHistory2);
        sellHistoryRepository.fetchAll().add(sellHistory2);

        String[] args = new String[2];
        args[0] = "1"; // Id product
        args[1] = "2"; // Id user connected

        displayProduct.display(args);

        assertThat(displayedPrice).isEqualTo(priceTest.getPrice() * 0.85);//15 % discount

    }
}
