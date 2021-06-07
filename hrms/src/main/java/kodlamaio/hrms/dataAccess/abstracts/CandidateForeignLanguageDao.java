package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateForeignLanguage;

public interface CandidateForeignLanguageDao extends JpaRepository<CandidateForeignLanguage, Integer> {

}
