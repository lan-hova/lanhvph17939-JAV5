package ASM.beans;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {
	private int id;
	@NotBlank(message = "Không được để trống !")
	private String name;
}
