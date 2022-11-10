package kodlama.io.language.language.business.requests.languageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageRequest {

	private int id;
	private String name;
}
