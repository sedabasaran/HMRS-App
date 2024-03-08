package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobPositonService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobPosition")
public class JobPositionController {
	
	private JobPositonService jobPositonService;

	public JobPositionController(JobPositonService jobPositonService) {
		super();
		this.jobPositonService = jobPositonService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobPosition>> getAll() {
		return this.jobPositonService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositonService.add(jobPosition);
	}
	

}
