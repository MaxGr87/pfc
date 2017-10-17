package domain;

import java.util.Collection;

public interface Dish extends Product {

    Collection<domain.impl.Ingredient> getIngredients();
}
