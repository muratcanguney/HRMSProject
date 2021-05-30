package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.validation.Employer.isEmployerAppropriate;
import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao,
			EmailVerificationService emailVerificationService) {
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public Result add(Employer employer) {

		if (!isEmployerAppropriate.isVerified(employer)) {
			return new ErrorResult(isEmployerAppropriate.getMessage());
		}

		if (this.userDao.findByEmail(employer.getEmail()).stream().count() > 0) {
			return new ErrorResult(employer.getEmail() + " Adresi Sistemde Kayıtlıdır. Lütfen Giriş Yapınız..");
		}

		if (this.emailVerificationService.emailVerify(employer.getEmail())) {
			this.employerDao.save(employer);
		}

		return new SuccessResult(employer.getEmail() + " Adresi Doğrulaması Yapıldı. Kaydınız Tamamlanmıştır..");
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi");
	}
}
