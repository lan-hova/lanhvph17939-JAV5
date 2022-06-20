package ASM.beans;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import ASM.entities.Accounts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
	private int id;
	private Date createDate;
	@NotBlank(message = "Không được để trống !")
	private String address;
	private Accounts accounts;
}
