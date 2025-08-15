package hrms.hrms.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobAdvertisementService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.dto.JobAdvertisementDto;
import hrms.hrms.dto.request.CreateJobAdvertisementRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jobPost")
public class JobAdvertisementController {

	private final JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateJobAdvertisementRequest request) {
		return jobAdvertisementService.add(request);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisementDto>> getAll() {
		return jobAdvertisementService.getAll();
	}

	@GetMapping("/active")
	public DataResult<List<JobAdvertisementDto>> getActive() {
		return jobAdvertisementService.getActive();
	}

	@GetMapping("/active/by-employer")
	public DataResult<List<JobAdvertisementDto>> getActiveByEmployer(@RequestParam Integer employerId) {
		return jobAdvertisementService.getActiveByEmployer(employerId);
	}

	@GetMapping("/sorted-by-deadline")
	public DataResult<List<JobAdvertisementDto>> getSortedByDeadlineAsc() {
		return jobAdvertisementService.getSortedByDeadlineAsc();
	}

	@GetMapping("/by-deadline")
	public DataResult<List<JobAdvertisementDto>> getByDeadline(@RequestParam LocalDate date) {
		return jobAdvertisementService.getByDeadline(date);
	}
}