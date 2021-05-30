package kodlamaio.hrms.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisManager implements MernisService {

	@Override
	public Boolean checkIfCandidateRealPerson(Candidate candidate) {
		KPSPublicSoap soapClient = new KPSPublicSoapProxy();

		boolean result = false;

		try {
			result = soapClient.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
					candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),
					candidate.getBirthDate().getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
