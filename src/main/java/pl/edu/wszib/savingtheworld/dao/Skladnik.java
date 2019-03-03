package pl.edu.wszib.savingtheworld.dao;

import javax.persistence.*;

@Entity
@Table
public class Skladnik {

    @Id
    @GeneratedValue
    Long id;

    @OneToOne
    TypSkladnika typSkladnika;


    int ilosc;

    @ManyToOne
    @JoinColumn(name = "przepis_id")
    Przepis przepis;

    public Skladnik() {
    }

    public Skladnik(TypSkladnika typSkladnika, int ilosc, Przepis przepis) {
        this.typSkladnika = typSkladnika;
        this.ilosc = ilosc;
        this.przepis = przepis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypSkladnika getTypSkladnika() {
        return typSkladnika;
    }

    public void setTypSkladnika(TypSkladnika typSkladnika) {
        this.typSkladnika = typSkladnika;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Przepis getPrzepis() {
        return przepis;
    }

    public void setPrzepis(Przepis przepis) {
        this.przepis = przepis;
    }
}
