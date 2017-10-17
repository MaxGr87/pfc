package domain;

/* Ингридиент это продукт определенного веса, дозированный для блюда  */
public interface Ingredient extends Product {
    Product getProduct();
    Double getWeight();
}
