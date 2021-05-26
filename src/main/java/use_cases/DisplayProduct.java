package use_cases;

import domain.Price;
import domain.Product;
import infrastructure.arguments.DisplayProductArgumentParser;
import infrastructure.arguments.DisplayProductDTO;
import infrastructure.console.ExitError;
import infrastructure.console.PrintProduct;
import infrastructure.db.FetchPrice;
import infrastructure.db.IFetchProductById;
import infrastructure.db.IFetchSellHistoryByUserId;

import java.util.Optional;


public class DisplayProduct {
    private final IFetchProductById productRepository;
    private final PrintProduct printer;
    private final ExitError exitError;
    private final IFetchSellHistoryByUserId fetchSellHistoryByUserId;
    private final FetchPrice fetchPrice;

    public DisplayProduct(IFetchProductById productRepository,
                          PrintProduct printer,
                          ExitError exitError,
                          IFetchSellHistoryByUserId fetchSellHistoryByUserId,
                          FetchPrice fetchPrice) {
        this.productRepository = productRepository;
        this.printer = printer;
        this.exitError = exitError;
        this.fetchSellHistoryByUserId = fetchSellHistoryByUserId;
        this.fetchPrice = fetchPrice;
    }

    public void display(String[] args) {

        DisplayProductDTO displayProductDTO = new DisplayProductArgumentParser().parse(args);

        //On parse les arguments en entrées
        Optional<Product> optionalProduct =  this.productRepository.fetchProductById(displayProductDTO.getProdutcrId());

        if (optionalProduct.isEmpty()) { // QUOI Faire ?
            exitError.errorAndExit("Product not found .");
            return;
        }

        final Product product = optionalProduct.get();

        Optional<Price> optionalPrice = this.fetchPrice.byProductId(product.getId());

        if (optionalPrice.isEmpty()) { // QUOI Faire ?
            exitError.errorAndExit("Price not found .");
            return;
        }

        final Price price = optionalPrice.get();


        if (displayProductDTO.getUserId().isEmpty()) {
            //Display Product
            this.printer.displayProduct(product, price.getPrice());
            return;
        }

        //Check if price has discount
        final int userId = displayProductDTO.getUserId().get();

        long lastSixMonthTransactions = this.fetchSellHistoryByUserId.countLastSixMonthTransactions(userId);
        long numberOfTransactionLastYear = this.fetchSellHistoryByUserId.countAllTransactionsLastYearOfProduct(userId, product.getId());
        this.printer.displayProduct(product, price.discount(numberOfTransactionLastYear, lastSixMonthTransactions));

    }

}
