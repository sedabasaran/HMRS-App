package hrms.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobSeekerService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.ErrorResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.core.utilities.SuccessDataResult;
import hrms.hrms.core.utilities.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	private JobSeekerDao jobSeekerDao;

	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	public Result isEmailUsed(String email) {
		if (this.jobSeekerDao.findByEmail(email) == null) {
			return new SuccessResult("");
		} else {
			return new ErrorResult("this email has been used is before.");
		}
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "jobseeker listed");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if (isEmailUsed(jobSeeker.getEmail()).getSucces()) {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("jobseeker is listed");
		} else {
			return new ErrorResult();
		}
	}

	public Result jobSeekerCheck(JobSeeker jobSeeker) {
		if (jobSeeker.getName() == null) {
			return new ErrorResult("name field cannot be left");
		} else if (jobSeeker.getLastName() == null) {
			return new ErrorResult("last name field cannot be left");
		} else if (jobSeeker.getBirthDate() < 1900 || jobSeeker.getBirthDate() > LocalDate.now().getYear()) {
			return new ErrorResult("Birth Date field cannot be left");
		} else if (jobSeeker.getEmail() == null) {
			return new ErrorResult("Email field cannot be left");
		} else if (jobSeeker.getPassword() == null) {
			return new ErrorResult("Password field cannot be left");
		}
		return new SuccessResult("Success");
	}

}
