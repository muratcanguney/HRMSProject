package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCVDao;
import kodlamaio.hrms.entities.concretes.CandidateCV;

@Service
public class CandidateCVManager implements CandidateCVService {

	private CandidateCVDao candidateCVDao;

	@Autowired
	public CandidateCVManager(CandidateCVDao candidateCVDao) {
		this.candidateCVDao = candidateCVDao;
	}

	@Override
	public Result add(CandidateCV candidateCV) {
		this.candidateCVDao.save(candidateCV);
		return new SuccessResult(candidateCV.getCandidate().getFirstName() + " "
				+ candidateCV.getCandidate().getLastName() + " Kullanıcı CV Oluşturuldu..");
	}

	@Override
	public DataResult<List<CandidateCV>> findByCandidate_UserIdAndActiveTrue(int candidateId) {
		return new SuccessDataResult<List<CandidateCV>>(this.candidateCVDao.findByCandidate_UserIdAndActiveTrue(candidateId));
	}
}
