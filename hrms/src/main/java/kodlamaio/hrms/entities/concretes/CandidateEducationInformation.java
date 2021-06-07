package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_education_informations")
public class CandidateEducationInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_id")
	private CandidateCV candidateCVE;

	@NotBlank(message = "Okul Adı Boş Geçilemez..")
	@Column(name = "school_name")
	private String schoolName;

	@NotBlank(message = "Bölüm Boş Geçilemez..")
	@Column(name = "department")
	private String department;

	@NotNull(message = "Okula Başlangıç Tarihi Boş Geçilemez..")
	@Column(name = "school_start_date")
	private Date schoolStartDate;

	@Column(name = "school_end_date")
	private Date schoolEndDate;

	@Column(name = "graduation_status")
	private boolean graduationStatus;
}
