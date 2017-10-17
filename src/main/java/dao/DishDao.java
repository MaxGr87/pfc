package dao;

import domain.impl.Dish;

public interface DishDao {

    void save(Dish dish);
    void update(Dish dish);
    void delete(Dish dish);
    Dish findByDishName(String name);
}