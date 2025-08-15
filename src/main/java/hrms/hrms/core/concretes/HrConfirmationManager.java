package hrms.hrms.core.concretes;

import org.springframework.stereotype.Service;
import hrms.hrms.core.abstracts.HrConfirmaitonService;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.core.utilities.SuccessResult;
import hrms.hrms.entity.Employer;

@Service
public class HrConfirmationManager implements HrConfirmaitonService {

	@Override
	public Result isConfirm(Employer employer) {
		return new SuccessResult("accepted");
	}

}
