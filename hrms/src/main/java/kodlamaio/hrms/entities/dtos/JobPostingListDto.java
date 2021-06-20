package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingListDto {

	private int id;
	private String companyName;
	private String jobTitleName;
	private int openPositionCount;
	private String releaseDate;
	private String applicationDeadline;
	private boolean active;
	private String jobTypeName;
	private String jobTimeName;
	private boolean confirmed;
	private String city;
}
