package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.dto.EmployerDto;
import hrms.hrms.dto.request.EmployerRegisterRequest;

public interface EmployerService {

	Result register(EmployerRegisterRequest request);

	DataResult<List<EmployerDto>> getAll();

}
