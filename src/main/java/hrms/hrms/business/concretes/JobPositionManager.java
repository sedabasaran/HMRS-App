package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobPositonService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.ErrorResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.core.utilities.SuccessDataResult;
import hrms.hrms.core.utilities.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobPositonDao;
import hrms.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositonService {
	private JobPositonDao jobPositonDao;

	public JobPositionManager(JobPositonDao jobPositonDao) {
		super();
		this.jobPositonDao = jobPositonDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositonDao.findAll(), "job position is listed");
	}

	public Result isJobPositionExist(String jobTitle) {
		if (this.jobPositonDao.findByTitle(jobTitle) == null) {
			return new SuccessResult();
		} else {
			return new ErrorResult();
		}
	}

	@Override
	public Result add(JobPosition position) {
		if (isJobPositionExist(position.getTitle()).getSucces()) {
			this.jobPositonDao.save(position);
			return new SuccessResult("Pozisyon basariyla eklendi: " + position.getTitle());
		} else {
			return new ErrorResult("Bu pozisyon daha once eklenmistir: " + position.getTitle());
		}
	}

}
