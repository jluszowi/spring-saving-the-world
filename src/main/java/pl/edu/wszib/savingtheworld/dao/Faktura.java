package pl.edu.wszib.savingtheworld.dao;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Faktura {

    @Id
    @GeneratedValue
    Long fakturaid;

    double kwota;
    String tytul;

    @ManyToMany
    List

    public Faktura() {

    }

    public Faktura(double kwota, String tytul) {
        this.kwota = kwota;
        this.tytul = tytul;
    }


    public Long getFakturaid() {
        return fakturaid;
    }

    public void setFakturaid(Long fakturaid) {
        this.fakturaid = fakturaid;
    }



    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
