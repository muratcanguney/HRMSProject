package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingListDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingListDto(p.id, e.companyName, j.title, p.openPositionCount, p.releaseDate, p.applicationDeadline) From JobPosting p Inner Join p.employer e Inner Join p.jobTitle j where p.active = true")
	List<JobPostingListDto> getJobPostingWithActiveTrue();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingListDto(p.id, e.companyName, j.title, p.openPositionCount, p.releaseDate, p.applicationDeadline) From JobPosting p Inner Join p.employer e Inner Join p.jobTitle j where p.active = true and to_Char(p.releaseDate, 'DD-MM-YYYY') =:releaseDate")
	List<JobPostingListDto> getJobPostingWithActiveTrueAndReleaseDate(String releaseDate);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingListDto(p.id, e.companyName, j.title, p.openPositionCount, p.releaseDate, p.applicationDeadline) From JobPosting p Inner Join p.employer e Inner Join p.jobTitle j where p.active = true and e.userId =:employerUserId")
	List<JobPostingListDto> getJobPostingWithActiveTrueAndEmployerId(int employerUserId);
}
	