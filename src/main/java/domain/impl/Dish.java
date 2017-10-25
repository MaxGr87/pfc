package domain.impl;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**class Dish
 *
 * indicates ID for the database:
 * id.
 *
 * indicates Ingredient name:
 * name.
 *
 * calculate (calories; protein; carbon; fat)
 * for a given result meaning.
 *
 * Create "Dish" table with columns equals fields.
 * Connect "Ingredients" table with @ManyToMany relationship
 *
 */
@Entity
@Table(name = "Dish")
public class Dish implements domain.Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "DishIngredient",
            joinColumns = @JoinColumn(
                    name = "Dish",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "Ingredients",
                    referencedColumnName = "id"
            )
    )
    private Collection<Ingredient> ingredients;

    @Column(name = "dish_name")
    private String name;

    /**
     * Constructor.
     * @param name Product name.
     * @param ingredients getting receives any number of
     *                    ingredients one at a time and placing them in an List.
     */
    public Dish (String name, Ingredient... ingredients) {
        this.name = name;
        this.ingredients = Arrays.asList(ingredients);
    }

    /**
     * Constructor.
     * Default constructor
     */
    public Dish() {
    }

    public String getName() {

        return name;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Returns full weight of a Dish
     * @returns Dish weight
     */
    public Double getWeight() {
        Double weight = 0.0;
        for (Ingredient ingredient : ingredients) {
            weight =  weight + ingredient.getWeight();
        }
        return weight;
    }

    /**
     * Returns total amount of calories of a Dish
     * @returns Dish calories
     */
    public Double getCalories() {
         Double calories = 0.0;
        for (Ingredient ingredient : ingredients) {
            calories = calories + ingredient.getCalories();
        }
        return calories;
    }

    /**
     * Returns total amount of protein of a Dish
     * @returns Dish protein
     */
    public Double getProtein() {
        Double protein = 0.0;
        for (Ingredient ingredient : ingredients) {
            protein = protein + ingredient.getProtein();
        }
        return protein;
    }

    /**
     * Returns total amount of carbon of a Dish
     * @returns Dish carbon
     */
    public Double getCarbon() {
        Double carbon = 0.0;
        for (Ingredient ingredient : ingredients) {
            carbon = carbon + ingredient.getCarbon();
        }
        return carbon;
    }

    /**
     * Returns total amount of fat of a Dish
     * @returns Dish fat
     */
    public Double getFat() {
        Double fat = 0.0;
        for (Ingredient ingredient : ingredients) {
            fat = fat + ingredient.getFat();
        }
        return fat;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
