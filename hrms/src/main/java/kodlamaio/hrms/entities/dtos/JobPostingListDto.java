package kodlamaio.hrms.entities.dtos;

import java.util.Date;

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
	private Date releaseDate;
	private Date applicationDeadline;
}
