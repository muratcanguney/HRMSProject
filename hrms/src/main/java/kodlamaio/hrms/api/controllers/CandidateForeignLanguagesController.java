package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.CandidateForeignLanguage;

@RestController
@RequestMapping(name = "api/candidateForeignLanguagesController/")
public class CandidateForeignLanguagesController {

	private CandidateForeignLanguageService candidateForeignLanguageService;

	@Autowired
	public CandidateForeignLanguagesController(CandidateForeignLanguageService candidateForeignLanguageService) {
		this.candidateForeignLanguageService = candidateForeignLanguageService;
	}

	@PostMapping("addCandidateForeignLanguage")
	public ResponseEntity<?> add(@Valid @RequestBody CandidateForeignLanguage candidateForeignLanguage) {
		return ResponseEntity.ok(this.candidateForeignLanguageService.add(candidateForeignLanguage));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Do??rulama Hatalar??");
		return errors;
	}
}
