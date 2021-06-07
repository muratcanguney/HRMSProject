package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateEducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.CandidateEducationInformation;

@RestController
@RequestMapping(name = "api/candidateEducationInformations/")
public class CandidateEducationInformationsController {

	private CandidateEducationInformationService candidateEducationInformationService;

	@Autowired
	public CandidateEducationInformationsController(
			CandidateEducationInformationService candidateEducationInformationService) {
		this.candidateEducationInformationService = candidateEducationInformationService;
	}

	@PostMapping("addCandidateEducationInformation")
	public ResponseEntity<?> add(@Valid @RequestBody CandidateEducationInformation candidateEducationInformation) {
		return ResponseEntity.ok(this.candidateEducationInformationService.add(candidateEducationInformation));
	}

	@GetMapping("findByCvIdSchoolEndDateSorted")
	public DataResult<List<CandidateEducationInformation>> findByCvIdSchoolEndDateSorted(@RequestParam int CvId) {
		return this.candidateEducationInformationService.findByCandidateCVE_Id(CvId);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");
		return errors;
	}
}
