package ASM.beans;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel {
	@NotBlank(message = "Không được để trống")
	private String email;
	@NotBlank(message = "Không được để trống")
	private String password;
}
