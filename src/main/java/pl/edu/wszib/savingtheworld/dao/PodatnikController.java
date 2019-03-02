package pl.edu.wszib.savingtheworld.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/podatnik")
public class PodatnikController {

    @Autowired
    PodatnikDAO dao;

    @GetMapping
    public Podatnik podatnik(@RequestParam Long pesel) {
        return dao.findById(pesel).orElse(null);

    }

    @GetMapping("/all")
    public List<Podatnik> podatnicy() {
        return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());

    }

    @PostMapping
    public Podatnik zapisz(Podatnik podatnik) {
        return dao.save(podatnik);

    }

    @DeleteMapping
    public Podatnik usun(Long pesel) {
        Podatnik podatnik = dao.findById(pesel).orElse(null);
        dao.deleteById(pesel);
        return podatnik;
    }
}
