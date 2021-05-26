package domain;

import java.util.Date;
import java.util.Objects;

public class SellHistory {
    private final int userId;
    private final int productId;
    private final Date date;

    public SellHistory(int userId, int productId, Date date) {
        this.userId = userId;
        this.productId = productId;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellHistory that = (SellHistory) o;
        return getUserId() == that.getUserId() && getProductId() == that.getProductId() && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getProductId(), getDate());
    }
}
