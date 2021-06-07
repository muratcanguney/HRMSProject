package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCV;

public interface CandidateCVService {

	Result add(CandidateCV candidateCV);

	DataResult<List<CandidateCV>> findByCandidate_UserIdAndActiveTrue(int candidateId);
}
