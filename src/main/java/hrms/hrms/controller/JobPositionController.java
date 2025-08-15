package hrms.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobPositonService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.dto.JobPositionDto;
import hrms.hrms.dto.request.CreateJobPositionRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jobPosition")
public class JobPositionController {

	private final JobPositonService jobPositonService;

	public JobPositionController(JobPositonService jobPositonService) {
		this.jobPositonService = jobPositonService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateJobPositionRequest request) {
		return jobPositonService.add(request);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobPositionDto>> getAll() {
		return jobPositonService.getAll();
	}

}
