package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_cv")
public class CandidateCV {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@Column(name = "github_account")
	private String githubAccount;

	@Column(name = "linkedin_account")
	private String linkedinAccount;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "active")
	private boolean active;

	@OneToMany(mappedBy = "candidateCVE")
	private List<CandidateEducationInformation> candidateEducationInformations;

	@OneToMany(mappedBy = "candidateCVL")
	private List<CandidateForeignLanguage> candidateForeignLanguage;

	@OneToMany(mappedBy = "candidateCVS")
	private List<CandidateSkill> candidateSkill;

	@OneToMany(mappedBy = "candidateCVW")
	private List<CandidateWorkExperience> candidateWorkExperience;
}
