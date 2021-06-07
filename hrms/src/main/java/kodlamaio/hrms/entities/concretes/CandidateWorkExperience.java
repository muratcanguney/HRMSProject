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
@Table(name = "candidate_work_experiences")
public class CandidateWorkExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_id")
	private CandidateCV candidateCVW;

	@NotBlank(message = "İş Yeri Adı Boş Geçilemez..")
	@Column(name = "workplace_name")
	private String workplaceName;

	@NotBlank(message = "İş Pozisyonu Boş Geçilemez..")
	@Column(name = "job_position")
	private String jobPosition;

	@NotNull(message = "İşe Başlangıç Tarihi Boş Geçilemez..")
	@Column(name = "work_start_date")
	private Date workStartDate;

	@Column(name = "work_end_date")
	private Date workEndDate;

	@Column(name = "working_status")
	private boolean workingStatus;
}
