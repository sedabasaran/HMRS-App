package hrms.hrms.core.concretes;

import org.springframework.stereotype.Service;

import hrms.hrms.core.abstracts.MailVerificationService;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.core.utilities.SuccessResult;

@Service
public class MailVerificatiınManager implements MailVerificationService{

	@Override
	public Result mailVerication(String email) {
		return new SuccessResult("Email verified.");
	}

}
