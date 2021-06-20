package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingListDto;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult(jobPosting.getPostTitle() + " Başlıklı İlanınız Yayınlanmıştır..");
	}

	@Override
	public Result updateJobPostingStatus(int id, boolean isActive) {
		JobPosting jobPosting = this.jobPostingDao.getById(id);

		jobPosting.setActive(isActive);
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult(jobPosting.getPostTitle() + " Başlıklı İlanınızın Durumu Güncellenmiştir..");
	}

	@Override
	public DataResult<List<JobPostingListDto>> getJobPostingWithActiveTrue() {
		return new SuccessDataResult<List<JobPostingListDto>>(this.jobPostingDao.getJobPostingWithActiveTrue(),
				"Aktif İlanlar Listelendi..");
	}

	@Override
	public DataResult<List<JobPostingListDto>> getJobPostingWithActiveTrueAndReleaseDate(String releaseDate) {
		return new SuccessDataResult<List<JobPostingListDto>>(
				this.jobPostingDao.getJobPostingWithActiveTrueAndReleaseDate(releaseDate),
				releaseDate + " Tarihli Aktif İlanlar Listelendi..");
	}

	@Override
	public DataResult<List<JobPostingListDto>> getJobPostingWithActiveTrueAndEmployerId(int employerUserId) {
		return new SuccessDataResult<List<JobPostingListDto>>(
				this.jobPostingDao.getJobPostingWithActiveTrueAndEmployerId(employerUserId),
				"Şirkete Ait Aktif İlanlar Listelendi..");
	}

	@Override
	public DataResult<List<JobPostingListDto>> getJobPostingWithAdminConfirmFalse() {

		return new SuccessDataResult<List<JobPostingListDto>>(this.jobPostingDao.getJobPostingWithAdminConfirmFalse(),
				"Yönetici Onayı Bekleyen İlanlar Listelendi..");
	}
}
