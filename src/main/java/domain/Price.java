package domain;

import java.util.Date;

public class Price {

    private final int productId;
    private final double price;
    private final Date updateDate;

    public Price(int productId, double price, Date updateDate) {
        this.productId = productId;
        this.price = price;
        this.updateDate = updateDate;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public double discount(long bougthLastYear, long numberOfProductBoughtLast6Month) {
        if (bougthLastYear >= 5 && numberOfProductBoughtLast6Month >= 3) {
            return this.price * 0.85;
        } else if (bougthLastYear >= 5) {
            return this.price * 0.95;
        } else if (numberOfProductBoughtLast6Month >= 3) {
            return this.price * 0.9;
        }
        return this.price;
    }
}
