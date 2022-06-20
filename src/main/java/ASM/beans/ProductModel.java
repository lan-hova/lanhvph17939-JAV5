package ASM.beans;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import ASM.entities.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	private int id;
	@NotBlank(message = "Không được để trống !")
	private String name;
	private String image;
	private int price;
	private Date createdDate;
	private int available;
	private Categories categories;
}
