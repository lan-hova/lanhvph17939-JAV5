// Generated with g9.

package ASM.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotBlank;


@Entity(name="products")
public class Products implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @NotBlank(message = "Không được để trống !")
    @Column(nullable=false, length=255)
    private String name;
    @Column(length=255)
    private String image;
    @Column(nullable=false, precision=10)
    private int price;
    @Column(name="created_date", nullable=false)
    private Date createdDate;
    @Column(nullable=false, precision=10)
    private int available;
    @ManyToOne(optional=false)
    @JoinColumn(name="category_id", nullable=false)
    private Categories categories;
    @OneToMany(mappedBy="products")
    private Set<OrderDetails> orderDetails;

    /** Default constructor. */
    public Products() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for image.
     *
     * @return the current value of image
     */
    public String getImage() {
        return image;
    }

    /**
     * Setter method for image.
     *
     * @param aImage the new value for image
     */
    public void setImage(String aImage) {
        image = aImage;
    }

    /**
     * Access method for price.
     *
     * @return the current value of price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter method for price.
     *
     * @param aPrice the new value for price
     */
    public void setPrice(int aPrice) {
        price = aPrice;
    }

    /**
     * Access method for createdDate.
     *
     * @return the current value of createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Setter method for createdDate.
     *
     * @param aCreatedDate the new value for createdDate
     */
    public void setCreatedDate(Date aCreatedDate) {
        createdDate = aCreatedDate;
    }

    /**
     * Access method for available.
     *
     * @return the current value of available
     */
    public int getAvailable() {
        return available;
    }

    /**
     * Setter method for available.
     *
     * @param aAvailable the new value for available
     */
    public void setAvailable(int aAvailable) {
        available = aAvailable;
    }

    /**
     * Access method for categories.
     *
     * @return the current value of categories
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * Setter method for categories.
     *
     * @param aCategories the new value for categories
     */
    public void setCategories(Categories aCategories) {
        categories = aCategories;
    }

    /**
     * Access method for orderDetails.
     *
     * @return the current value of orderDetails
     */
    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    /**
     * Setter method for orderDetails.
     *
     * @param aOrderDetails the new value for orderDetails
     */
    public void setOrderDetails(Set<OrderDetails> aOrderDetails) {
        orderDetails = aOrderDetails;
    }

    /**
     * Compares the key for this instance with another Products.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Products and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Products)) {
            return false;
        }
        Products that = (Products) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Products.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Products)) return false;
        return this.equalKeys(other) && ((Products)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Products |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
