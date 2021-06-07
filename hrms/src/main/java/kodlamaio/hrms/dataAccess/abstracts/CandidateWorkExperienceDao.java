package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateWorkExperience;

public interface CandidateWorkExperienceDao extends JpaRepository<CandidateWorkExperience, Integer> {

	List<CandidateWorkExperience> findByCandidateCVW_Id(int CvId, Sort sort);
}
