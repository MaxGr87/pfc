package dao;
import domain.impl.Product;

public interface ProductDao {

    void save(Product product);
    void update(Product product);
    void delete(Product product);
    Product findByProductName(String name);
}