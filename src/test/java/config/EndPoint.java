package config;

public interface EndPoint {
    String GET_MATCHES = "matches";

    String GET_USERS = "users";
    String GET_PRODUCTS = "product";
    String GET_SINGLE_PRODUCT = "product/{productId}";
}
