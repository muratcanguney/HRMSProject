package kodlamaio.hrms.business.validation.JobTitle;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobTitle;

public class isJobTitleAppropriate {

	private static Result isVerified = null;
	private static String message;

	public static boolean isVerified(JobTitle jobTitle) {
		isVerified = nullControl(jobTitle);

		if (!isVerified.isSuccess()) {
			message = isVerified.getMessage();
			return false;
		}

		message = isVerified.getMessage();
		return true;
	}

	private static Result nullControl(JobTitle jobTitle) {

		if (jobTitle.getTitle().equals("")) {
			return new ErrorResult("İş Tanımı Boş Geçilemez..");
		}
		return new SuccessResult("Boş Alan Kontrolü Yapıldı..");
	}

	public static Result getIsVerified() {
		return isVerified;
	}

	public static String getMessage() {
		return message;
	}
}
