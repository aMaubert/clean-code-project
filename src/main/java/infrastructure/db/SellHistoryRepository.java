package infrastructure.db;

import domain.SellHistory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class SellHistoryRepository extends Repository<SellHistory> implements IFetchSellHistoryByUserId {

    public SellHistoryRepository(IDatabase connection) {
        super(connection);
    }


    @Override
    public long countLastSixMonthTransactions(int userId) {

        LocalDate sixMonthBefore = LocalDate.now().minus(6, ChronoUnit.MONTHS);
        return this.fetchAll()
                .stream()
                .filter(sellHistory -> {
                    LocalDate localDate = LocalDate.ofInstant(sellHistory.getDate().toInstant(), ZoneId.systemDefault());
                    boolean isAfterLastSixMonth = !sixMonthBefore.isAfter( localDate );
                    return isAfterLastSixMonth && sellHistory.getUserId() == userId;
                })
                .count();
    }

    @Override
    public long countAllTransactionsLastYearOfProduct(int userId, int productId) {
        int lastYear = LocalDate.now().minus(1, ChronoUnit.YEARS).getYear();

        return this.fetchAll()
                        .stream()
                        .filter(sellHistory -> {
                            boolean isLastYear = LocalDate.ofInstant(sellHistory.getDate().toInstant(), ZoneId.systemDefault()).getYear() == lastYear;
                            return isLastYear && sellHistory.getUserId() == userId && sellHistory.getProductId() ==  productId ;
                        })
                        .count();

    }

}
