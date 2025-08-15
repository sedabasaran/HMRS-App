package hrms.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.CityService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.dto.CityDto;
import hrms.hrms.dto.request.CreateCityRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	private final CityService cityService;

	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCityRequest request) {
		return cityService.add(request);
	}

	@GetMapping("/getAll")
	public DataResult<List<CityDto>> getAll() {
		return cityService.getAll();
	}

}
