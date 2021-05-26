package infrastructure.arguments;

import java.util.Optional;



public class  DisplayProductDTO {

    private final int produtctId;
    private final Optional<Integer> userId;

    public DisplayProductDTO(int produtctId, Optional<Integer> userId) {
        this.produtctId = produtctId;
        this.userId = userId;
    }

    public int getProdutcrId() {
        return produtctId;
    }

    public Optional<Integer> getUserId() {
        return userId;
    }
}
