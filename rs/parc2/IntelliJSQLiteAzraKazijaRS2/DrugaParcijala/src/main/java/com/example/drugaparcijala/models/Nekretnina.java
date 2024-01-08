package com.example.drugaparcijala.models;

import java.time.LocalDate;
import java.util.List;


        public class Nekretnina {
    private String jedinstveniBroj;
    private String adresa;
    private String grad;
    private double cijena;
    private LocalDate datumProdaje;
    private double cijenaProdaje;
    private String komentar;
    private boolean prodajeSe;
    private boolean prodajaAktivna;

    public Nekretnina(String jedinstveniBroj, String adresa, String grad, double cijena, LocalDate datumProdaje,
                      double cijenaProdaje, String komentar, boolean prodajeSe) {
        this.jedinstveniBroj = jedinstveniBroj;
        this.adresa = adresa;
        this.grad = grad;
        this.cijena = cijena;
        this.datumProdaje = datumProdaje;
        this.cijenaProdaje = cijenaProdaje;
        this.komentar = komentar;
        this.prodajeSe = prodajeSe;
    }

    // Getters and Setters

    public String getJedinstveniBroj() {
        return jedinstveniBroj;
    }

    public void setJedinstveniBroj(String jedinstveniBroj) {
        this.jedinstveniBroj = jedinstveniBroj;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public LocalDate getDatumProdaje() {
        return datumProdaje;
    }

    public void setDatumProdaje(LocalDate datumProdaje) {
        this.datumProdaje = datumProdaje;
    }

    public double getCijenaProdaje() {
        return cijenaProdaje;
    }

    public void setCijenaProdaje(double cijenaProdaje) {
        this.cijenaProdaje = cijenaProdaje;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public boolean isProdajeSe() {
        return prodajeSe;
    }

    public void setProdajeSe(boolean prodajeSe) {
        this.prodajeSe = prodajeSe;
    }

             public boolean isProdajaAktivna() {
                return prodajaAktivna;
            }

            public void setProdajaAktivna(boolean prodajaAktivna) {
                this.prodajaAktivna = prodajaAktivna;
            }

        }
