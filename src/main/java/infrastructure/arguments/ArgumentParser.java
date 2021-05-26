package infrastructure.arguments;

public interface ArgumentParser<T> {
    T parse(String[] args);
}
