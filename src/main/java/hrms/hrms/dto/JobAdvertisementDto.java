package hrms.hrms.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private Integer id;
	private String jobTitle;
	private String companyName;
	private String city;
	private Integer openPositionCount;
	private Integer minSalary;
	private Integer maxSalary;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;
	private boolean active;
}
