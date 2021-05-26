package infrastructure.arguments;


import java.util.Optional;

public class DisplayProductArgumentParser implements ArgumentParser<DisplayProductDTO> {

    @Override
    public DisplayProductDTO parse(String[] args) {
        if (args.length == 0) throw new RuntimeException("Should have at least 1 argument (product ID)");
        int productId = Integer.parseInt(args[0]) ;
        if (args.length == 1) return new DisplayProductDTO( productId, Optional.empty());
        int userId = Integer.parseInt( args[1]) ;
        return new DisplayProductDTO( productId, Optional.of(userId));
    }
}
