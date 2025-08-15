package hrms.hrms.core.abstracts;

import hrms.hrms.core.utilities.Result;

public interface MailVerificationService {
	
	Result mailVerication(String email);

}
