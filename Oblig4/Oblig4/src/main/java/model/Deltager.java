package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import service.PassordService;

@Entity
@Table(schema = "DAT108Oblig4")
public class Deltager {

    @Pattern(regexp = "^[1-9]\\d{7}$", message = "Servant: Mobiwnyummew må OwO væwe nøyaktig 8 siffew og kan ikke starte med 0.")
    @NotNull(message ="Servant: Mobiwnyummew må OwO væwe nøyaktig 8 siffew og kan ikke starte med 0.")
    @Id
    private String mobil;

    @Size(min = 8, message ="Servant: Passowd må OwO væwe minst 8 tegn.")
    @NotNull(message = "Servant: Passowd må OwO væwe minst 8 tegn.")
    @Embedded
    private Passord passord;

    @Pattern(regexp = "^[A-Za-zæøåÆØÅ\\- ]{2,20}$",message = "Servant: Fownyavn må OwO væwe mewwom 2 og 20 bokstavew.")
    @NotNull(message = "Servant: Fownyavn må OwO væwe mewwom 2 og 20 bokstavew.")
    private String fornavn;

    @Pattern(regexp ="^[A-Za-zæøåÆØÅ\\- ]{2,20}$", message = "Servant: E-E-Ettewnyavn må OwO væwe mewwom 2 og 20 bokstavew.")
    @NotNull(message = "Servant: E-E-Ettewnyavn må OwO væwe mewwom 2 og 20 bokstavew.")
    private String etternavn;

    @NotNull(message = "kan ikkje være tom")
    private Kjonn kjonn;

    static final PassordService passordService = new PassordService();

    public Deltager() {
    }

    public Deltager(String mobil, String passord, String fornavn, String etternavn, Kjonn kjonn) {
        this.mobil = mobil;
        setPassord(passord);
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

    public Passord getPassord() {
        return passord;
    }
    public void setPassord(String passord){
        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt(passord, salt);
        this.passord = new Passord(hash, salt);
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

