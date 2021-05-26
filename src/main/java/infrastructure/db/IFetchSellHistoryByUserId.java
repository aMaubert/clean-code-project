package infrastructure.db;


public interface IFetchSellHistoryByUserId {
    long countLastSixMonthTransactions(int userId);
    long countAllTransactionsLastYearOfProduct(int userId, int productId);
}
