package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.entities.concretes.JobPosition;

public interface JobPositonService {
	DataResult<List<JobPosition>> getAll();	
	Result add(JobPosition jobPosition);

}
