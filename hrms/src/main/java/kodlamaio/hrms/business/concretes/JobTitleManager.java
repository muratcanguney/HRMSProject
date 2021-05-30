package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.business.validation.JobTitle.isJobTitleAppropriate;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobTitle jobTitle) {

		if (!isJobTitleAppropriate.isVerified(jobTitle)) {
			return new ErrorResult(isJobTitleAppropriate.getMessage());
		}

		if (this.jobTitleDao.findByTitle(jobTitle.getTitle()).stream().count() > 0) {
			return new ErrorResult(jobTitle.getTitle() + " İş Pozisyonu Sistemde Kayıtlıdır..");
		}

		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş Pozisyonu Eklendi..");
	}
}
