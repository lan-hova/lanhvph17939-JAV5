// Generated with g9.

package ASM.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="accounts", indexes={@Index(name="accounts_username_IX", columnList="username", unique=true), @Index(name="accounts_email_IX", columnList="email", unique=true)})
public class Accounts implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @NotBlank(message = "Không được để trống !")
    @Column(unique=true, nullable=false, length=255)
    private String username;
    @NotBlank(message = "Không được để trống !")
    @Column(nullable=false, length=255)
    private String password;
    @NotBlank(message = "Không được để trống !")
    @Column(nullable=false, length=255)
    private String fullname;
    @NotBlank(message = "Không được để trống !")
    @Email(message = "Không đúng định dạng Email !")
    @Column(unique=true, nullable=false, length=255)
    private String email;
    @Column(length=255)
    private String photo;
    @NotNull(message = "Không được để trống !")
    @Column(nullable=false, precision=10)
    private int activated;
    @NotNull(message = "Không được để trống !")
    @Column(nullable=false, precision=10)
    private int admin;
    @OneToMany(mappedBy="accounts")
    private Set<Orders> orders;

    /** Default constructor. */
    public Accounts() {
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
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for fullname.
     *
     * @return the current value of fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Setter method for fullname.
     *
     * @param aFullname the new value for fullname
     */
    public void setFullname(String aFullname) {
        fullname = aFullname;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for photo.
     *
     * @return the current value of photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Setter method for photo.
     *
     * @param aPhoto the new value for photo
     */
    public void setPhoto(String aPhoto) {
        photo = aPhoto;
    }

    /**
     * Access method for activated.
     *
     * @return the current value of activated
     */
    public int getActivated() {
        return activated;
    }

    /**
     * Setter method for activated.
     *
     * @param aActivated the new value for activated
     */
    public void setActivated(int aActivated) {
        activated = aActivated;
    }

    /**
     * Access method for admin.
     *
     * @return the current value of admin
     */
    public int getAdmin() {
        return admin;
    }

    /**
     * Setter method for admin.
     *
     * @param aAdmin the new value for admin
     */
    public void setAdmin(int aAdmin) {
        admin = aAdmin;
    }

    /**
     * Access method for orders.
     *
     * @return the current value of orders
     */
    public Set<Orders> getOrders() {
        return orders;
    }

    /**
     * Setter method for orders.
     *
     * @param aOrders the new value for orders
     */
    public void setOrders(Set<Orders> aOrders) {
        orders = aOrders;
    }

    /**
     * Compares the key for this instance with another Accounts.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Accounts and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Accounts)) {
            return false;
        }
        Accounts that = (Accounts) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Accounts.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Accounts)) return false;
        return this.equalKeys(other) && ((Accounts)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Accounts |");
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
