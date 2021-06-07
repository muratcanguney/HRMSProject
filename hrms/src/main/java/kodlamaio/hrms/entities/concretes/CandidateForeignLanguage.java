package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_foreign_languages")
public class CandidateForeignLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_id")
	private CandidateCV candidateCVL;

	@NotBlank(message = "Dil Adı Boş Geçilemez..")
	@Column(name = "language_name")
	private String languageName;

	@Min(1)
	@Max(5)
	@NotNull(message = "Dil Seviyesi Boş Geçilemez..")
	@Column(name = "language_level")
	private int languageLevel;
}
