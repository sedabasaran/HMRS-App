package hrms.hrms.core.abstracts;

import hrms.hrms.core.utilities.Result;
import hrms.hrms.entities.concretes.Employer;

public interface HrConfirmaitonService {
	public Result isConfirm(Employer employer);

}
