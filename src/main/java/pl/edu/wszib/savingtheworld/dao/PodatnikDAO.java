package pl.edu.wszib.savingtheworld.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PodatnikDAO extends CrudRepository<Podatnik, Long> {

    Optional<Podatnik> findByImieIgnoreCase (String imie);
//    List<Podatnik> findAllByFaktury_(String nazwisko);
    // tą ninijkę można zapisać : List<Podatnik> findAllOrderByImieDesc();

}
