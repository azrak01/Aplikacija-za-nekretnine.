package com.example.drugaparcijala.repository;

import com.example.drugaparcijala.models.Nekretnina;
import java.util.ArrayList;
import java.util.List;

public class NekretninaRepository {
    private List<Nekretnina> nekretnine;

    public NekretninaRepository() {
        this.nekretnine = new ArrayList<>();
    }

    public void dodajNekretninu(Nekretnina nekretnina) {
        nekretnine.add(nekretnina);
    }

    public List<Nekretnina> getAktivneNekretnine() {
        List<Nekretnina> aktivneNekretnine = new ArrayList<>();
        for (Nekretnina nekretnina : nekretnine) {
            if (nekretnina.isProdajaAktivna()) {
                aktivneNekretnine.add(nekretnina);
            }
        }
        return aktivneNekretnine;
    }

    public List<Nekretnina> getProdateNekretnine() {
        List<Nekretnina> prodateNekretnine = new ArrayList<>();
        for (Nekretnina nekretnina : nekretnine) {
            if (!nekretnina.isProdajaAktivna()) {
                prodateNekretnine.add(nekretnina);
            }
        }
        return prodateNekretnine;
    }


    public void save(Nekretnina selektiranaNekretnina) {
    }

    public List<Nekretnina> findAll() {

        return nekretnine;
    }
}