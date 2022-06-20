// Generated with g9.

package ASM.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="orders")
public class Orders implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/** Primary key. */
    protected static final String PK = "id";



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(name="create_date", nullable=false)
    private Date createDate;

    @Column(nullable=false, length=255)
    private String address;
    @ManyToOne(optional=false)
    @JoinColumn(name="user_id", nullable=false)
    private Accounts accounts;

    /** Default constructor. */
    public Orders() {
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
     * Access method for createDate.
     *
     * @return the current value of createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Setter method for createDate.
     *
     * @param aCreateDate the new value for createDate
     */
    public void setCreateDate(Date aCreateDate) {
        createDate = aCreateDate;
    }

    /**
     * Access method for address.
     *
     * @return the current value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for address.
     *
     * @param aAddress the new value for address
     */
    public void setAddress(String aAddress) {
        address = aAddress;
    }

    /**
     * Access method for accounts.
     *
     * @return the current value of accounts
     */
    public Accounts getAccounts() {
        return accounts;
    }

    /**
     * Setter method for accounts.
     *
     * @param aAccounts the new value for accounts
     */
    public void setAccounts(Accounts aAccounts) {
        accounts = aAccounts;
    }

    /**
     * Compares the key for this instance with another Orders.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Orders and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Orders)) {
            return false;
        }
        Orders that = (Orders) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Orders.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Orders)) return false;
        return this.equalKeys(other) && ((Orders)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Orders |");
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
