import dao.ProductDao;
import domain.impl.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.jgroups.util.Util.assertEquals;

/**
 *
 * This Test are Checking creating process of the Product in to the Database
 *
 */


public class TestProduct {

    @Test
    public void testProductCreation() throws Exception {
        ApplicationContext appContext =
                new FileSystemXmlApplicationContext("D:/BGU/module1/src/main/resources/META-INF/spring/BeanLocations.xml");
        ProductDao productDao = (ProductDao) appContext.getBean("productDao");
        Product pork = new Product("Pork", 11.4, 49.3, 0, 489.0);
        productDao.save(pork);

        assertEquals("Checking", 11.4, productDao.findByProductName("Pork").getProtein());
    }
}
