package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.SytemEmployeeService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.core.utilities.SuccessDataResult;
import hrms.hrms.core.utilities.SuccessResult;
import hrms.hrms.entity.SystemEmployee;
import hrms.hrms.repository.SystemEmployeeDao;

@Service
public class SystemEmployeeManager implements SytemEmployeeService {
	private SystemEmployeeDao systemEmployeeDao;

	public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
		super();
		this.systemEmployeeDao = systemEmployeeDao;
	}

	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		return new SuccessDataResult<List<SystemEmployee>>(this.systemEmployeeDao.findAll(), "system employee listed");
	}

	@Override
	public Result add(SystemEmployee systemEmployee) {
		this.systemEmployeeDao.save(systemEmployee);
		return new SuccessResult("System employee added.");
	}
}
