package kodlama.io.language.language.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.language.language.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
