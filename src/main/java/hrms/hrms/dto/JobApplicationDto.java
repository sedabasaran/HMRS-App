package hrms.hrms.dto;

import java.time.LocalDateTime;

import hrms.hrms.entity.JobApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationDto {

	private Integer id;
	private Integer jobAdvertisementId;
	private Integer jobSeekerId;
	private String jobTitle;
	private String employerCompanyName;
	private LocalDateTime applicationDate;
	private JobApplicationStatus status;
}
