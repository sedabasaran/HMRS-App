package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.dto.JobPositionDto;
import hrms.hrms.dto.request.CreateJobPositionRequest;

public interface JobPositonService {
	
	Result add(CreateJobPositionRequest request);

	DataResult<List<JobPositionDto>> getAll();

}
