package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping(name = "api/candidates/")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@PostMapping(name = "add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}

	@GetMapping(name = "getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}
	
	@PostMapping("imageAdd")
	public Result imageAdd(@RequestParam int candidateId, @RequestBody MultipartFile file) {
		return this.candidateService.imageAdd(candidateId, file);
	}
}
