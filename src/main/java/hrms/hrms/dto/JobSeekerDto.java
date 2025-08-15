package hrms.hrms.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerDto {

	private Integer id;
	private String name;
	private String lastName;
	private String nationalId;
	private LocalDate birthDate;
	private String email;
}
