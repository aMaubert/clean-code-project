package infrastructure.db;

import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T> {
    private List<T> list;
    private IDatabase connection;

    public Repository(IDatabase connection) {
        this.list = new ArrayList<>();
        this.connection = connection;
    }

    public List<T> fetchAll() {
        return this.list;
    }

}
