package kodlamaio.hrms.core.utilities.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisService {

	Boolean checkIfCandidateRealPerson(Candidate candidate);
}
