package domain;

import java.util.Map;
import java.util.Objects;

public class Product {
    private final int id;
    private final String name ;
    private final String description;
    private final String category;
    private final Map<String,String> details;

    public Product(int id, String name, String description, String category, Map<String, String> details) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.details = details;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", details=" + details +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() == product.getId() && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getCategory(), product.getCategory()) && Objects.equals(getDetails(), product.getDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getCategory(), getDetails());
    }
}
