package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.dto.JobApplicationDto;
import hrms.hrms.dto.request.ApplyJobRequest;
import hrms.hrms.dto.request.UpdateApplicationStatusRequest;

public interface JobApplicationService {

	Result apply(ApplyJobRequest request);

	Result updateStatus(UpdateApplicationStatusRequest request);

	DataResult<List<JobApplicationDto>> getByAdvertisement(Integer jobAdvertisementId);

	DataResult<List<JobApplicationDto>> getByJobSeeker(Integer jobSeekerId);
}
