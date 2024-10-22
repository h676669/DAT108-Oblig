package org.example;

import java.util.List;

public class Deltager {
    private String mobil;
    private String passord;
    private String fornavn;
    private String etternavn;
    private Kjonn kjonn;

    public Deltager(String mobil, String passord, String fornavn, String etternavn, Kjonn kjonn) {
        this.mobil = mobil;
        this.passord = passord;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
    }
    public Deltager(String mobil, String fornavn, String etternavn, Kjonn kjonn) {
        this.mobil = mobil;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public Kjonn getKjonn() {
        return kjonn;
    }

    public void setKjonn(Kjonn kjonn) {
        this.kjonn = kjonn;
    }
}
