package kodlama.io.language.language.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.language.language.business.abstracts.LanguageService;
import kodlama.io.language.language.business.requests.languageRequests.CreateLanguageRequest;
import kodlama.io.language.language.business.requests.languageRequests.DeleteLanguageRequest;
import kodlama.io.language.language.business.requests.languageRequests.UpdateLanguageRequest;
import kodlama.io.language.language.business.responses.languageResponses.GetAllLanguageResponse;
import kodlama.io.language.language.business.responses.languageResponses.GetByIdLanguageResponse;
import kodlama.io.language.language.dataAccess.abstracts.LanguageRepository;
import kodlama.io.language.language.entities.concretes.Language;

@Service
public class LanguageMenager implements LanguageService {

	private LanguageRepository languageRepository;
	 		
	
	@Autowired
	public LanguageMenager(LanguageRepository languageRepository) {
				super();
				this.languageRepository = languageRepository;
			}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		
		List<Language> languages = languageRepository.findAll();
		for (Language l : languages) {
			if(l.getName().equals(language.getName())) {
				throw new Exception("İsimler tekrar edemez.");
			}
		}
		if(language.getName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez!");
		}
		
		this.languageRepository.save(language);
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		Language language = new Language();
		language.setId(deleteLanguageRequest.getId());
		languageRepository.delete(language);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		Language language = new Language();
		language.setId(updateLanguageRequest.getId());
		language.setName(updateLanguageRequest.getName());
		
		List<Language> languages = languageRepository.findAll();
		
		for (Language l : languages) {
			if(l.getName().equals(language.getName())) {
				throw new Exception("İsimler tekrar edemez.");
			}
		}
		if(language.getName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez!");
		}
		
		Language updateLanguage = languageRepository.getReferenceById(language.getId());
		updateLanguage.setName(language.getName());
		languageRepository.save(updateLanguage);
	
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponpe = new ArrayList<GetAllLanguageResponse>();
		
		for (Language language : languages) {
			GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponpe.add(responseItem);
			
			
		}
		return languageResponpe;
		
		}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = languageRepository.getReferenceById(id);
		
		GetByIdLanguageResponse languageResponpe = new GetByIdLanguageResponse();
		languageResponpe.setId(language.getId());
		languageResponpe.setName(language.getName());
		return languageResponpe;
	}

	

}
