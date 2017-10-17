package domain.impl;
import javax.persistence.*;

/**class Ingredients
 *
 * indicates ID for the database:
 * id.
 *
 * indicates Ingredient name:
 * name.
 *
 * calculate (calories; protein; carbon; fat)
 * for a given weight for an ingredient.
 *
 * Create "Ingredient" table with columns equals fields.
 * Connect "Product" table with @ManyToOne relationship
 *
 */
@Entity
@Table(name = "Ingredients")
public class Ingredient implements domain.Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "ingredient_name")
    private String name;

    /**
     * Constructor.
     * @param name Product name.
     * @param product getting object.
     * @param weight set Ingredient weight.
     */
    public Ingredient(String name, Product product, Double weight) {
        this.name = name;
        this.product = product;
        this.weight = weight;
    }

    /**
     * Constructor.
     * Default constructor
     */
    public Ingredient() {
    }

    public Product getProduct() {
        return product;
    }

    public Double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns calories for a given weight by formula: (product*weight/100)
     * @returns Ingredient calories
     */
    public Double getCalories() {
        return product.getCalories() * weight / 100;
    }

    /**
     * Returns calories for a given weight by formula: (product*weight/100)
     * @returns Ingredient protein
     */
    public Double getProtein() {
        return product.getProtein() * weight / 100;
    }

    /**
     * Returns calories for a given weight by formula: (product*weight/100)
     * @returns Ingredient carbon
     */
    public Double getCarbon() {
        return product.getCarbon() * weight / 100;
    }

    /**
     * Returns calories for a given weight by formula: (product*weight/100)
     * @returns Ingredient fat
     */
    public Double getFat() {
        return product.getFat() * weight / 100;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

