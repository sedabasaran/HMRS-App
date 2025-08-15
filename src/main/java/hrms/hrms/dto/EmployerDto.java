package hrms.hrms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {
	
	private Integer id;
	private String companyName;
	private String companyWebPage;
	private String email;
	private String phoneNumber;
}
