package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateEducationInformation;

public interface CandidateEducationInformationService {
	
	Result add(CandidateEducationInformation candidateEducationInformation);
	
	DataResult<List<CandidateEducationInformation>> findByCandidateCVE_Id(int CvId);
}
