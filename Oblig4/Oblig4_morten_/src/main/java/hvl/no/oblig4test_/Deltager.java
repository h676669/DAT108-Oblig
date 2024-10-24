package hvl.no.oblig4test_;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Deltager {

    public Deltager(String fornavn, String etternavn, String mobil, String passord, String kjonn) {
        this.fornavn = storForbokstav(fornavn);
        this.etternavn = storForbokstav(etternavn);
        this.mobil = mobil;
        this.passord = passord;
        this.kjonn = kjonn;
    }
    public Deltager() {}

    @Size(min=2, max=20, message="Navn må inneholde mellom 2 og 20 tegn")
    @Pattern(regexp = "^[A-ZØÆÅ][a-zA-ZøæåØÆÅ\\s-]*$", message = "Fornavn kan kun inneholde bokstaver, bindestrek og mellomrom.")
    @NotNull(message = "Fornavn er obligatorisk")
    private String fornavn;


    @Size(min=2, max=20, message="Navn må inneholde mellom 2 og 20 tegn")
    @Pattern(regexp = "^[A-ZØÆÅ][a-zA-ZøæåØÆÅ\\s-]*$", message = "Etternavn kan kun inneholde bokstaver, bindestrek og mellomrom.")
    @NotNull(message = "Etternavn er obligatorisk")
    private String etternavn;

    @Pattern(regexp = "^\\d{8}$", message="Mobilnummer må være eksakt 8 sifre.")
    @NotNull(message = "Mobil er obligatorisk")
    private String mobil;

    @Size(min=6, message = "Passord må være minst 6 tegn langt.")
    @NotNull(message = "!!!")
    private String passord;

    private String repetertPassord;

    @NotNull(message = "Kjønn er obligatorisk")
    @Pattern(regexp = "Mann|Kvinne", message = "Kjønn må være mann eller kvinne.")
    private String kjonn;

    @Override
    public String toString() {
        return fornavn + " " + etternavn + ", tlf: " + mobil + ", " + kjonn;
    }

    public String getFornavn() {
        return fornavn;
    }
    public String getEtternavn() {
        return etternavn;
    }
    public String getMobil() {
        return mobil;
    }
    public String getPassord() {
        return passord;
    }
    public String getKjonn() {
        return kjonn;
    }
    public String getRepetertPassord() {
        return repetertPassord;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = storForbokstav(fornavn);
    }
    public void setEtternavn(String etternavn) {
        this.etternavn = storForbokstav(etternavn);
    }
    public void setMobil(String mobil) {
        this.mobil = mobil;
    }
    public void setPassord(String passord) {
        this.passord = passord;
    }
    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }
    public void setRepetertPassord(String repetertPassord) {
        this.repetertPassord = repetertPassord;
    }

    private String storForbokstav(String navn) {
        if (navn == null || navn.isEmpty()) {
            return navn;
        }
        return navn.substring(0, 1).toUpperCase() + navn.substring(1).toLowerCase();
    }


}
