package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.abstracts.HrConfirmaitonService;
import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.ErrorResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.core.utilities.SuccessDataResult;
import hrms.hrms.core.utilities.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private HrConfirmaitonService hrConfirmaitonService;

	public EmployerManager(EmployerDao employerDao, HrConfirmaitonService hrConfirmaitonService) {
		super();
		this.employerDao = employerDao;
		this.hrConfirmaitonService = hrConfirmaitonService;
	}

	public Result isEmailUsed(String email) {
		if (this.employerDao.findByEmail(email) == null) {
			return new SuccessResult("ok!");
		} else {
			return new ErrorResult("This email has been used is before");
		}
	}

	public Result isRePasswordCheck(String password) {
		if (this.employerDao.findByPassword(password).getRePassword().equals(password)) {
			return new SuccessResult();
		} else {
			return new ErrorResult("This password has been used is before");
		}
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employer listed");
	}

	@Override
	public Result add(Employer employer) {

		if (!this.hrConfirmaitonService.isConfirm(employer).getSucces()) {
			return new ErrorResult("H.R tarafından onaylanmadı");
		} else if (isEmailUsed(employer.getEmail()).getSucces()) {
			this.employerDao.save(employer);
			return new SuccessResult("employer kaydedildi" + employer.getCompanyName());
		} else {
			return new ErrorResult(isEmailUsed(employer.getEmail()).getMessage());
		}
	}

	public Result employerCheck(Employer employer) {
		if (employer.getCompanyName() == null) {
			return new ErrorResult("Name field cannot be left blank");
		} else if (employer.getCompanyWebPage() == null) {
			return new ErrorResult("Company web page field cannot be left blank");
		} else if (employer.getEmail() == null) {
			return new ErrorResult("Email field cannot be left blanked");
		} else if (employer.getPhoneNumber() == null) {
			return new ErrorResult("Phone number field cannot be left blanked");
		} else if (employer.getRePassword() == null) {
			return new ErrorResult("Password field cannot be left blanked");
		}
		return new SuccessResult("register is success");
	}
}
