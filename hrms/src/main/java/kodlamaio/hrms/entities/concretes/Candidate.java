package kodlamaio.hrms.entities.concretes;

import java.util.Date;
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
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "candidateCV" })
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Candidate extends User {

	@Column(name = "user_id", insertable = false, updatable = false)
	private int userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "image")
	private String image;

	@OneToMany(mappedBy = "candidate")
	private List<CandidateCV> candidateCV;
}
