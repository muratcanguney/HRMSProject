package kodlamaio.hrms.business.validation.Employer;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

public class isEmployerAppropriate {

	private static Result isVerified = null;
	private static String message;

	public static boolean isVerified(Employer employer) {
		isVerified = nullControl(employer);

		if (!isVerified.isSuccess()) {
			message = isVerified.getMessage();
			return false;
		}

		isVerified = isAppropriateEmail(employer.getEmail(), employer.getWebAdress());
		if (!isVerified.isSuccess()) {
			message = isVerified.getMessage();
			return false;
		}

		message = isVerified.getMessage();
		return true;
	}

	private static Result nullControl(Employer employer) {

		if (employer.getEmail().equals("")) {
			return new ErrorResult("Mail Adresi Boş Geçilemez..");
		}

		if (employer.getPassword().equals("")) {
			return new ErrorResult("Şifre Boş Geçilemez..");
		}

		if (employer.getCompanyName().equals("")) {
			return new ErrorResult("Şirket Adı Boş Geçilemez..");
		}

		if (employer.getWebAdress().equals("")) {
			return new ErrorResult("Web Adresi Boş Geçilemez..");
		}
		return new SuccessResult("Boş Alan Kontrolü Yapıldı..");
	}

	private static Result isAppropriateEmail(String email, String webAdress) {
		String[] emailArr = email.split("@");
		String[] webAdressArr = webAdress.split("www.");

		if (!emailArr[1].equals(webAdressArr[1])) {
			return new ErrorResult("Web Adresi Uygun Değildir..");
		}
		return new SuccessResult("e-Mail Kontrolü Yapıldı..");
	}

	public static Result getIsVerified() {
		return isVerified;
	}

	public static String getMessage() {
		return message;
	}
}
