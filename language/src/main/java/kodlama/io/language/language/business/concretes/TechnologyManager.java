package kodlama.io.language.language.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.language.language.business.abstracts.TechnologyService;
import kodlama.io.language.language.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.language.language.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.language.language.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.language.language.business.responses.technologyResponses.GetAllTechnologyResponse;
import kodlama.io.language.language.business.responses.technologyResponses.GetByIdTechnologyResponse;
import kodlama.io.language.language.dataAccess.abstracts.LanguageRepository;
import kodlama.io.language.language.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.language.language.entities.concretes.Language;
import kodlama.io.language.language.entities.concretes.Technology;
@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
			LanguageRepository languageRepository;
	

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
				super();
				this.technologyRepository = technologyRepository;
				this.languageRepository = languageRepository;
			}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		Language language = languageRepository.getReferenceById(createTechnologyRequest.getLanguageId());
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		technology.setLanguage(language);
		
		List<Technology> technologies = technologyRepository.findAll();
		
		for (Technology t : technologies) {
			if(t.getName().equals(technology.getName()));
			throw new Exception("İsimler tekrar edemez.");
		}
		if (technology.getName().isEmpty()) {
			throw new Exception("Teknoloji ismi boş geçilemez.");
		}
		this.technologyRepository.save(technology);
		
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		Technology technology = new Technology();
		technology.setId(deleteTechnologyRequest.getId());
		technologyRepository.delete(technology);
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		Language language = languageRepository.getReferenceById(updateTechnologyRequest.getLanguageId());
		Technology technology = new Technology();
		technology.setName(updateTechnologyRequest.getName());
		technology.setLanguage(language);
		
		List<Technology> technologies = technologyRepository.findAll();
		
		for (Technology t : technologies) {
			if(t.getName().equals(technology.getName())) {
				throw new Exception("İsimler tekrar edemez.");
			}
		}
		if (technology.getName().isEmpty()) {
			throw new Exception("Teknoloji ismi boş geçilemez.");
		}
		Technology updateTechnology = technologyRepository.getReferenceById(technology.getId());
		updateTechnology.setName(technology.getName());
		updateTechnology.setLanguage(language);
		technologyRepository.save(updateTechnology);
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologyResponse = new ArrayList<GetAllTechnologyResponse>();
		
		for (Technology t : technologies) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
			Language language = languageRepository.getReferenceById(t.getLanguage().getId());
			
			responseItem.setId(t.getId());
			responseItem.setLanguageName(language.getName());
			responseItem.setName(t.getName());
			technologyResponse.add(responseItem);
			
		}
		return technologyResponse;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		Technology technology = technologyRepository.getReferenceById(id);
		Language language = languageRepository.getReferenceById(technology.getLanguage().getId());
		GetByIdTechnologyResponse tresponseItem = new GetByIdTechnologyResponse();
		tresponseItem.setId(technology.getId());
		tresponseItem.setLanguageName(language.getName());
		tresponseItem.setName(technology.getName());
		
		return tresponseItem;
	}

}
