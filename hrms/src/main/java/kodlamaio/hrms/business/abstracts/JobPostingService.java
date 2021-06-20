package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingListDto;

public interface JobPostingService {

	Result add(JobPosting jobPosting);
	
	Result updateJobPostingStatus(int id, boolean isActive);

	DataResult<List<JobPostingListDto>> getJobPostingWithActiveTrue();

	DataResult<List<JobPostingListDto>> getJobPostingWithActiveTrueAndReleaseDate(String releaseDate);
	
	DataResult<List<JobPostingListDto>> getJobPostingWithActiveTrueAndEmployerId(int employerUserId);
	
	DataResult<List<JobPostingListDto>> getJobPostingWithAdminConfirmFalse();
}
