package org;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Deltager {

    @Pattern(regexp = "^[1-9]\\d{7}$", message = "Mobilnummer må være nøyaktig 8 siffer og kan ikke begynne på 0.")
    @NotNull(message ="Mobilnummer må være nøyaktig 8 siffer og kan ikke begynne på 0.")
    private String mobil;

    @Size(min = 8, message ="Passord må være minst 8 tegn")
    @NotNull(message = "Passord må være minst 8 tegn")
    private String passord;

    @Pattern(regexp = "^[A-Za-zæøåÆØÅ\\- ]{2,20}$",message = "Fornavn må være mellom 2 og 20 bokstaver.")
    @NotNull(message = "Fornavn må være mellom 2 og 20 bokstaver.")
    private String fornavn;

    @Pattern(regexp ="^[A-Za-zæøåÆØÅ\\- ]{2,20}$", message = "Etternavn må være mellom 2 og 20 bokstaver.")
    @NotNull(message = "Etternavn må være mellom 2 og 20 bokstaver.")
    private String etternavn;

    @NotNull(message = "kan ikke være tom")
    private Kjonn kjonn;

    public Deltager() {
    }

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
