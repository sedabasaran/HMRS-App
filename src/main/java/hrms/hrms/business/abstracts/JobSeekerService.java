package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.dto.JobSeekerDto;
import hrms.hrms.dto.request.JobSeekerRegisterRequest;

public interface JobSeekerService {
	
	Result register(JobSeekerRegisterRequest request);

	DataResult<List<JobSeekerDto>> getAll();

}
