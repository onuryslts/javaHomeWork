package kodlama.io.language.language.business.responses.technologyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTechnologyResponse {

	private int id;
	private String languageName;
	private String name;
}
