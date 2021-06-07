package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateForeignLanguage;

@Service
public class CandidateForeignLanguageManager implements CandidateForeignLanguageService {

	private CandidateForeignLanguageDao candidateForeignLanguageDao;

	@Autowired
	public CandidateForeignLanguageManager(CandidateForeignLanguageDao candidateForeignLanguageDao) {
		this.candidateForeignLanguageDao = candidateForeignLanguageDao;
	}

	@Override
	public Result add(CandidateForeignLanguage candidateForeignLanguage) {
		this.candidateForeignLanguageDao.save(candidateForeignLanguage);
		return new SuccessResult(candidateForeignLanguage.getLanguageName() + " Dil Bilgisi Kayıt Edildi..");
	}
}
