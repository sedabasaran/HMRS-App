package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.dto.CityDto;
import hrms.hrms.dto.request.CreateCityRequest;

public interface CityService {

	Result add(CreateCityRequest request);

	DataResult<List<CityDto>> getAll();

}
