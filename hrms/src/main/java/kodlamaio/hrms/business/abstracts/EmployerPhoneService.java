package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerPhone;

public interface EmployerPhoneService {

	Result add(EmployerPhone employerPhone);

	DataResult<List<EmployerPhone>> findByEmployerP_UserId(int employerId);
}
