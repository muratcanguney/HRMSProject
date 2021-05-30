package kodlamaio.hrms.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailVerificationService;

@Service
public class EmailVerificationManager implements EmailVerificationService {

	@Override
	public Boolean emailVerify(String email) {

		return true;
	}
}
