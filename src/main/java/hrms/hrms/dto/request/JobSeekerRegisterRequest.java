package hrms.hrms.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerRegisterRequest {

	@NotBlank
	@Size(min = 2, max = 100)
	private String name;

	@NotBlank
	@Size(min = 2, max = 100)
	private String lastName;

	@NotBlank
	@Size(min = 10, max = 20)
	private String nationalId;

	@NotNull
	@Past
	private LocalDate birthDate;

	@NotBlank
	@Email
	@Size(max = 180)
	private String email;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	@NotBlank
	@Size(min = 6, max = 100)
	private String confirmPassword;
}
