package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobPositonService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.ErrorResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.core.utilities.SuccessDataResult;
import hrms.hrms.core.utilities.SuccessResult;
import hrms.hrms.dto.JobPositionDto;
import hrms.hrms.dto.request.CreateJobPositionRequest;
import hrms.hrms.entity.JobPosition;
import hrms.hrms.repository.JobPositonDao;

@Service
public class JobPositionManager implements JobPositonService {

	private final JobPositonDao jobPositonDao;

	public JobPositionManager(JobPositonDao jobPositonDao) {
		this.jobPositonDao = jobPositonDao;
	}

	@Override
	public Result add(CreateJobPositionRequest request) {
		if (jobPositonDao.findByTitle(request.getTitle()).isPresent()) {
			return new ErrorResult("Job position already exists.");
		}
		JobPosition p = new JobPosition();
		p.setTitle(request.getTitle());
		jobPositonDao.save(p);
		return new SuccessResult("Job position created.");
	}

	@Override
	public DataResult<List<JobPositionDto>> getAll() {
		var list = jobPositonDao.findAll().stream().map(j -> new JobPositionDto(j.getId(), j.getTitle())).toList();
		return new SuccessDataResult<>(list, "Job positions listed.");
	}
}
