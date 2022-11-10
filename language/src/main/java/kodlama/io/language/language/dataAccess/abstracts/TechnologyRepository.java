package kodlama.io.language.language.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.language.language.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

}
