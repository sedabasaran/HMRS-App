package hrms.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobApplicationService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.dto.JobApplicationDto;
import hrms.hrms.dto.request.ApplyJobRequest;
import hrms.hrms.dto.request.UpdateApplicationStatusRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

	private final JobApplicationService jobApplicationService;

	public JobApplicationController(JobApplicationService jobApplicationService) {
		this.jobApplicationService = jobApplicationService;
	}

	@PostMapping("/apply")
	public Result apply(@Valid @RequestBody ApplyJobRequest request) {
		return jobApplicationService.apply(request);
	}

	@PostMapping("/update-status")
	public Result updateStatus(@Valid @RequestBody UpdateApplicationStatusRequest request) {
		return jobApplicationService.updateStatus(request);
	}

	@GetMapping("/by-advertisement/{adId}")
	public DataResult<List<JobApplicationDto>> getByAdvertisement(@PathVariable("adId") Integer adId) {
		return jobApplicationService.getByAdvertisement(adId);
	}

	@GetMapping("/by-jobseeker/{seekerId}")
	public DataResult<List<JobApplicationDto>> getByJobSeeker(@PathVariable("seekerId") Integer seekerId) {
		return jobApplicationService.getByJobSeeker(seekerId);
	}
}
