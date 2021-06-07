package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	Result add(Candidate candidate);

	DataResult<List<Candidate>> getAll();
	
	DataResult<Candidate> findByUserId(int userId);
	
	Result imageAdd(int candidateId,  MultipartFile imageFile);
}
