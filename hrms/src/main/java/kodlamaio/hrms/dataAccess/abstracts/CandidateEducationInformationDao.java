package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateEducationInformation;

public interface CandidateEducationInformationDao extends JpaRepository<CandidateEducationInformation, Integer> {

	List<CandidateEducationInformation> findByCandidateCVE_Id(int CvId, Sort sort);
}
