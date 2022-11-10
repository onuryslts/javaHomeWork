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

import kodlama.io.language.language.business.abstracts.LanguageService;
import kodlama.io.language.language.business.requests.languageRequests.CreateLanguageRequest;
import kodlama.io.language.language.business.requests.languageRequests.DeleteLanguageRequest;
import kodlama.io.language.language.business.requests.languageRequests.UpdateLanguageRequest;
import kodlama.io.language.language.business.responses.languageResponses.GetAllLanguageResponse;
import kodlama.io.language.language.business.responses.languageResponses.GetByIdLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest ) throws Exception{
		languageService.add(createLanguageRequest);
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) {
		languageService.delete(deleteLanguageRequest);
	}
	@PutMapping("/update")
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception{
		languageService.update(updateLanguageRequest);
	}
	@GetMapping("/getall")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	@GetMapping("/getbyid")
	public GetByIdLanguageResponse getById(@PathVariable int id) {
		return languageService.getById(id);
	}
	
}
