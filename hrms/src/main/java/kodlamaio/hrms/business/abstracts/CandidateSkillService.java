package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSkill;

public interface CandidateSkillService {

	Result add(CandidateSkill candidateSkill);
}
