package hrms.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.SytemEmployeeService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.entity.SystemEmployee;

@RestController
@RequestMapping("/api/hrController")
public class SystemEmployeeController {
	private SytemEmployeeService sytemEmployeeService;

	public SystemEmployeeController(SytemEmployeeService sytemEmployeeService) {
		super();
		this.sytemEmployeeService = sytemEmployeeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody SystemEmployee systemEmployee) {
		return this.sytemEmployeeService.add(systemEmployee);
	}

	@GetMapping("/getAll/systemEmployee")
	public DataResult<List<SystemEmployee>> getAll() {
		return this.sytemEmployeeService.getAll();

	}

}
