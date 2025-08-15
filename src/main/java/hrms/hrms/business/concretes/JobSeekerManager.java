package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobSeekerService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.ErrorResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.core.utilities.SuccessDataResult;
import hrms.hrms.core.utilities.SuccessResult;
import hrms.hrms.dto.JobSeekerDto;
import hrms.hrms.dto.request.JobSeekerRegisterRequest;
import hrms.hrms.entity.JobSeeker;
import hrms.hrms.repository.JobSeekerDao;

@Service
public class JobSeekerManager implements JobSeekerService {

	private final JobSeekerDao jobSeekerDao;
	private final PasswordEncoder passwordEncoder;

	public JobSeekerManager(JobSeekerDao jobSeekerDao, PasswordEncoder passwordEncoder) {
		this.jobSeekerDao = jobSeekerDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Result register(JobSeekerRegisterRequest request) {
		if (!request.getPassword().equals(request.getConfirmPassword())) {
			return new ErrorResult("Passwords do not match.");
		}
		if (jobSeekerDao.findByEmail(request.getEmail()).isPresent()) {
			return new ErrorResult("Email is already in use.");
		}
		if (jobSeekerDao.findByNationalId(request.getNationalId()).isPresent()) {
			return new ErrorResult("National ID is already in use.");
		}

		JobSeeker js = new JobSeeker();
		js.setName(request.getName());
		js.setLastName(request.getLastName());
		js.setNationalId(request.getNationalId());
		js.setBirthDate(request.getBirthDate());
		js.setEmail(request.getEmail());
		js.setPassword(passwordEncoder.encode(request.getPassword()));
		jobSeekerDao.save(js);

		return new SuccessResult("Job seeker registered.");
	}

	@Override
	public DataResult<List<JobSeekerDto>> getAll() {
		var list = jobSeekerDao.findAll().stream().map(j -> new JobSeekerDto(j.getId(), j.getName(), j.getLastName(),
				j.getNationalId(), j.getBirthDate(), j.getEmail())).toList();
		return new SuccessDataResult<>(list, "Job seekers listed.");
	}

}
