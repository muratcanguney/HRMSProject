package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerPhoneService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerPhoneDao;
import kodlamaio.hrms.entities.concretes.EmployerPhone;

@Service
public class EmployerPhoneManager implements EmployerPhoneService{
	
	private EmployerPhoneDao employerPhoneDao;

	@Autowired
	public EmployerPhoneManager(EmployerPhoneDao employerPhoneDao) {
		this.employerPhoneDao = employerPhoneDao;
	}

	@Override
	public Result add(EmployerPhone employerPhone) {
		this.employerPhoneDao.save(employerPhone);
		return new SuccessResult(employerPhone.getPhoneNumber() + " Numarası Eklenmiştir..");
	}

	@Override
	public DataResult<List<EmployerPhone>> findByEmployerP_UserId(int employerId) {
		return new SuccessDataResult<List<EmployerPhone>>(this.employerPhoneDao.findByEmployerP_UserId(employerId), "İşveren Telefonları Listelendi..");
	}

}
