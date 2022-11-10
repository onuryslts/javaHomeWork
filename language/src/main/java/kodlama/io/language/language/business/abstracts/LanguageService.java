package kodlama.io.language.language.business.abstracts;

import java.util.List;

import kodlama.io.language.language.business.requests.languageRequests.CreateLanguageRequest;
import kodlama.io.language.language.business.requests.languageRequests.DeleteLanguageRequest;
import kodlama.io.language.language.business.requests.languageRequests.UpdateLanguageRequest;
import kodlama.io.language.language.business.responses.languageResponses.GetAllLanguageResponse;
import kodlama.io.language.language.business.responses.languageResponses.GetByIdLanguageResponse;

public interface LanguageService {
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
	List<GetAllLanguageResponse> getAll();
	GetByIdLanguageResponse getById(int id);
}
