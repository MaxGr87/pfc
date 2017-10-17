package dao;
import domain.impl.Ingredient;

public interface IngredientDao {

    void save(Ingredient ingredient);
    void update(Ingredient ingredient);
    void delete(Ingredient ingredient);
    Ingredient findByIngredientName(String name);
}