package kodlama.io.language.language.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.language.language.business.abstracts.TechnologyService;
import kodlama.io.language.language.business.requests.technologyRequests.CreateTechnologyRequest;
import kodlama.io.language.language.business.requests.technologyRequests.DeleteTechnologyRequest;
import kodlama.io.language.language.business.requests.technologyRequests.UpdateTechnologyRequest;
import kodlama.io.language.language.business.responses.technologyResponses.GetAllTechnologyResponse;
import kodlama.io.language.language.business.responses.technologyResponses.GetByIdTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController  {

	private TechnologyService technologyService;

	public TechnologyController() {
		super();
	}
	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest ) throws Exception{
		technologyService.add(createTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.delete(deleteTechnologyRequest);
	}
	@PutMapping("/update")
	public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) throws Exception{
		technologyService.update(updateTechnologyRequest);
	}
	@GetMapping("/getall")
	public List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
	@GetMapping("/getbyid")
	public GetByIdTechnologyResponse getById(@PathVariable int id) {
		return technologyService.getById(id);
	}

	
}
