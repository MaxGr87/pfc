/*
 * Classes:
 * Main, Product, Ingredient, Dish,
 * ProductDaoImpl, IngredientDaoImpl, DishDaoImpl
 * CustomHibernateDaoSupport
 *
 * Version information:
 * This program calculates the energy value of  the Dish
 * (protein, fat, carbon and calories values),
 * consisting of one or more ingredients.
 * Ingredients obtained from Products.
 *
 * Algorithm of action:
 * 1. Products are entered in the database with fields
 * ("name", proteins, fats, carbon, calories) per 100 gr.
 * 2. Necessary products from the database becomes the Ingredients with
 * the addition of fields ("name", Product, weight of the product).
 * 3. Ingredients added from the database to the Dishes with fields
 * ("dish name", Ingredients). After this the proteins,
 * fats, carbohydrates, calories, and weight counted.
 *
 *
 * This program has been developed with help next tools:
 *
 * Development tools:
 * - IDEA;
 *
 * Database tools:
 * - MySQL Workbench;
 *
 * Database systems:
 * - MySQL;
 *
 * Version control systems:
 * - Git;
 *
 * Build automation tool:
 * - Maven;
 *
 * Frameworks:
 * - Hibernate;
 * - Spring;
 *
 * Testing:
 * - JUnit library
 *
 * Date:
 * 17/10/2017
 *
 */

package domain.impl;

import dao.DishDao;
import dao.IngredientDao;
import dao.ProductDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        try {

            ApplicationContext appContext =

                    new FileSystemXmlApplicationContext("D:/BGU/module1/src/main/resources/META-INF/spring/BeanLocations.xml");

            /** Creating DAO objects**/
            ProductDao productDao = (ProductDao) appContext.getBean("productDao");
            IngredientDao ingredientDao = (IngredientDao) appContext.getBean("ingredientDao");
            DishDao dishDao = (DishDao) appContext.getBean("dishDao");

            /** insert **/

            /** Create Product Objects**/
            Product pork = new Product("Pork", 11.4, 49.3, 0, 489);                     // 500 гр
            Product rice = new Product("Rice", 8, 1, 76, 345);                              // 400 гр
            Product carrot = new Product("Carrot", 1.3, 0.1, 7, 34);                        // 250 гр
            Product onyon = new Product("Onyon", 1.3, 0, 4.3, 22);                              // 300 гр
            Product garlic = new Product("Garlic", 6.5, 0, 21.2, 110);                      // 50 гр
            Product naturalOil = new Product("Natural_Oil", 0, 99.9, 0, 899);              // 50 гр
            Product salt = new Product("Salt", 0, 0, 0, 0);                                 // 1 гр
            Product pepper = new Product("Pepper", 1.3, 0, 4.7, 24);                           // 1 гр

            /** Paste Products into the database**/
            productDao.save(pork);
            productDao.save(rice);
            productDao.save(carrot);
            productDao.save(onyon);
            productDao.save(garlic);
            productDao.save(naturalOil);
            productDao.save(salt);
            productDao.save(pepper);

            Ingredient[] ingredient = new Ingredient[8];

            /** Create Ingredients Objects**/
            ingredient[0] = new Ingredient("pork", productDao.findByProductName("Pork"), 500.0);
            ingredient[1] = new Ingredient("Rice", productDao.findByProductName("Rice"), 400.00);
            ingredient[2] = new Ingredient("Carrot", productDao.findByProductName("Carrot"), 250.00);
            ingredient[3] = new Ingredient("Onyon", productDao.findByProductName("Onyon"), 300.00);
            ingredient[4] = new Ingredient("Garlic", productDao.findByProductName("Garlic"), 50.00);
            ingredient[5] = new Ingredient("Natural_Oil", productDao.findByProductName("Natural_Oil"), 50.00);
            ingredient[6] = new Ingredient("Salt", productDao.findByProductName("Salt"), 1.0);
            ingredient[7] = new Ingredient("Pepper", productDao.findByProductName("Pepper"), 1.00);

            /** Paste Ingredients into the database**/
            for (int i = 0; i < ingredient.length; i++) {
                ingredientDao.save(ingredient[i]);
            }

            /** Create Dish Object**/
            Dish plov = new Dish("plov",ingredient);

            /** Paste Dish into the database**/
            dishDao.save(plov);

            /** select **/

            /** Getting from the database compisition of the Dish and evaluationg result meaning**/
            System.out.println("Блюдо - " + dishDao.findByDishName("plov").getName());
            System.out.println("Вес - " + dishDao.findByDishName("plov").getWeight());
            System.out.println("Белки - " + dishDao.findByDishName("plov").getProtein());
            System.out.println("Жиры - " + dishDao.findByDishName("plov").getFat());
            System.out.println("Углеводы - " + dishDao.findByDishName("plov").getCarbon());
            System.out.println("Каллории - " + dishDao.findByDishName("plov").getCalories());

            /** update **/
            /** Update information about Dish name in database**/
//            Dish d = dishDao.findByDishName("plov");
//            d.setName("NoviPlov");
//            dishDao.update(d);
//
            /** delete **/

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
