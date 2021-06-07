package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateWorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateWorkExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateWorkExperience;

@Service
public class CandidateWorkExperienceManager implements CandidateWorkExperienceService {

	private CandidateWorkExperienceDao candidateWorkExperienceDao;

	@Autowired
	public CandidateWorkExperienceManager(CandidateWorkExperienceDao candidateWorkExperienceDao) {
		this.candidateWorkExperienceDao = candidateWorkExperienceDao;
	}

	@Override
	public Result add(CandidateWorkExperience candidateWorkExperience) {
		this.candidateWorkExperienceDao.save(candidateWorkExperience);
		return new SuccessResult(candidateWorkExperience.getWorkplaceName() + " İş Deneyimi Kayıt Edildi..");
	}
	
	public DataResult<List<CandidateWorkExperience>> findByCandidateCVW_Id(int CvId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "workEndDate");
		return new SuccessDataResult<List<CandidateWorkExperience>>(candidateWorkExperienceDao.findByCandidateCVW_Id(CvId, sort), "Data Listelendi..");
	}
}
