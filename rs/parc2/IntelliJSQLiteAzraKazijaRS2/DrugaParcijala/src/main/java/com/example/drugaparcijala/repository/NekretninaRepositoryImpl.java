package com.example.drugaparcijala.repository;

import com.example.drugaparcijala.models.Nekretnina;

import java.util.ArrayList;
import java.util.List;




public class NekretninaRepositoryImpl extends NekretninaRepository {
    private List<Nekretnina> nekretnine;

    public NekretninaRepositoryImpl() {
        this.nekretnine = new ArrayList<>();
    }

    //@Override
    public List<Nekretnina> findAll() {
        return nekretnine;
    }

    //@Override
    public void save(Nekretnina nekretnina) {
        if (nekretnine.contains(nekretnina)) {
            nekretnine.remove(nekretnina);
        }
        nekretnine.add(nekretnina);
    }

   // @Override
    public void delete(Nekretnina nekretnina) {
        nekretnine.remove(nekretnina);
    }

   // @Override
    public void dodajNekretninu(Nekretnina nekretnina) {
        nekretnine.add(nekretnina);
    }

    //@Override
    public List<Nekretnina> getAktivneNekretnine() {
        List<Nekretnina> aktivneNekretnine = new ArrayList<>();
        for (Nekretnina nekretnina : nekretnine) {
            if (nekretnina.isProdajaAktivna()) {
                aktivneNekretnine.add(nekretnina);
            }
        }
        return aktivneNekretnine;
    }

    //@Override
    public List<Nekretnina> getProdateNekretnine() {
        List<Nekretnina> prodateNekretnine = new ArrayList<>();
        for (Nekretnina nekretnina : nekretnine) {
            if (!nekretnina.isProdajaAktivna()) {
                prodateNekretnine.add(nekretnina);
            }
        }
        return prodateNekretnine;
    }

}