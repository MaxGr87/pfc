import dao.IngredientDao;
import dao.ProductDao;
import domain.impl.Ingredient;
import domain.impl.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.jgroups.util.Util.assertEquals;

/**
 * This Test Check creating process of the Ingredient in to the Database.
 * Also this test Check evaluation method (product*weight/100) in Ingredient class.
 */
public class TestIngredientCreation {


    @Test
    public void testProductCreation() throws Exception {
        ApplicationContext appContext =
                new FileSystemXmlApplicationContext("D:/BGU/module1/src/main/resources/META-INF/spring/BeanLocations.xml");
        ProductDao productDao = (ProductDao) appContext.getBean("productDao");
        IngredientDao ingredientDao = (IngredientDao) appContext.getBean("ingredientDao");

        Product pork = new Product("Pork", 11.4, 49.3, 0, 489.0);
        productDao.save(pork);

        Ingredient porkIngredient = new Ingredient("Pork", pork, 500.0);
        ingredientDao.save(porkIngredient);


        assertEquals("Checking", 11.4*500/100, ingredientDao.findByIngredientName("Pork").getProtein());
    }



}
