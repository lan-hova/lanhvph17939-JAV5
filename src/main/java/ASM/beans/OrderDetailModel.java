package ASM.beans;

import ASM.entities.Orders;
import ASM.entities.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailModel {
	private Orders orders;
	private Products products;
	private double price;
	private int quantity;
}
