package domain.impl;
import javax.persistence.*;

/**class Product
 *
 * indicates ID for the database:
 * id.
 *
 * indicates Product name:
 * name.
 *
 * indicates the main fields with which calculations are made:
 * calories; protein; carbon; fat.
 *
 * Create "Product" table with columns equals fields.
 *
 */

@Entity
@Table(name = "Product")
public class Product implements domain.Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private Double calories;

    @Column(name = "protein")
    private Double protein;

    @Column(name = "carbon")
    private Double carbon;

    @Column(name = "fat")
    private Double fat;

    /**
     * Constructor.
     * @param name Product name.
     * @param protein per 100 grams of Product weight.
     * @param fat per 100 grams of Product weight.
     * @param carbon per 100 grams of Product weight.
     * @param calories per 100 grams of Product weight.
     */
    public Product(String name, double protein, double fat, double carbon, double calories) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbon = carbon;
        this.fat = fat;
    }

    /**
     * Constructor.
     * Default constructor
     */
    public Product() {
    }

    public String getName() {
        return name;
    }

    public Double getCalories() {
        return calories;
    }

    public Double getProtein() {
        return protein;
    }

    public Double getCarbon() {
        return carbon;
    }

    public Double getFat() {
        return fat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public void setCarbon(Double carbon) {
        this.carbon = carbon;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}