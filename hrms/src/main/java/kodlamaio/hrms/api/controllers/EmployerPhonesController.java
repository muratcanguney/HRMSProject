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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerPhoneService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.EmployerPhone;

@RestController
@RequestMapping("api/employerPhones/")
public class EmployerPhonesController {

	private EmployerPhoneService employerPhoneService;

	@Autowired
	public EmployerPhonesController(EmployerPhoneService employerPhoneService) {
		this.employerPhoneService = employerPhoneService;
	}

	@PostMapping("addEmployerPhone")
	public ResponseEntity<?> add(@Valid @RequestBody EmployerPhone employerPhone) {
		return ResponseEntity.ok(this.employerPhoneService.add(employerPhone));
	}

	@GetMapping("findByEmployerP_UserId")
	public DataResult<List<EmployerPhone>> findByEmployerP_UserId(int employerId) {
		return this.employerPhoneService.findByEmployerP_UserId(employerId);
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
