package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTimeDao;
import kodlamaio.hrms.entities.concretes.JobTime;

@Service
public class JobTimeManager implements JobTimeService {

	private JobTimeDao jobTimeDao;

	@Autowired
	public JobTimeManager(JobTimeDao jobTimeDao) {
		this.jobTimeDao = jobTimeDao;
	}

	@Override
	public DataResult<List<JobTime>> getAll() {
		return new SuccessDataResult<List<JobTime>>(this.jobTimeDao.findAll(), "Data Listelendi..");
	}
}
