package hrms.hrms.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class CreateJobPositionRequest {
	
    @NotBlank(message = "Job position title cannot be blank.")
    @Size(min = 2, max = 150, message = "Job position title must be between 2 and 150 characters.")
    private String title;
}
