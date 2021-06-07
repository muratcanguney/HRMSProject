package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateSkillService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSkillDao;
import kodlamaio.hrms.entities.concretes.CandidateSkill;

@Service
public class CandidateSkillManager implements CandidateSkillService {

	private CandidateSkillDao candidateSkillDao;

	@Autowired
	public CandidateSkillManager(CandidateSkillDao candidateSkillDao) {
		this.candidateSkillDao = candidateSkillDao;
	}

	@Override
	public Result add(CandidateSkill candidateSkill) {
		this.candidateSkillDao.save(candidateSkill);
		return new SuccessResult(candidateSkill.getSkillName() + " Beceri Bilgisi Kayıt Edildi..");
	}
}
