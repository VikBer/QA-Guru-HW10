package data;

public enum Product {
    IPHONE("Айфон"),
    XIAOMI("Ксиоми"),
    SAMSUNG("Самсунг");
    public final String description;

    Product(String description) {
        this.description = description;
    }
}
