package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTypeDao;
import kodlamaio.hrms.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService {

	private JobTypeDao jobTypeDao;

	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao) {
		this.jobTypeDao = jobTypeDao;
	}

	@Override
	public DataResult<List<JobType>> getAll() {
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll(), "Data Listelendi..");
	}
}
