import domain.impl.Dish;
import domain.impl.Ingredient;
import domain.impl.Product;
import org.junit.Test;

import static org.jgroups.util.Util.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * This Test check the process of evaluation
 *
 */
public class TestEvaluationDishEnergy {

    @Test
    public void testEvaluationDishEnergy() throws Exception {

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

}
