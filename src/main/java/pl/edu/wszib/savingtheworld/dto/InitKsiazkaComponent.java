package pl.edu.wszib.savingtheworld.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.savingtheworld.dao.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Component
public class InitKsiazkaComponent {
    @Autowired
   TypSkladnikaDAO typSkladnikaDAO;

   @Autowired
   SkladnikDAO skladnikDAO;

   @Autowired
   PrzepisDAO przepisDAO;

   @Autowired
   KsiazkaKucharskaDAO ksiazkaKucharskaDAO;

   @PostConstruct
   public void init() {

       for (int i = 0; i<10; i++) {
           TypSkladnika typSkladnika = new TypSkladnika("skladnik " + i);
           typSkladnikaDAO.save(typSkladnika);
       }

       KsiazkaKucharska ksiazkaKucharska = new KsiazkaKucharska();
       ksiazkaKucharska.setTytul("Moja ksiazka");
       ksiazkaKucharska = ksiazkaKucharskaDAO.save(ksiazkaKucharska);

       Przepis przepis = new Przepis();
       przepis.setKsiazkaKucharska(ksiazkaKucharska);
       przepis.setTytul("Przepis 1");

       przepis = przepisDAO.save(przepis);

       List<TypSkladnika> typSkladnikas = typSkladnikaDAO.findAll();
       for (TypSkladnika typ : typSkladnikas) {
           Skladnik skladnik = new Skladnik();
           skladnik.setIlosc(new Random().nextInt(5) + 1);
           skladnik.setTypSkladnika(typ);
           skladnik.setPrzepis(przepis);
           skladnikDAO.save(skladnik);
       }

       System.out.println("");
   }

}
