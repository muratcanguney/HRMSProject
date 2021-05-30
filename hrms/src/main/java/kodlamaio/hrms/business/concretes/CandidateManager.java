package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.validation.Candidate.isCandidateAppropriate;
import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private MernisService mernisService;
	private UserDao userDao;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisService mernisService, UserDao userDao,
			EmailVerificationService emailVerificationService) {
		this.candidateDao = candidateDao;
		this.mernisService = mernisService;
		this.userDao = userDao;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public Result add(Candidate candidate) {

		if (!isCandidateAppropriate.isVerified(candidate)) {
			return new ErrorResult(isCandidateAppropriate.getMessage());
		}

		if (this.userDao.findByEmail(candidate.getEmail()).stream().count() > 0) {
			return new ErrorResult(candidate.getEmail() + " Adresi Sistemde Kayıtlıdır. Lütfen Giriş Yapınız..");
		}

		if (this.candidateDao.findByIdentityNumber(candidate.getIdentityNumber()).stream().count() > 0) {
			return new ErrorResult(
					candidate.getIdentityNumber() + " Kimlik Numarası Sistemde Kayıtlıdır. Lütfen Giriş Yapınız..");
		}

		/*
		 * if (!this.mernisService.checkIfCandidateRealPerson(candidate)) { return new
		 * ErrorResult("Mernis Doğrulaması Başarısız. Lütfen Kimlik Bilgilerinizi Kontrol Ediniz.."
		 * ); }
		 */

		if (this.emailVerificationService.emailVerify(candidate.getEmail())) {
			this.candidateDao.save(candidate);
		}
		return new SuccessResult(candidate.getEmail() + " Adresi Doğrulaması Yapıldı. Kaydınız Tamamlanmıştır..");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi");
	}
}
