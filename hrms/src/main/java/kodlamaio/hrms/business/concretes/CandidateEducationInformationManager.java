package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateEducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateEducationInformationDao;
import kodlamaio.hrms.entities.concretes.CandidateEducationInformation;

@Service
public class CandidateEducationInformationManager implements CandidateEducationInformationService {

	private CandidateEducationInformationDao candidateEducationInformationDao;

	@Autowired
	public CandidateEducationInformationManager(CandidateEducationInformationDao candidateEducationInformationDao) {
		this.candidateEducationInformationDao = candidateEducationInformationDao;
	}

	@Override
	public Result add(CandidateEducationInformation candidateEducationInformation) {
		this.candidateEducationInformationDao.save(candidateEducationInformation);
		return new SuccessResult(candidateEducationInformation.getSchoolName() + " Okul Bilgisi Kayıt Edildi..");
	}

	@Override
	public DataResult<List<CandidateEducationInformation>> findByCandidateCVE_Id(int CvId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "schoolEndDate");
		return new SuccessDataResult<List<CandidateEducationInformation>>(candidateEducationInformationDao.findByCandidateCVE_Id(CvId, sort), "Data Listelendi..");
	}
}
