package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCV;

@RestController
@RequestMapping(name = "api/candidateCV/")
public class CandidateCVController {

	private CandidateCVService candidateCVService;

	@Autowired
	public CandidateCVController(CandidateCVService candidateCVService) {
		this.candidateCVService = candidateCVService;
	}

	@PostMapping("addCandidateCV")
	public Result add(@RequestBody CandidateCV candidateCV) {
		return this.candidateCVService.add(candidateCV);
	}

	@GetMapping("findByCandidateIdOfCv")
	public DataResult<List<CandidateCV>> findByCandidateIdOfCv(@RequestParam int candidateId) {
		return this.candidateCVService.findByCandidate_UserIdAndActiveTrue(candidateId);
	}
}
