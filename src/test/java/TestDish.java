import dao.DishDao;
import dao.IngredientDao;
import dao.ProductDao;
import domain.impl.Dish;
import domain.impl.Ingredient;
import domain.impl.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.jgroups.util.Util.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This Test check the process of evaluation
 */
public class TestDish {

    @Test
    public void testDish() throws Exception {

        Product pork = new Product("Pork", 11.4, 49.3, 0, 489);                     // 500 гр
        Product rice = new Product("Rice", 8, 1, 76, 345);                              // 400 гр
        Product carrot = new Product("Carrot", 1.3, 0.1, 7, 34);                        // 250 гр
        Product onyon = new Product("Onyon", 1.3, 0, 4.3, 22);                              // 300 гр
        Product garlic = new Product("Garlic", 6.5, 0, 21.2, 110);                      // 50 гр
        Product naturalOil = new Product("Natural_Oil", 0, 99.9, 0, 899);              // 50 гр
        Product salt = new Product("Salt", 0, 0, 0, 0);                                 // 1 гр
        Product pepper = new Product("Pepper", 1.3, 0, 4.7, 24);                           // 1 гр

        Ingredient[] ingredient = new Ingredient[8];

        ingredient[0] = new Ingredient("Pork", pork, 500.0);
        ingredient[1] = new Ingredient("Rice", rice, 400.00);
        ingredient[2] = new Ingredient("Carrot", carrot, 250.00);
        ingredient[3] = new Ingredient("Onyon", onyon, 300.00);
        ingredient[4] = new Ingredient("Garlic", garlic, 50.00);
        ingredient[5] = new Ingredient("Natural_Oil", naturalOil, 50.00);
        ingredient[6] = new Ingredient("Salt", salt, 1.0);
        ingredient[7] = new Ingredient("Pepper", pepper, 1.00);

        Dish plov = new Dish("Plov", ingredient);

        assertNotNull("Checking creating Dish", plov);
        assertEquals("Checking total weight", 1552.0, plov.getWeight());

    }

    @Test
    public void testDishDatabase() throws Exception {

        ApplicationContext appContext =

                new FileSystemXmlApplicationContext("D:/BGU/module1/src/main/resources/META-INF/spring/BeanLocations.xml");

        ProductDao productDao = (ProductDao) appContext.getBean("productDao");
        IngredientDao ingredientDao = (IngredientDao) appContext.getBean("ingredientDao");
        DishDao dishDao = (DishDao) appContext.getBean("dishDao");

        Product pork = new Product("Pork", 11.4, 49.3, 0, 489);                     // 500 гр
        Product rice = new Product("Rice", 8, 1, 76, 345);                              // 400 гр
        Product carrot = new Product("Carrot", 1.3, 0.1, 7, 34);                        // 250 гр
        Product onyon = new Product("Onyon", 1.3, 0, 4.3, 22);                              // 300 гр
        Product garlic = new Product("Garlic", 6.5, 0, 21.2, 110);                      // 50 гр
        Product naturalOil = new Product("Natural_Oil", 0, 99.9, 0, 899);              // 50 гр
        Product salt = new Product("Salt", 0, 0, 0, 0);                                 // 1 гр
        Product pepper = new Product("Pepper", 1.3, 0, 4.7, 24);                           // 1 гр

        productDao.save(pork);
        productDao.save(rice);
        productDao.save(carrot);
        productDao.save(onyon);
        productDao.save(garlic);
        productDao.save(naturalOil);
        productDao.save(salt);
        productDao.save(pepper);

        Ingredient[] ingredient = new Ingredient[8];

        ingredient[0] = new Ingredient("pork", productDao.findByProductName("Pork"), 500.0);
        ingredient[1] = new Ingredient("Rice", productDao.findByProductName("Rice"), 400.00);
        ingredient[2] = new Ingredient("Carrot", productDao.findByProductName("Carrot"), 250.00);
        ingredient[3] = new Ingredient("Onyon",productDao.findByProductName("Onyon"), 300.00);
        ingredient[4] = new Ingredient("Garlic", productDao.findByProductName("Garlic"), 50.00);
        ingredient[5] = new Ingredient("Natural_Oil", productDao.findByProductName("Natural_Oil"), 50.00);
        ingredient[6] = new Ingredient("Salt", productDao.findByProductName("Salt"), 1.0);
        ingredient[7] = new Ingredient("Pepper", productDao.findByProductName("Pepper"), 1.00);

        for (int i = 0; i < ingredient.length; i++) {
            ingredientDao.save(ingredient[i]);
        }

        Dish plov = new Dish("Plov",  ingredient);
        dishDao.save(plov);


        assertEquals("Checking total weight", 1552.0, dishDao.findByDishName("Plov").getWeight());
    }

}
