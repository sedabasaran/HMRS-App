package hrms.hrms.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobAdvertisementRequest {

	@NotNull
	private Integer jobPositionId;

	@NotNull
	private Integer cityId;

	@NotNull
	private Integer employerId;

	@NotBlank
	@Size(min = 10, max = 5000)
	private String description;

	@NotNull
	@Positive
	private Integer openPositionCount;

	@PositiveOrZero
	private Integer minSalary;

	@PositiveOrZero
	private Integer maxSalary;

	@NotNull
	@Future
	private LocalDate applicationDeadline;
}
