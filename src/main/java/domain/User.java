package domain;


import java.util.Objects;

public class User {
    private final int id;
    private final String name;
    private final String login;

    public User(int id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = login;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && getName().equals(user.getName()) && getLogin().equals(user.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLogin());
    }
}
