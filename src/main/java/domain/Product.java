package domain;

/* The Product contain information about amount of energy on 100 gr. weight of real product  */
public interface Product {
    String getName();
    Double getCalories();
    Double getProtein();
    Double getCarbon();
    Double getFat();
}
