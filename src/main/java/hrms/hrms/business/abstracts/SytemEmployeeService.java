package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.entity.SystemEmployee;

public interface SytemEmployeeService {
	
	DataResult<List<SystemEmployee>> getAll();

	Result add(SystemEmployee systemEmployee);

}
