package kodlama.io.language.language.business.abstracts;

import java.util.List;

import kodlama.io.language.language.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.language.language.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.language.language.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.language.language.business.responses.technologyResponses.GetAllTechnologyResponse;
import kodlama.io.language.language.business.responses.technologyResponses.GetByIdTechnologyResponse;

public interface TechnologyService {

	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
	List<GetAllTechnologyResponse> getAll();
	GetByIdTechnologyResponse getById(int id);
}
