package pl.edu.wszib.savingtheworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.savingtheworld.dao.Faktura;
import pl.edu.wszib.savingtheworld.dao.FakturaDAO;
import pl.edu.wszib.savingtheworld.dao.Podatnik;
import pl.edu.wszib.savingtheworld.dao.PodatnikDAO;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class InitComponent {
   @Autowired
   PodatnikDAO podatnikDAO;

   @Autowired
   FakturaDAO fakturaDAO;

   @PostConstruct
   public void init() {
       IntStream.range(0, 10).forEach(i -> {
           Podatnik podatnik = new Podatnik("Adam", "Adam" + i);
           Podatnik podatnikSaved = podatnikDAO.save(podatnik);

           IntStream.range(0, 10000).forEach(j -> {
               Faktura faktura = new Faktura(3.50, "cos" + j);
               faktura.setPodatnik(podatnikSaved);
               faktura = fakturaDAO.save(faktura);
           });
       });

       System.out.println();
   }

    @PreDestroy
    public void teardown() {

    }
}
