package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.validation.Candidate.isCandidateAppropriate;
import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudinaryService;
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
	private CloudinaryService cloudinaryService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisService mernisService, UserDao userDao,
			EmailVerificationService emailVerificationService, CloudinaryService cloudinaryService) {
		this.candidateDao = candidateDao;
		this.mernisService = mernisService;
		this.userDao = userDao;
		this.emailVerificationService = emailVerificationService;
		this.cloudinaryService = cloudinaryService;
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

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi..");
	}

	@Override
	public Result imageAdd(int candidateId, MultipartFile file) {
		Candidate candidate = findByUserId(candidateId).getData();

		if (candidate == null) {
			return new ErrorResult("Kullanıcı Bulunamadı..");
		}

		Map result = (Map) this.cloudinaryService.uploadImageFile(file).getData();
		String imageUrl = result.get("url").toString();

		candidate.setImage(imageUrl);
		this.candidateDao.save(candidate);

		return new SuccessResult("Fotoğraf yüklendi..");
	}

	@Override
	public DataResult<Candidate> findByUserId(int userId) {

		return new SuccessDataResult<Candidate>(this.candidateDao.findByUserId(userId),
				"Kullanıcı Bilgileri Getirildi..");
	}
}
