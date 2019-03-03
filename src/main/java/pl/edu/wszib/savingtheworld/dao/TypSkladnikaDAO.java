package pl.edu.wszib.savingtheworld.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypSkladnikaDAO extends OurCrudRepository<TypSkladnika, Long> {
}
