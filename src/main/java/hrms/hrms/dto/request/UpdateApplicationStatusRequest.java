package hrms.hrms.dto.request;

import hrms.hrms.entity.JobApplicationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class UpdateApplicationStatusRequest {
	
    @NotNull
    private Integer applicationId;
    @NotNull
    private JobApplicationStatus status; 
}
