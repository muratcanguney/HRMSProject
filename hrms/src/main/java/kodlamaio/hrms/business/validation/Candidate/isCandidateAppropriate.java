package kodlamaio.hrms.business.validation.Candidate;

import java.util.Date;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;

public class isCandidateAppropriate {

	private static Result isVerified = null;
	private static String message;

	public static boolean isVerified(Candidate candidate) {
		isVerified = nullControl(candidate);

		if (!isVerified.isSuccess()) {
			message = isVerified.getMessage();
			return false;
		}

		isVerified = birthDateControl(candidate.getBirthDate());
		if (!isVerified.isSuccess()) {
			message = isVerified.getMessage();
			return false;
		}
		message = isVerified.getMessage();
		return true;
	}

	private static Result nullControl(Candidate candidate) {

		if (candidate.getEmail().equals("")) {
			return new ErrorResult("Mail Adresi Boş Geçilemez..");
		}

		if (candidate.getPassword().equals("")) {
			return new ErrorResult("Şifre Boş Geçilemez..");
		}

		if (candidate.getFirstName().equals("")) {
			return new ErrorResult("Kullanıcı Adı Boş Geçilemez..");
		}

		if (candidate.getLastName().equals("")) {
			return new ErrorResult("Kullanıcı Soyadı Boş Geçilemez..");
		}

		if (candidate.getIdentityNumber().equals("")) {
			return new ErrorResult("Kullanıcı Kimlik Numarası Boş Geçilemez..");
		}

		if (candidate.getBirthDate() == null) {
			return new ErrorResult("Kullanıcı Doğum Tarihi Boş Geçilemez..");
		}

		if (candidate.getIdentityNumber().length() != 11) {
			return new ErrorResult("Kullanıcı Kimlik Numarası Algoritmaya Uymamaktadır..");
		}
		return new SuccessResult("Boş Alan Kontrolü Yapıldı..");
	}

	private static Result birthDateControl(Date birthDate) {
		Date currentDate = new Date();

		if (birthDate.after(currentDate)) {
			return new ErrorResult("Kullanıcı Doğum Tarihi Günün Tarihinden İleride Olamaz !!.");
		}
		return new SuccessResult("Doğum Tarihi Kontrolü Yapıldı..");
	}

	public static Result getIsVerified() {
		return isVerified;
	}

	public static String getMessage() {
		return message;
	}
}
