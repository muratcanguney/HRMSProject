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

import kodlamaio.hrms.business.abstracts.CandidateWorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.CandidateWorkExperience;

@RestController
@RequestMapping(name = "api/candidateWorkExperiences/")
public class CandidateWorkExperiencesController {

	private CandidateWorkExperienceService candidateWorkExperienceService;

	@Autowired
	public CandidateWorkExperiencesController(CandidateWorkExperienceService candidateWorkExperienceService) {
		this.candidateWorkExperienceService = candidateWorkExperienceService;
	}

	@PostMapping("addCandidateWorkExperience")
	public ResponseEntity<?> add(@Valid @RequestBody CandidateWorkExperience candidateWorkExperience) {
		return ResponseEntity.ok(this.candidateWorkExperienceService.add(candidateWorkExperience));
	}

	@GetMapping("findByCvIdWorkEndDateSorted")
	public DataResult<List<CandidateWorkExperience>> findByCvIdWorkEndDateSorted(@RequestParam int CvId) {
		return this.candidateWorkExperienceService.findByCandidateCVW_Id(CvId);
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
