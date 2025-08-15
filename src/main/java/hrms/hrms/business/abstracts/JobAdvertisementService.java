package hrms.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import hrms.hrms.core.utilities.DataResult;
import hrms.hrms.core.utilities.Result;
import hrms.hrms.dto.JobAdvertisementDto;
import hrms.hrms.dto.request.CreateJobAdvertisementRequest;

public interface JobAdvertisementService {

	Result add(CreateJobAdvertisementRequest request);

	DataResult<List<JobAdvertisementDto>> getAll();

	DataResult<List<JobAdvertisementDto>> getActive();

	DataResult<List<JobAdvertisementDto>> getActiveByEmployer(Integer employerId);

	DataResult<List<JobAdvertisementDto>> getSortedByDeadlineAsc();

	DataResult<List<JobAdvertisementDto>> getByDeadline(LocalDate date);
}
