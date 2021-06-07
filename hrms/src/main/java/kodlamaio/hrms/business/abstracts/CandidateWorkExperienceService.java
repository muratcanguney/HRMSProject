package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateWorkExperience;

public interface CandidateWorkExperienceService {

	Result add(CandidateWorkExperience candidateWorkExperience);

	DataResult<List<CandidateWorkExperience>> findByCandidateCVW_Id(int CvId);
}
