package hrms.hrms.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRegisterRequest {

	@NotBlank
	@Size(min = 2, max = 200)
	private String companyName;

	@NotBlank
	@Size(max = 255)
	private String companyWebPage;

	@NotBlank
	@Email
	@Size(max = 180)
	private String email;

	@NotBlank
	@Size(min = 10, max = 30)
	private String phoneNumber;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	@NotBlank
	@Size(min = 6, max = 100)
	private String confirmPassword;
}
