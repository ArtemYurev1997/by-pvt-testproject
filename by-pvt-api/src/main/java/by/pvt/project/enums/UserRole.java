package by.pvt.project.enums;

public enum UserRole {
    ADMINISTRATOR("Administrator"),
    SALE_USER("Sale user"),
    CUSTOMER_USER("Customer user"),
    SECURE_API_USER("Secure API user");

    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
