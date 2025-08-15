package hrms.hrms.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyJobRequest {

	@NotNull
	private Integer jobAdvertisementId;
	@NotNull
	private Integer jobSeekerId;
}
