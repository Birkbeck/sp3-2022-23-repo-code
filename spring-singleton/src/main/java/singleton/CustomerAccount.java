package singleton;

public class CustomerAccount {

    private String name;

    public CustomerAccount() {
    }

    public CustomerAccount(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
            "name='" + name + '\'' +
            '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}