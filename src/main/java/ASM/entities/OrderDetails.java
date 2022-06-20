// Generated with g9.

package ASM.entities;

import java.io.Serializable;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="order_details")
public class OrderDetails implements Serializable {

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
    @ManyToOne(optional=false)
    @JoinColumn(name="order_id", nullable=false)
    private Orders orders;

    @Column(nullable=false, precision=12)
    private double price;

    @Column(nullable=false, precision=10)
    private int quantity;
    @ManyToOne(optional=false)
    @JoinColumn(name="product_id", nullable=false)
    private Products products;


}
