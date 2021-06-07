package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "job_postings")
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@NotBlank(message = "İlan Başlığı Boş Geçilemez..")
	@Column(name = "post_title")
	private String postTitle;

	@NotBlank(message = "İlan Açıklaması Boş Geçilemez..")
	@Column(name = "job_description")
	private String jobDescription;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobTitle jobTitle;

	@NotNull(message = "Açık Pozisyon Sayısı Boş Geçilemez..")
	@Column(name = "open_position_count")
	private int openPositionCount;

	@Column(name = "release_date")
	private Date releaseDate;

	@Column(name = "application_deadline")
	private Date applicationDeadline;

	@Column(name = "active")
	private boolean active;
}
