package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobPostings" })
public class Employer extends User {
	
	@Column(name = "user_id", insertable = false, updatable = false)
	private int userId;
	
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_adress")
	private String webAdress;

	@OneToMany(mappedBy = "employerP")
	private List<EmployerPhone> employerPhones;

	@OneToMany(mappedBy = "employer")
	private List<JobPosting> jobPostings;
}
