package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateSkill;

public interface CandidateSkillDao extends JpaRepository<CandidateSkill, Integer> {

}
